package no.ntnu.trainamqpservice.impl;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import no.ntnu.trainamqpservice.interfaces.TrainAMQPConnection;

public class AMQPConnection implements TrainAMQPConnection{
	
	private Connection connection;
	
	public AMQPConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Channel getChannel() throws IOException {
		return connection.createChannel();
	}

	@Override
	public void closeChannel() throws IOException {
		connection.close();
	}
	
	

}
