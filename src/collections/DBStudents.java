package collections;

import java.util.HashSet;
import java.util.Set;

public class DBStudents {
	
	DBStudents() {
	}
	
	public static Set<Student> searchStudent() {
		Set<Student> students = new HashSet<>();
		students.add(new Student(1, "John", 12));
		students.add(new Student(2, "Peter", 11));
		students.add(new Student(3, "Paul", 15));
		students.add(new Student(4, "James", 10));
		return students;
	}
	
}
