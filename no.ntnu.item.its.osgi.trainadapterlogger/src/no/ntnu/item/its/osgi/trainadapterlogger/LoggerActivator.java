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
	private PrintWriter writer;

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
		writer = new PrintWriter("Finaltest-" +System.currentTimeMillis()+ ".log");
		tracker.getService().addLogListener(this);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		tracker.getService().removeLogListener(this);
		tracker.close();
		writer.close();
		LoggerActivator.context = null;
	}

	@Override
	public void logged(LogEntry entry) {
		if(entry.getLevel() != 4) return;
		writer.println(String.format("%d [%s] %s", entry.getTime(), entry.getBundle().getSymbolicName(), entry.getMessage()));
	}

}
