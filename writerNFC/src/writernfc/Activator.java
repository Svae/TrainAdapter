package writernfc;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import impl.TestService;

public class Activator implements BundleActivator {

	private static BundleContext context;	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	/*public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Filter filter = null;
		try {
			filter = context.createFilter(filterString);
			beaconTracker = new ServiceTracker<>(context, filter, null);
			beaconTracker.open();

			

			
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
					try {
						Thread.sleep(5000);
						doWrite(String.valueOf((99999988)));
						Thread.sleep(5000);
						doWrite(String.valueOf((99999991)));
						Thread.sleep(5000);
						for (int i = 0; i < 12; i++) {
							doRead();
							Thread.sleep(5000);
						}
						doRead();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
		};
		new Thread(runnable).start();
	}*/

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	
	
	
	/*private void doWrite(String content) {
		System.out.println("doWrite()");
		if(beaconTracker.getService() == null) System.out.println("NULL");
		beaconTracker.getService().write(content);
	}

	private void doRead(){
		beaconTracker.getService().read();
	}*/

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		ServiceTracker<TestService, TestService> t = new ServiceTracker<>(bundleContext, TestService.class, null);
		t.open();
		Thread.sleep(4000);
		t.getService().inc();
		Thread.sleep(10000);
		}
}
