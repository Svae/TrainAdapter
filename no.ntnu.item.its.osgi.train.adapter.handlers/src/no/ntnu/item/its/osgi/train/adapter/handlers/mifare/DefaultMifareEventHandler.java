package no.ntnu.item.its.osgi.train.adapter.handlers.mifare;

import org.osgi.service.event.Event;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.its.osgi.common.interfaces.MifareControllerService;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;

public class DefaultMifareEventHandler implements SensorHandler{
	
	private EventReceiver receiver;
	
	public DefaultMifareEventHandler(EventReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void handleEvent(Event e) {
		receiver.sendNFCEvent(new NFCReading((String)e.getProperty(MifareControllerService.LOC_ID_KEY)));
	}
}
