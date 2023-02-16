package workdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import calculateage.AgeCalculator;

public class Principal {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		Date now = new Date();
		logger.info(now::toString);
		Date date = Date.from(Instant.parse("1928-11-10T03:00:00Z"));
		logger.info(date::toString);
		
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DAY_OF_MONTH, 5);
		calendar.set(Calendar.MONTH, 0); // values: 0(jan) - 11(dez).
		calendar.set(Calendar.YEAR, 1950);
		
		logger.info(() -> calendar.getTime().toString());
		calendar.add(Calendar.MONTH, 6);
		logger.info(() -> calendar.getTime().toString());
		calendar.add(Calendar.MONTH, -12);
		logger.info(() -> calendar.getTime().toString());
		calendar.add(Calendar.DAY_OF_MONTH, 31);
		logger.info(() -> calendar.getTime().toString());
		calendar.roll(Calendar.DAY_OF_MONTH, 30);
		logger.info(() -> calendar.getTime().toString());
		
		DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/y");
		DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/y HH:mm:ss");
		
		logger.info(() -> "Ex.1A:  " + dateFormat1.format(now));
		logger.info(() -> "Ex.1B:  " + dateFormat2.format(now));
		logger.info(() -> "Ex.1C:  " + dateFormat1.format(date));
		logger.info(() -> "Ex.1D:  " + dateFormat2.format(date));
		logger.info(() -> "Ex.1E:  " + calendar.getTime());
		
		logger.info(() -> "Ex.2A:  "
				+ DateFormat.getDateInstance(DateFormat.SHORT).format(now));
		logger.info(() -> "Ex.2B:  "
				+ DateFormat.getDateInstance(DateFormat.SHORT).format(date));
		
		logger.info(() -> "Ex.3A:  "
				+ DateFormat.getDateInstance(DateFormat.MEDIUM).format(now));
		logger.info(() -> "Ex.3B:  "
				+ DateFormat.getDateInstance(DateFormat.MEDIUM).format(date));
		
		logger.info(() -> "Ex.4A:  "
				+ DateFormat.getDateInstance(DateFormat.LONG).format(now));
		logger.info(() -> "Ex.4B:  "
				+ DateFormat.getDateInstance(DateFormat.LONG).format(date));
		
		logger.info(() -> "Ex.5A:  "
				+ DateFormat.getDateInstance(DateFormat.FULL).format(now));
		logger.info(() -> "Ex.5C:  "
				+ DateFormat.getDateInstance(DateFormat.FULL).format(date));
		
		LocalDate date2 = LocalDate.now();
		logger.info(date2::toString);
		
		String birthday = "1950-01-05"; // yyyy/MM/dd
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		LocalDate localdate = LocalDate.parse(birthday, formatter);
		logger.info(localdate::toString);
		logger.info(() -> "Ex.6: "
				+ DateFormat.getDateInstance(DateFormat.FULL).format(date));
		logger.info("Ex.7: " + localdate.getDayOfMonth() + "/"
				+ localdate.getMonthValue() + "/" + localdate.getYear());
		
		logger.info(() -> AgeCalculator.calculeAgeToString(localdate));
		
		logger.info(() -> DateTimeFormatter.ofPattern("d/MMM/y")
				.format(LocalDate.of(2023, 1, 7)));
		logger.info(() -> DateTimeFormatter.ofPattern("d/MMMM/y")
				.format(LocalDate.now()));
		
	}
	
}
