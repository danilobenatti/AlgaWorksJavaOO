package classsuper;

public class Product {
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String identify(Product product) {
		return String.format("Name: %s", product.getName());
	}
	
}
