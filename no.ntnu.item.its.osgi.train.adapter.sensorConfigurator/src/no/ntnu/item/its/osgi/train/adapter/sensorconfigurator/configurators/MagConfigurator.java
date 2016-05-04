package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators;

import java.util.HashMap;
import java.util.Map.Entry;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.interfaces.PublisherService;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;

public class MagConfigurator implements SensorConfigurator{

	private BundleContext context;
	private String filter = String.format("%s=%s", PublisherType.class.getSimpleName(), PublisherType.MAG);
	private ServiceTracker<PublisherService, PublisherService> magTracker;
	
	public MagConfigurator(BundleContext context) {
		this.context = context;
		magTracker = new ServiceTracker<>(context, filter, null);
		magTracker.open();	
	}
	
	@Override
	public void configure(HashMap<SensorConfigurationOption, Object> properties) {
		for (Entry<SensorConfigurationOption, Object> entry : properties.entrySet()) {
			configure(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void configure(SensorConfigurationOption property, Object value) {
		if(magTracker.getService() == null) return;
		switch (property) {
		case PUBLISHRATE:
			if(!(value instanceof Long)) return;
				//TODO: ADD LOGGING
			changePublishRate((long) value);
			break;
		case STOP:
			stopPublisher();
		default:
			break;
		}
	}
	
	private void stopPublisher() {
		magTracker.getService().stopPublisher();
	}

	private void changePublishRate(long rate) {
		magTracker.getService().setPublishRate(rate);
		
	}
	
	

}
