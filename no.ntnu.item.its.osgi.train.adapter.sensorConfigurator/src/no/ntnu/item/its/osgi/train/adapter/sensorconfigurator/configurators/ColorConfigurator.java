package no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.configurators;

import java.util.HashMap;

import no.ntnu.item.its.osgi.train.adapter.sensorconfigurator.interfaces.SensorConfigurator;

public class ColorConfigurator implements SensorConfigurator {

	@Override
	public void configure(HashMap<String, Object> properties) {
		for (String p : properties.keySet()) {
			if(p.equals("START")) startBundle();
			if(p.equals("STOP")) stopBundle();
		}
	}
	
	private void startBundle(){
//		try {
//			FrameworkUtil.getBundle(ColorPubActivator.class).start();
//		} catch (BundleException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	private void stopBundle(){
//		try {
//			FrameworkUtil.getBundle(ColorPubActivator.class).stop();
//		} catch (BundleException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	
	
}
