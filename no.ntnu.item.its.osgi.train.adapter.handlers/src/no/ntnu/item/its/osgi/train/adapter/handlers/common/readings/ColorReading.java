package no.ntnu.item.its.osgi.train.adapter.handlers.common.readings;

import no.ntnu.item.its.osgi.sensors.common.enums.EColor;

public class ColorReading {

	EColor color; 
	
	public ColorReading(EColor color) {
		this.color = color;
	}
	
	public EColor getReading(){
		return color;
	}
}
