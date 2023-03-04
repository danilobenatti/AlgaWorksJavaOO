package examplelambda.model;

public enum Status {
	
	PENDING(1, "Pending"), PAID(2, "Paid"), OVERDUE(3, "Overdue"),
	CANCELED(4, "Canceled");
	
	private int code;
	private String description;
	
	private Status(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Status toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (Status status : Status.values()) {
			if (code.equals(status.getCode())) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid code for status: " + code);
	}
}
