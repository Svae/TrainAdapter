package no.ntnu.item.its.train.adapter.sensorcontroller;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandlerController;
import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.interfaces.AccelerationControllerService;
import no.ntnu.item.its.osgi.common.interfaces.ColorControllerService;
import no.ntnu.item.its.osgi.common.interfaces.MagControllerService;
import no.ntnu.item.its.osgi.common.interfaces.MifareControllerService;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;

public class SensorController extends Block implements EventReceiver {

	private final String colorEvent = "COLOREVENT";
	private final String sensorStatusEvent = "SENSORSTATUSEVENT";
	private final String nfcEvent = "NFCEVENT";
	private final String accEvent = "ACCELEROMETEREVENT";
	private final String magEvent = "MAGNETOMETEREVENT";
	private final String dummyEvent = "DUMMYEVENT";
	private final String tempEvent = "TEMPERATUREEVENT";
	
	
	private final String eventHandlerName = EventHandler.class.getName();
	private final String eventHandlerCtrFilter = "(objectclass=" + SensorHandlerController.class.getName() + ")";
	private ServiceTracker eventHandlerCtrTracker;
	private ServiceListener eventHandlerListener;
	private HashMap<PublisherType, ServiceRegistration> registrations;
	public BundleContext context;
	
	public void init() {
		registrations = new HashMap<PublisherType, ServiceRegistration>();
		eventHandlerCtrTracker = new ServiceTracker<>(context, SensorHandlerController.class.getName(), null);
		eventHandlerCtrTracker.open();
		eventHandlerListener = new ServiceListener() {
			
			@Override
			public void serviceChanged(ServiceEvent ev) {
				switch (ev.getType()) {
				case ServiceEvent.REGISTERED:
					updateSensorHandlers();
					break;
				case ServiceEvent.MODIFIED:
					updateSensorHandlers();
					break;
				default:
					break;
				}
			}
		};
		try {
			context.addServiceListener(eventHandlerListener, eventHandlerCtrFilter);
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void registerSensor(ServiceEvent ev){
		System.out.println("NEW SENSOR");
		PublisherType type = (PublisherType) ev.getServiceReference().getProperty(PublisherType.class.getSimpleName());
		if(type == null){
			logger.info("Sensor type property is not set");
			return;
		}
		registerSensorHandler(type);
	}
	
	public void registerSensorHandler(PublisherType type){
		if(eventHandlerCtrTracker.getService() == null){
			System.out.println("LOL");
			return;
		}
		Dictionary<String, String> p = new Hashtable<>();
		SensorHandler handler = ((SensorHandlerController)eventHandlerCtrTracker.getService()).getSensorHandler(type, this);
		
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
			case DISTANCE:
				logger.info("Distance sensor is not yet implemented");
				return;
			case VELOCITY:
				logger.info("Velocity sensor is not yet implemented");
				return;
			default:
				logger.info("Unkown sensor type: "+ type);
				return;
		}
		ServiceRegistration registration = context.registerService(eventHandlerName, handler, p);
		registrations.put(type, registration);
		logger.info("Registered handler for " + type.toString());
	}
	
	
	
	public void unregisterSensor(ServiceEvent ev){
		PublisherType type = (PublisherType) ev.getServiceReference().getProperty(PublisherType.class.getSimpleName());
		unregisterSensorHandler(type);
	}
	
	
	private void unregisterSensorHandler(PublisherType type){
		ServiceRegistration reg = registrations.get(type);
		reg.unregister();
		registrations.remove(reg);
		logger.debug("Unregistered handler for sensor of type: " + type);
	}
	
	public void updateSensorHandlers(){
		if(registrations.isEmpty()) return;
		for (Entry<PublisherType,ServiceRegistration> entry : registrations.entrySet()) {
			entry.getValue().unregister();
			registerSensorHandler(entry.getKey());
			logger.info("Updated sensor handler for sensor of type:" + entry.getKey());
		}
		logger.info("Sensor handlers has been updated");
	}
	
	public void modifiedSensor(ServiceEvent ev) {
		registerSensor(ev);
		sendToBlock(sensorStatusEvent, ev);
	}
	

	@Override
	public void sendColorEvent(ColorReading color) {
		sendToBlock(colorEvent, color);
		
	}

	@Override
	public void sendSensorStatusEvent(PublisherType type) {
		sendToBlock(sensorStatusEvent, type);
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
		sendToBlock(magEvent,r);
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
		for (ServiceRegistration reg : registrations.values()) {
			reg.unregister();
		}
		logger.info("Stopped Sensor Controller");
	}

}