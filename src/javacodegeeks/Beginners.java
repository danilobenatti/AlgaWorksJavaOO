package javacodegeeks;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Beginners {
	
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger("");
		Pattern pattern = Pattern.compile("Java \\d");
		String candidate = "this is a Java test";
		Matcher matcher = pattern.matcher(candidate);
		
		logger.log(Level.INFO, "{0}", matcher.find());
		
	}
	
}
