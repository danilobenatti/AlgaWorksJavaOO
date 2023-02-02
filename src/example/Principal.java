package example;

import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import calculate.Imc;
import calculate.Salary;

public class Principal {
	
	private static final NumberFormat c = NumberFormat.getCurrencyInstance();
	
	private static String imc(Person p) {
		return Imc.imcByGender(p.getWeight(), p.getHeight(), p.getSex());
	}
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		var owner1 = new Driver();
		owner1.setName("John Wayne");
		owner1.setCpf("123.456.789-0");
		owner1.setAge(40);
		owner1.setAddress("Main Street Way, W34");
		owner1.setSex('M');
		owner1.setWeight(92.8f);
		owner1.setHeight(1.78f);
		owner1.setBirthDate(LocalDate.of(1952, Month.JULY, 25));
		owner1.setFollowers(2000);
		Character[] licensesOwner1 = { 'A', 'B' };
		owner1.setDrivingLicense(licensesOwner1);
		owner1.setExpirationDate(LocalDate.of(2023, Month.JANUARY, 28));
		logger.log(Level.INFO, String.format("%s IMC{0}", owner1.getName()),
				imc(owner1));
		
		var beetle = new Vehicle();
		beetle.setType("car");
		beetle.setManufactor("VW");
		beetle.setModel("1600S");
		beetle.setColor("Blue");
		beetle.setYearManufacture(1974);
		beetle.setPrice(7530.75f);
		beetle.setVelocity(60);
		beetle.setActive(true);
		beetle.setOwner(owner1);
		logger.log(Level.INFO, "License is valid? {0}",
				Driver.validateLicense(owner1.getExpirationDate()));
		
		var owner2 = new Driver();
		owner2.setName("Axel Rose");
		owner2.setCpf("098.765.432-1");
		owner2.setAge(25);
		owner2.setAddress("Jorge Whashington, S87");
		owner2.setSex('f');
		owner2.setWeight(58.7f);
		owner2.setHeight(1.54f);
		owner2.setBirthDate(LocalDate.of(1987, Month.SEPTEMBER, 05));
		owner2.setFollowers(5000);
		Character[] licensesOwner2 = { 'A', 'B', 'C' };
		owner2.setDrivingLicense(licensesOwner2);
		owner2.setExpirationDate(LocalDate.of(2023, Month.FEBRUARY, 28));
		logger.log(Level.INFO, String.format("%s IMC{0}", owner2.getName()),
				imc(owner2));
		
		var pickup = new Vehicle();
		pickup.setType("utility");
		pickup.setManufactor("Ford");
		pickup.setModel("Ranger XL");
		pickup.setColor("Black");
		pickup.setYearManufacture(1994);
		pickup.setPrice(30000.78f);
		pickup.setVelocity(100);
		pickup.setActive(true);
		pickup.setOwner(owner2);
		logger.log(Level.INFO, "License is valid? {0}",
				Driver.validateLicense(owner2.getExpirationDate()));
		
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(beetle);
		vehicles.add(pickup);
		beetle.speed(6); // increase 6%
		pickup.speed(-10); // decrease 10%
		logger.info(vehicles::toString);
		
		Vehicle[] cars = new Vehicle[4];
		int i = 0;
		for (Vehicle vehicle : vehicles) {
			cars[i] = vehicle;
			i++;
		}
		for (Vehicle vehicle : cars) {
			logger.log(Level.INFO, "{0}", vehicle);
		}
		
		double[] values = { 1500, 1600, 2000, 2000.1, 500.75, 1100.5, 500.76 };
		
		String max = c.format(Salary.max(values).orElse(0.0));
		String min = c.format(Salary.min(values).orElse(0.0));
		String sum = c.format(Salary.sum(values));
		String avg = c.format(Salary.avg(values).getAsDouble());
		
		logger.log(Level.INFO, "Salary value MAX: {0}", max);
		logger.log(Level.INFO, "Salary value MIN: {0}", min);
		logger.log(Level.INFO, "Salary value SUM: {0}", sum);
		logger.log(Level.INFO, "Salary value AVG: {0}", avg);
		
		/**
		 * owner1.getFollowers() = 2000 / owner2.getFollowers() = 5000
		 */
		logger.log(Level.INFO, "Test1 followers: {0}",
				owner2.getFollowers().compareTo(owner1.getFollowers())); // 1
		logger.log(Level.INFO, "Test2 followers: {0}",
				owner2.getFollowers().compareTo(5000)); // 0
		logger.log(Level.INFO, "Test3 followers: {0}",
				owner1.getFollowers().compareTo(owner2.getFollowers())); // -1
		
		Integer i1 = 127;
		Integer i2 = 127;
		logger.log(Level.INFO, "Test1: {0}", i1 == i2);
		logger.log(Level.INFO, "Test2: {0}", Objects.equals(i1, i2));
		
		Integer i3 = 128;
		Integer i4 = 128;
		logger.log(Level.INFO, "Test3: {0}", i3 == i4);
		logger.log(Level.INFO, "Test4: {0}", Objects.equals(i3, i4));
		
		String info = switch (i3.compareTo(i4)) {
			case -1 -> "Test5: i3 is lessthan the argument i4";
			case 0 -> "Test5: i3 is equal to the argument i4";
			case 1 -> "Test5: i3 greater than argument i4";
			default -> null;
		};
		logger.info(info);
		
		Vehicle scooter = new Vehicle();
		scooter.setType("Scooter");
		scooter.setModel("Vespa");
		scooter.setManufactor("Piaggio & C.");
		logger.log(Level.INFO, scooter::toString);
		
		scooter.changeManufactor("Honda");
		scooter.changeModel("Honda PCX");
		logger.info(scooter::toString);
		
		Supplier supermarket = new Supplier();
		supermarket.setName("Candy Crush Inc.");
		supermarket.setAddress("400 Park Pl");
		
		Accounts accounts = new Accounts();
		accounts.setDescription("Crispy Toast 7.1oz");
		accounts.setValue(1.58);
		accounts.setExpirationDate(Date.from(Instant.now()));
		accounts.setSupplier(supermarket);
		logger.info(accounts::payAccount);
		
	}
	
}
