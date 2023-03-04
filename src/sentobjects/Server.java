package sentobjects;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import sentobjects.model.Person;

public class Server {
	
	private static Logger logger = Logger.getLogger(Server.class.getName());
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("./src/config/log4j.properties");
		
		try (ServerSocket server = new ServerSocket(3333)) {
			
			logger.info("Waiting connections...");
			Socket socket = server.accept();
			logger.info(String.format("Connected: %s",
					socket.getRemoteSocketAddress()));
			
			InputStream inputStream = socket.getInputStream();
			ObjectInputStream objStream = new ObjectInputStream(inputStream);
			
			Person person = (Person) objStream.readObject();
			logger.info(person);
			
			OutputStream output = socket.getOutputStream();
			DataOutput dataOutput = new DataOutputStream(output);
			dataOutput.writeUTF("Successfully received");
			
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}
}
