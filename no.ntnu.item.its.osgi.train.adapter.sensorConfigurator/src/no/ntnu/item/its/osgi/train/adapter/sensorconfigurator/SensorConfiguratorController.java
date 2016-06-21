package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator;

import java.util.List;

import org.osgi.framework.BundleContext;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorReconfiguration;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators.ColorConfigurator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators.MagConfigurator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators.MifareConfigurator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators.SensorConfigurator;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces.TrainSensorConfiguratorController;

public class SensorConfiguratorController implements TrainSensorConfiguratorController {
	
	private ColorConfigurator color;
	private MagConfigurator mag;
	private MifareConfigurator mifare;
	private BundleContext context;
	
	public SensorConfiguratorController(BundleContext context) {
		this.context = context;
		color = new ColorConfigurator(context);
		mag = new MagConfigurator(context);
		mifare = new MifareConfigurator(context);
	}
	
	@Override
	public void configureSensor(List<SensorReconfiguration>reconfigurations){
		for (SensorReconfiguration reconfiguration : reconfigurations) {
			configureSensor(reconfiguration);
		}
	}

	@Override
	public void configureSensor(SensorReconfiguration reconfiguration) {
		if(reconfiguration.getType() == null) return;
		getConfigurator(reconfiguration.getType()).configure(reconfiguration);
	}

	private SensorConfigurator getConfigurator(PublisherType type){
		switch (type) {
			case SLEEPER:
				return color; 
			case MAG:
				return mag;
			case BEACON:
				return mifare;
			default:
				return null;
			}
	}
	@Override
	public long getPublishRate(PublisherType type) {
		return getConfigurator(type).getPublishRate();
	}

	@Override
	public long getDefaultPublishRate(PublisherType type) {
		return getConfigurator(type).getDefaultPublishRate();
	}

	@Override
	public Status getPublisherStatus(PublisherType type) {
		return getConfigurator(type).getPublisherStatus();
	}
}
