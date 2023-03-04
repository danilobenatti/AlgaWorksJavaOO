package exampleinout;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import exampleinout.model.Person;

public class SerializeObject {
	
	static Logger log = Logger.getLogger(SerializeObject.class.getName());
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("./src/config/log4j.properties");
		
		Person p1 = new Person();
		p1.setId(1L);
		p1.setName("Jhon");
		p1.setBirthday(LocalDate.of(1999, Month.APRIL, 1));
		p1.setGender('M');
		p1.setAlive(true);
		
		try (ObjectOutput output = new ObjectOutputStream(
				new FileOutputStream("./src/exampleinout/p1.obj"))) {
			output.writeObject(p1);
			log.info(String.format("Saved person data: %s", p1.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
