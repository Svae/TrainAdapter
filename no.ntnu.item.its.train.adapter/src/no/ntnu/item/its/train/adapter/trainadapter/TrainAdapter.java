package no.ntnu.item.its.train.adapter.trainadapter;

import no.ntnu.item.arctis.runtime.Block;

public class TrainAdapter extends Block {
	public org.osgi.framework.BundleContext context;
	public java.lang.String filter;

	public String getFilterString() {
		return "";
	}

	public int getTrainID() {
		return 1;
	}
}
