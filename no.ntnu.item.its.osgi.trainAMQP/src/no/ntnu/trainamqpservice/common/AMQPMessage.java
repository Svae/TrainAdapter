package no.ntnu.trainamqpservice.common;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;

public class AMQPMessage {
	
	
	private String consumerTag;
	private Envelope envelope;
	private AMQP.BasicProperties properties;
	private byte[] body;

	public AMQPMessage(String consumerTag, Envelope envelope,
            AMQP.BasicProperties properties, byte[] body) {
		this.consumerTag = consumerTag;
		this.envelope = envelope;
		this.properties = properties;
		this.body = body;
	}

	public String getConsumerTag() {
		return consumerTag;
	}

	public Envelope getEnvelope() {
		return envelope;
	}

	public AMQP.BasicProperties getProperties() {
		return properties;
	}

	public byte[] getBody() {
		return body;
	}
	
}
