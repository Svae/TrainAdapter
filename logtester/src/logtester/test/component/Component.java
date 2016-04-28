package logtester.test.component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.trainamqpservice.common.AMQPMessage;
import no.ntnu.trainamqpservice.common.AMQPProperties;
import no.ntnu.trainamqpservice.common.TrainDefaultConsumer;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPChannel;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPService;

public class Component extends Block {
	
	
	public org.osgi.framework.BundleContext context;

	TrainAMQPChannel channel;
	Function<AMQPMessage, Void> function;
	AMQPProperties properties;
	TrainDefaultConsumer consumer;
	ServiceTracker<TrainAMQPService, Object> tracker;
	
	public void initAMQP() {
		tracker = new ServiceTracker<>(context, TrainAMQPService.class, null);
		tracker.open();
		properties = new AMQPProperties();
		function = createFunction();
		
		try {
			channel = ((TrainAMQPService)tracker.getService()).openChannel(properties);
			channel.subscribe("testi");
			consumer = new TrainDefaultConsumer(function, channel);
			channel.setConsumer(consumer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
	}

	
	private Function<AMQPMessage, Void> createFunction() {
		Function<AMQPMessage, Void> function = new Function<AMQPMessage, Void>() {

			@Override
			public Void apply(AMQPMessage t) {
				String msg = new String(t.getBody());
				sendToBlock("MSG", msg);
				return null;
			}
		};
		return function;
	}
	
	private Function<AMQPMessage, Void> createFunction2() {
		Function<AMQPMessage, Void> function = new Function<AMQPMessage, Void>() {

			@Override
			public Void apply(AMQPMessage t) {
				String msg = new String(t.getBody());
				msg += " new function";
				sendToBlock("MSG", msg);
				return null;
			}
		};
		return function;
	}
	
	


	public void printMsg(String s){
		System.out.println("Got message: " + s);
		consumer.setFunction(createFunction2());
		
	}
}
