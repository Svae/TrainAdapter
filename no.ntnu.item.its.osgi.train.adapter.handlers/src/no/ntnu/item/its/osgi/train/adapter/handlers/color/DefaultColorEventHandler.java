package no.ntnu.item.its.osgi.train.adapter.handlers.color;

import org.osgi.service.event.Event;
import org.osgi.service.log.LogService;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.EventReceiver;
import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandler;
import no.ntnu.item.its.osgi.common.enums.EColor;
import no.ntnu.item.its.osgi.common.interfaces.ColorControllerService;
import no.ntnu.item.its.osgi.train.adapter.handlers.HandlersActivator;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.enums.SleeperColor;
import no.ntnu.item.its.osgi.train.adapter.handlers.common.readings.ColorReading;

public class DefaultColorEventHandler implements SensorHandler{

	private EventReceiver receiver;
	
	public DefaultColorEventHandler(EventReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void handleEvent(Event e) {
		if(e.getProperty(ColorControllerService.COLOR_KEY) == null || !(e.getProperty(ColorControllerService.COLOR_KEY) instanceof EColor)) return;
		EColor ec = (EColor)e.getProperty(ColorControllerService.COLOR_KEY);
		if(ec  == EColor.BLUE ) HandlersActivator.getLogger().log(LogService.LOG_DEBUG, String.format("[%s] %d %s", this.getClass().getSimpleName(), System.currentTimeMillis(), ec));
		ColorReading cr = new ColorReading(convert(ec));
		receiver.sendColorEvent(cr);
	}
	
	private SleeperColor convert(EColor c){
		return SleeperColor.valueOf(c.name());
	}
	
}
