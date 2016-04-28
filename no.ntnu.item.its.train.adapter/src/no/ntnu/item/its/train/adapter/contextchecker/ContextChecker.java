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
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.interfaces.TrainRestrictionsChecker;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController;



public class ContextChecker extends Block implements TrainContext {

	
	private final String speedRestriction = "SPEED";
	private TrainState trainState;
	
	private ServiceTracker<TrainRestrictionsChecker, Object> trainRestrictionTracker;
	private ServiceTracker<MapRestrictionChecker, Object> mapRestrictionTracker;
	private ServiceTracker<TrainStateController, Object> trainStateCtrTracker;
	
	public BundleContext context; 
	
	public void init(){
		setUpTrackers();
		
	}
	
	private void setUpTrackers(){
		mapRestrictionTracker = new ServiceTracker<>(context, MapRestrictionChecker.class, null);
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
	public void sendSpeedRestriction() {
		sendToBlock(speedRestriction, null);
	}

	
	
	public void handleColorEvent(ColorReading color){
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
	
	
	
}
