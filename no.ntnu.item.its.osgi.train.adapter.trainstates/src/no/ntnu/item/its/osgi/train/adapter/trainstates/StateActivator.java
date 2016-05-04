package no.ntnu.item.its.osgi.train.adapter.trainstates;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController;

public class StateActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration<TrainStateController> reg;
	protected static ServiceTracker<LogService, Object> logServiceTracker;

	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		StateActivator.context = bundleContext;
		logServiceTracker = new ServiceTracker<>(bundleContext, LogService.class, null);
		logServiceTracker.open();
		reg = context.registerService(TrainStateController.class, new StateController(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		logServiceTracker.close();
		reg.unregister();
		StateActivator.context = null;
	}

}
