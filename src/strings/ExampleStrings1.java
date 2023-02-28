package strings;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExampleStrings1 {
	
	static final Logger logger = Logger
			.getLogger(ExampleStrings1.class.getName());
	
	public static void main(String[] args) {
		
		String s1 = "Peter";
		String s2 = "Peter";
		String s3 = new String("Peter");
		String s4 = "PETER";
		
		logger.log(Level.INFO, "s1 == s2: {0}", s1 == s2 ? "YES" : "NO");
		
		logger.log(Level.INFO, "s3 == s2: {0}", s3 == s1 ? "YES" : "NO");
		
		logger.log(Level.INFO, "s4 == s1: {0}", s4 == s1 ? "YES" : "NO");
		
		logger.log(Level.INFO, "s1 equals s2: {0}", s1.equals(s2));
		
		logger.log(Level.INFO, "s3 equals s1: {0}", s3.equals(s1));
		
		logger.log(Level.INFO, "s4 equals s1: {0}", s4.equalsIgnoreCase(s1));
		
	}
	
}
