package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators;

import java.util.HashMap;
import java.util.Map.Entry;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.common.interfaces.PublisherService;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;

public class MagConfigurator implements SensorConfigurator{

	private BundleContext context;
	private String filterString = String.format("(%s=%s)", PublisherType.class.getSimpleName(), PublisherType.MAG);
	private ServiceTracker<PublisherService, PublisherService> magTracker;
	
	public MagConfigurator(BundleContext context) {
		this.context = context;
		Filter filter = null;
		try {
			filter = context.createFilter(filterString);
			magTracker = new ServiceTracker<>(context, filter, null);
			magTracker.open();
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}
		
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
		//TODO: ADD LOGGING
			case PUBLISHRATE:
				if(!(value instanceof Long)) return;
				changePublishRate((long) value);
				break;
			case STOP:
				stopPublisher();
				break;
			case READ:
				doRead();
				break;
			default:
				break;
		}
	}
	
	private void doRead(){
		magTracker.getService().read();
	}
	
	private void stopPublisher() {
		magTracker.getService().stopPublisher();
	}

	private void changePublishRate(long rate) {
		magTracker.getService().setPublishRate(rate);
		
	}

	@Override
	public long getPublishRate() {
		return 0;
	}

	@Override
	public long getDefaultPublishRate() {
		return 0;
	}
	
	@Override
	public Status getPublisherStatus() {
		if(magTracker.getService() == null) return null;
		return magTracker.getService().getStatus();
	}
	

}
