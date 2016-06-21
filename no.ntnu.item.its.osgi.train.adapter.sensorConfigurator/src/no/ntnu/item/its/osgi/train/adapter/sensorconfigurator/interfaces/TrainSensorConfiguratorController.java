package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces;

import java.util.List;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorReconfiguration;

public interface TrainSensorConfiguratorController {
	public void configureSensor(List<SensorReconfiguration> reconfigurations);
	public void configureSensor(SensorReconfiguration reconfiguration);
	public long getPublishRate(PublisherType type);
	public long getDefaultPublishRate(PublisherType type);
	public Status getPublisherStatus(PublisherType type);

}
