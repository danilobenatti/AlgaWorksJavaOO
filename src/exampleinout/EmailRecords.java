package exampleinout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class EmailRecords {
	
	private static Logger log = Logger.getLogger(EmailRecords.class.getName());
	
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		String[] emails1 = { "peter@email.com", "bob@jmail.com",
				"beth@beth.com.tw" };
		String[] emails2 = { "james@host.com", "paul@code.com.eu",
				"jhon@test.com" };
		File file1 = new File("./src/exampleinout/emails1.txt");
		File file2 = new File("./src/exampleinout/emails2.txt");
		
		bufferWrite(emails1, file1);
		bufferWrite(emails2, file1);
		printStream(emails1, file2);
		printStream(emails2, file2);
		
		try {
			bufferRead(new FileReader(file1,
					Charset.forName(StandardCharsets.UTF_8.toString())));
			bufferRead(new FileReader(file2,
					Charset.forName(StandardCharsets.UTF_8.toString())));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	private static void bufferWrite(String[] emails, File file) {
		String f = file.getPath();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
			for (String email : emails) {
				bw.write(email);
				bw.newLine();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void printStream(String[] emails, File file) {
		String f = file.getPath();
		try (PrintStream bw = new PrintStream(f)) {
			for (String email : emails) {
				bw.println(email);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void bufferRead(FileReader file) {
		try (BufferedReader br = new BufferedReader(file)) {
			String line = null;
			while ((line = br.readLine()) != null) {
				log.info(String.format("Mail sent to: %s", line));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
