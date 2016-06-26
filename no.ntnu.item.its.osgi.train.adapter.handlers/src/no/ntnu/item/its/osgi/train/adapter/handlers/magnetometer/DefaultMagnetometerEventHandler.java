package no.ntnu.item.its.osgi.train.adapter.handlers.magnetometer;

import org.osgi.service.event.Event;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.common.interfaces.AccelerationControllerService;
import no.ntnu.item.its.osgi.common.interfaces.ColorControllerService;
import no.ntnu.item.its.osgi.common.interfaces.MagControllerService;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;

public class DefaultMagnetometerEventHandler implements SensorHandler{
	
	private EventReceiver receiver;
	private double prevHeading = Double.MAX_VALUE;
	
	public DefaultMagnetometerEventHandler(EventReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void handleEvent(Event e) {
		if(e.getProperty(MagControllerService.STATE) != null){
			receiver.sendSensorStateEvent((Status)e.getProperty(MagControllerService.STATE), PublisherType.MAG);
			return;
		}
		long time = (long) e.getProperty(MagControllerService.TIMESTAMP_KEY);
		double heading = (double) e.getProperty(MagControllerService.HEADING_KEY);
		if (prevHeading == Double.MAX_VALUE) {
			prevHeading = heading;
		}
		prevHeading = heading;
		receiver.sendMagnetometerEvent(new MagnetometerReading(time,heading, false));
	}

}
