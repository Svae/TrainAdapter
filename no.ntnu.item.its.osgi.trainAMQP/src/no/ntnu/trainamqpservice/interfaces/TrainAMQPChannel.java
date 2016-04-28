package no.ntnu.trainamqpservice.interfaces;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

import no.ntnu.trainamqpservice.common.TrainDefaultConsumer;

public interface TrainAMQPChannel{
	public void setConsumer(TrainDefaultConsumer consumer) throws IOException;
	public void subscribe(String topic) throws IOException;
	public void subscribe(List<String> topics) throws IOException;
	public void unSubscribe(String topic) throws IOException;
	public void send(Object message, String topic) throws IOException;
	public void closeChannel() throws IOException, TimeoutException;
	public Channel getChannel();
}
