package registerclient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import calculateage.Calculate;
import registerclient.dao.AddressDAO;
import registerclient.dao.ClientDAO;
import registerclient.dao.DAOFactory;
import registerclient.dao.PhoneDAO;
import registerclient.model.Address;
import registerclient.model.Client;
import registerclient.model.Phone;
import registerclient.model.annotation.AnnotationExclusionStrategy;

public class Principal {
	
	static final Logger logger = Logger.getLogger(Principal.class.getName());
	
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(
				UIManager.getCrossPlatformLookAndFeelClassName());
		Calculate calc = new Calculate() {
			@Override
			public String calculeAgeToString(LocalDate dateOfBirth) {
				Period period = Period.between(dateOfBirth, LocalDate.now());
				return String.format("Age is %d years %d months and %d days.",
						period.getYears(), period.getMonths(),
						period.getDays());
			}
			
			@Override
			public int calculeAge(LocalDate dateOfBirth, LocalDate deathDate) {
				if (deathDate.isAfter(dateOfBirth)) {
					return Period.between(dateOfBirth, deathDate).getYears();
				}
				return 0;
			}
			
			@Override
			public int calculeAge(LocalDate dateOfBirth) {
				if (dateOfBirth.isBefore(LocalDate.now())) {
					return Period.between(dateOfBirth, LocalDate.now())
							.getYears();
				}
				return 0;
			}
			
			@Override
			public String calculeAge(Period period) {
				return String.format("Age is %d years %d months and %d days.",
						period.getYears(), period.getMonths(),
						period.getDays());
			}
		};
		AddressDAO addressDAO = DAOFactory.getDAOFactory().getAddressDAO();
		ClientDAO clientDAO = DAOFactory.getDAOFactory().getClientDAO();
		PhoneDAO phoneDAO = DAOFactory.getDAOFactory().getPhoneDAO();
		
		Address addressClient1 = new Address();
		addressClient1.setStreet("163 Newark Ave");
		addressClient1.setCity("Jersey City");
		addressClient1.setEstate("New Jersey");
		addressDAO.save(addressClient1);
		
		Phone phone1 = new Phone(null, 'H', "9912123434", null);
		Phone phone2 = new Phone(null, 'M', "9988887777", null);
		Set<Phone> phonesClient1 = new HashSet<>(Arrays.asList(phone1, phone2));
		
		Client client1 = new Client(null, "Jimmy Foster",
				LocalDate.of(1951, Month.DECEMBER, 16), null, 'M', true,
				addressClient1, phonesClient1);
		phone1.setClient(client1);
		phone2.setClient(client1);
		
		clientDAO.save(client1);
		phoneDAO.saveAll(phonesClient1);
		
		Address addressClient2 = new Address(null, "10165 McKinley Dr", "Tampa",
				"Florida");
		addressDAO.save(addressClient2);
		
		Client client2 = new Client();
		client2.setName("Peter Parker");
		client2.setBirthday(LocalDate.of(1962, Month.AUGUST, 10));
		client2.setDeathDate(null);
		client2.setGender('M');
		client2.setAlive(true);
		client2.setAddress(addressClient2);
		var phone3 = new Phone(null, 'W', "0011112222", null);
		client2.setPhones(new HashSet<>(Arrays.asList(phone3)));
		phone3.setClient(client2);
		
		clientDAO.save(client2);
		phoneDAO.save(phone3);
		
		var client3 = new Client(null, "John Wayne",
				LocalDate.of(1907, Month.MAY, 26),
				LocalDate.of(1979, Month.JUNE, 11), 'M', false, null, null);
		var client4 = new Client(null, "Marilyn Monroe",
				LocalDate.of(1926, Month.JUNE, 1),
				LocalDate.of(1962, Month.AUGUST, 4), 'F', false, null, null);
		
		List<Client> clients = new ArrayList<>();
		clients.add(client3);
		clients.add(client4);
		clientDAO.saveAll(clients);
		
		logger.info("Clients successfully saved.");
		
		Client clientSearch = clientDAO.searchById(3L);
		logger.info(clientSearch::toString);
		
		logger.log(Level.INFO,
				String.format("%s is {0} years old", client1.getName()),
				calc.calculeAge(client1.getBirthday()));
		logger.log(Level.INFO,
				String.format("%s was {0} years old", client4.getName()),
				calc.calculeAge(client4.getBirthday(), client4.getDeathDate()));
		
		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class,
				new JsonSerializer<LocalDate>() {
					private static final DateTimeFormatter formatter = DateTimeFormatter
							.ofPattern("yyyy-MM-dd");
					
					@Override
					public JsonElement serialize(LocalDate localDate,
							Type srcType, JsonSerializationContext context) {
						return new JsonPrimitive(formatter.format(localDate));
					}
				}).setExclusionStrategies(new AnnotationExclusionStrategy())
				.setPrettyPrinting().serializeNulls()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				.create();
		String json1 = gson.toJson(client1);
		logger.info(json1);
		String json2 = gson.toJson(client2);
		logger.info(json2);
		String json3 = gson.toJson(client3);
		logger.info(json3);
		String json4 = gson.toJson(client4);
		logger.info(json4);
		
		if (JOptionPane.showConfirmDialog(null, "Insert new client?", "Yes/No",
				JOptionPane.YES_NO_OPTION) == 0) {
			String inputName = JOptionPane.showInputDialog(null, "Info name",
					"Full Name", JOptionPane.QUESTION_MESSAGE);
			
			String inputDate = JOptionPane
					.showInputDialog(null,
							"Info date of birth in YYYY-MM-DD format.",
							"Info Date", JOptionPane.QUESTION_MESSAGE)
					.replace('/', '-').trim();
			
			Object[] selectionValues = { "Female", "Male" };
			String inputGender = (String) JOptionPane.showInputDialog(null,
					"Info gender", "Gender", JOptionPane.QUESTION_MESSAGE, null,
					selectionValues, selectionValues[0]);
			
			if (!inputName.isBlank() && !inputDate.isBlank()
					&& !inputGender.isBlank()) {
				Client client5 = new Client(null, inputName,
						LocalDate.parse(inputDate), null,
						setCharGender(inputGender), true, null, null);
				clientDAO.save(client5);
				JOptionPane.showMessageDialog(null, "Client save!");
			}
			
		}
		
		List<Client> list = clientDAO.searchAll();
		list.forEach(System.out::println);
		
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("client", Client.class);
		xStream.aliasAttribute(Client.class, "id", "id");
		xStream.aliasAttribute(Address.class, "id", "id");
		xStream.aliasAttribute(Phone.class, "id", "id");
		xStream.allowTypeHierarchy(Client.class);
		xStream.processAnnotations(new Class[] { Phone.class, Client.class });
		
		logger.log(Level.INFO, () -> xStream.toXML(list));
		logger.log(Level.INFO, () -> xStream.toXML(clientDAO.searchById(3L)));
		
		try {
			OutputStream outputStream1 = new FileOutputStream(
					new File("./src/registerclient/client1.xml"));
			xStream.toXML(client1, outputStream1);
			OutputStream outputStream2 = new FileOutputStream(
					new File("./src/registerclient/client2.xml"));
			xStream.toXML(client2, outputStream2);
			File file = new File("./src/registerclient/client3.xml");
			OutputStream outputStream3 = new FileOutputStream(file);
			xStream.toXML(client3, outputStream3);
			Client clientFromFileXml = (Client) xStream.fromXML(file);
			logger.log(Level.INFO, "{0}", clientFromFileXml);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static char setCharGender(String inputGender) {
		return switch (inputGender) {
			case "Masculine", "Male", "men", "m" -> 'M';
			case "Feminine", "Female", "woman", "f" -> 'F';
			default -> '-';
		};
	}
	
}
