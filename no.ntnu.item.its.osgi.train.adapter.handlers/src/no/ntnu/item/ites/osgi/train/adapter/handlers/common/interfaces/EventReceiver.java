package no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces;

import no.ntnu.item.its.osgi.common.enums.PublisherType;
import no.ntnu.item.its.osgi.common.enums.Status;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;

public interface EventReceiver {

	public void sendColorEvent(ColorReading color);
	public void sendNFCEvent(NFCReading locationID);
	public void sendAccelerationEvent(AccelerometerReading acc);
	public void sendMagnetometerEvent(MagnetometerReading direction);
	public void sendDummyEvent();
	public void sendTemperaturEvent(TemperatureReading temp);
	public void sendSensorStateEvent(Status status, PublisherType type);
}
