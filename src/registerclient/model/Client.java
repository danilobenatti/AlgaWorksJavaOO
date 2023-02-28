package registerclient.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Client {
	
	private Long id;
	private String name;
	private LocalDate birthday;
	private LocalDate deathDate;
	private char gender;
	private boolean isAlive;
	private Address address;
	private Set<Phone> phones;
	
	public Client() {
	}
	
	public Client(Long id, String name, LocalDate birthday, LocalDate deathDate,
			char gender, boolean isAlive, Address address, Set<Phone> phones) {
		super();
		this.setId(id);
		this.setName(name);
		this.setBirthday(birthday);
		this.setDeathDate(deathDate);
		this.setGender(gender);
		this.setAlive(isAlive);
		this.setAddress(address);
		this.setPhones(phones);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public LocalDate getDeathDate() {
		return deathDate;
	}
	
	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Set<Phone> getPhones() {
		return phones;
	}
	
	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Client))
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", deathDate=");
		builder.append(deathDate);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", isAlive=");
		builder.append(isAlive);
		builder.append(", address=");
		builder.append(address);
		builder.append(", phones=");
		builder.append(phones);
		builder.append("]");
		return builder.toString();
	}
	
}
