package exceptions;

public class Account {
	
	private double balance;
	
	public Account() {
	}
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Value less than zero(0).");
		}
		this.balance += amount;
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException {
		if ((this.balance - amount) < 0) {
			throw new InsufficientBalanceException("Insufficient balance!");
		}
		this.balance -= amount;
	}
	
	public double getBalance() {
		return balance;
	}
	
}
