package workdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Principal {
	
	static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(Principal.class.getName(),
				"./src/config/log4j2.properties");
		
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
		logger.info(() -> "Ex.6: ".concat(
				DateFormat.getDateInstance(DateFormat.FULL).format(date)));
		logger.info(() -> "Ex.7: "
				.concat(String.format("%s/%s/%s", localdate.getDayOfMonth(),
						localdate.getMonthValue(), localdate.getYear())));
		
		logger.info(() -> calculeAgeToString(localdate));
		
		logger.info(() -> DateTimeFormatter.ofPattern("d/MMM/y")
				.format(LocalDate.of(2023, 1, 7)));
		logger.info(() -> DateTimeFormatter.ofPattern("d/MMMM/y")
				.format(LocalDate.now()));
		
	}
	
	public static String calculeAgeToString(LocalDate dateOfBirth) {
		Period period = Period.between(dateOfBirth, LocalDate.now());
		return String.format("Age is %d years %d months and %d days.",
				period.getYears(), period.getMonths(), period.getDays());
	}
	
}
