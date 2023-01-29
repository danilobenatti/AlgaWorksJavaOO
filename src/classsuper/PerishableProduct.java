package classsuper;

import java.util.Date;

public class PerishableProduct extends Product {
	
	private Date validity;
	
	public Date getValidity() {
		return validity;
	}
	
	public void setValidity(Date validity) {
		this.validity = validity;
	}
	
	public String identify(PerishableProduct product) {
		return super.identify(product) + ", "
				+ String.format("Validity: %s", product.getValidity());
	}
	
}
