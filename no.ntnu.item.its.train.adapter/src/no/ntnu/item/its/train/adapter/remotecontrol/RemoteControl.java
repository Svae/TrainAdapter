package no.ntnu.item.its.train.adapter.remotecontrol;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.function.Function;

import org.osgi.util.tracker.ServiceTracker;

import com.google.gson.Gson;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.its.train.adapter.common.TrainCommand;
import no.ntnu.trainamqpservice.common.AMQPMessage;
import no.ntnu.trainamqpservice.common.AMQPProperties;
import no.ntnu.trainamqpservice.common.TrainDefaultConsumer;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPChannel;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPService;

public class RemoteControl extends Block {
	public org.osgi.framework.BundleContext context;
	private ServiceTracker<TrainAMQPService, TrainAMQPService> amqpTracker;
	private TrainAMQPChannel channel;
	private TrainDefaultConsumer consumer;
	private Function<AMQPMessage, Void> function;
	private String topic;
	private Gson gson;
	
	private String error = "ERROR";
	private String failed = "FAILED";
	private String received = "RECEIVED";
	private String ready = "READY";

	public void initAMQP() {
		amqpTracker = new ServiceTracker<>(context, TrainAMQPService.class.getName(), null);
		amqpTracker.open();
		gson = new Gson();
		//For testing
		topic = "traincommand";
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				getChannel();
			}
		};
		runAsync(r);
	}
	
	private void getChannel(){
		if(amqpTracker.getService() == null) return;
		TrainAMQPService service = (TrainAMQPService)amqpTracker.getService();
		AMQPProperties properties = new AMQPProperties();
		function = getCallbackFunction();
		try {
			channel = service.openChannel(properties);
			consumer = new TrainDefaultConsumer(function, channel);
			channel.setConsumer(consumer);
			//For testing
			channel.subscribe(topic);
			sendToBlock(ready);
		} catch (Exception e) {
			sendToBlock(failed, e.getMessage());
		}
	}
	
	private Function<AMQPMessage, Void> getCallbackFunction(){
		return new Function<AMQPMessage, Void>() {

			@Override
			public Void apply(AMQPMessage t) {
				String msg = decodeBody(t.getRawBody());
				logger.debug("Received message");
				if(msg == null) return null;
				sendToBlock(received, (TrainCommand)gson.fromJson(msg, TrainCommand.class));
				return null;
			}
			
		};
	}
	
	private String decodeBody(byte[] body){
		try {
			return new String(body, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			sendToBlock(error, e.getMessage());
		}
		return null;
	}

	public void sendMsg(AMQPMessage msg) {
		try {
			channel.send(msg.getBody(), msg.getTopic());
		} catch (IOException e) {
			sendToBlock(error, e.getMessage());
		}
	}
	
	public void addTopic(String topic){
		try {
			channel.subscribe(topic);
		} catch (IOException e) {
			sendToBlock("ERROR", e.getMessage());
		}
	}
	
	public void addTopics(List<String> topics){
		try {
			channel.subscribe(topics);
		} catch (IOException e) {
			sendToBlock("ERROR", e.getMessage());
		}
	}
	
	public void removeTopic(String topic){
		try {
			channel.unSubscribe(topic);
		} catch (IOException e) {
			sendToBlock("ERROR", e.getMessage());
		}
	}
	
	public void removeTopics(List<String> topics){
		for(String t : topics) removeTopic(t);
	}
	
	public void stop(){
		try {
			channel.closeChannel();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		amqpTracker.close();
	}
}
