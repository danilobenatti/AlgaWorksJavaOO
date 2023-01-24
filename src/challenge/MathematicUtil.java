package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MathematicUtil {
	
	public static final double PI = Math.PI;
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		logger.log(Level.INFO, "{0}", calculateFibonacci(12));
		logger.log(Level.INFO, "{0}", circleAreaByRadius(12));
		logger.log(Level.INFO, "{0}", circleAreaByDiameter(24));
	}
	
	/**
	 * A sequência de Fibonacci é uma sequência de números, onde o número 1 é o
	 * primeiro e também segundo termo da ordem e os demais são originados pela
	 * soma de seus antecessores. [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144]
	 * 
	 * @param value
	 * @return
	 */
	public static List<Integer> calculateFibonacci(int value) {
		ArrayList<Integer> result = new ArrayList<>();
		result.add(0, 1);
		result.add(1, 1);
		for (int i = 2; i < value; i++) {
			result.add(i, result.get(i - 1) + result.get(i - 2));
		}
		return result;
	}
	
	/**
	 * AREA = PI * R²
	 * 
	 * @param radius
	 * @return
	 */
	public static double circleAreaByRadius(float radius) {
		return PI * Math.pow(radius, 2);
	}
	
	/**
	 * AREA = (PI * D²)/4
	 * 
	 * @param diameter
	 * @return
	 */
	public static double circleAreaByDiameter(float diameter) {
		return (PI * Math.pow(diameter, 2)) / 4;
	}
}
