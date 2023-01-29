package exampleinterfaces.buy;

import java.text.NumberFormat;

import exampleinterfaces.files.File;
import exampleinterfaces.payment.Authorizable;

public class Purchase implements Authorizable, File {
	
	private double totalValue;
	private String product;
	private String client;
	
	@Override
	public double getTotalValue() {
		return this.totalValue;
	}
	
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	public String getProduct() {
		return product;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}
	
	public String getClient() {
		return client;
	}
	
	public void setClient(String client) {
		this.client = client;
	}
	
	@Override
	public String getHeader() {
		return this.getProduct() + " = "
				+ NumberFormat.getCurrencyInstance().format(getTotalValue());
	}
	
	@Override
	public String getBodyPage() {
		return this.getClient();
	}
	
}
