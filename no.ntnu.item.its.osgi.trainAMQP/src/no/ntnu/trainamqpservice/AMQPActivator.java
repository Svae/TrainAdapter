package no.ntnu.trainamqpservice;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.trainamqpservice.interfaces.TrainAMQPSendService;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPService;

public class AMQPActivator implements BundleActivator {

	protected static ServiceTracker<LogService, Object> logServiceTracker;

	private static BundleContext context;
	private ServiceRegistration<TrainAMQPService> reg;
	private ServiceRegistration<TrainAMQPSendService> sendReg;
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		AMQPActivator.context = bundleContext;
		logServiceTracker = new ServiceTracker<>(AMQPActivator.getContext(), LogService.class, null);
		logServiceTracker.open();
		reg = (ServiceRegistration<TrainAMQPService>) context.registerService(TrainAMQPService.class.getName(), new AMQPService(), null);
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		
		reg.unregister();
		logServiceTracker.close();
		AMQPActivator.context = null;
	}

}
