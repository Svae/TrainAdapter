package sensortester;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import dummySensors.AccelerationSensor;
import dummySensors.ColorSensor;
import dummySensors.NFCSensor;
import no.ntnu.item.its.sensor.common.enums.EventProperties;
import no.ntnu.item.its.sensor.common.enums.SensorType;
import no.ntnu.item.its.sensor.common.interfaces.Sensor;



public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceTracker tracker;
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Dictionary dp = new Hashtable();
		dp.put(EventProperties.TYPE.toString(), SensorType.ACCELEROMETER);
		context.registerService(Sensor.class.getName(), new AccelerationSensor(context), dp);
		dp.put(EventProperties.TYPE.toString(), SensorType.NFC);
		context.registerService(Sensor.class.getName(), new NFCSensor(context), dp);
		
		
/*
		dp.put("type", SensorType.ACCELEROMETER);
		context.registerService(Sensor.class.getName(), new AccelerationSensor(context), dp);
*/
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
