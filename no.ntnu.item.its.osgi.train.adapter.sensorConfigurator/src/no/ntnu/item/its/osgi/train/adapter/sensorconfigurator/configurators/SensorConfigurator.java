package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators;

import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorReconfiguration;

public interface SensorConfigurator {
	
	public void configure(SensorReconfiguration reconfiguration);
	public long getPublishRate();
	public long getDefaultPublishRate();
	public Status getPublisherStatus();

}
