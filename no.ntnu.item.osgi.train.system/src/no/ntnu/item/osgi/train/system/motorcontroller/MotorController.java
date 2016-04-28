package no.ntnu.item.osgi.train.system.motorcontroller;

import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.its.osgi.common.enums.MotorCommand;
import no.ntnu.item.its.osgi.common.interfaces.ActuatorControllerService;

public class MotorController extends Block {

	
	private ServiceTracker<ActuatorControllerService, ActuatorControllerService> controllerTracker;
	public org.osgi.framework.BundleContext context;
	
	public void init(){
		controllerTracker = new ServiceTracker<>(context, ActuatorControllerService.class, new MotorControllerCustomizer());
		controllerTracker.open();
	}
	
	public void setSpeed(int speed){
		getController().send(MotorCommand.FORWARD, speed);
	}
	
	public void stopMotorBlock(){
		controllerTracker.close();
	}
	
	public void stopTrain(){
		getController().send(MotorCommand.STOP);
	}
	
	private ActuatorControllerService getController(){
		return controllerTracker.getService();
	}
	
	private class MotorControllerCustomizer implements ServiceTrackerCustomizer<ActuatorControllerService, ActuatorControllerService>{

		@Override
		public ActuatorControllerService addingService(ServiceReference<ActuatorControllerService> ref) {
			return (ActuatorControllerService)context.getService(ref);
		}

		@Override
		public void modifiedService(ServiceReference<ActuatorControllerService> arg0, ActuatorControllerService arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removedService(ServiceReference<ActuatorControllerService> arg0, ActuatorControllerService arg1) {
			stopMotorBlock();
		}
		
	}
}
