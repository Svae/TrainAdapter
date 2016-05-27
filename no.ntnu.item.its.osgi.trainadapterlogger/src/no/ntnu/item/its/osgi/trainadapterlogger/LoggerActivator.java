package no.ntnu.item.its.osgi.trainadapterlogger;

import java.io.PrintWriter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.osgi.util.tracker.ServiceTracker;

public class LoggerActivator implements BundleActivator, LogListener {

	private static BundleContext context;
	private ServiceTracker<LogReaderService, LogReaderService> tracker;
	private PrintWriter nfcwriter, turnwriter, configwriter, debugwriter;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		LoggerActivator.context = bundleContext;
		tracker = new ServiceTracker<>(bundleContext, LogReaderService.class, null);
		tracker.open();
		if(tracker.getService() == null){
			System.out.println("Logger service is not up");
			return;
		}
		nfcwriter = new PrintWriter("TrainNFCEvents" +System.currentTimeMillis()+ ".log");
		turnwriter = new PrintWriter("TrainTurnEvents" +System.currentTimeMillis()+ ".log");
		configwriter = new PrintWriter("TrainConfigEvents" +System.currentTimeMillis()+ ".log");
		debugwriter = new PrintWriter("TrainDebugEvents" +System.currentTimeMillis()+ ".log");
		tracker.getService().addLogListener(this);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		tracker.getService().removeLogListener(this);
		tracker.close();
		nfcwriter.close();
		turnwriter.close();
		configwriter.close();
		debugwriter.close();
		LoggerActivator.context = null;
	}

	@Override
	public void logged(LogEntry entry) {
		if(entry.getLevel() != 4) return;
		debugwriter.println(String.format("%d [%s] %s", entry.getTime(), entry.getBundle().getSymbolicName(), entry.getMessage()));
		if(entry.getMessage().contains("YELLOW") || entry.getMessage().contains("IsTurning:") || entry.getMessage().contains("Turn:")){
			turnwriter.println(String.format("%d [%s] %s", entry.getTime(), entry.getBundle().getSymbolicName(), entry.getMessage()));
			return;
		}
		if(entry.getMessage().contains("RED") || entry.getMessage().contains("Added:") || entry.getMessage().contains("Removed:")|| entry.getMessage().contains("[DefaultMifareEventHandler]")){
			configwriter.println(String.format("%d [%s] %s", entry.getTime(), entry.getBundle().getSymbolicName(), entry.getMessage()));
			return;
		}
		nfcwriter.println(String.format("%d [%s] %s", entry.getTime(), entry.getBundle().getSymbolicName(), entry.getMessage()));

	}

}
