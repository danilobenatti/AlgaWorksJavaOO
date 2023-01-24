package example;

import java.util.Date;

public class Accounts {
	
	private String description;
	private double value;
	private Date expirationDate;
	private Supplier supplier;
	
	public Accounts() {
		super();
	}
	
	public Accounts(String description, double value, Date expirationDate,
			Supplier supplier) {
		this.description = description;
		this.value = value;
		this.expirationDate = expirationDate;
		this.supplier = supplier;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
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
	
	public String payAccount() {
		return toString();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Accounts [description=");
		builder.append(description);
		builder.append(", value=");
		builder.append(value);
		builder.append(", expirationDate=");
		builder.append(expirationDate);
		builder.append(", supplier=");
		builder.append(supplier);
		builder.append("]");
		return builder.toString();
	}
	
}
