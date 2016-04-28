package servicetester;

import java.io.IOException;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import no.ntnu.trainamqpservice.common.AMQPProperties;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPChannel;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceTracker amqptracker;
	private TrainAMQPService service;
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
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
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
