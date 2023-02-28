package strings;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExampleStrings4 {
	
	static final Logger logger = Logger
			.getLogger(ExampleStrings4.class.getName());
	
	public static void main(String[] args) {
		
		String s = "1;Peter;15;84.5;1.87";
		
		String[] array = s.split(";");
		for (int i = 0; i < array.length; i++) {
			System.out.println("[" + i + "]=" + array[i]);
		}
		logger.log(Level.INFO, "{0}",
				array[0] + ", " + array[1] + ", " + array[2]);
		/**
		 * thread-safe - context of competition, more performative. StringBuffer
		 * buffer = new StringBuffer();
		 */
		// no thread-safe - more faster.
		StringBuilder builder = new StringBuilder();
		int count = 0;
		for (String string : array) {
			count += 1;
			builder.append(string);
			if (count < array.length) {
				builder.append("; ");
			}
		}
		logger.log(Level.INFO, "{0}", builder);
		
		String j = "Java";
		logger.log(Level.INFO, "{0}", j.indexOf("a"));
		logger.log(Level.INFO, "{0}", j.lastIndexOf("a"));
		
	}
	
}
