package no.ntnu.item.its.train.adapter.customservicetracker;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import no.ntnu.item.arctis.runtime.Block;

public class CustomServiceTracker extends Block {
	private final String unregistrationEvent = "UNREGISTRATION";
	private final String registrationEvent = "REGISTRATION";
	private final String modifiedEvent = "MODIFIED";
	private final String invalid = "INVALID";
	public BundleContext context;
	public java.lang.String filterString;
	private ServiceTracker serviceTracker;
	public java.lang.String filter;

	public void startListener(String filterString) {
		Filter filter;
		try {
			filter = context.createFilter(filterString);
			if (serviceTracker != null) {
				serviceTracker.close();
			}
			serviceTracker = new ServiceTracker(context, filter, new CustomeServiceTrackerCustomizer());
			serviceTracker.open();
		} catch (InvalidSyntaxException e) {
			sendToBlock(invalid, filterString);
		}
	}

	public void stop() {
		if (serviceTracker != null)
			serviceTracker.close();
		logger.info("Stopped CustomeServiceListener");
	}

	public CustomServiceTracker() {
	}

	private class CustomeServiceTrackerCustomizer implements ServiceTrackerCustomizer<Object, Object> {
		@Override
		public Object addingService(ServiceReference<Object> ev) {
			logger.info("New service registered");
			sendToBlock(registrationEvent, ev);
			return ev;
		}

		@Override
		public void modifiedService(ServiceReference<Object> ev, Object arg1) {
			logger.info("Service unregistered");
			sendToBlock(modifiedEvent, ev);
		}

		@Override
		public void removedService(ServiceReference<Object> ev, Object arg1) {
			logger.info("Service unregistered");
			sendToBlock(unregistrationEvent, ev);
			context.ungetService(ev);
		}
	}
}
