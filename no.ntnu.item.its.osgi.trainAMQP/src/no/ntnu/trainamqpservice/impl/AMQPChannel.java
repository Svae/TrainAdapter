package no.ntnu.trainamqpservice.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.MessageProperties;

import no.ntnu.trainamqpservice.common.TrainDefaultConsumer;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPChannel;

public class AMQPChannel implements TrainAMQPChannel{
	
	private Channel channel;
	private String exchangeName;
	private String queueName;
	
	private Gson gson = new Gson();
	
	public AMQPChannel(Channel channel, String exchangeName, String queueName) {
		this.channel = channel;
		this.exchangeName = exchangeName;
		this.queueName = queueName;
	}

	public void send(Object message, String topic) throws IOException {
		String body;
		if(message instanceof String) body = (String) message;
		else body = gson.toJson(message);
		channel.basicPublish(exchangeName, topic, MessageProperties.PERSISTENT_BASIC, body.getBytes());
	}
	
	public void setConsumer(TrainDefaultConsumer consumer) throws IOException {
		channel.basicConsume(queueName, true, consumer);
	}
	
	@Override
	public void subscribe(String topic) throws IOException {
		if(channel == null) return;
		channel.queueBind(queueName, exchangeName, topic);		
	}
	
	@Override
	public void subscribe(List<String> topics) throws IOException{
		if(channel == null) return;
		for (String t : topics) {subscribe(t);}
	}

	@Override
	public void unSubscribe(String topic) throws IOException {
		channel.queueUnbind(queueName, exchangeName, topic);
	}

	@Override
	public void closeChannel() throws IOException, TimeoutException {
		channel.close();
		
	}

	@Override
	public Channel getChannel() {
		return channel;
	}
}
