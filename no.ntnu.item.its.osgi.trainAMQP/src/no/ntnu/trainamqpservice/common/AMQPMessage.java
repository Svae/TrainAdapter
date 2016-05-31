package no.ntnu.trainamqpservice.common;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;

public class AMQPMessage {
		
	private String consumerTag;
	private Envelope envelope;
	private AMQP.BasicProperties properties;
	private byte[] rawBody;
	
	private String topic;
	private Object body;

	public AMQPMessage(String consumerTag, Envelope envelope,
            AMQP.BasicProperties properties, byte[] rawBody) {
		this.consumerTag = consumerTag;
		this.envelope = envelope;
		this.properties = properties;
		this.rawBody = rawBody;
	}

	public AMQPMessage(String topic, Object body){
		this.topic = topic;
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

	public byte[] getRawBody() {
		return rawBody;
	}
	
	public String getTopic(){
		return topic;
	}
	
	public Object getBody(){
		return body;
	}
}
