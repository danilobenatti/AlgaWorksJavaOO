package generics;

public class Client {
	
	String name;
	int age;
	
	public Client() {
	}
	
	public Client(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	
}
