package no.ntnu.item.its.osgi.train.adapter.handlers.common.readings;

import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;

public class ColorReading {

	SleeperColor color; 
	
	public ColorReading(SleeperColor color) {
		this.color = color;
	}
	
	public SleeperColor getReading(){
		return color;
	}
}
