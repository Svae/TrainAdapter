package no.ntnu.amqpimpl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import no.ntnu.amqpinterface.TrainAmqp;

public class TrainAmqpimpl implements TrainAmqp{

	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;
	private String queue_name;
	private Consumer consumer;

	private BundleContext context;
	private EventAdmin eventAdmin;
	private String eventTopic;
	
	
	public TrainAmqpimpl(BundleContext context) {
		this.context = context;
		eventTopic = "test/communication/";
		ServiceReference ref = context.getServiceReference(EventAdmin.class.getName());
        if (ref != null)
        {
            eventAdmin = (EventAdmin) context.getService(ref);
        }
	}
	
	@Override
	public void connect(String host, int port, String username, String password, String exchange) throws IOException, TimeoutException {
		factory.setHost(host);
		factory.setUsername(username);
		factory.setPassword(password);
		connection = factory.newConnection();
		channel = connection.createChannel();
		channel.exchangeDeclare(exchange, "topic");
		queue_name = channel.queueDeclare().getQueue();
		consumer = new DefaultConsumer(channel) {
		      @Override
		      public void handleDelivery(String consumerTag, Envelope envelope,
		                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
		        String value = new String(body);
		        System.out.println("Message topic: " + envelope.getRoutingKey());		        
		    };
		};
		    
		channel.basicConsume(queue_name, true, consumer);

		
		
	}
	

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribe(String topic) {
		// TODO Auto-generated method stub
		
	}
}
