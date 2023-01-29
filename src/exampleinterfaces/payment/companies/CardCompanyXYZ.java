package exampleinterfaces.payment.companies;

import exampleinterfaces.payment.Authorizable;
import exampleinterfaces.payment.CreditCard;
import exampleinterfaces.payment.CreditCardOperator;

public class CardCompanyXYZ implements CreditCardOperator {
	
	@Override
	public boolean authorize(Authorizable authorizable, CreditCard card) {
		return card.getCardNumber().endsWith("0123")
				&& authorizable.getTotalValue() < 1000;
	}
	
}
