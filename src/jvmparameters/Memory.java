package jvmparameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Memory {
	static Logger logger = Logger.getLogger(Memory.class.getName());
	List<Object> list = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Memory memory = new Memory();
		
		try (Scanner scanner = new Scanner(System.in)) {
			int option = 0;
			do {
				logger.log(Level.INFO, "Info option (0 or 1): ");
				if (scanner.hasNext()) {
					option = scanner.nextInt();
				}
				if (option == 1) {
					for (int i = 0; i < 2_000_000; i++) {
						memory.list.add(new Object());
					}
				}
			} while (option != 0);
		}
		
	}
	
}
