package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces.TrainSensorConfiguratorController;

public class ConfiguratorActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration<TrainSensorConfiguratorController> reg;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		ConfiguratorActivator.context = bundleContext;
		reg = context.registerService(TrainSensorConfiguratorController.class, new SensorConfiguratorController(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		reg.unregister();
		ConfiguratorActivator.context = null;
	}

}
