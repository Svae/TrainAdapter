package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators;

import java.util.HashMap;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.interfaces.PublisherService;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;

public class ColorConfigurator implements SensorConfigurator {

	private BundleContext context;
	private String filter = String.format("%s=%s", PublisherType.class.getSimpleName(), PublisherType.SLEEPER);
	private ServiceTracker<PublisherService, PublisherService> colorTracker;
	
	public ColorConfigurator(BundleContext context) {
		this.context = context;
		colorTracker = new ServiceTracker<>(context, filter, null);
		colorTracker.open();
	}
	
	@Override
	public void configure(SensorConfigurationOption property, Object value) {
		if(colorTracker.getService() == null) return;
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
		colorTracker.getService().stopPublisher();
	}

	private void changePublishRate(long rate) {
		colorTracker.getService().setPublishRate(rate);
		
	}

	@Override
	public void configure(HashMap<SensorConfigurationOption, Object> properties) {
		
	}
	
	private void startBundle(){
//		try {
//			FrameworkUtil.getBundle(ColorPubActivator.class).start();
//		} catch (BundleException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	private void stopBundle(){
//		try {
//			FrameworkUtil.getBundle(ColorPubActivator.class).stop();
//		} catch (BundleException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	

	
	
}
