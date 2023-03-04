package examplelambda.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SendMail {
	
	static Logger logger = Logger.getLogger(SendMail.class.getName());
	
	public void send(String email, String msg) {
		
		PropertyConfigurator.configure("./src/config/log4j.properties");
		
		StringBuilder builder = new StringBuilder();
		builder.append("Send mail for: ");
		builder.append(email);
		builder.append(", Message: ");
		builder.append(msg);
		logger.info(builder.toString());
		
	}
	
}
