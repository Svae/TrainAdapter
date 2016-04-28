package no.ntnu.trainamqpservice.common;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import no.ntnu.trainamqpservice.interfaces.TrainAMQPChannel;

public class ConsoleConsumer extends DefaultConsumer{

	public ConsoleConsumer(TrainAMQPChannel channel) {
		super(channel.getChannel());
	}
	
	@Override
    public void handleDelivery(String consumerTag, Envelope envelope,
                               AMQP.BasicProperties properties, byte[] body) throws IOException {
      String message = new String(body, "UTF-8");
      System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
    }
	
}
