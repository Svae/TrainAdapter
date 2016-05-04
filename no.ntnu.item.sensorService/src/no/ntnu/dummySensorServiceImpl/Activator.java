package no.ntnu.dummySensorServiceImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import no.ntnu.item.its.osgi.common.interfaces.SensorSchedulerService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceTracker<SensorSchedulerService, SensorSchedulerService> tracker;
	

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		tracker = new ServiceTracker<>(context, SensorSchedulerService.class, null);
		tracker.open();
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("RUNNABLE");
			}
		};
		tracker.getService().add(runnable, 1000, 2000);
		Thread.sleep(11000);
		tracker.getService().remove(runnable, false);
		tracker.getService().add(runnable, 1000, 5000);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		
		Activator.context = null;
	}

}
