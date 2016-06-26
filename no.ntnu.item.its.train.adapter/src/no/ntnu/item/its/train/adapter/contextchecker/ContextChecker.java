package no.ntnu.item.its.train.adapter.contextchecker;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.SensorStateEvent;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapChecker;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorReconfiguration;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.common.SpeedRestrictionLevel;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.interfaces.TrainRestrictionsChecker;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainContext;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainState;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;
import no.ntnu.item.its.train.adapter.common.TrainCommand;
import no.ntnu.item.its.train.adapter.trainInfo.TrainInfo;
import no.ntnu.trainamqpservice.common.AMQPMessage;

public class ContextChecker extends Block implements TrainContext {

	private final String speedRestriction = "SPEED";
	private final String stopTrain = "STOP";
	private final String changeFilter = "CHANGEFILTER";
	private final String sendMessage = "MESSSAGE";
	private final String addTopic = "ADDTOPIC";
	private final String removeTopic = "REMOVETOPIC";
	private final String light = "LIGHT";
	private final String updateHandler = "UPDATEHANDLER";
	private final String reconfigureSensor = "RECONFIGURESENSOR";

	private TrainState trainState;
	private ServiceTracker<TrainRestrictionsChecker, TrainRestrictionsChecker> trainRestrictionTracker;
	private ServiceTracker<MapChecker, MapChecker> mapRestrictionTracker;
	private ServiceTracker<TrainStateController, TrainStateController> trainStateCtrTracker;

	
	public BundleContext context;
	public String remoteErrorMsg;
	public TrainInfo trainInfo;

	public void init() {
		setUpTrackers();
	}

	private void setUpTrackers() {
		mapRestrictionTracker = new ServiceTracker<>(context, MapChecker.class, null);
		mapRestrictionTracker.open();
		trainRestrictionTracker = new ServiceTracker<>(context, TrainRestrictionsChecker.class, null);
		trainRestrictionTracker.open();
		trainStateCtrTracker = new ServiceTracker<>(context, TrainStateController.class, null);
		trainStateCtrTracker.open();
	}

	@Override
	public void setTrainState(TrainStates state) {
		logger.info("Trainstate changed to: " + state);
		logger.debug("Statechange: " + state);
		trainInfo.setTrainState(state);
		TrainState newState = getTrainState(state);
		if(newState == null) return;
		this.trainState = newState;
	}

	@Override
	public void sendSpeedRestriction(SpeedRestrictionLevel level) {
		double speed = getTrainRestrictionChecker().getSpeedRestriction(level);
		trainInfo.setSpeed(speed);
		trainInfo.setSpeedRestrictionLevel(level);
		logger.debug("Speedchange: " + speed);
		sendToBlock(speedRestriction, speed);
	}

	public void handleColorEvent(ColorReading color) {
		trainState.colorUpdate(color);
	}

	public void handleNFCEvent(NFCReading hex) {
		trainState.nfcUpdate(hex);
	}

	public void handleSensorStateEvent(SensorStateEvent event) {
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

	public boolean runWithoutRemote() {
		logger.warn("RemoteController failed");
		if (getTrainRestrictionChecker() == null)
			return false;
		return getTrainRestrictionChecker().canRunWithoutRemoteController();

	}

	@Override
	public TrainStateController getTrainStateController() {
		TrainStateController res = (TrainStateController) trainStateCtrTracker.getService();
		if (res == null) {
			logger.warn("Could not find train state controller");
		}
		return res;
	}

	@Override
	public void reconfigureSensor(SensorReconfiguration reconfiguration){
		sendToBlock(reconfigureSensor, reconfiguration);
	}
	
	@Override
	public TrainRestrictionsChecker getTrainRestrictionChecker() {
		TrainRestrictionsChecker res = (TrainRestrictionsChecker) trainRestrictionTracker.getService();
		if (res == null) {
			logger.debug("Could not find train restrictions checker");
		}
		return res;
	}

	@Override
	public double getSpeed() {
		return trainInfo.getSpeed();
	}

	@Override
	public MapChecker getMapRestrictions() {
		MapChecker res = (MapChecker) mapRestrictionTracker.getService();
		if (res == null) {
			logger.debug("Could not find map restrictions checker");
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
	public double getHeading() {
		return trainInfo.getHeading();
	}

	@Override
	public void setHeading(double heading) {
		trainInfo.setHeading(heading);
	}

	@Override
	public void increaseSpeedForTurn() {
		trainInfo.setInTurn(true);
		double newSpeed = trainInfo.getSpeed() + getTrainRestrictionChecker().getSpeedIncreaseInTurne();
		logger.info("Train in turn increasing speed to " + newSpeed);
		logger.debug("Turn: Increase " + newSpeed);
		trainInfo.setSpeed(newSpeed);
		sendToBlock(speedRestriction, newSpeed);
	}

	@Override
	public void decreaseSpeedForTurn() {
		trainInfo.setInTurn(false);
		double newSpeed = trainInfo.getSpeed() - getTrainRestrictionChecker().getSpeedIncreaseInTurne();
		logger.info("Train out of turn decreasing speed " + newSpeed);
		logger.debug("Turn: Decrease " + newSpeed);
		trainInfo.setSpeed(newSpeed);
		sendToBlock(speedRestriction, newSpeed);
	}

	@Override
	public TrainStates getCurrentTrainState() {
		return trainInfo.getTrainState();
	}

	@Override
	public void stopTrain() {
		logger.info("Stopping train");
		sendToBlock(stopTrain);
	}

	public void handleMessage(TrainCommand message) {
		if (message.getCmd() == null) {
			logger.info("Empty TrainCommand");
			return;
		}
		switch (message.getCmd()) {
		case START:
			sendSpeedRestriction(SpeedRestrictionLevel.valueOf((String) message.getValue()));
			break;
		case STOP:
			stopTrain();
			break;
		case FILTER:
			sendToBlock(changeFilter, (String) message.getValue());
			break;
		case LIGHT:
			sendToBlock(light, (boolean) message.getValue());
			break;
		case ADDTOPIC:
			sendToBlock(addTopic, (String) message.getValue());
			break;
		case REMOVETOPIC:
			sendToBlock(removeTopic, (String) message.getValue());
			break;
		case CHANGEFILTER:
			sendToBlock(changeFilter, (String) message.getValue());
			break;
		case TEMPERATUR:
			handleTemperatureEvent(new TemperatureReading((double) message.getValue()));
			break;
		case STATE:
			TrainStates state = (TrainStates.valueOf((String) message.getValue()));
			if (state != null)
				setTrainState(state);
			break;
		default:
			logger.info("Unknow train command");
			break;
		}

	}

	public void sendMessage(AMQPMessage message) {
		sendToBlock(sendMessage, message);
	}

	public void handleSendError(String error) {
		logger.error(error);
	}

	@Override
	public SpeedRestrictionLevel getSpeedRestrictionLevel() {
		return trainInfo.getSpeedRestrictionLevel();
	}

	@Override
	public String getCurrentLocationID() {
		return trainInfo.getCurrentLocationID();
	}

	@Override
	public void setCurrentLocationID(String locationID) {
		trainInfo.setCurrentLocationID(locationID);
	}

	public void stop() {
		mapRestrictionTracker.close();
		trainRestrictionTracker.close();
		trainStateCtrTracker.close();
	}

	private TrainState getTrainState(TrainStates state) {
		TrainStateController ctr = (TrainStateController) trainStateCtrTracker.getService();
		if (ctr == null) {
			logger.warn("Could not find train state controller");
			return null;
		}
		return ctr.getTrainState(state, this);
	}

	@Override
	public Status getSensorState(PublisherType type) {
		return trainInfo.getSensorStaus(type);
	}
	
	@Override
	public void setSensorState(PublisherType type, Status status){
		trainInfo.setSensorStatus(type, status);
	}

	@Override
	public void setLastSleeperColor(SleeperColor color) {
		trainInfo.setLastSleeperColor(color);
		
	}

	@Override
	public SleeperColor getLastSleeperColor() {
		return trainInfo.getLastSleeperColor();
	}

}
