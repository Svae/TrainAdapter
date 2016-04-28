package simple;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	private final static String QUEUE_NAME = "tests";
	private final static String HOST = "192.168.0.196";
	private final static String FILEPATH = "resources/data.txt";
	
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException{

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setPassword("test");
		factory.setUsername("test");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false,false,false, null);
		channel.basicPublish("", QUEUE_NAME, null, "testitest".getBytes());
		System.out.println(" [x] Sent '" + "testitest" +"'");
		channel.close();
		connection.close();
	}
}
