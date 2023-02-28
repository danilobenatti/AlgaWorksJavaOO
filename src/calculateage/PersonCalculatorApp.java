package calculateage;

import java.time.LocalDate;
import java.time.Period;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import calculate.Imc;

public class PersonCalculatorApp {
	
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(
				UIManager.getCrossPlatformLookAndFeelClassName());
		
		JOptionPane.showMessageDialog(null, "Calculate current age and BMI",
				"Person Calculator", JOptionPane.INFORMATION_MESSAGE);
		
		String inputDate = JOptionPane.showInputDialog(null,
				"Info date of birth in YYYY-MM-DD format.", "Info Date",
				JOptionPane.QUESTION_MESSAGE).replace('/', '-').trim();
		
		String inputWeight = JOptionPane.showInputDialog(null,
				"Info weight in kilograms, Ex.: 85.0", "Info Weight",
				JOptionPane.QUESTION_MESSAGE);
		
		String inputHeight = JOptionPane.showInputDialog(null,
				"Info height in meters, Ex.: 1.87", "Info Height",
				JOptionPane.QUESTION_MESSAGE);
		
		Object[] selectionValues = { "Female", "Male" };
		String inputGender = (String) JOptionPane.showInputDialog(null,
				"Info gender", "Gender", JOptionPane.QUESTION_MESSAGE, null,
				selectionValues, selectionValues[0]);
		
		String inputName = JOptionPane.showInputDialog(null, "Info name",
				"Full Name", JOptionPane.QUESTION_MESSAGE);
		
		if (!inputDate.isBlank() && !inputWeight.isBlank()
				&& !inputHeight.isBlank() && !inputGender.isBlank()
				&& !inputName.isBlank()) {
			String gender = (("Male".equals(inputGender)) ? "Mr. %s\n"
					: "Mrs. %s\n");
			StringBuilder builder = new StringBuilder();
			builder.append(gender.replace("%s", inputName));
			builder.append(calculeAgeToString(
					LocalDate.parse(inputDate.replace('/', '-').trim())))
					.append("\n");
			builder.append(Imc.imcByGender(Float.parseFloat(inputWeight),
					Float.parseFloat(inputHeight), getCharGender(inputGender)))
					.append("\n");
			JOptionPane.showMessageDialog(null, builder);
			
		}
		
	}
	
	private static String calculeAgeToString(LocalDate dateOfBirth) {
		Period period = Period.between(dateOfBirth, LocalDate.now());
		return String.format("Age is %d years %d months and %d days.",
				period.getYears(), period.getMonths(),
				period.getDays());
	}

	private static char getCharGender(String inputGender) {
		return switch (inputGender) {
			case "Masculine", "Male", "men", "m" -> 'M';
			case "Feminine", "Female", "woman", "f" -> 'F';
			default -> '-';
		};
	}
	
}
