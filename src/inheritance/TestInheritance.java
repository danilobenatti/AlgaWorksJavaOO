package inheritance;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.TextStyle;
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
		
		var coach = new Coach();
		coach.setName("John");
		coach.setBirthday(LocalDate.of(1982, 7, 3));
		coach.setAge(calculeAge(coach.getBirthday()));
		coach.setGenre(Genre.MALE);
		Sports[] coachSports = { Sports.SOCCER, Sports.BASKETBALL };
		coach.setSport(coachSports);
		coach.setSalary(8500.89f);
		
		var player = new Player();
		player.setName("Alice");
		player.setBirthday(LocalDate.of(1988, 8, 24));
		player.setAge(calculeAge(player.getBirthday()));
		Sports[] playerSports = { Sports.BASKETBALL, Sports.SWIMMING };
		player.setGenre(Genre.FEMALE);
		player.setSport(playerSports);
		player.setSalary(5360.59f);
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
		Period between = Period.between(person.getBirthday(), LocalDate.now());
		return String.format("%s: age is %d years %d months and %d days.",
				person.getName(), between.getYears(), between.getMonths(),
				between.getDays());
	}
	
}
