package no.ntnu.item.osgi.train.system.train;

import no.ntnu.item.arctis.runtime.Block;

public class Train extends Block {

	public String getSensorFilter() {
		return "";
	}

	public void initAMQP() {
	}

	public int getSpeed() {
		return 100;
	}

	public int convertSpeed(double speed) {
		return (int) speed;
	}

	public void logSpeed(int speed) {
		logger.info("Train speed change");
	}

}
