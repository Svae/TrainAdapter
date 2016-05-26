package no.ntnu.item.its.train.adapter.common;

import no.ntnu.item.its.train.adapter.enums.TrainCommandType;

public class TrainCommand {
	private TrainCommandType cmd;
	private Object value;
	
	public TrainCommand(TrainCommandType cmd) {
		this.cmd = cmd;
	}
	
	public TrainCommand(TrainCommandType cmd, Object value) {
		this.cmd = cmd;
		this.value = value;
	}

	public TrainCommandType getCmd() {
		return cmd;
	}

	public Object getValue() {
		return value;
	}
	
}

