package enums;

public enum ArithmeticOperation {
	SUM {
		@Override
		public float operation(float a, float b) {
			return a + b;
		}
	},
	SUBTRACTION {
		@Override
		public float operation(float a, float b) {
			return a - b;
		}
	},
	DIVISION {
		@Override
		public float operation(float a, float b) {
			if (b > 0) {
				return a / b;
			}
			return Float.POSITIVE_INFINITY;
		}
	},
	MULTIPLY {
		@Override
		public float operation(float a, float b) {
			return a * b;
		}
	};
	
	public abstract float operation(float a, float b);
	
}
