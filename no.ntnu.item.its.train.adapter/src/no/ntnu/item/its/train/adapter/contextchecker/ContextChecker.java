package no.ntnu.item.its.train.adapter.contextchecker;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapRestrictionChecker;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces.TrainSensorConfiguratorController;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.interfaces.TrainRestrictionsChecker;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;
import no.ntnu.item.its.train.adapter.trainInfo.TrainInfo;



public class ContextChecker extends Block implements TrainContext {

	
	private final String speedRestriction = "SPEED";
	private TrainState trainState;
	private TrainInfo trainInfo;
	
	private ServiceTracker<TrainRestrictionsChecker, TrainRestrictionsChecker> trainRestrictionTracker;
	private ServiceTracker<MapRestrictionChecker, MapRestrictionChecker> mapRestrictionTracker;
	private ServiceTracker<TrainStateController, TrainStateController> trainStateCtrTracker;
	private ServiceTracker<TrainSensorConfiguratorController, TrainSensorConfiguratorController> configuratorTracker;
	
	public BundleContext context; 
	
	public void init(){
		trainInfo = new TrainInfo();
		setUpTrackers();
		setTrainState(TrainStates.RUNNINGCITY);
	}
	
	private void setUpTrackers(){
		mapRestrictionTracker = new ServiceTracker<>(context, MapRestrictionChecker.class, null);
		mapRestrictionTracker.open();
		trainRestrictionTracker = new ServiceTracker<>(context, TrainRestrictionsChecker.class, null);
		trainRestrictionTracker.open();
		trainStateCtrTracker = new ServiceTracker<>(context, TrainStateController.class, null);
		trainStateCtrTracker.open();
		configuratorTracker = new ServiceTracker<>(context, TrainSensorConfiguratorController.class, null);
		configuratorTracker.open();
	}

	@Override
	public void setTrainState(TrainStates state) {
		logger.info("Trainstate changed to: " + state);
		this.trainState = getTrainStateController().getTrainState(state, this);
	}
	

	@Override
	public void sendSpeedRestriction(SpeedRestrictionLevel level) {
		double speed = getTrainRestrictionChecker().getSpeedRestriction(level);
		logger.info("Sending speed restriction: " + speed);
		trainInfo.setSpeed(speed);
		sendToBlock(speedRestriction, speed);
	}

	
	
	public void handleColorEvent(ColorReading color){
		logger.info("Color event");
		trainState.colorUpdate(color);
	}
	
	public void handleNFCEvent(NFCReading hex) {
		trainState.nfcUpdate(hex);
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
			logger.debug("Could not find train restrictions checker");
		}
		return res;
	}

	@Override
	public double getSpeed() {
		return 0;
	}

	@Override
	public MapRestrictionChecker getMapRestrictions() {
		MapRestrictionChecker res = (MapRestrictionChecker) mapRestrictionTracker.getService();
		if(res == null){
			logger.debug("Could not find map restrictions checker");
		}
		return res;
	}
	
	@Override
	public TrainSensorConfiguratorController getSensorConfigurator(){
		TrainSensorConfiguratorController res = (TrainSensorConfiguratorController) configuratorTracker.getService();
		if(res == null){
			logger.debug("Could not find sensor configurator");
		}
		return res;
	}

	@Override
	public boolean isInTurn() {
		return trainInfo.isInTurn();
	}
	
	@Override
	public void setInturn(boolean b) {
		trainInfo.setInTurn(b);
	}

	@Override
	public void increaseSpeedForTurn() {
		sendToBlock(speedRestriction, trainInfo.getSpeed() + getTrainRestrictionChecker().getSpeedIncreaseInTurne());
	}

	@Override
	public void decreaseSpeedForTurn() {
		sendToBlock(speedRestriction, trainInfo.getSpeed() - getTrainRestrictionChecker().getSpeedIncreaseInTurne());
	}
	
	
}
