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
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		Logger logger = Logger.getLogger("");
		
		Person owner1 = new Person();
		owner1.name = "John Wayne";
		owner1.cpf = "123.456.789-0";
		owner1.age = 40;
		owner1.address = "Main Street Way, W34";
		owner1.sex = 'M';
		owner1.weight = 92.8f;
		owner1.height = 1.78f;
		owner1.birthDate = Date.from(Instant.parse("1952-07-25T03:00:00.00Z"));
		owner1.followers = 2000;
		logger.log(Level.INFO, String.format("%s IMC{0}", owner1.name),
				Imc.calcImc(owner1.weight, owner1.height, owner1.sex));
		
		Vehicle beetle = new Vehicle();
		beetle.type = "car";
		beetle.manufactor = "VW";
		beetle.model = "1600S";
		beetle.color = "Blue";
		beetle.yearManufacture = 1974;
		beetle.price = 7530.75f;
		beetle.velocity = 60;
		beetle.active = true;
		beetle.owner = owner1;
		
		Person owner2 = new Person();
		owner2.name = "Axel Rose";
		owner2.cpf = "098.765.432-1";
		owner2.age = 25;
		owner2.address = "Jorge Whashington, S87";
		owner2.sex = 'f';
		owner2.weight = 58.7f;
		owner2.height = 1.54f;
		owner2.birthDate = Date.from(Instant.parse("1987-09-05T03:00:00.00Z"));
		owner2.followers = 5000;
		logger.log(Level.INFO, String.format("%s IMC{0}", owner2.name),
				Imc.calcImc(owner2.weight, owner2.height, owner2.sex));
		
		Vehicle pickup = new Vehicle();
		pickup.type = "utility";
		pickup.manufactor = "Ford";
		pickup.model = "Ranger XL";
		pickup.color = "Black";
		pickup.yearManufacture = 1994;
		pickup.price = 30000.78f;
		pickup.velocity = 100;
		pickup.active = true;
		pickup.owner = owner2;
		
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
		logger.log(Level.INFO, "MAX: {0}",
				currency.format(Salary.max(values).orElse(0.0)));
		logger.log(Level.INFO, "MIN: {0}",
				currency.format(Salary.min(values).orElse(0.0)));
		logger.log(Level.INFO, "SUM: {0}", currency.format(Salary.sum(values)));
		logger.log(Level.INFO, "AVG: {0}",
				currency.format(Salary.avg(values).getAsDouble()));
		
		/**
		 * owner1.followers = 2000 / owner2.followers = 5000
		 */
		logger.log(Level.INFO, "Test followers: {0}",
				owner1.followers.compareTo(owner2.followers));
		
		Integer i1 = 127;
		Integer i2 = 127;
		logger.log(Level.INFO, "Test1: {0}", i1 == i2);
		logger.log(Level.INFO, "Test2: {0}", Objects.equals(i1, i2));
		
		Integer i3 = 128;
		Integer i4 = 128;
		logger.log(Level.INFO, "Test3: {0}", i3 == i4);
		logger.log(Level.INFO, "Test4: {0}", Objects.equals(i3, i4));
		
		switch (i3.compareTo(i4)) {
			case -1:
				logger.log(Level.INFO, "Test5: i3 is lessthan the argument i4");
				break;
			case 0:
				logger.log(Level.INFO, "Test5: i3 is equal to the argument i4");
				break;
			case 1:
				logger.log(Level.INFO, "Test5: i3 greater than argument i4");
				break;
			default:
				break;
		}
		
		Vehicle scooter = new Vehicle();
		scooter.type = "Scooter";
		scooter.model = "Vespa";
		scooter.manufactor = "Piaggio & C.";
		logger.log(Level.INFO, scooter::toString);
		scooter.changeManufactor("Honda");
		scooter.changeModel("Honda PCX");
		logger.log(Level.INFO, scooter::toString);
		
	}
	
}
