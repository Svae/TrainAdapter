package dummySensors;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import no.ntnu.item.its.sensor.common.enums.EventProperties;
import no.ntnu.item.its.sensor.common.enums.EventTopics;
import no.ntnu.item.its.sensor.common.interfaces.Sensor;

public class AccelerationSensor implements Sensor {

	private BundleContext context;
	public AccelerationSensor(BundleContext context) {
		this.context = context;
		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ServiceReference ref = context.getServiceReference(EventAdmin.class.getName());
				if (ref != null)
				{
					EventAdmin eventAdmin = (EventAdmin) context.getService(ref);
					Dictionary<String, Double> p = new Hashtable<>(); 
					p.put(EventProperties.VALUE.toString(), (double) 1);

					Event event = new Event(EventTopics.ACCELERATION.getTopic(), p);
					eventAdmin.postEvent(event);

				} else System.out.println("Can't find EventAdmin!");

			};
		};
	new Thread(r).start();
	}
}
