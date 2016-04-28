package no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces;

import org.osgi.framework.ServiceEvent;

import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.AccelerometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.MagnetometerReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.TemperatureReading;

public interface TrainState {
	
	public void colorUpdate(ColorReading color);
	public void accelerationUpdate(AccelerometerReading acc);
	public void magnetometerUpdate(MagnetometerReading reading);
	public void temperaturUpdate(TemperatureReading temp);
	public void nfcUpdate(NFCReading hex);
	public void sensorUpdate(ServiceEvent event);
	public void dummyUpdate();

}
