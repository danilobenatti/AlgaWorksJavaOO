package calculateage;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgeCalculator {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		LocalDate date = LocalDate.now();
		String inputDate = null;
		try (Scanner scanner = new Scanner(System.in)) {
			logger.info("Info date of birth in YYYY-MM-DD format.");
			if (scanner.hasNext()) {
				inputDate = scanner.next();
				date = LocalDate.parse(inputDate.replace('/', '-').trim());
			}
		}
		logger.log(Level.INFO, "Calculated age: {0}", calculeAge(date));
		
		/**
		 * LocalDate dateOfBirth = LocalDate.of(1988, 8, 24);
		 * 
		 * @author danil
		 */
		LocalDate dateOfBirth = LocalDate.of(date.getYear(),
				date.getMonthValue(), date.getDayOfMonth());
		LocalDate currentDate = LocalDate.now();
		
		Period period = Period.between(dateOfBirth, currentDate);
		
		logger.log(Level.INFO, "Ex.1: {0}", calculeAge(period));
		logger.log(Level.INFO, "Ex.2: {0}", calculeAgeToString(dateOfBirth));
		logger.log(Level.INFO, "Ex.3: {0}", String.format("Age is %d years.",
				ChronoUnit.YEARS.between(dateOfBirth, currentDate)));
		logger.log(Level.INFO, "Ex.4: {0}", String.format("Age is %d days.",
				ChronoUnit.DAYS.between(dateOfBirth, currentDate)));
		
		Calendar dateOfBirth2 = new GregorianCalendar(date.getYear(),
				date.getMonthValue(), date.getDayOfMonth());
		Calendar currentDate2 = new GregorianCalendar();
		int age = Math.subtractExact(currentDate2.get(Calendar.YEAR),
				dateOfBirth2.get(Calendar.YEAR));
		if ((dateOfBirth2.get(Calendar.MONTH) > currentDate2
				.get(Calendar.MONTH))
				|| (dateOfBirth2.get(Calendar.MONTH) == currentDate2
						.get(Calendar.MONTH)
						&& dateOfBirth2
								.get(Calendar.DAY_OF_MONTH) > currentDate2
										.get(Calendar.DAY_OF_MONTH))) {
			// decrements age by 1
			age--;
		}
		logger.log(Level.INFO, "Gregorian Calendar: {0}", age);
		
	}
	
	private static String calculeAge(Period period) {
		return String.format("Age is %d years %d months and %d days.",
				period.getYears(), period.getMonths(), period.getDays());
	}
	
	public static int calculeAge(LocalDate dateOfBirth) {
		return Period.between(dateOfBirth, LocalDate.now()).getYears();
	}
	
	public static String calculeAgeToString(LocalDate dateOfBirth) {
		Period period = Period.between(dateOfBirth, LocalDate.now());
		return String.format("Age is %d years %d months and %d days.",
				period.getYears(), period.getMonths(), period.getDays());
	}
	
}
