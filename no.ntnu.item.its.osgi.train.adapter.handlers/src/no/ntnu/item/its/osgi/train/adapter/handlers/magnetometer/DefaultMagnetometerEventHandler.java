package no.ntnu.item.its.osgi.train.adapter.handlers.magnetometer;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.its.osgi.sensors.common.interfaces.AccelerationControllerService;
import no.ntnu.item.its.osgi.sensors.common.interfaces.MagControllerService;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;

public class DefaultMagnetometerEventHandler implements SensorHandler{
	
	private EventReceiver receiver;
	
	public DefaultMagnetometerEventHandler(EventReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void handleEvent(Event e) {
		long time = (long) e.getProperty(AccelerationControllerService.TIMESTAMP_KEY);
		double heading = (double) e.getProperty(MagControllerService.HEADING_KEY);
		receiver.sendMagnetometerEvent(new MagnetometerReading(time,heading));
	}

}
