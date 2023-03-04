package examplelambda;

import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import examplelambda.dao.InvoiceDAOL;
import examplelambda.model.Invoice;
import examplelambda.model.Status;
import examplelambda.util.InvoiceStatus;
import examplelambda.util.SendMail;

public class Principal {
	
	static Logger logger = Logger.getLogger(Principal.class.getName());
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("./src/config/log4j.properties");
		
		List<Invoice> invoices = new InvoiceDAOL().invoicesDueList();
		
		SendMail sendMail = new SendMail();
		InvoiceStatus invoiceStatus = new InvoiceStatus();
		
		for (Invoice invoice : invoices) {
			invoice.setSentMail(true);
			sendMail.send(invoice.getEmail(), invoice.resume());
		}
		
		invoices.forEach(i -> {
			sendMail.send(i.getEmail(), i.resume());
			i.setSentMail(true);
		});
		
		invoices.forEach(i -> i.setStatus(Status.PAID));
		
		invoices.forEach(i -> invoiceStatus.info(i, i.status()));
		
		Stream<Invoice> stream = invoices.stream()
				.filter(i -> i.getValue() > 50.0);
		stream.forEach(s -> {
			logger.info(s.resume());
			logger.info(s.status());
		});
		
	}
	
}
