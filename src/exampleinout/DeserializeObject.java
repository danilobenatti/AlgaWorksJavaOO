package exampleinout;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import example.Person;

public class DeserializeObject {
	
	static Logger log = Logger.getLogger(DeserializeObject.class.getName());
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("./src/config/log4j.properties");
		
		try (ObjectInput input = new ObjectInputStream(
				new FileInputStream("./src/exampleinout/p1.obj"))) {
			Person p = (Person) input.readObject();
			log.info(p); // log.info(input.readObject());
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
