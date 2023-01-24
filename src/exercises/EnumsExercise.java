package exercises;

import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnumsExercise {
	
	public static final Payments payments = new Payments();
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		Supplier supplier1 = new Supplier();
		supplier1.setName("pharmacy");
		
		Supplier supplier2 = new Supplier("supermarket");
		
		Account account1 = new Account();
		account1.setDescription("analgesic");
		account1.setValue(5.998);
		account1.setExpirationDate(Date.from(Instant.now()));
		account1.setSupplier(supplier1);
		account1.setAccountStatus(AccountStatus.PENDING);
		
		Account account2 = new Account("beer", 10.957, Date.from(Instant.now()),
				supplier2, AccountStatus.PENDING);
		
		logger.log(Level.INFO, "{0}", payments.executePayment(account1));
		logger.log(Level.INFO, "{0}", payments.cancelPayment(account1));
		logger.log(Level.INFO, "{0}", payments.cancelPayment(account2));
		logger.log(Level.INFO, "{0}", payments.executePayment(account2));
		
	}
	
}
