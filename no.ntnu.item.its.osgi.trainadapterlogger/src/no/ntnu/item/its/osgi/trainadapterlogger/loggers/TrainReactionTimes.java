package no.ntnu.item.its.osgi.trainadapterlogger.loggers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;

public class TrainReactionTimes implements LogListener{

	private PrintWriter writer;
	
	public TrainReactionTimes() throws IOException {
		writer = new PrintWriter("Reactiontimes".concat(new Date().toString()).concat(".log"));
		
	}
	
	@Override
	public void logged(LogEntry entry) {
		String msg = String.format("%d %s %s", entry.getTime(), entry.getBundle(), entry.getMessage());
		writer.println(msg);
	}

}
