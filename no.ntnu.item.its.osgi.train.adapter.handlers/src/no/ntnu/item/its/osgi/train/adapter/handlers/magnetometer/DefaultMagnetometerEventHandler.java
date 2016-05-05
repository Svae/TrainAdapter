package no.ntnu.item.its.osgi.train.adapter.handlers.magnetometer;

import org.osgi.service.event.Event;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.its.osgi.common.interfaces.AccelerationControllerService;
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
		long time = (long) e.getProperty(AccelerationControllerService.TIMESTAMP_KEY);
		double heading = (double) e.getProperty(MagControllerService.HEADING_KEY);
		if (prevHeading == Double.MAX_VALUE) {
			prevHeading = heading;
		}
		boolean turning = Math.abs(heading - prevHeading) > 2;
		prevHeading = heading;
		receiver.sendMagnetometerEvent(new MagnetometerReading(time,heading, turning));
	}

}
