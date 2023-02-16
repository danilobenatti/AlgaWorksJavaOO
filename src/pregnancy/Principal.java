package pregnancy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
	Locale locale = new Locale.Builder().setLanguage("pt").setRegion("BR")
			.build();
	Logger logger = Logger.getLogger("");
	
	public static void main(String[] args) {
		new Principal();
	}
	
	public Principal() {
		try (Scanner scanner = new Scanner(System.in)) {
			logger.info("Data do último período menstrual (dd/mm/aaaa):");
			String ultimoPeriodoMenstrual = null;
			if (scanner.hasNext()) {
				ultimoPeriodoMenstrual = scanner.nextLine();
			}
			Date dataUltimoPeriodoMenstrual = converterEmData(
					ultimoPeriodoMenstrual);
			Calculator calculator = new Calculator(dataUltimoPeriodoMenstrual);
			
			Date dataEstimadaConcepcao = calculator
					.calcularDataEstimadaConcepcao();
			logger.log(Level.INFO, "Data estimada da concepção: {0}",
					formatarData(dataEstimadaConcepcao));
			
			Date dataEstimadaParto = calculator.calcularDataEstimadaParto();
			logger.log(Level.INFO, "Data estimada para parto: {0}",
					formatarData(dataEstimadaParto));
			
		} catch (ParseException ex) {
			ex.getMessage();
		}
	}
	
	private String formatarData(Date data) {
		// Padrão de formatação de data por extenso
		// A classe Locale representa uma região no planeta, sendo neste caso
		// o Brasil (br), onde falamos Português (pt)
		// O Locale é usado aqui para formatar a data em português brasileiro
		DateFormat dateFormat = new SimpleDateFormat(
				"EEEE, dd 'de' MMMM 'de' yyyy", locale);
		return dateFormat.format(data);
	}
	
	private Date converterEmData(String date) throws ParseException {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.parse(date);
	}
	
}
