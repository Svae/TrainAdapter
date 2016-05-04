package no.ntnu.item.its.osgi.consolelogger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class Activator implements BundleActivator, LogListener {

	private static BundleContext context;
	private ServiceTracker<LogReaderService, Object> readerTracker;


	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		readerTracker = new ServiceTracker<LogReaderService, Object>(
				bundleContext, 
				LogReaderService.class,
				new LogReaderTrackerCustomizer());
		readerTracker.open();

	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}



	public void listenTo(LogReaderService logReader) {
		logReader.addLogListener(this);
	}

	@Override
	public void logged(LogEntry arg0) {
		String level = null;
		switch (arg0.getLevel()) {
		case LogService.LOG_DEBUG:
			level = "DEBUG";
			break;
		case LogService.LOG_INFO:
			level = "INFO";
			break;
		case LogService.LOG_WARNING:
			level = "WARNING";
			break;
		case LogService.LOG_ERROR:
			level = "ERROR";
			break;
		}
		System.out.println(String.format(
				"[%s]%s: %s",
				level, 
				arg0.getBundle(), 
				arg0.getMessage()));				
	}

	private class LogReaderTrackerCustomizer implements ServiceTrackerCustomizer<LogReaderService, Object> {
		@Override
		public Object addingService(ServiceReference<LogReaderService> arg0) {
			listenTo(context.getService(arg0));
			return null;
		}
		@Override
		public void modifiedService(ServiceReference<LogReaderService> arg0, Object arg1) {}
		@Override
		public void removedService(ServiceReference<LogReaderService> arg0, Object arg1) {}

	}
}
