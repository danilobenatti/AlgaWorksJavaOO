package calculate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

public class Salary {
	
	private static ArrayList<Double> list;
	
	private Salary() {
	}
	
	private static void listValues(double... values) {
		list = new ArrayList<>();
		for (double value : values)
			list.add(value);
	}
	
	public static Optional<Double> max(double... values) {
		listValues(values);
		return list.stream().max(Comparator.comparing(i -> i));
	}
	
	public static Optional<Double> min(double... values) {
		listValues(values);
		return list.stream().min(Comparator.comparing(i -> i));
	}
	
	public static double sum(double... values) {
		listValues(values);
		return list.stream().mapToDouble(i -> i).sum();
	}
	
	public static OptionalDouble avg(double... values) {
		listValues(values);
		return list.stream().mapToDouble(i -> i).average();
	}
	
}
