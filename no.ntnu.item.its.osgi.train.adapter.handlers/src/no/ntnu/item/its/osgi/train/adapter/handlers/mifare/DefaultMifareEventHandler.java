package no.ntnu.item.its.osgi.train.adapter.handlers.mifare;

import org.osgi.service.event.Event;
import org.osgi.service.log.LogService;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.its.osgi.common.interfaces.MifareControllerService;
import no.ntnu.item.its.osgi.train.adapter.handlers.HandlersActivator;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.NFCReading;

public class DefaultMifareEventHandler implements SensorHandler{
	
	private EventReceiver receiver;
	
	public DefaultMifareEventHandler(EventReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void handleEvent(Event e) {
		String id = (String)e.getProperty(MifareControllerService.LOC_ID_KEY);
		HandlersActivator.getLogger().log(LogService.LOG_DEBUG, String.format("[%s] %s",this.getClass().getSimpleName(), id));
		receiver.sendNFCEvent(new NFCReading(id));
	}
}
