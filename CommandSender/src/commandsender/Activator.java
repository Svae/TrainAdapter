package commandsender;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.trainamqpservice.common.LegoTrainAMQPSendServiceTrackerCustomizer;
import no.ntnu.trainamqpservice.interfaces.TrainAMQPSendService;

public class Activator implements BundleActivator {

	private static BundleContext context;
//	private ServiceTracker<TrainAMQPSendService, TrainAMQPSendService> amqpTracker;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	/*	amqpTracker = new ServiceTracker<>(bundleContext, TrainAMQPSendService.class, new LegoTrainAMQPSendServiceTrackerCustomizer(bundleContext));
		amqpTracker.open();
		amqpTracker.getService().send((Object)getMessage(), "traincommand");*/
	}

	private Object getMessage() {
		//return new TrainCommand(TrainCommandType.STOP, SpeedRestrictionLevel.NORMAL);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
