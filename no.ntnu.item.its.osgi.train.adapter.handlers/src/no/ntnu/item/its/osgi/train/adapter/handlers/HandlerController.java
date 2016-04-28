package no.ntnu.item.its.osgi.train.adapter.handlers;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandlerController;
import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.handlers.accelerometer.DefaultAccelerometerEventHandler;
import no.ntnu.item.its.osgi.train.adapter.handlers.color.DefaultColorEventHandler;
import no.ntnu.item.its.osgi.train.adapter.handlers.magnetometer.DefaultMagnetometerEventHandler;
import no.ntnu.item.its.osgi.train.adapter.handlers.mifare.DefaultMifareEventHandler;

public class HandlerController implements SensorHandlerController{

	@Override
	public SensorHandler getSensorHandler(PublisherType type, EventReceiver receiver) {
		switch (type) {
		case ACCEL:
			return new DefaultAccelerometerEventHandler(receiver);
		case DISTANCE:
			//TODO: Distance publisher is not implemented
			break;
		case SLEEPER:
			return new DefaultColorEventHandler(receiver);
		case BEACON:
			return new DefaultMifareEventHandler(receiver);
		case VELOCITY:
			//TODO: Velocity publisher is not implemented
			break;
		case MAG:
			return new DefaultMagnetometerEventHandler(receiver);
		default:
			break;
		}
		return null;
	}

}
