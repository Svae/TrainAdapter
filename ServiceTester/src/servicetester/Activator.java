package servicetester;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import impl.TestService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	/*public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		ServiceTracker amqptracker = new ServiceTracker<>(context, TrainAMQPService.class.getName(), null);
		amqptracker.open();
		service = (TrainAMQPService)amqptracker.getService();
		AMQPProperties properties = new AMQPProperties();
		TrainAMQPChannel channel = service.openChannel(properties);
		
		
		Consumer consumer = new DefaultConsumer(channel.getChannel()) {
		      @Override
		      public void handleDelivery(String consumerTag, Envelope envelope,
		                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
		        String message = new String(body, "UTF-8");
		        System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
		      }
		    };
		channel.subscribe("testi");
		
	}*/
	
	

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		ServiceReference s = bundleContext.getServiceReference(TestService.class);
		TestService t = (TestService) bundleContext.getService(s);
		t.inc();
	}

}
