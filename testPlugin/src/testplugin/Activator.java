package testplugin;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import impl.TestService;

public class Activator implements BundleActivator {

	// AMQPServiceIF service;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello World!!");
		/*ServiceReference<?> serviceRef = context.getServiceReference(AMQPServiceIF.class.getName());
		service = (AMQPServiceIF) context.getService(serviceRef);
		service.connectToBroker("192.168.0.196", "hello", 0, 0);
		subscribe();*/
		Dictionary dp = new Hashtable<>();
		//dp.put(EventConstants.EVENT_TOPIC ,"test/*");
		//context.registerService(EventHandler.class.getName(), new SensorEventHandler(), dp);
		context.registerService(TestService.class, new TestService(), dp);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}


}
