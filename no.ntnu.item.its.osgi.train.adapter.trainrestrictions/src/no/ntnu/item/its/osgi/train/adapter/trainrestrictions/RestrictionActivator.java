package no.ntnu.item.its.osgi.train.adapter.trainrestrictions;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.interfaces.TrainRestrictionsChecker;
import no.ntnu.item.its.osgi.train.adapter.trainrestrictions.legotrain.LegoTrainRestrictionChecker;

public class RestrictionActivator implements BundleActivator{

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
		RestrictionActivator.context = bundleContext;
		reg = context.registerService(TrainRestrictionsChecker.class.getName(), new LegoTrainRestrictionChecker(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		reg.unregister();
		RestrictionActivator.context = null;
	}
	
	public RestrictionActivator() {
		// TODO Auto-generated constructor stub
	}

}
