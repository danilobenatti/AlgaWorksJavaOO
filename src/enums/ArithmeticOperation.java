package enums;

public enum ArithmeticOperation {
	SUM {
		@Override
		public double operation(double a, double b) {
			return a + b;
		}
	},
	SUBTRACTION {
		@Override
		public double operation(double a, double b) {
			return a - b;
		}
	},
	DIVISION {
		@Override
		public double operation(double a, double b) {
			if (b > 0) {
				return a / b;
			}
			return Double.POSITIVE_INFINITY;
		}
	},
	MULTIPLY {
		@Override
		public double operation(double a, double b) {
			return a * b;
		}
	};
	
	public abstract double operation(double a, double b);
	
}
