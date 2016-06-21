package no.ntnu.item.its.osgi.train.adapter.trainstates.impl;

import org.osgi.service.log.LogService;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SensorEventType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.SensorStateEvent;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.common.MapZone;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorReconfiguration;
import no.ntnu.item.its.osgi.train.adapter.trainstates.StateActivator;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;

public abstract class LegoTrainNFC implements TrainState {

	protected final TrainContext train;
	private boolean last = false;

	public LegoTrainNFC(TrainContext train) {
		this.train = train;
	}

	public void updateSensorState(SensorStateEvent event) {
		if (event.getEvent() == SensorEventType.REGISTERED || event.getEvent() == SensorEventType.STARTED)
			train.setSensorState(event.getType(), Status.OK);
		if (event.getEvent() == SensorEventType.STOPPED)
			train.setSensorState(event.getType(), Status.STOPPED);
		if (event.getEvent() == SensorEventType.STOPPED)
			train.setSensorState(event.getType(), Status.FAULTED);
	};

	@Override
	public void colorUpdate(ColorReading reading) {
		SleeperColor color = reading.getReading();
		if (color == SleeperColor.UNKNOWN || color == SleeperColor.GRAY)
			return;
		StateActivator.getLogger().log(LogService.LOG_DEBUG, String.format("Color: %s", color));
		switch (reading.getReading()) {
		case GREEN:
			train.stopTrain();
			break;
		case BLUE:
			setTrainMapZone(train.getMapRestrictions().getNextMapZone(train.getCurrentLocationID(), true));
			break;
		case RED:
			Status sensorstatus = train.getSensorState(PublisherType.MAG);
			if (sensorstatus == null)
				return;
			if (sensorstatus == Status.STOPPED)
				reconfigurePublisherRate(PublisherType.MAG, train.getSpeed());
			else
				stopPublisher(PublisherType.MAG);
			break;
		case YELLOW:
			if (train.isInTurn()) {
				train.decreaseSpeedForTurn();
			} else
				train.increaseSpeedForTurn();
			break;
		default:
			return;
		}

	}

	protected void reconfigurePublisherRate(PublisherType type, double speed) {
		if (type == PublisherType.MAG)
			train.reconfigureSensor(new SensorReconfiguration(type, SensorConfigurationOption.PUBLISHRATE,
					calculateMagPullRate(speed)));
	}

	protected void stopPublisher(PublisherType type) {
		train.reconfigureSensor(new SensorReconfiguration(type, SensorConfigurationOption.STOP, null));
	}

	@Override
	public void accelerationUpdate(AccelerometerReading acc) {

	}

	@Override
	public void nfcUpdate(NFCReading hex) {
		
	}

	private MapZone getNextMapZone() {
		return train.getMapRestrictions().getNextMapZone(train.getCurrentLocationID(), true);
	}

	protected void setTrainMapZone(MapZone zone) {
		if (zone == MapZone.CITY)
			train.setTrainState(TrainStates.CITYNFC);
		if (zone == MapZone.INNERCITY)
			train.setTrainState(TrainStates.INNERCITYNFC);
		if (zone == MapZone.NORMAL)
			train.setTrainState(TrainStates.RUNNINGNFC);
	}

	@Override
	public void magnetometerUpdate(MagnetometerReading reading) {
		if (last == reading.isTurning())
			return;
		last = reading.isTurning();
		train.setHeading(reading.getHeading());
		StateActivator.getLogger().log(LogService.LOG_DEBUG,
				String.format("IsTurning: %s", reading.isTurning() ? "Turning" : "Not turning"));

	}

	@Override
	public void temperaturUpdate(TemperatureReading temp) {

	}

	protected long calculateColorPullRate(double speed) {
		return (long) (125 - speed);
	}

	protected long calculateMagPullRate(double speed) {
		return (long) (1000 - 4 * speed);
	}

}
