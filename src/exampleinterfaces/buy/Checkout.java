package exampleinterfaces.buy;

import java.util.logging.Level;
import java.util.logging.Logger;

import exampleinterfaces.payment.CreditCard;
import exampleinterfaces.payment.CreditCardOperator;
import exampleinterfaces.printers.Printer;

public class Checkout {
	Logger logger = Logger.getLogger("");
	
	private CreditCardOperator cardOperator;
	private Printer printer;
	
	public Checkout(CreditCardOperator cardOperator, Printer printer) {
		this.cardOperator = cardOperator;
		this.printer = printer;
	}
	
	public void executePayment(Purchase buy, CreditCard card) {
		boolean authorize = this.cardOperator.authorize(buy, card);
		if (authorize) {
			this.printer.print(buy);
		} else {
			logger.log(Level.INFO, "Payment denied!");
		}
	}
	
}
