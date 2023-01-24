package enums;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayCards {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		Cards cardsFourPaus = new Cards();
		cardsFourPaus.setNumber(4);
		cardsFourPaus.setNaip(NaipEnum.PAUS);
		
		logger.log(Level.INFO, "{0}", cardsFourPaus);
		logger.log(Level.INFO, "{0}", cardsFourPaus.getNaip().getCode());
	}
	
}
