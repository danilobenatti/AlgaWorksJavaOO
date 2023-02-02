package enums;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestOperationEnum {
	
	private static Logger logger = Logger.getLogger("");
	
	public static void main(String[] args) {
		
		logger.log(Level.INFO, "Sum: {0}",
				ArithmeticOperation.SUM.operation(2, 3));
		logger.log(Level.INFO, "Subtraction: {0}",
				ArithmeticOperation.SUBTRACTION.operation(2, 3));
		logger.log(Level.INFO, "Division: {0}",
				ArithmeticOperation.DIVISION.operation(2, 3));
		logger.log(Level.INFO, "Division by zero: {0}",
				ArithmeticOperation.DIVISION.operation(2, 0));
		logger.log(Level.INFO, "Multiply: {0}",
				ArithmeticOperation.MULTIPLY.operation(2, 3));
		
		for (ArithmeticOperation ao : ArithmeticOperation.values()) {
			String msg = String.format("%s: {0}", ao).toUpperCase();
			logger.log(Level.INFO, msg, ao.operation(5, 10));
		}
		
	}
	
}
