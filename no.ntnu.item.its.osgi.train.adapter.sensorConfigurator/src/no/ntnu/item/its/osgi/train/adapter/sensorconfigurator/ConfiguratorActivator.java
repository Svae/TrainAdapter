package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces.TrainSensorConfiguratorController;

public class ConfiguratorActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration<TrainSensorConfiguratorController> reg;
	private static ServiceTracker<LogService, LogService> logServiceTracker;


	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		ConfiguratorActivator.context = bundleContext;
		logServiceTracker = new ServiceTracker<>(bundleContext, LogService.class, null);
		logServiceTracker.open();
		reg = context.registerService(TrainSensorConfiguratorController.class, new SensorConfiguratorController(context), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		reg.unregister();
		logServiceTracker.close();
		ConfiguratorActivator.context = null;
	}
	
	public static LogService getLogger(){
		return logServiceTracker.getService();
	}

}
