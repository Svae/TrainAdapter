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

public class NFCSensor implements Sensor{

	private BundleContext context;
	private int[] hexes = {0x00001,0x00011,0x00002}; 
	
	public NFCSensor(BundleContext context) throws InterruptedException {
		this.context = context;
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				ServiceReference ref = context.getServiceReference(EventAdmin.class.getName());
				if (ref != null)
				{
					EventAdmin eventAdmin = (EventAdmin) context.getService(ref);
					for (int i : hexes) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Dictionary p = new Hashtable<>(); 
						p.put(EventProperties.VALUE.toString(), i);
						Event event = new Event(EventTopics.NFC.getTopic(), p);
						eventAdmin.postEvent(event);
					}
					

				} else System.out.println("Can't find EventAdmin!");
				
			}
		};
		new Thread(r).start();
		
	}
	
}
