package no.ntnu.item.its.osgi.train.adapter.handlers;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import no.ntnu.item.ites.osgi.train.adapter.handlers.common.interfaces.SensorHandlerController;

public class HandlersActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration reg;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		HandlersActivator.context = bundleContext;
		reg = context.registerService(SensorHandlerController.class, new HandlerController(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		reg.unregister();
		HandlersActivator.context = null;
	}

}
