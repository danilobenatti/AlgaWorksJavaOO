package exampleinterfaces;

import exampleinterfaces.buy.Checkout;
import exampleinterfaces.buy.Purchase;
import exampleinterfaces.payment.CreditCard;
import exampleinterfaces.payment.CreditCardOperator;
import exampleinterfaces.payment.companies.CardCompanyXYZ;
import exampleinterfaces.payment.companies.RedCard;
import exampleinterfaces.printers.Printer;
import exampleinterfaces.printers.PrinterDeskjet;
import exampleinterfaces.printers.PrinterLaserjet;

public class TestCheckout {
	
	public static void main(String[] args) {
		
		CreditCardOperator operator1 = new CardCompanyXYZ();
		Printer printer1 = new PrinterDeskjet();
		CreditCardOperator operator2 = new RedCard();
		Printer printer2 = new PrinterLaserjet();
		
		CreditCard card = new CreditCard();
		card.setCardHolder("John Fieldman");
		card.setCardNumber("1234.5678.9000.0123");
		
		Purchase buy = new Purchase();
		buy.setClient("Peter Samuel");
		buy.setProduct("red wine");
		buy.setTotalValue(101);
		
		Checkout checkout1 = new Checkout(operator1, printer1);
		checkout1.executePayment(buy, card);
		Checkout checkout2 = new Checkout(operator2, printer2);
		checkout2.executePayment(buy, card);
	}
	
}
