package no.ntnu.item.its.train.adapter.customeservicelistener;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

import no.ntnu.item.arctis.runtime.Block;

public class CustomeServiceListener extends Block {

	private final String unregistrationEvent = "UNREGISTRATION";
	private final String registrationEvent = "REGISTRATION";
	private final String modifiedEvent = "MODIFIED";
	
	public BundleContext context;
	
	private ServiceListener sensorListener;
	public java.lang.String filter;

	public void startListener(String filter) {
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
		try {
			context.addServiceListener(sensorListener, filter);
			logger.info("CustomeServiceListener started with filter: " + filter);
		} catch (InvalidSyntaxException e) {
			logger.error("Failed to add ServiceListener due to invalid filter syntax: " + filter);
		}
	}
	

	public void stop() {
		context.removeServiceListener(sensorListener);
		logger.info("Stopped CustomeServiceListener");
	}

	public CustomeServiceListener() {
	}
}
