package calculateage;

import java.time.LocalDate;
import java.time.Period;

public interface Calculate {
	
	public String calculeAge(Period period);
	
	public int calculeAge(LocalDate dateOfBirth);
	
	public int calculeAge(LocalDate dateOfBirth, LocalDate deathDate);
	
	public String calculeAgeToString(LocalDate dateOfBirth);
	
}