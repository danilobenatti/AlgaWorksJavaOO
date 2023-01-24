package staticmodifiers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCounter {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		Counter.count++;
		
		int value = Counter.count;
		
		logger.log(Level.INFO, "{0}", value);
		
		Counter c = new Counter();
		
		c.increment();
		logger.log(Level.INFO, "{0}", Counter.count);
		
		Counter.count++;
		logger.log(Level.INFO, "{0}", c.count);
		
		logger.log(Level.INFO, "{0}", Counter.printCount());
	}
	
}
