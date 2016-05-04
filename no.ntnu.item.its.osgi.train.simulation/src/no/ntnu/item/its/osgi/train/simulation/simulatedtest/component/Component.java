package no.ntnu.item.its.osgi.train.simulation.simulatedtest.component;

import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {

	public String getString() {
		return "";
	}

	public void logSpeed(double speed) {
		System.out.println("Speed: " + speed);
	}

}
