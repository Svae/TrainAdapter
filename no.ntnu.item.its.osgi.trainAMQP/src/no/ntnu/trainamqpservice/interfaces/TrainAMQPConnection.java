package no.ntnu.trainamqpservice.interfaces;

import java.io.IOException;

import com.rabbitmq.client.Channel;

public interface TrainAMQPConnection {
	
	public Channel getChannel() throws IOException;
	public void closeChannel() throws IOException;

}
