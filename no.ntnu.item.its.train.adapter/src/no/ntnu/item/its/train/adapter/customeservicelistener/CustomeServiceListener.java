package no.ntnu.item.its.train.adapter.customeservicelistener;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import no.ntnu.item.arctis.runtime.Block;

public class CustomeServiceListener extends Block {

	private final String unregistrationEvent = "UNREGISTRATION";
	private final String registrationEvent = "REGISTRATION";
	private final String modifiedEvent = "MODIFIED";
	
	public BundleContext context;
	
	private ServiceListener sensorListener;
	public java.lang.String filterString;
	private ServiceTracker serviceTracker;
	public java.lang.String filter;

	public void startListener(String filterString) {
		Filter filter;
		try {
			filter = context.createFilter(filterString);
			serviceTracker = new ServiceTracker<>(context, filter, new CustomeServiceTracker());
			serviceTracker.open();
		} catch (InvalidSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		detectRegisteredServices();
		
		sensorListener = new ServiceListener() {
			public void serviceChanged(ServiceEvent ev) {
				switch (ev.getType()) {
					case ServiceEvent.REGISTERED: {
						logger.debug("New service registered");
						sendToBlock(registrationEvent, ev);
						break;
					}
					case ServiceEvent.UNREGISTERING: {
						logger.debug("Service unregistered");
						sendToBlock(unregistrationEvent, ev);
						break;
					}
					case ServiceEvent.MODIFIED: {
						logger.debug("Service mondified");
						sendToBlock(modifiedEvent, ev);
						break;
					}
				}
			}
		};
/*		try {
			
			context.addServiceListener(sensorListener, filter);
			logger.info("CustomeServiceListener started with filter: " + filter);
		} catch (InvalidSyntaxException e) {
			logger.error("Failed to add ServiceListener due to invalid filter syntax: " + filter);
		}*/
	}
	

	private void detectRegisteredServices() {
		if(serviceTracker == null) return;
		ServiceReference[] services = serviceTracker.getServiceReferences();
		if(services.length == 0) return;
		for (ServiceReference serviceReference : services) {
			sendToBlock(registrationEvent, serviceReference);
		}
		logger.info(services.length + " publisher registerd with the framework");
	}


	public void stop() {
		context.removeServiceListener(sensorListener);
		logger.info("Stopped CustomeServiceListener");
	}

	public CustomeServiceListener() {
	}
	
	private class CustomeServiceTracker implements ServiceTrackerCustomizer<Object, Object>{

		@Override
		public Object addingService(ServiceReference<Object> ev) {
			logger.debug("New service registered");
			sendToBlock(registrationEvent, ev);
			return ev;
		}

		@Override
		public void modifiedService(ServiceReference<Object> ev, Object arg1) {
			logger.debug("Service unregistered");
			sendToBlock(unregistrationEvent, ev);
		}

		@Override
		public void removedService(ServiceReference<Object> ev, Object arg1) {
			logger.debug("Service unregistered");
			sendToBlock(unregistrationEvent, ev);
		}
		
	}
}
