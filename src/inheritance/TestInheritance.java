package inheritance;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestInheritance {
	
	public static void main(String[] args) {
		/*
		 * https://www.javatpoint.com/java-calculate-age
		 */
		Logger logger = Logger.getLogger("");
		ZoneId zoneId = ZoneId.systemDefault();
		logger.info(
				zoneId.getDisplayName(TextStyle.NARROW, Locale.getDefault()));
		
		Coach coach = new Coach();
		coach.setName("John");
		coach.setBirthday(Date.from(Instant.parse("1982-07-03T03:00:00Z")));
		LocalDate coachBirthday = LocalDate
				.ofInstant(coach.getBirthday().toInstant(), zoneId);
		coach.setAge(calculeAge(coachBirthday));
		coach.setGenre(Genre.MALE);
		Sports[] coachSports = { Sports.SOCCER, Sports.BASKETBALL };
		coach.setSport(coachSports);
		coach.setSalary(8500.89F);
		
		Player player = new Player();
		player.setName("Alice");
		player.setBirthday(Date.from(Instant.parse("1988-08-24T03:00:00Z")));
		LocalDate playerBirthday = LocalDate
				.ofInstant(player.getBirthday().toInstant(), zoneId);
		player.setAge(calculeAge(playerBirthday));
		Sports[] playerSports = { Sports.BASKETBALL, Sports.SWIMMING };
		player.setGenre(Genre.FEMALE);
		player.setSport(playerSports);
		player.setSalary(5360.59F);
		player.setCoach(coach);
		
		logger.log(Level.INFO, "{0}", coach);
		logger.log(Level.INFO, "{0}", showAge(coach));
		logger.log(Level.INFO, "{0}", player);
		logger.log(Level.INFO, "{0}", showAge(player));
	}
	
	public static int calculeAge(LocalDate dateOfBirth) {
		LocalDate now = LocalDate.now();
		return Period.between(dateOfBirth, now).getYears();
	}
	
	public static String showAge(Person person) {
		LocalDate personBirthday = LocalDate.ofInstant(
				person.getBirthday().toInstant(), ZoneId.systemDefault());
		Period between = Period.between(personBirthday, LocalDate.now());
		return String.format("%s: age is %d years %d months and %d days.",
				person.getName(), between.getYears(), between.getMonths(),
				between.getDays());
	}
	
}
