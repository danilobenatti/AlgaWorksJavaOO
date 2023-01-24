package inheritance;

import java.util.Date;

public class Person {
	
	private String name;
	private int age;
	private Genre genre;
	private Date birthday;
	private float weight;
	private float height;
	
	public Person() {
	}
	
	public Person(String name, int age, Genre genre, Date birthday,
			float weight, float height) {
		this.name = name;
		this.age = age;
		this.genre = genre;
		this.birthday = birthday;
		this.weight = weight;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", genre=");
		builder.append(genre.getDescription());
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}
	
}
