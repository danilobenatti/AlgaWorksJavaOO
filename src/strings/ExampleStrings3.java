package strings;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExampleStrings3 {
	
	static final Logger logger = Logger
			.getLogger(ExampleStrings3.class.getName());
	
	public static void main(String[] args) {
		
		char[] hello = { 'H', 'e', 'l', 'l', 'o' };
		
		char[] world = { 'w', 'o', 'r', 'l', 'd', '!' };
		
		String s = new String(hello) + " " + new String(world);
		logger.log(Level.INFO, "{0}", s);
		logger.log(Level.INFO, "{0}", s.substring(5));
		logger.log(Level.INFO, "{0}", s.substring(0, 5));
		
		String t = "    espace    ";
		logger.log(Level.INFO, "{0}", "<" + t + ">");
		logger.log(Level.INFO, "{0}", "<" + t.trim() + ">");
		
	}
	
}
