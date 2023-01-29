package classsuper;

import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestSuper {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		var product = new PerishableProduct();
		product.setName("Chocolate");
		product.setValidity(Date.from(Instant.now()));
		logger.log(Level.INFO, "{0}", product.identify(product));
		
	}
	
}
