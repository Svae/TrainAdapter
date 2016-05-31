package no.ntnu.trainamqpservice.interfaces;

import java.io.IOException;

import com.rabbitmq.client.Channel;

public interface TrainAMQPConnection {
	
	public TrainAMQPChannel getChannel() throws IOException;
	public void closeConnection() throws IOException;

}
