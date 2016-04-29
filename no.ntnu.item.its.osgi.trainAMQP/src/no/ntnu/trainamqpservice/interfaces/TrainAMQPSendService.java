package no.ntnu.trainamqpservice.interfaces;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import no.ntnu.trainamqpservice.common.AMQPProperties;

public interface TrainAMQPSendService {

	public void connect(AMQPProperties properties) throws IOException, TimeoutException;
	public void send(Object body, String topic) throws IOException;
}
