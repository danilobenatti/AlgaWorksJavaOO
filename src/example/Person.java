package example;

import java.util.Date;

public class Person {
	
	String name = null;
	String cpf = "000.000.000-00";
	int age = 18;
	String address = null;
	char sex = 'M';
	float weight = 0;
	float height = 0;
	Date birthDate = null;
	Integer followers = null;
	
	public Person() {
		super();
	}
	
	public Person(String name, String cpf, int age, String address, char sex,
			float weight, float height, Date birthDate, Integer followers) {
		super();
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
	
	@Override
	public String toString() {
		return String.format(
				"Person [name=%s, cpf=%s, age=%s, address=%s, sexo=%s, weight=%s, height=%s, birthDate=%s, followers=%s]",
				name, cpf, age, address, sex, weight, height, birthDate,
				followers);
	}
	
}
