package no.ntnu.item.its.train.adapter.trainadapter;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.its.osgi.common.interfaces.PublisherService;
import no.ntnu.item.its.osgi.train.adapter.trainstates.interfaces.TrainStateController.TrainStates;
import no.ntnu.item.its.train.adapter.trainInfo.TrainInfo;

public class TrainAdapter extends Block {
	public org.osgi.framework.BundleContext context;
	public no.ntnu.item.its.train.adapter.trainInfo.TrainInfo trainInfo;
	public java.lang.String failureMsg;


	public String getFilter() {
		return String.format("(objectclass=%s)", PublisherService.class.getName());
	}


	public TrainInfo getTrainInfo() {
		TrainInfo info = new TrainInfo();
		info.setCurrentLocationID("99999989");
		info.setHeading(180);
		info.setSpeed(0);
		info.setTrainState(TrainStates.RUNNING);
		return new TrainInfo();
	}
}
