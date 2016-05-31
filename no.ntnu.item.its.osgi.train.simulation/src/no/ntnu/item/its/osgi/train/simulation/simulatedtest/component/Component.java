package no.ntnu.item.its.osgi.train.simulation.simulatedtest.component;

import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {

	public void logSpeed(double speed) {
		logger.info("Speed: " + speed);
	}

	public void stop() {
		logger.info("TRAIN STOP");
	}

	public void light(boolean t) {
		logger.info(t ? "Light on" : "Light off");
	}

}
