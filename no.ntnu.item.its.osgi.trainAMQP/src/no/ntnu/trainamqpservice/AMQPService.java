package no.ntnu.trainamqpservice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeoutException;

import org.osgi.service.log.LogService;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import no.ntnu.trainamqpservice.common.AMQPProperties;
import no.ntnu.trainamqpservice.impl.AMQPChannel;
import no.ntnu.trainamqpservice.impl.AMQPConnection;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPChannel;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPConnection;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPService;

public class AMQPService implements TrainAMQPService {

	private ConnectionFactory factory;
	
	private HashMap<AMQPProperties, ConnectionFactory> factorylist = new HashMap<>();

	public TrainAMQPChannel openChannel(AMQPProperties properties) throws IOException, TimeoutException {

		TrainAMQPConnection connection = openConnection(properties);
		Channel channel = connection.getChannel();
		channel.exchangeDeclare(properties.getExchangename(), "topic");
		String queue = channel.queueDeclare().getQueue();
		return new AMQPChannel(channel, properties.getExchangename(), queue);

	}

	public TrainAMQPConnection openConnection(AMQPProperties properties) throws IOException, TimeoutException {
		ConnectionFactory factory = getFactory(properties);
		return new AMQPConnection(factory.newConnection());
	}

	private ConnectionFactory getFactory(AMQPProperties properties) throws IOException, TimeoutException {
		for (Entry<AMQPProperties, ConnectionFactory> entry : factorylist.entrySet()) {
			if (entry.getKey().equal(properties)) {
				return entry.getValue();
			}
		}
		return createNewFactory(properties);
	}

	public ConnectionFactory createNewFactory(AMQPProperties properties){

		factory = new ConnectionFactory();
		factory.setHost(properties.getHostname());
		factory.setPort(properties.getPort());
		factory.setUsername(properties.getUsername());
		factory.setPassword(properties.getPassword());getLogger().log(LogService.LOG_INFO,
				String.format("Factory set up to connect to %s:%d", factory.getHost(), factory.getPort()));
		return factory;
	}

	void close(){
		getLogger().log(LogService.LOG_INFO, "Closing TrainAMQPService");
	}

	private LogService getLogger() {
		if (((LogService) AMQPActivator.logServiceTracker.getService()) == null) {
			System.out.println("No logger available");
		}
		return ((LogService) AMQPActivator.logServiceTracker.getService());
	}


}
