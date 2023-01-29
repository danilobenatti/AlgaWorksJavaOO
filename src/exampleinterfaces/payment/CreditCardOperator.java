package exampleinterfaces.payment;

public interface CreditCardOperator {
	
	public boolean authorize(Authorizable authorizable, CreditCard creditCard);
	
}
