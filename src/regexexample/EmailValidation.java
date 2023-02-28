package regexexample;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
	
	private static Logger logger = Logger.getLogger("");
	
	public static void main(String[] args) {
		
		List<String> emails = new ArrayList<>();
		emails.add("jhon@email.com");
		emails.add("mary@");
		emails.add("peter@peter");
		emails.add("paul@email.com.br");
		
		String regex = "\\w+@\\w+\\.\\w+.\\w+";
		Pattern pattern = Pattern.compile(regex);
		for (String email : emails) {
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				logger.log(Level.INFO, "{0}", email);
			}
		}
	}
	
}
