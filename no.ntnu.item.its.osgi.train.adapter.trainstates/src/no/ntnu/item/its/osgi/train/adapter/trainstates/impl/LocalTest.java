package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import org.osgi.framework.ServiceEvent;
import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainstates.StateActivator;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public class LocalTest implements TrainState {

	protected final TrainContext train;
	private SpeedRestrictionLevel speed = SpeedRestrictionLevel.NORMAL;
	
	public LocalTest(TrainContext train) {
		this.train = train;
		train.sendSpeedRestriction(speed);
	}

	@Override
	public void sensorUpdate(ServiceEvent event) {
	}

	@Override
	public void colorUpdate(ColorReading reading) {
		speed = (speed== SpeedRestrictionLevel.NORMAL) ? SpeedRestrictionLevel.CITY : SpeedRestrictionLevel.NORMAL;
		train.sendSpeedRestriction(speed);
		
	}

	protected void reconfigureSensors(PublisherType type, SpeedRestrictionLevel level) {

		train.getSensorConfigurator().configureSensor(SensorConfigurationOption.PUBLISHRATE,
				calculateMagPullRate(level), type);
	}

	@Override
	public void accelerationUpdate(AccelerometerReading acc) {

	}

	@Override
	public void magnetometerUpdate(MagnetometerReading reading) {
		if (train.getSpeed() == 0)
			return;
		if (!train.isInTurn() && reading.isTurning())
			train.increaseSpeedForTurn();
		if (train.isInTurn() && !reading.isTurning())
			train.decreaseSpeedForTurn();
	}

	@Override
	public void temperaturUpdate(TemperatureReading temp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nfcUpdate(NFCReading hex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dummyUpdate() {
		// TODO Auto-generated method stub

	}

	protected long calculatePullRate(PublisherType type, SpeedRestrictionLevel level) {
		switch (type) {
		case MAG:
			return calculateMagPullRate(level);
		case SLEEPER:
			return calculateColorPullRate(level);
		default:
			break;
		}
		return 0;
	}

	protected long calculateColorPullRate(SpeedRestrictionLevel level) {
		if (level == SpeedRestrictionLevel.CITY)
			return 50;
		if (level == SpeedRestrictionLevel.INNERCITY)
			return 100;
		return train.getTrainRestrictionChecker().getPublishRate(PublisherType.SLEEPER);
	}

	protected long calculateMagPullRate(SpeedRestrictionLevel level) {
		if (level == SpeedRestrictionLevel.CITY)
			return 500;
		if (level == SpeedRestrictionLevel.INNERCITY)
			return 700;
		return train.getTrainRestrictionChecker().getPublishRate(PublisherType.MAG);
	}

}
