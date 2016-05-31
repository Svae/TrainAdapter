package no.ntnu.trainamqpservice.impl;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import no.ntnu.trainamqpservice.common.AMQPProperties;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPChannel;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPConnection;

public class AMQPConnection implements TrainAMQPConnection{
	
	private Connection connection;
	private AMQPProperties properties;
	
	public AMQPConnection(Connection connection, AMQPProperties properties) {
		this.connection = connection;
		this.properties = properties;
	}

	@Override
	public TrainAMQPChannel getChannel() throws IOException {
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(properties.getExchangename(), "topic");
		String queue = channel.queueDeclare().getQueue();
		return new AMQPChannel(connection.createChannel(), properties.getExchangename(), queue);
	}

	@Override
	public void closeConnection() throws IOException {
		connection.close();
	}
	
	

}
