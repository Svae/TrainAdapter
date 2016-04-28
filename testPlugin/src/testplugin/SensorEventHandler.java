package testplugin;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class SensorEventHandler implements EventHandler{

	@Override
	public void handleEvent(Event e) {
		System.out.println("Received event: " + e.getProperty("value"));
	}
	
	

}
