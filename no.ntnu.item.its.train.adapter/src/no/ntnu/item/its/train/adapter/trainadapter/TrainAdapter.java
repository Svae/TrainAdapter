package no.ntnu.item.its.train.adapter.trainadapter;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.its.osgi.common.interfaces.PublisherService;
import no.ntnu.item.its.train.adapter.trainInfo.TrainInfo;

public class TrainAdapter extends Block {
	public org.osgi.framework.BundleContext context;
	public no.ntnu.item.its.train.adapter.trainInfo.TrainInfo trainInfo;


	public String getFilter() {
		return String.format("(objectclass=%s)", PublisherService.class.getName());
	}


	public TrainInfo getTrainInfo() {
		return new TrainInfo();
	}
}
