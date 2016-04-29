package logtester.communicationmodule;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.trainamqpservice.common.AMQPMessage;
import no.ntnu.trainamqpservice.common.AMQPProperties;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPChannel;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPService;

public class CommunicationModule extends Block {

	
	private ServiceTracker<TrainAMQPService, TrainAMQPService> amqpTracker;
	public BundleContext context;
	private TrainAMQPChannel channel;
	public AMQPProperties properties;
	
	public void init(){
		amqpTracker = new ServiceTracker<>(context, TrainAMQPService.class, null);
		amqpTracker.open();
		
	}
	
	public void connect(AMQPProperties properties){
		try {
			channel = getService().openChannel(properties);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	public void subscribeToMany(List<String> topics){
		try {
			channel.subscribe(topics);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void subscribe(String topic){
		try {
			channel.subscribe(topic);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private TrainAMQPService getService(){
		//TODO: Check for null
		return amqpTracker.getService();
	}

	public void send(AMQPMessage msg) {
		try {
			channel.send(msg.getBody(), msg.getConsumerTag());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
