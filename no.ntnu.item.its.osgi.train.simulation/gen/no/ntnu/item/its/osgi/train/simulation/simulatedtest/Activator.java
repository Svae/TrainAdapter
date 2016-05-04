package no.ntnu.item.its.osgi.train.simulation.simulatedtest;

import java.util.concurrent.Semaphore;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.arctis.runtime.Runtime;
import no.ntnu.item.arctis.runtime.Runtime.TerminationRequester;

public class Activator implements BundleActivator {
	private final Logger logger = LoggerFactory.getLogger(Activator.class);
	private Runtime runtime;
	private Semaphore lock = new Semaphore(0);

	@Override
	public void start(BundleContext bc) {
		logger.info("Bundle starts: no.ntnu.item.its.osgi.train.simulation");
		runtime = MyRuntime.create();
		runtime.setTerminationListener(new Runtime.IRuntimeTerminationListener() {
			@Override
			public void terminationReqFromApp() {
				// Nothing to clean up before termination from the application
			}

			@Override
			public void runtimeStopped() {
				if (runtime.getTerminationRequester() == TerminationRequester.APP) {
					// Termination was requested by the application.
					// Call BundleActivator.stop().
					try {
						FrameworkUtil.getBundle(this.getClass()).getBundleContext().getBundle().stop();
					} catch (BundleException e) {
						e.printStackTrace();
					}
				} else if (runtime.getTerminationRequester() == TerminationRequester.FRAMEWORK) {
					// Termination was requested by the OSGi framework and the TERMNINATE signal has been processed.
					// Release lock.
					lock.release();
				} else { // TerminationRequester.NONE
					logger.error("Should never end up here!");
				}
			}
		});
		runtime.setContext("BUNDLE_CONTEXT", bc);
		runtime.start();
	}

	@Override
	public void stop(BundleContext bc) {
		if (runtime.getTerminationRequester() == TerminationRequester.FRAMEWORK) {
			// Multiple terminations were requested by the OSGi framework.
			// Unlikely. Handle the first request and ignore the rests.
		} else if (runtime.getTerminationRequester() == TerminationRequester.APP) {
			// Termination was requested by the application. There is nothing to do.
		} else { // TerminationRequester.NONE
			// Termination is requested by the OSGi framework.
			// Send TERMINATE signal to the Termination block and acquire lock.
			logger.info("Received bundle stop command from the OSGi framework: "
				+ "no.ntnu.item.its.osgi.train.simulation");

			runtime.setTerminationRequester(TerminationRequester.FRAMEWORK);
			Object o = runtime.getProperty("TERMINATION_LISTENER");
			if (o != null && o instanceof Block) {
				logger.debug("Found the Termination block. Send TERMINATE signal.");
				Block block = (Block) o;
				block.sendToBlock("TERMINATE");

				try {
					logger.debug("Acquire lock");
					lock.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				//TODO: force termination?
				logger.error("The OSGi framework stops the bundle, but the Termination block is not found. "
					+ "The application is NOT terminated correctly and resources are NOT released!");
			}
		}
	}

}
