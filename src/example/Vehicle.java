package example;

public class Vehicle {
	
	String type = "car";
	String manufactor = null;
	String model = null;
	String color = null;
	int yearManufacture = 0;
	float price = 0;
	float velocity = 0;
	boolean active = true;
	Person owner = null;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(String type, String manufactor, String model, String color,
			int yearManufacture, float price, float velocity, boolean active,
			Person owner) {
		super();
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
	
	void changeManufactor(String manufactor) {
		this.manufactor = manufactor;
	}
	
	void changeModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [");
		builder.append("type=");
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
