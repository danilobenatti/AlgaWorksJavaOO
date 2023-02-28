package challenge;

import static java.lang.Math.PI;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MathematicUtil {
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		logger.log(Level.INFO, "1: {0}", fibonacci(12));
		logger.log(Level.INFO, "2: {0}", fibonacci(12L));
		logger.log(Level.INFO, "3: {0}", fibonacciRecursive(11));
		logger.log(Level.INFO, "4: {0}", circleAreaByRadius(6));
		logger.log(Level.INFO, "5: {0}", circleAreaByDiameter(24));
	}
	
	/**
	 * A sequência de Fibonacci é uma sequência de números, onde o número 1 é o
	 * primeiro e também segundo termo da ordem e os demais são originados pela
	 * soma de seus antecessores. [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144]
	 * F(n) = F(n-1) + F(n-2)
	 * 
	 * @param value
	 * @return
	 */
	public static List<Integer> fibonacci(int value) {
		List<Integer> result = new ArrayList<>();
		result.add(0, 1);
		result.add(1, 1);
		for (int i = 2; i < value; i++) {
			result.add(i, result.get(i - 1) + result.get(i - 2));
		}
		return result;
	}
	
	public static List<Long> fibonacci(long value) {
		List<Long> result = new ArrayList<>();
		for (int i = 0; i < value; i++) {
			result.add(fibonacciRecursive(i));
		}
		return result;
	}
	
	public static long fibonacciRecursive(long p) {
		if (p < 0) {
			return 0;
		}
		if (p == 0 || p == 1) {
			return 1;
		}
		return fibonacciRecursive(p - 1) + fibonacciRecursive(p - 2);
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
		return PI * Math.pow(diameter, 2) / 4;
	}
}
