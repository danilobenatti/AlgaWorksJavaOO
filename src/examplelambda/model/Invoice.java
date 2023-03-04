package examplelambda.model;

import java.text.NumberFormat;

public class Invoice {
	
	private long id;
	private String email;
	private float value;
	private boolean sentMail;
	private Status status;
	
	public Invoice() {
	}
	
	public Invoice(Long id, String email, float value, boolean sentMail,
			Status status) {
		this.id = id;
		this.email = email;
		this.value = value;
		this.sentMail = sentMail;
		this.status = status;
	}
	
	public String resume() {
		return String.format("Value due: %s - Status: %s",
				NumberFormat.getCurrencyInstance().format(value),
				status.getDescription());
	}
	
	public String status() {
		return String.format("Actual Status: %s", getStatus().getDescription());
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public float getValue() {
		return value;
	}
	
	public void setValue(float value) {
		this.value = value;
	}
	
	public boolean isSentMail() {
		return sentMail;
	}
	
	public void setSentMail(boolean sentMail) {
		this.sentMail = sentMail;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
