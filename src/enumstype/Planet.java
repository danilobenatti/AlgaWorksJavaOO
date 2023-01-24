package enumstype;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum Planet {
	
	MERCURY(3.303e+23, 2.4397e6), VENUS(4.869e+24, 6.0518e6),
	EARTH(5.976e+24, 6.37814e6), MARS(6.421e+23, 3.3972e6),
	JUPITER(1.9e+27, 7.1492e7), SATURN(5.688e+26, 6.0268e7),
	URANUS(8.686e+25, 2.5559e7), NEPTUNE(1.024e+26, 2.4746e7);
	
	private double mass;
	private double radius;
	
	Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
	}
	
	public double getMass() {
		return mass;
	}
	
	public double getRadius() {
		return radius;
	}
	
	// universal gravitational constant (m3 kg-1 s-2)
	public static final double G = 6.67300E-11;
	
	double surfaceGravity() {
		return G * mass / (Math.pow(radius, 2));
	}
	
	double surfaceWeight(double otherMass) {
		return otherMass * surfaceGravity();
	}
	
	/**
	 * https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("");
		if (args.length != 1) {
			logger.log(Level.WARNING, "Usage: java Planet <earth_weight>");
			System.exit(-1);
		}
		double earthWeight = Double.parseDouble(args[0]);
		double mass = earthWeight / EARTH.surfaceGravity();
		for (Planet p : Planet.values())
			logger.log(Level.INFO, "{0}", String.format(
					"Your weight on %s is %f%n", p, p.surfaceWeight(mass)));
	}
}
