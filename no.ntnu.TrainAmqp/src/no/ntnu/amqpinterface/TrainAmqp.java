package no.ntnu.amqpinterface;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface TrainAmqp {
	
	public void connect(String host, int port, String username, String password, String exchange) throws IOException, TimeoutException;
	public void send(String msg);
	public void subscribe(String topic);

}
