package no.ntnu.item.its.osgi.train.adapter.maprestrictions;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import no.ntnu.item.its.osgi.train.adapter.maprestrictions.interfaces.MapRestrictionController;

public class RestrictionActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration<MapRestrictionController> reg;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		RestrictionActivator.context = bundleContext;
		reg = context.registerService(MapRestrictionController.class, new RestrictionController(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		reg.unregister();
		RestrictionActivator.context = null;
	}

}
