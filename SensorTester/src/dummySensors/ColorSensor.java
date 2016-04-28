package dummySensors;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import no.ntnu.item.its.sensor.common.enums.EventTopics;
import no.ntnu.item.its.sensor.common.interfaces.Sensor;
import no.ntnu.item.its.train.adapter.enums.SleeperColor;

public class ColorSensor implements Sensor{
	
	private BundleContext context;
	private HashMap<SleeperColor, Integer> track2;
	private ArrayList<SleeperTuple> track1;

	public ColorSensor(BundleContext context) {
		System.out.println("ColorSensor started");
		this.context = context;
		track2 = new HashMap<>();
		track1 = new ArrayList<>();
		createTrack();
		ServiceReference ref = context.getServiceReference(EventAdmin.class.getName());
        if (ref != null)
        {
            EventAdmin eventAdmin = (EventAdmin) context.getService(ref);
            Runnable r = new Runnable() {
				
				@Override
				public void run() {
					System.out.println("Thread running");
					Dictionary p = new Hashtable<>();
					Event event;
					int factor;
					for (SleeperTuple sleeper : track1) {
						p.put("value", sleeper.getColor());
						factor = (sleeper.getColor() == SleeperColor.RED) ? 2000 : 1000; 
						event = new Event(EventTopics.COLOR.getTopic(), p);
				        eventAdmin.postEvent(event);
				        try {
							Thread.sleep(sleeper.getNextSleeper()*factor);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					 System.out.println("DONE!");
				}
			};
			new Thread(r).start();
        } else System.out.println("Can't find EventAdmin!");
	}
	
	private void createTrack(){
		track1.add(new SleeperTuple(SleeperColor.BLUE, 13));
		track1.add(new SleeperTuple(SleeperColor.GREEN, 3));
		track1.add(new SleeperTuple(SleeperColor.RED, 3));
		track1.add(new SleeperTuple(SleeperColor.RED, 3));
		track1.add(new SleeperTuple(SleeperColor.GREEN, 3));
		track1.add(new SleeperTuple(SleeperColor.BLUE, 20));
		/*track2.add(SleeperColor.YELLOW);
		track2.add(SleeperColor.BLUE);
		track2.add(SleeperColor.YELLOW);*/
		
		
	}
	
	private class SleeperTuple{
		private SleeperColor color;
		private int nextSleeper;
		
		public SleeperTuple(SleeperColor color, int nextSleeper) {
			this.color = color;
			this.nextSleeper = nextSleeper;
		}
		
		public SleeperColor getColor(){
			return color;
		}
		
		public int getNextSleeper() {
			return nextSleeper;
			
		}
	}
}
