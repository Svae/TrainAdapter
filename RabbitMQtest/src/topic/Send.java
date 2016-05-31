package topic;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	private static String EXCHANGE_NAME = "trainCommunication";
	private static Gson gson;

	public static void main(String[] argv) throws Exception {
		gson = new Gson();
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.0.196");
		factory.setUsername("test");
		factory.setPassword("test");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "topic");

		String routingKey = "traincommand/*";
		String message = getMessage();

		channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
		System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

		connection.close();

	}

	private static String getMessage() {
	}
}
