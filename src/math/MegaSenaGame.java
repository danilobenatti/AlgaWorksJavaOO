package math;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MegaSenaGame {
	
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger("");
		
		String name = "Johnny";
		int age = 48;
		var number = age % name.length();
		logger.log(Level.INFO, "{0}", number);
		
		Random random = new Random();
		int lower = 0;
		int upper = 60;
		int rand = random.nextInt(upper - lower) + lower;
		logger.log(Level.INFO, "{0}", rand);
		
		int r = (int) (Math.random() * (upper - lower)) + lower;
		logger.log(Level.INFO, "{0}", r);
	}
	
}
