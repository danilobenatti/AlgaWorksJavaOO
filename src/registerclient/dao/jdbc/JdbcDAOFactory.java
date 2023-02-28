package registerclient.dao.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import registerclient.dao.AddressDAO;
import registerclient.dao.ClientDAO;
import registerclient.dao.DAOFactory;
import registerclient.dao.PhoneDAO;

public class JdbcDAOFactory extends DAOFactory {
	
	private Connection connection;
	
	public JdbcDAOFactory() {
		Properties prop = new Properties();
		String url = null;
		File file = new File("./src/registerclient/config/config.properties");
		try (FileInputStream inStream = new FileInputStream(file)) {
			prop.load(inStream);
			url = prop.getProperty("database.url");
			prop.setProperty("user", prop.getProperty("database.username"));
			prop.setProperty("password", prop.getProperty("database.password"));
			prop.setProperty("encoding", prop.getProperty("database.encoding"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, prop);
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM phone");
			statement.executeUpdate("ALTER TABLE phone AUTO_INCREMENT = 1");
			statement.executeUpdate("DELETE FROM client");
			statement.executeUpdate("ALTER TABLE client AUTO_INCREMENT = 1");
			statement.executeUpdate("DELETE FROM address");
			statement.executeUpdate("ALTER TABLE address AUTO_INCREMENT = 1");
			statement.close();
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ConnectionException("Error connecting to database.", ex);
		}
		
	}
	
	@Override
	public ClientDAO getClientDAO() {
		return new JdbcClientDAO(connection);
	}
	
	@Override
	public AddressDAO getAddressDAO() {
		return new JdbcAddressDAO(connection);
	}
	
	@Override
	public PhoneDAO getPhoneDAO() {
		return new JdbcPhoneDAO(connection);
	}
	
}
