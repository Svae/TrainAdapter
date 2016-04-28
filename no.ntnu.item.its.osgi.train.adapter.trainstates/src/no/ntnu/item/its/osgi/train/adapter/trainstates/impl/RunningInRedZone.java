package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import no.ntnu.item.its.osgi.sensors.common.enums.EColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.train.adapter.enums.SpeedLevel;

public class RunningInRedZone extends Running {

	public RunningInRedZone(TrainContext train) {
		super(train);		
	}
	
	@Override
	public void nfcUpdate(NFCReading hex) {
		if(hex.getReading() != "0x000001") train.setTrainState(new Running(train));
	}
	
	@Override
	public void colorUpdate(ColorReading color){
		if(color.getReading() == EColor.RED){ train.setTrainState(new Running(train));
		train.sendSpeedRestriction(SpeedLevel.NORMAL);
		}
	}

}
