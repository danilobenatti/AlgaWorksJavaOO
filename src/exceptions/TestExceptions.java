package exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestExceptions {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		Account account = new Account(1000);
		
		try {
			account.deposit(10);
			logger.log(Level.INFO, "Balance after deposit: {0}",
					account.getBalance());
		} catch (IllegalArgumentException ex) {
			logger.log(Level.WARNING, () -> "Exception: " + ex.getMessage());
		}
		
		try {
			account.withdraw(50);
			logger.log(Level.INFO, "Withdrawal1: {0}", account.getBalance());
			account.withdraw(960);
			logger.log(Level.INFO, "Withdrawal2: {0}", account.getBalance());
		} catch (InsufficientBalanceException ex) {
			logger.log(Level.WARNING, () -> "Exception: " + ex.getMessage());
		} finally {
			logger.info("Have a nice day!");
		}
		
	}
	
}
