package staticmodifiers;

public class Counter {
	
	Counter() {
	}
	
	public static int count = 0;
	
	public static final double PI = Math.PI;
	
	public void increment() {
		count++;
	}
	
	public static int printCount() {
		return Counter.count;
	}
	
}
