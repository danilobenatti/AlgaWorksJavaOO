package inheritance;

public enum Genre {
	
	MALE(0, 'M', "Masculine"), FEMALE(1, 'F', "Feminine");
	
	private int code;
	private Character symbol;
	private String description;
	
	Genre(int code, Character symbol, String description) {
		this.code = code;
		this.symbol = symbol;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public Character getSymbol() {
		return symbol;
	}
	
	public String getDescription() {
		return description;
	}
	
}
