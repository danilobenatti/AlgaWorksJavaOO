package inheritance;

import java.util.Arrays;

public class Coach extends Person {
	
	private Sports[] sport;
	private float salary;
	
	public Coach() {
	}
	
	public Coach(Sports[] sport, float salary) {
		super();
		this.sport = sport;
		this.salary = salary;
	}
	
	public Sports[] getSport() {
		return sport;
	}
	
	public void setSport(Sports[] sport) {
		this.sport = sport;
	}
	
	public float getSalary() {
		return salary;
	}
	
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coach [sport=");
		builder.append(Arrays.toString(sport));
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", ");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
