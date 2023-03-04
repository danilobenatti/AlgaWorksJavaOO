package examplelambda.util;

import java.text.NumberFormat;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import examplelambda.model.Invoice;

public class InvoiceStatus {
	
	NumberFormat f = NumberFormat.getCurrencyInstance();
	static Logger logger = Logger.getLogger(InvoiceStatus.class.getName());
	
	public void info(Invoice invoice, String msg) {
		
		PropertyConfigurator.configure("./src/config/log4j.properties");
		
		StringBuilder builder = new StringBuilder();
		builder.append("Invoice Nº: ");
		builder.append(invoice.getId());
		builder.append(", Value: ");
		builder.append(f.format(invoice.getValue()));
		builder.append(" - ");
		builder.append(msg);
		logger.info(builder.toString());
		
	}
	
}
