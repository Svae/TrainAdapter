package no.ntnu.item.its.osgi.train.adapter.handlers.accelerometer;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.its.osgi.sensors.common.interfaces.AccelerationControllerService;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;

public class DefaultAccelerometerEventHandler implements SensorHandler{
	
	private EventReceiver receiver;
	
	public DefaultAccelerometerEventHandler(EventReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void handleEvent(Event e) {
		double x = (double) e.getProperty(AccelerationControllerService.X_DATA_KEY);
		long time = (long) e.getProperty(AccelerationControllerService.TIMESTAMP_KEY);
		receiver.sendAccelerationEvent((new AccelerometerReading(time, x)));
	}

}
