package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;

public class Innercity extends LegoTrain {

	public Innercity(TrainContext train) {
		super(train);
		train.sendSpeedRestriction(SpeedRestrictionLevel.INNERCITY);
	}

	@Override
	public void dummyUpdate() {
		// TODO Auto-generated method stub
		
	}

}
