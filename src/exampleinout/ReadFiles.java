package exampleinout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ReadFiles {
	
	static Locale locale = new Locale.Builder().setLanguage("pt")
			.setRegion("BR").build();
	static Logger logger = Logger.getLogger(ReadFiles.class.getName());
	static NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("./src/config/log4j.properties");
		
		String file = "./src/exampleinout/order_itens.txt";
		try (Scanner scanner = new Scanner(
				new BufferedReader(new FileReader(file)))) {
			
			scanner.useDelimiter(";");
			scanner.useLocale(locale);
			
			while (scanner.hasNext()) {
				String produto = scanner.next();
				int quantidade = scanner.nextInt();
				String unidade = scanner.next();
				double preco = Double.parseDouble(scanner.next());
				scanner.nextLine();
				
				String msg = String.format(
						"Produto: %s; Qtd: %d%s; Preço: %s", produto,
						quantidade, unidade, nf.format(preco));
				logger.info(msg);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
