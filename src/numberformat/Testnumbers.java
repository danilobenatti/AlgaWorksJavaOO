package numberformat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testnumbers {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		double value = 1300.59;
		
		DecimalFormat decimalFormat = new DecimalFormat("R$ #,##0.00");
		logger.log(Level.INFO, "Ex.1: {0}", decimalFormat.format(value));
		
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		logger.log(Level.INFO, "Ex.2: {0}", numberFormat.format(value));
		
		logger.log(Level.INFO, "Ex.3: {0}", NumberFormat
				.getCurrencyInstance(new Locale("en", "US")).format(value));
		
		String money = "R$ 1.300,59";
		try {
			double price = decimalFormat.parse(money).doubleValue();
			logger.log(Level.INFO, "Ex.4: {0}", price);
			logger.log(Level.INFO, "Ex.5: {0}", NumberFormat
					.getCurrencyInstance(new Locale("fr", "FR")).format(price));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		BigDecimal bigDecimal = BigDecimal.valueOf(51312311231000d);
		logger.info(() -> new StringBuilder().append("Ex.6: ")
				.append(bigDecimal.divide(BigDecimal.TEN)).toString());
		
	}
	
}
