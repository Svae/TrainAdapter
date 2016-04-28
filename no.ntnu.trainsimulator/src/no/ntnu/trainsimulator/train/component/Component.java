package no.ntnu.trainsimulator.train.component;

import org.osgi.framework.BundleContext;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.its.osgi.sensors.common.interfaces.PublisherService;
import no.ntnu.item.its.train.adapter.enums.SpeedLevel;

public class Component extends Block {

	public BundleContext context;

	public void logSpeed() {
		logger.info("SPEED");
	}

	public void logStopp() {
		logger.info("Stop command sent to train");
	}

	public String getId() {
		System.out.println("(objectclass=" + PublisherService.class.getName() + ")");
		return "(objectclass=" + PublisherService.class.getName() + ")";
	}
	

}
