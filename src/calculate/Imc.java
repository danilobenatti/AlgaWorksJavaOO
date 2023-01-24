package calculate;

public class Imc {
	
	private Imc() {
	}
	
	public static double calcImc(float weight, float height) {
		double value = 0;
		if (weight > 0 && height > 0)
			value = weight / Math.pow(height, 2);
		return value;
	}
	
	public static String imc(float weight, float height, char sex) {
		double imc = calcImc(weight, height);
		return switch (sex) {
			case 'f', 'F' -> femaleImc(imc);
			case 'm', 'M' -> maleImc(imc);
			default -> null;
		};
	}
	
	public static String femaleImc(double value) {
		String info = null;
		if (value < 19.1) {
			info = String.format("[%.2f] under weight.", value);
		} else if (value > 19.2 && value < 25.8) {
			info = String.format("[%.2f] at ideal weight.", value);
		} else if (value > 25.9 && value < 27.3) {
			info = String.format("[%.2f] a little overweight.", value);
		} else if (value > 27.4 && value < 32.3) {
			info = String.format("[%.2f] over ideal weight.", value);
		} else {
			info = String.format("[%.2f] obesity.", value);
		}
		return info;
	}
	
	public static String maleImc(double value) {
		String info = null;
		if (value < 20.7) {
			info = String.format("[%.2f] under weight.", value);
		} else if (value > 20.8 && value < 26.4) {
			info = String.format("[%.2f] at ideal weight.", value);
		} else if (value > 26.5 && value < 27.8) {
			info = String.format("[%.2f] a little overweight.", value);
		} else if (value > 27.9 && value < 31.1) {
			info = String.format("[%.2f] over ideal weight.", value);
		} else {
			info = String.format("[%.2f] obesity.", value);
		}
		return info;
	}
	
}
