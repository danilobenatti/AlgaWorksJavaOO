package exampleinterfaces.printers;

import java.util.logging.Level;
import java.util.logging.Logger;

import exampleinterfaces.files.File;

public class PrinterDeskjet implements Printer {
	Logger logger = Logger.getLogger("");
	
	@Override
	public void print(File file) {
		StringBuilder msgSupplier = new StringBuilder();
		msgSupplier.append("\n******************************");
		msgSupplier.append("\n" + file.getHeader());
		msgSupplier.append("\n******************************");
		msgSupplier.append("\n" + file.getBodyPage());
		msgSupplier.append("\n------------------------------");
		msgSupplier.append("\n             EPSON            ");
		msgSupplier.append("\n------------------------------");
		logger.log(Level.INFO, "{0}", msgSupplier);
	}
	
}
