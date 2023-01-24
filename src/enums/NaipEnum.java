package enums;

public enum NaipEnum {
	
	OUROS(1, "red"), PAUS(2, "black"), ESPADAS(3, "black"), COPAS(4, "red");
	
	private int code;
	private String color;
	
	NaipEnum(int code, String color) {
		this.code = code;
		this.color = color;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getColor() {
		return color;
	}
	
}
