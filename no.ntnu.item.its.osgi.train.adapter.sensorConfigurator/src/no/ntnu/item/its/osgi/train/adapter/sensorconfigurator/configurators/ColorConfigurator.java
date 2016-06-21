package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators;

import java.util.HashMap;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.common.interfaces.PublisherService;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.ConfiguratorActivator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorReconfiguration;

public class ColorConfigurator implements SensorConfigurator {

	private BundleContext context;
	private String filterString = String.format("(%s=%s)", PublisherType.class.getSimpleName(), PublisherType.SLEEPER);
	private ServiceTracker<PublisherService, PublisherService> colorTracker;
	
	public ColorConfigurator(BundleContext context) {
		this.context = context;
		Filter filter = null;
		try {
			filter = context.createFilter(filterString);
			colorTracker = new ServiceTracker<>(context, filter, null);
			colorTracker.open();
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void configure(SensorReconfiguration reconfiguration) {
		if(colorTracker.getService() == null) return;
		ConfiguratorActivator.getLogger().log(LogService.LOG_DEBUG, "[" + this.getClass().getSimpleName() + "] " + System.currentTimeMillis());
		Object value = reconfiguration.getValue();
		switch (reconfiguration.getOption()) {
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
	
	private void stopPublisher() {
		colorTracker.getService().stopPublisher();
	}

	private void changePublishRate(long rate) {
		colorTracker.getService().setPublishRate(rate);
		
	}
	
	private void doRead(){
		colorTracker.getService().read();
	}

	@Override
	public long getPublishRate() {
		// TODO Auto-generated method stub
		return colorTracker.getService().getPublishRate();
	}

	@Override
	public long getDefaultPublishRate() {
		// TODO Auto-generated method stub
		return colorTracker.getService().getDefaultPublishRate();
	}

	@Override
	public Status getPublisherStatus() {
		return colorTracker.getService().getStatus();
	}

	
	
}
