package inheritance;

import java.util.Arrays;

public class Player extends Person {
	
	private Sports[] sport;
	private float salary;
	private Coach coach;
	
	public Player() {
	}
	
	public Player(Sports[] sport, float salary, Coach coach) {
		super();
		this.sport = sport;
		this.salary = salary;
		this.coach = coach;
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
	
	public Coach getCoach() {
		return coach;
	}
	
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [sport=");
		builder.append(Arrays.toString(sport));
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", coach=");
		builder.append(coach.getName());
		builder.append(", ");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
