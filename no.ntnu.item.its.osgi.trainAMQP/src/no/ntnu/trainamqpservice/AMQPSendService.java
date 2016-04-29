package no.ntnu.trainamqpservice;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.osgi.service.log.LogService;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import no.ntnu.trainamqpservice.common.AMQPProperties;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPSendService;

public class AMQPSendService implements TrainAMQPSendService {

	
	private ConnectionFactory factory;
	private Channel channel;
	private Gson gson = new Gson();
	private String exchangeName;


	@Override
	public void connect(AMQPProperties properties) throws IOException, TimeoutException {
		createNewFactory(properties);
		exchangeName = properties.getExchangename();
		channel = factory.newConnection().createChannel();
	}
	
	public void createNewFactory(AMQPProperties properties) throws IOException, TimeoutException {
		if(factory != null) getLogger().log(LogService.LOG_INFO, "Reconfiguring Connection factory");
		factory = new ConnectionFactory();
		factory.setHost(properties.getHostname());
		factory.setPort(properties.getPort());
		factory.setUsername(properties.getUsername());
		factory.setPassword(properties.getPassword());
		getLogger().log(LogService.LOG_INFO,
				String.format("Connection made to %s:%d", factory.getHost(), factory.getPort()));
	}

	@Override
	public void send(Object body, String topic) throws IOException {
		String serialized;
		if(body instanceof String) serialized = (String) body;
		else serialized = gson.toJson(body);
		channel.basicPublish(exchangeName, topic, MessageProperties.PERSISTENT_BASIC, serialized.getBytes());
	}
	
	private LogService getLogger() {
		if (((LogService) AMQPActivator.logServiceTracker.getService()) == null) {
			System.out.println("No logger available");
		}
		return ((LogService) AMQPActivator.logServiceTracker.getService());
	}

}
