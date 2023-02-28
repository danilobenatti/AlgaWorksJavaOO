package registerclient.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import registerclient.model.annotation.Exclude;

@XStreamAlias(value = "phone")
public class Phone {
	
	private Long id;
	private char type;
	private String number;
	
	@Exclude
	@XStreamOmitField
	private Client client;
	
	public Phone() {
	}
	
	public Phone(Long id, char type, String number, Client client) {
		this.setId(id);
		this.setType(type);
		this.setNumber(number);
		this.setClient(client);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public char getType() {
		return type;
	}
	
	public void setType(char type) {
		this.type = type;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Phone [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", number=");
		builder.append(number);
		builder.append(", client=");
		builder.append(client.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
