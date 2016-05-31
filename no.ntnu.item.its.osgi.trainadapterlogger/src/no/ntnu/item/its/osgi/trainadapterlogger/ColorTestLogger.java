package no.ntnu.item.its.osgi.trainadapterlogger;

import java.io.IOException;
import java.io.PrintWriter;

import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.osgi.util.tracker.ServiceTracker;

public class ColorTestLogger implements LogListener{

	private PrintWriter writer;
	private ServiceTracker<LogReaderService, LogReaderService> tracker;

	
	public ColorTestLogger() throws IOException {
		writer = new PrintWriter("ColorTest.log");
		tracker = new ServiceTracker<>(LoggerActivator.getContext(), LogReaderService.class, null);
		tracker.open();
	}
	
	public void close(){
		tracker.close();
		writer.close();
	}
	
	@Override
	public void logged(LogEntry entry) {
		if(entry.getLevel() != 4) return;
		if(entry.getMessage().contains("DefaultColorEventHandler"))	writer.println(String.format("%d %s %s", entry.getTime(), entry.getBundle(), entry.getMessage()));
	}

}
