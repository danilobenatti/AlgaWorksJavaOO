package loggerapache;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PropertiesConfigLog4j {
	
	private static Logger logger = Logger
			.getLogger(PropertiesConfigLog4j.class);
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("./src/loggerapache/log4j.properties");
		
		logger.info("Application starting...");
		
		logger.debug("Info -> ...");
		
		logger.warn("Application finalizing.");
		
	}
	
}
