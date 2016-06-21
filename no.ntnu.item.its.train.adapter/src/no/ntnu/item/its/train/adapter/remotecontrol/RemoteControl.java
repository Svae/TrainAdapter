package no.ntnu.item.its.train.adapter.remotecontrol;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.function.Function;

import org.osgi.util.tracker.ServiceTracker;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

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
	private Gson gson;
	
	private String topic= "trains.0.traincommand";
	
	private String error = "ERROR";
	private String failed = "FAILED";
	private String received = "RECEIVED";
	private String ready = "READY";

	public void initAMQP() {
		amqpTracker = new ServiceTracker<>(context, TrainAMQPService.class.getName(), null);
		amqpTracker.open();
		gson = new Gson();
		//For testing
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				getChannel();
			}
		};
		runAsync(r);
	}
	
	private void getChannel(){
		if(amqpTracker.getService() == null){
			sendToBlock(failed, "Could not find AMQPSerivce");
			return;
		}
		TrainAMQPService service = (TrainAMQPService)amqpTracker.getService();
		AMQPProperties properties = new AMQPProperties();
		try {
			channel = service.openChannel(properties);
			function = getCallbackFunction();
			consumer = new TrainDefaultConsumer(function, channel);
			channel.setConsumer(consumer);
			//For testing
			channel.subscribe(topic);
			logger.info(this.getClass().getSimpleName() + " is ready");
			sendToBlock(ready);
		} catch (Exception e) {
			logger.error(this.getClass().getSimpleName() + " failed to start");
			sendToBlock(failed, e.getMessage());
		}
	}
	
	private Function<AMQPMessage, Void> getCallbackFunction(){
		return new Function<AMQPMessage, Void>() {

			@Override
			public Void apply(AMQPMessage t) {
				TrainCommand cmd = deserilizeBody(t.getRawBody());
				logger.debug("Received message");
				if(cmd == null) return null;
				sendToBlock(received, cmd);
				return null;
			}
			
		};
	}
	
	private TrainCommand deserilizeBody(byte[] body){
		
			String json;
			try {
				json = new String(body, "UTF-8");
				TrainCommand cmd = gson.fromJson(json, TrainCommand.class);
				return cmd;
			} catch (UnsupportedEncodingException e1) {
				sendToBlock(error, e1.getMessage());
			} catch (JsonSyntaxException e2){
				sendToBlock(error, e2.getMessage());
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
