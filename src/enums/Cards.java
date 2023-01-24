package enums;

public class Cards {
	
	private int number;
	private NaipEnum naip;
	
	Cards() {
	}
	
	public Cards(int number, NaipEnum naip) {
		super();
		this.number = number;
		this.naip = naip;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public NaipEnum getNaip() {
		return naip;
	}
	
	public void setNaip(NaipEnum naip) {
		this.naip = naip;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cards [number=");
		builder.append(number);
		builder.append(", naip=");
		builder.append(naip);
		builder.append(", color=");
		builder.append(naip.getColor());
		builder.append("]");
		return builder.toString();
	}
	
}
