package no.ntnu.trainamqpservice.common;

import java.io.IOException;
import java.util.function.Function;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import no.ntnu.trainamqpservice.interfaces.TrainAMQPChannel;

public class TrainDefaultConsumer extends DefaultConsumer {

	Function<AMQPMessage, Void> function;
	
	public TrainDefaultConsumer(Function<AMQPMessage, Void>function, TrainAMQPChannel channel) {
		super(channel.getChannel());
		this.function = function;
	}
	

	@Override
    public void handleDelivery(String consumerTag, Envelope envelope,
                               AMQP.BasicProperties properties, byte[] body) throws IOException {
		AMQPMessage msg = new AMQPMessage(consumerTag, envelope, properties, body);
		synchronized (function) {
			function.apply(msg);
		}
    }
	
	public void setFunction(Function<AMQPMessage, Void> function){
		this.function = function;
	}

}
