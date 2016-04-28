package no.ntnu.item.its.train.adapter.trainadapter;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.its.osgi.common.interfaces.PublisherService;

public class TrainAdapter extends Block {
	public org.osgi.framework.BundleContext context;
	public java.lang.String filter;


	public int getTrainID() {
		return 1;
	}


	public String getFilter() {
		return filter.isEmpty() ? String.format("(objectclass=%s)", PublisherService.class) : filter;
	}
}
