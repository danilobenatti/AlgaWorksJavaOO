package enumstype;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EnumTest {
	
	Day day;
	
	public EnumTest(Day day) {
		this.day = day;
	}
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		EnumTest firstDay = new EnumTest(Day.MONDAY);
		logger.log(Level.INFO, "{0}", firstDay.tellItLikeItIs());
		EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
		logger.log(Level.INFO, "{0}", thirdDay.tellItLikeItIs());
		EnumTest fifthDay = new EnumTest(Day.FRIDAY);
		logger.log(Level.INFO, "{0}", fifthDay.tellItLikeItIs());
		EnumTest sixthDay = new EnumTest(Day.SATURDAY);
		logger.log(Level.INFO, "{0}", sixthDay.tellItLikeItIs());
		EnumTest seventhDay = new EnumTest(Day.SUNDAY);
		logger.log(Level.INFO, "{0}", seventhDay.tellItLikeItIs());
	}
	
	public String tellItLikeItIs() {
		return switch (day) {
			case MONDAY -> "Mondays are bad.";
			case FRIDAY -> "Fridays are better.";
			case SATURDAY, SUNDAY -> "Weekends are best.";
			default -> "Midweek days are so-so.";
		};
		
	}
}
