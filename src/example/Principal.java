package example;

import java.text.NumberFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import calculate.Imc;
import calculate.Salary;

public class Principal {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		Person owner1 = new Person();
		owner1.setName("John Wayne");
		owner1.setCpf("123.456.789-0");
		owner1.setAge(40);
		owner1.setAddress("Main Street Way, W34");
		owner1.setSex('M');
		owner1.setWeight(92.8f);
		owner1.setHeight(1.78f);
		Instant date1 = Instant.parse("1952-07-25T03:00:00.00Z");
		owner1.setBirthDate(Date.from(date1));
		owner1.setFollowers(2000);
		logger.log(Level.INFO, String.format("%s IMC{0}", owner1.getName()), Imc
				.imc(owner1.getWeight(), owner1.getHeight(), owner1.getSex()));
		
		Vehicle beetle = new Vehicle();
		beetle.setType("car");
		beetle.setManufactor("VW");
		beetle.setModel("1600S");
		beetle.setColor("Blue");
		beetle.setYearManufacture(1974);
		beetle.setPrice(7530.75f);
		beetle.setVelocity(60);
		beetle.setActive(true);
		beetle.setOwner(owner1);
		
		Person owner2 = new Person();
		owner2.setName("Axel Rose");
		owner2.setCpf("098.765.432-1");
		owner2.setAge(25);
		owner2.setAddress("Jorge Whashington, S87");
		owner2.setSex('f');
		owner2.setWeight(58.7f);
		owner2.setHeight(1.54f);
		Instant date2 = Instant.parse("1987-09-05T03:00:00.00Z");
		owner2.setBirthDate(Date.from(date2));
		owner2.setFollowers(5000);
		logger.log(Level.INFO, String.format("%s IMC{0}", owner2.getName()), Imc
				.imc(owner2.getWeight(), owner2.getHeight(), owner2.getSex()));
		
		Vehicle pickup = new Vehicle();
		pickup.setType("utility");
		pickup.setManufactor("Ford");
		pickup.setModel("Ranger XL");
		pickup.setColor("Black");
		pickup.setYearManufacture(1994);
		pickup.setPrice(30000.78f);
		pickup.setVelocity(100);
		pickup.setActive(true);
		pickup.setOwner(owner2);
		
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
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		logger.log(Level.INFO, "MAX: {0}",
				currency.format(Salary.max(values).orElse(0.0)));
		logger.log(Level.INFO, "MIN: {0}",
				currency.format(Salary.min(values).orElse(0.0)));
		logger.log(Level.INFO, "SUM: {0}", currency.format(Salary.sum(values)));
		logger.log(Level.INFO, "AVG: {0}",
				currency.format(Salary.avg(values).getAsDouble()));
		
		/**
		 * owner1.getFollowers() = 2000 / owner2.getFollowers() = 5000
		 */
		logger.log(Level.INFO, "Test followers: {0}",
				owner1.getFollowers().compareTo(owner2.getFollowers())); // -1
		/**
		 * owner2.getFollowers() = 5000 / owner1.getFollowers() = 2000
		 */
		logger.log(Level.INFO, "Test followers: {0}",
				owner2.getFollowers().compareTo(owner1.getFollowers())); // 1
		
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
