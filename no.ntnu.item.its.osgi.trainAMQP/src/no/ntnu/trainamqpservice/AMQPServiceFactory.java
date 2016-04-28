package no.ntnu.trainamqpservice;

import java.util.HashMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import no.ntnu.trainamqpservice.interfaces.TrainAMQPService;

public class AMQPServiceFactory implements ServiceFactory<TrainAMQPService>{

	
	@Override
	public TrainAMQPService getService(Bundle arg0, ServiceRegistration<TrainAMQPService> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ungetService(Bundle arg0, ServiceRegistration<TrainAMQPService> arg1, TrainAMQPService arg2) {
		// TODO Auto-generated method stub
		
	}

}
