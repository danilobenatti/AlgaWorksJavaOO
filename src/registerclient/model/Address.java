package registerclient.model;

public class Address {
	
	private Long id;
	private String street;
	private String city;
	private String estate;
	
	public Address() {
	}
	
	public Address(Long id, String street, String city, String estate) {
		this.setId(id);
		this.setStreet(street);
		this.setCity(city);
		this.setEstate(estate);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getEstate() {
		return estate;
	}
	
	public void setEstate(String estate) {
		this.estate = estate;
	}
	
}
