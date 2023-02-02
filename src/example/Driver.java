package example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Driver extends Person {
	
	private Character[] drivingLicense;
	private LocalDate expirationDate;
	
	public Driver() {
	}
	
	public Driver(Character[] drivingLicense, LocalDate expirationDate) {
		super();
		this.setDrivingLicense(drivingLicense);
		this.setExpirationDate(expirationDate);
	}
	
	public Character[] getDrivingLicense() {
		return drivingLicense;
	}
	
	public void setDrivingLicense(Character[] drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", License [drivingLicense=");
		builder.append(Arrays.toString(drivingLicense));
		builder.append(", expirationDate=");
		builder.append(expirationDate);
		builder.append("]");
		return builder.toString();
	}
	
	public static String validateLicense(LocalDate expirationDate) {
		LocalDate currentDate = LocalDate.now();
		long between = ChronoUnit.DAYS.between(currentDate, expirationDate);
		return between > 0 ? "Yes, it's ok." : "No, it's invalid!";
	}
	
}
