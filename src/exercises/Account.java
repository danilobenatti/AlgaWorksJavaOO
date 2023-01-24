package exercises;

import java.util.Date;

public class Account {
	
	private String description;
	private Double value;
	private Date expirationDate;
	private Supplier supplier;
	private AccountStatus accountStatus;
	
	public Account() {
	}
	
	public Account(String description, Double value, Date expirationDate,
			Supplier supplier, AccountStatus accountStatus) {
		this.description = description;
		this.value = value;
		this.expirationDate = expirationDate;
		this.supplier = supplier;
		this.accountStatus = accountStatus;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	
}
