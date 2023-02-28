package strings;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExampleStrings2 {
	
	static final Logger logger = Logger
			.getLogger(ExampleStrings2.class.getName());
	
	public static void main(String[] args) {
		
		String s = "ALGAWORKS";
		
		logger.log(Level.INFO, "{0}", s.charAt(0));
		logger.log(Level.INFO, "{0}", s.charAt(2));
		logger.log(Level.INFO, "{0}", s.charAt(4));
		logger.log(Level.INFO, "{0}", s.length());
		logger.log(Level.INFO, "{0}", s.charAt(s.length() - 1));
	}
	
}
