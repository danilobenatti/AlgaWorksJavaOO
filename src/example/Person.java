package example;

import java.util.Date;

public class Person {
	
	private String name = null;
	private String cpf = "000.000.000-00";
	private int age = 18;
	private String address = null;
	private char sex = 'M';
	private float weight = 0;
	private float height = 0;
	private Date birthDate = null;
	private Integer followers = null;
	
	public Person() {
		super();
	}
	
	public Person(String name, String cpf, int age, String address, char sex,
			float weight, float height, Date birthDate, Integer followers) {
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.address = address;
		this.sex = sex;
		this.weight = weight;
		this.height = height;
		this.birthDate = birthDate;
		this.followers = followers;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public char getSex() {
		return sex;
	}
	
	public void setSex(char sex) {
		this.sex = sex;
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
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Integer getFollowers() {
		return followers;
	}
	
	public void setFollowers(Integer followers) {
		this.followers = followers;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", age=");
		builder.append(age);
		builder.append(", address=");
		builder.append(address);
		builder.append(", sex=");
		builder.append(sex);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", height=");
		builder.append(height);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", followers=");
		builder.append(followers);
		builder.append("]");
		return builder.toString();
	}
	
}
