package loggerapache;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LoggingLog4j {
	
	private static Logger logger = Logger.getLogger(LoggingLog4j.class);
	
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		logger.info("Application starting...");
		
		logger.debug("Info -> ...");
		
		logger.warn("Application finalizing.");
		
	}
	
}
