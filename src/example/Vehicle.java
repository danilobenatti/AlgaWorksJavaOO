package example;

public class Vehicle {
	
	private String type = "car";
	private String manufactor = null;
	private String model = null;
	private String color = null;
	private int yearManufacture = 0;
	private float price = 0;
	private float velocity = 0;
	private boolean active = true;
	private Person owner = null;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(String type, String manufactor, String model, String color,
			int yearManufacture, float price, float velocity, boolean active,
			Person owner) {
		this.type = type;
		this.manufactor = manufactor;
		this.model = model;
		this.color = color;
		this.yearManufacture = yearManufacture;
		this.price = price;
		this.velocity = velocity;
		this.active = active;
		this.owner = owner;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getManufactor() {
		return manufactor;
	}
	
	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getYearManufacture() {
		return yearManufacture;
	}
	
	public void setYearManufacture(int yearManufacture) {
		this.yearManufacture = yearManufacture;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getVelocity() {
		return velocity;
	}
	
	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Person getOwner() {
		return owner;
	}
	
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	void changeManufactor(String manufactor) {
		this.manufactor = manufactor;
	}
	
	void changeModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [type=");
		builder.append(type);
		builder.append(", manufactor=");
		builder.append(manufactor);
		builder.append(", model=");
		builder.append(model);
		builder.append(", color=");
		builder.append(color);
		builder.append(", yearManufacture=");
		builder.append(yearManufacture);
		builder.append(", price=");
		builder.append(price);
		builder.append(", velocity=");
		builder.append(velocity);
		builder.append(", active=");
		builder.append(active);
		builder.append(", owner=");
		builder.append(owner);
		builder.append("]");
		return builder.toString();
	}
	
	void speed(float value) {
		velocity += velocity * (value / 100);
	}
	
}
