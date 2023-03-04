package sentobjects;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.Month;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import sentobjects.model.Person;

public class Client {
	
	private static Logger logger = Logger.getLogger(Client.class.getName());
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("./src/config/log4j.properties");
		
		try (Socket socket = new Socket("192.168.0.100", 3333)) {
			
			OutputStream output = socket.getOutputStream();
			ObjectOutput object = new ObjectOutputStream(output);
			Person person = new Person();
			person.setId(1L);
			person.setName("Peter");
			person.setBirthday(LocalDate.of(1999, Month.FEBRUARY, 15));
			person.setGender('M');
			person.setAlive(true);
			object.writeObject(person);
			
			InputStream input = socket.getInputStream();
			DataInputStream dataInput = new DataInputStream(input);
			
			logger.info(String.format("Received from server: %s",
					dataInput.readUTF()));
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
