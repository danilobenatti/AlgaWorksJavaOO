package exerciseinterfaces;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		
		InsuranceAgent agent99 = new InsuranceAgent();
		
		Car car1 = new Car(45000, 2012);
		House house1 = new House(920000, 320);
		
		logger.log(Level.INFO, "{0}", agent99.insuranceProposal(car1));
		logger.log(Level.INFO, "{0}", agent99.insuranceProposal(house1));
		
	}
	
}
