package no.ntnu.item.its.osgi.trainadapterlogger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.osgi.util.tracker.ServiceTracker;

public class TrainReactionTimes implements LogListener {

	private ServiceTracker<LogReaderService, LogReaderService> tracker;
	private PrintWriter nfcwriter, turnwriter, configwriter, debugwriter;

	public TrainReactionTimes() throws FileNotFoundException {
		tracker = new ServiceTracker<>(LoggerActivator.getContext(), LogReaderService.class, null);
		tracker.open();
		nfcwriter = new PrintWriter("TrainNFCEvents" + System.currentTimeMillis() + ".log");
		turnwriter = new PrintWriter("TrainTurnEvents" + System.currentTimeMillis() + ".log");
		configwriter = new PrintWriter("TrainConfigEvents" + System.currentTimeMillis() + ".log");
		debugwriter = new PrintWriter("TestTrainDebugEvents" + System.currentTimeMillis() + ".log");
	}

	public void close() {
		tracker.close();
		nfcwriter.close();
		turnwriter.close();
		configwriter.close();
		debugwriter.close();
	}

	@Override
	public void logged(LogEntry entry) {
		
		debugwriter.println(
				String.format("%d [%s] %s", entry.getTime(), entry.getBundle().getSymbolicName(), entry.getMessage()));
		if (entry.getLevel() != 4)
			return;
		if (entry.getMessage().contains("YELLOW") || entry.getMessage().contains("IsTurning:")
				|| entry.getMessage().contains("Turn:")) {
			turnwriter.println(String.format("%d [%s] %s", entry.getTime(), entry.getBundle().getSymbolicName(),
					entry.getMessage()));
			return;
		}
		if (entry.getMessage().contains("RED") || entry.getMessage().contains("Added:")
				|| entry.getMessage().contains("Removed:")) {
			configwriter.println(String.format("%d [%s] %s", entry.getTime(), entry.getBundle().getSymbolicName(),
					entry.getMessage()));
			return;
		}
		if (!entry.getMessage().contains("Speedchange: ") && !entry.getMessage().contains("[Train]")) {
			nfcwriter.println(String.format("%d [%s] %s", entry.getTime(), entry.getBundle().getSymbolicName(),
					entry.getMessage()));
		}

	}

}
