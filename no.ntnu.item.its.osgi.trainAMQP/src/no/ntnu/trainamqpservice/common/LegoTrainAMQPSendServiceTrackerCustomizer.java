package no.ntnu.trainamqpservice.common;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import no.ntnu.trainamqpservice.interfaces.TrainAMQPSendService;

public class LegoTrainAMQPSendServiceTrackerCustomizer implements ServiceTrackerCustomizer<TrainAMQPSendService, TrainAMQPSendService> {

	private BundleContext context;
	
	private AMQPProperties properties;
	
	public LegoTrainAMQPSendServiceTrackerCustomizer(BundleContext context, AMQPProperties properties) {
		this.context = context;
		this.properties = properties;
	}
	
	public LegoTrainAMQPSendServiceTrackerCustomizer(BundleContext context) {
		this.context = context;
		this.properties = new AMQPProperties();
	}
	
	
	@Override
	public TrainAMQPSendService addingService(ServiceReference<TrainAMQPSendService> ref) {
		TrainAMQPSendService service = (TrainAMQPSendService) context.getService(ref);
		try {
			service.connect(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return service;
	}


	@Override
	public void modifiedService(ServiceReference<TrainAMQPSendService> arg0, TrainAMQPSendService arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removedService(ServiceReference<TrainAMQPSendService> arg0, TrainAMQPSendService arg1) {
		// TODO Auto-generated method stub
		
	}

}
