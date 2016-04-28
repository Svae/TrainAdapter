package topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	private static String EXCHANGE_NAME = "trainAMQPtest";
	
	  public static void main(String[] argv)
              throws Exception {

    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("192.168.0.196");
    factory.setUsername("test");
    factory.setPassword("test");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "topic");

    String routingKey = "testi";
    String message = "trololo";

    channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
    System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

    connection.close();
	
	  }
}
