package collections;

import java.util.Set;
import java.util.logging.Logger;

public class TestHashSet {
	
	static Logger logger = Logger.getLogger(TestHashSet.class.getName());
	
	public static void main(String[] args) {
		
		Student student = new Student(4, "James", 10);
		logger.info(() -> "Student exists? " + (check(student) ? "YES" : "NO"));
		
	}
	
	public static boolean check(Student student) {
		Set<Student> students = DBStudents.searchStudent();
		return (students.contains(student));
	}
	
}
