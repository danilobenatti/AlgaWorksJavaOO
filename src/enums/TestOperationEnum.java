package enums;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestOperationEnum {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		logger.log(Level.INFO, "sum: {0}",
				ArithmeticOperation.SUM.operation(2, 3));
		logger.log(Level.INFO, "subtraction: {0}",
				ArithmeticOperation.SUBTRACTION.operation(2, 3));
		logger.log(Level.INFO, "division: {0}",
				ArithmeticOperation.DIVISION.operation(2, 3));
		logger.log(Level.INFO, "division: {0}",
				ArithmeticOperation.DIVISION.operation(2, 0));
		logger.log(Level.INFO, "multiply: {0}",
				ArithmeticOperation.MULTIPLY.operation(2, 3));
		
		for (ArithmeticOperation ao : ArithmeticOperation.values()) {
			String msg = String.format("%s: {0}", ao).toLowerCase();
			logger.log(Level.INFO, msg, ao.operation(5, 10));
			
		}
		
	}
	
}
