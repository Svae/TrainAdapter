package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators;

import java.util.HashMap;
import java.util.Map.Entry;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.interfaces.PublisherService;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;

public class MifareConfigurator implements SensorConfigurator{

	
	private BundleContext context;
	private String filterString = String.format("(%s=%s)", PublisherType.class.getSimpleName(), PublisherType.BEACON);
	private ServiceTracker<PublisherService, PublisherService> beaconTracker;
	
	public MifareConfigurator(BundleContext context) {
		this.context = context;
		Filter filter = null;
		try {
			filter = context.createFilter(filterString);
			beaconTracker = new ServiceTracker<>(context, filter, null);
			beaconTracker.open();
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
		if(beaconTracker.getService() == null) return;
		switch (property) {
			case PUBLISHRATE:
				break;
			case READ:
				doRead();
				break;
			case STOP:
				stopPublisher();
				break;
			case WRITE:
				doWrite((String) value);
			default:
				break;
		}
		
	}
	
	private void doWrite(String content) {
		beaconTracker.getService().write(content);
	}

	private void doRead(){
		beaconTracker.getService().read();
	}
	
	private void stopPublisher() {
		beaconTracker.getService().stopPublisher();
	}

	@Override
	public long getPublishRate() {
		return beaconTracker.getService().getPublishRate();
	}

	@Override
	public long getDefaultPublishRate() {
		return beaconTracker.getService().getDefaultPublishRate();
	}

}
