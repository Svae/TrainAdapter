package no.ntnu.item.its.osgi.train.adapter.handlers;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandlerController;
import no.ntnu.item.its.osgi.sensors.common.enums.PublisherType;
import no.ntnu.item.its.osgi.train.adapter.handlers.accelerometer.DefaultAccelerometerEventHandler;
import no.ntnu.item.its.osgi.train.adapter.handlers.color.DefaultColorEventHandler;
import no.ntnu.item.its.osgi.train.adapter.handlers.mifare.DefaultMifareEventHandler;

public class HandlerController implements SensorHandlerController{

	@Override
	public SensorHandler getSensorHandler(PublisherType type, EventReceiver receiver) {
		switch (type) {
		case ACCEL:
			return new DefaultAccelerometerEventHandler(receiver);
		case DISTANCE:
			//TODO: Add distance
			break;
		case SLEEPER:
			return new DefaultColorEventHandler(receiver);
		case BEACON:
			return new DefaultMifareEventHandler(receiver);
		case VELOCITY:
			//TODO: Add velocity
			break;
		default:
			break;
		}
		return null;
	}

}
