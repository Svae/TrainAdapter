package no.ntnu.item.its.train.adapter.sensorcontroller;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandlerController;
import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.common.interfaces.AccelerationControllerService;
import no.ntnu.item.its.osgi.common.interfaces.ColorControllerService;
import no.ntnu.item.its.osgi.common.interfaces.MagControllerService;
import no.ntnu.item.its.osgi.common.interfaces.MifareControllerService;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SensorEventType;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.SensorStateEvent;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorConfigurationOption;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.common.SensorReconfiguration;
import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces.TrainSensorConfiguratorController;

public class SensorController extends Block implements EventReceiver {

	private final String colorEvent = "COLOREVENT";
	private final String sensorStateEvent = "SENSORSTATEEVENT";
	private final String nfcEvent = "NFCEVENT";
	private final String accEvent = "ACCELEROMETEREVENT";
	private final String magEvent = "MAGNETOMETEREVENT";
	private final String dummyEvent = "DUMMYEVENT";
	private final String tempEvent = "TEMPERATUREEVENT";

	private final String eventHandlerName = EventHandler.class.getName();
	private ServiceTracker<SensorHandlerController, SensorHandlerController> eventHandlerCtrTracker;
	private ServiceTracker<TrainSensorConfiguratorController, TrainSensorConfiguratorController> configuratorTracker;
	private HashMap<PublisherType, ServiceRegistration> registrations;
	public BundleContext context;

	public void init() {
		registrations = new HashMap<PublisherType, ServiceRegistration>();
		eventHandlerCtrTracker = new ServiceTracker<>(context, SensorHandlerController.class.getName(),
				new EventHandlerTrackerCustomizer());
		eventHandlerCtrTracker.open();
		configuratorTracker = new ServiceTracker<>(context, TrainSensorConfiguratorController.class, null);
		configuratorTracker.open();
	}

	public void registerSensor(ServiceReference ev) {
		PublisherType type = (PublisherType) ev.getProperty(PublisherType.class.getSimpleName());
		if (type == null) {
			logger.info("Sensor type property is not set");
			return;
		}
		sendToBlock(sensorStateEvent, new SensorStateEvent(type, SensorEventType.REGISTERED));
		registerSensorHandler(type, null);

	}

	public void registerSensorHandler(PublisherType type, SensorHandlerController controller) {
		SensorHandlerController ctr;
		if (controller != null)
			ctr = controller;
		else {
			if (getHandlerController() == null) {
				registrations.put(type, null);
				logger.warn("SensorHandler service could not be find");
				return;
			}
			ctr = getHandlerController();
		}
		SensorHandler handler = ctr.getSensorHandler(type, this);
		Dictionary<String, String> p = new Hashtable<>();
		switch (type) {
		case SLEEPER:
			p.put(EventConstants.EVENT_TOPIC, ColorControllerService.EVENT_TOPIC);
			break;
		case BEACON:
			p.put(EventConstants.EVENT_TOPIC, MifareControllerService.EVENT_TOPIC);
			break;
		case ACCEL:
			p.put(EventConstants.EVENT_TOPIC, AccelerationControllerService.EVENT_TOPIC);
			break;
		case MAG:
			p.put(EventConstants.EVENT_TOPIC, MagControllerService.EVENT_TOPIC);
			break;
		case DISTANCE:
			logger.info("Distance sensor is not yet implemented");
			return;
		case VELOCITY:
			logger.info("Velocity sensor is not yet implemented");
			return;
		default:
			logger.info("Unkown sensor type: " + type);
			return;
		}
		ServiceRegistration registration = context.registerService(eventHandlerName, handler, p);
		registrations.put(type, registration);
		logger.info("Registered handler for " + type.toString());
	}

	public void unregisterSensor(ServiceReference ev) {
		PublisherType type = (PublisherType) ev.getProperty(PublisherType.class.getSimpleName());
		if (type == null)
			return;
		unregisterSensorHandler(type);
		sendToBlock(sensorStateEvent, new SensorStateEvent(type, SensorEventType.UNREGISTERED));
	}

	private void unregisterSensorHandler(PublisherType type) {
		ServiceRegistration reg = registrations.get(type);
		if (reg == null)
			return;
		reg.unregister();
		registrations.remove(reg);
		logger.info("Unregistered handler for sensor of type: " + type);
	}

	public void externalUpdates() {
		if (registrations.isEmpty())
			return;
		for (Entry<PublisherType, ServiceRegistration> entry : registrations.entrySet()) {
			if (entry.getValue() != null)
				entry.getValue().unregister();
			registerSensorHandler(entry.getKey(), null);
			logger.info("Updated sensor handler for sensor of type:" + entry.getKey());
		}
		logger.info("Sensor handlers has been updated");
	}

	public void updateSensorHandlers(SensorHandlerController controller) {
		if (registrations.isEmpty())
			return;
		for (PublisherType type : registrations.keySet()) {
			updateSensorHandler(controller, type);
		}
		logger.info("Sensor handlers has been updated");
	}

	public void updateSensorHandler(SensorHandlerController controller, PublisherType type) {
		ServiceRegistration reg = registrations.get(type);
		if (reg != null)
			reg.unregister();
		registerSensorHandler(type, controller);
		logger.info("Updated sensor handler for sensor of type:" + type);
	}

	public void modifiedSensor(ServiceReference ev) {
		registerSensor(ev);
	}

	@Override
	public void sendColorEvent(ColorReading color) {
		sendToBlock(colorEvent, color);

	}

	@Override
	public void sendNFCEvent(NFCReading hex) {
		sendToBlock(nfcEvent, hex);
	}

	@Override
	public void sendAccelerationEvent(AccelerometerReading acc) {
		sendToBlock(accEvent, acc);

	}

	@Override
	public void sendMagnetometerEvent(MagnetometerReading r) {
		sendToBlock(magEvent, r);
	}

	@Override
	public void sendDummyEvent() {
		sendToBlock(dummyEvent);
	}

	@Override
	public void sendTemperaturEvent(TemperatureReading temp) {
		sendToBlock(tempEvent, temp);
	}

	public void stop() {
		registrations.values().forEach(reg -> reg.unregister());
		logger.info("Stopped Sensor Controller");
	}

	private SensorHandlerController getHandlerController() {
		if (eventHandlerCtrTracker.getService() == null)
			logger.warn("Can not find EventHandlerController");
		return eventHandlerCtrTracker.getService();
	}

	public void externalUpdate(PublisherType type) {
		updateSensorHandler(null, type);
	}

	public TrainSensorConfiguratorController getSensorConfigurator() {
		TrainSensorConfiguratorController res = (TrainSensorConfiguratorController) configuratorTracker.getService();
		if (res == null) {
			logger.debug("Could not find sensor configurator");
		}
		return res;
	}

	public void reconfigureSensor(SensorReconfiguration reconfiguration) {
		TrainSensorConfiguratorController ctr = getSensorConfigurator();
		if (ctr == null)
			return;
		ctr.configureSensor(reconfiguration);
		
	}
	
	@Override
	public void sendSensorStateEvent(Status status, PublisherType type) {
		if (type == PublisherType.BEACON)
			return;
		if (status == Status.STOPPED)
			sendToBlock(sensorStateEvent, new SensorStateEvent(type, SensorEventType.STOPPED));
		if (status == Status.OK)
			sendToBlock(sensorStateEvent, new SensorStateEvent(type, SensorEventType.STARTED));	
	}

	private class EventHandlerTrackerCustomizer
			implements ServiceTrackerCustomizer<SensorHandlerController, SensorHandlerController> {

		@Override
		public SensorHandlerController addingService(ServiceReference<SensorHandlerController> ev) {
			if (!registrations.isEmpty())
				updateSensorHandlers(context.getService(ev));
			return (SensorHandlerController) context.getService(ev);
		}

		@Override
		public void modifiedService(ServiceReference<SensorHandlerController> arg0, SensorHandlerController arg1) {
		}

		@Override
		public void removedService(ServiceReference<SensorHandlerController> ref, SensorHandlerController arg1) {
			context.ungetService(ref);
		}

	}

}