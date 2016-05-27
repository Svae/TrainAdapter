package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;

public class Running extends LegoTrain{

	protected int direction;
	
	public Running(TrainContext train) {
		super(train);
		train.sendSpeedRestriction(SpeedRestrictionLevel.NORMAL);
	}
	

	@Override
	public void dummyUpdate() {
		// TODO Auto-generated method stub
		
	}


	
	
	
	

}
