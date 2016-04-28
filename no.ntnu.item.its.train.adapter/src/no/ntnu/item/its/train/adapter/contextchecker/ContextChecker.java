package no.ntnu.item.its.train.adapter.contextchecker;

import org.osgi.framework.ServiceEvent;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.interfaces.TrainRestrictionsChecker;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController;
import no.ntnu.item.its.train.adapter.enums.SpeedLevel;
import no.ntnu.item.its.train.adapter.interfaces.MapRestrictions;
import no.ntnu.item.its.train.adapter.trainInfo.TrainAdapterProperties;



public class ContextChecker extends Block implements TrainContext {

	
	private final String speedRestriction = "SPEED";
	private TrainState trainState;
	
	private ServiceTracker<TrainRestrictionsChecker, Object> trainRestrictionTracker;
	private ServiceTracker<MapRestrictions, Object> mapRestrictionTracker;
	private ServiceTracker<TrainStateController, Object> trainStateCtrTracker;
	
	private TrainAdapterProperties trainProperties;
	public org.osgi.framework.BundleContext context; 
	
	
	
	
	public void init(){
		trainProperties = new TrainAdapterProperties(0);
		setUpTrackers();
		
	}
	
	private void setUpTrackers(){
		mapRestrictionTracker = new ServiceTracker<>(context, MapRestrictions.class, null);
		mapRestrictionTracker.open();
		trainRestrictionTracker = new ServiceTracker<>(context, TrainRestrictionsChecker.class, null);
		trainRestrictionTracker.open();
		trainStateCtrTracker = new ServiceTracker<>(context, TrainStateController.class, null);
		trainStateCtrTracker.open();
		
	}

	@Override
	public void setTrainState(TrainState state) {
		this.trainState = state;
	}
	

	@Override
	public void sendSpeedRestriction(SpeedLevel speed) {
		sendToBlock(speedRestriction, speed);
	}

	@Override
	public double getSpeed() {
		return trainProperties.getSpeed();
	}
	
	
	public void handleColorEvent(ColorReading color){
		trainState.colorUpdate(color);
		trainProperties.newSleeper(color);
	}
	
	public void handleNFCEvent(NFCReading hex) {
		trainState.nfcUpdate(hex);
		trainProperties.newNFCreading(hex);
	}

	public void handleSensorStateEvent(ServiceEvent event) {
		trainState.sensorUpdate(event);
	}

	public void handleTemperatureEvent(TemperatureReading temp) {
		trainState.temperaturUpdate(temp);
	}

	public void handleAccelerometerEvent(AccelerometerReading acc) {
		trainState.accelerationUpdate(acc);
	}

	public void handleMagnetometerEvent(MagnetometerReading reading) {
		trainState.magnetometerUpdate(reading);
	}
	
	public void handleDummyEvent() {
		trainState.dummyUpdate();
	}

	@Override
	public TrainAdapterProperties getTrainProperties() {
		return trainProperties;
	}

	@Override
	public MapRestrictions getMapRestrictions(){
		MapRestrictions res = (MapRestrictions) mapRestrictionTracker.getService();
		if(res == null){
			logger.warn("Could not find map restrictions");
		}
		return res;
	}
	
	@Override
	public TrainStateController getTrainStateController(){
		TrainStateController res = (TrainStateController) trainStateCtrTracker.getService();
		if(res == null){
			logger.warn("Could not find train state controller");
		}
		return res;
	}

	@Override
	public TrainRestrictionsChecker getTrainRestrictionChecker() {
		TrainRestrictionsChecker res = (TrainRestrictionsChecker) trainRestrictionTracker.getService();
		if(res == null){
			logger.debug("Could not find train restrictions");
		}
		return res;
	}
	
}
