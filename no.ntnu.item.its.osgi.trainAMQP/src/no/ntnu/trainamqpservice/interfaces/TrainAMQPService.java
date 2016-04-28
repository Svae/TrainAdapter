package no.ntnu.trainamqpservice.interfaces;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import no.ntnu.trainamqpservice.common.AMQPProperties;

public interface TrainAMQPService {
	

	public TrainAMQPChannel openChannel(AMQPProperties properties) throws IOException, TimeoutException;
	public TrainAMQPConnection openConnection(AMQPProperties properties) throws IOException, TimeoutException;

}
