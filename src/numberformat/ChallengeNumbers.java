package numberformat;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChallengeNumbers {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		Locale locale = new Locale("pt", "BR");
		
		var input = 0.0d; // double
		var tax = 0.0d; // double
		try (Scanner scanner = new Scanner(System.in)) {
			logger.info("What is the value of the product?");
			if (scanner.hasNext()) {
				input = scanner.nextDouble();
			}
			logger.info("What is the value of the tax[ex.: 0 - 100]?");
			if (scanner.hasNext()) {
				tax = scanner.nextDouble() / 100;
			}
		}
		
		BigDecimal total = BigDecimal.valueOf(input);
		var value = total.multiply(BigDecimal.valueOf(tax)).add(total);
		StringBuilder builder = new StringBuilder();
		builder.append(NumberFormat.getCurrencyInstance(locale).format(value));
		builder.append(" - tax add: ");
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		percentFormat.setMaximumFractionDigits(1);
		builder.append(percentFormat.format(tax));
		
		logger.log(Level.INFO, "{0}", builder);
		
	}
	
}
