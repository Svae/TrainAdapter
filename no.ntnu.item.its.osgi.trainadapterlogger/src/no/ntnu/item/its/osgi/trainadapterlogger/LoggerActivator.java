package no.ntnu.item.its.osgi.trainadapterlogger;

import java.io.PrintWriter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.osgi.util.tracker.ServiceTracker;

public class LoggerActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceTracker<LogReaderService, LogReaderService> tracker;
	private PrintWriter nfcwriter, turnwriter, configwriter, debugwriter;
	private LogListener listener;

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
		listener = new ColorTestLogger();
		tracker.getService().addLogListener(listener);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		((ColorTestLogger)listener).close();
		tracker.getService().removeLogListener(listener);
		LoggerActivator.context = null;
	}

}
