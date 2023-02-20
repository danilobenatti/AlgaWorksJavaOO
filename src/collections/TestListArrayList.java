package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestListArrayList {
	
	static Logger logger = Logger.getLogger(TestListArrayList.class.getName());
	
	public static void main(String[] args) {
		
		Student student1 = new Student(1, "John", 12);
		var student2 = new Student(2, "Peter", 11);
		var student3 = new Student();
		student3.setId(3);
		student3.setName("Paul");
		student3.setAge(13);
		var student4 = new Student(4, "James", 10);
		
		List<Student> list = Arrays.asList(student3, student1, student4,
				student2);
		
		logger.log(Level.INFO, "List: {0}", list);
		
		for (Student student : list) {
			logger.info(student::toString);
		}
		Collections.sort(list);
		logger.log(Level.INFO, "Sort1 list: {0}", list);
		
		Collections.sort(list, new AgeComparator());
		logger.log(Level.INFO, "Sort2 list: {0}", list);
		
		Collections.sort(list, new AgeComparator() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getAge() - s2.getAge();
			}
		});
		logger.log(Level.INFO, "Sort3 list: {0}", list);
		
		Comparator<Student> byName = Comparator.comparing(Student::getName);
		Collections.sort(list, byName);
		logger.log(Level.INFO, "Sort4 list: {0}", list);
		
		Comparator<Student> byAge = Comparator.comparing(Student::getAge);
		list.sort(byAge);
		list.forEach(System.out::println);
		
		Set<Student> students = new HashSet<>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student3);
		students.add(student4);
		
		logger.log(Level.INFO, "List1: {0}", printStudentsList(students));
		logger.log(Level.INFO, "List2: {0}", printStudentsList1(students));
		logger.log(Level.INFO, "List3: {0}", printStudentsList2(students));
		logger.log(Level.INFO, "List4: {0}", printStudentsList3(students));
		
		HashMap<Integer, Student> elementaryStudents = new HashMap<>();
		elementaryStudents.put(0, student3);
		elementaryStudents.put(1, student2);
		elementaryStudents.put(2, student1);
		elementaryStudents.put(3, student3);
		elementaryStudents.put(4, student4);
		
		logger.log(Level.INFO, "List5: {0}",
				printStudentsList(elementaryStudents));
		
	}
	
	private static String printStudentsList(
			HashMap<Integer, Student> students) {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<Integer, Student> entry : students.entrySet()) {
			Integer key = entry.getKey();
			Student obj = entry.getValue();
			builder.append("Student [id=").append(key).append(", name=")
					.append(obj.getName()).append(", age=").append(obj.getAge())
					.append("], ");
		}
		return builder.toString();
	}
	
	public static List<String> printStudentsList(Set<Student> students) {
		List<String> list = new ArrayList<>();
		for (Student student : students) {
			list.add(student.toString());
		}
		return list;
	}
	
	public static List<String> printStudentsList1(Set<Student> students) {
		return students.stream().map(Student::getName).toList();
	}
	
	public static List<String> printStudentsList2(Set<Student> students) {
		return students.stream().map(Student::getName).sorted().toList();
	}
	
	public static List<String> printStudentsList3(Set<Student> students) {
		return students.stream()
				.sorted(Comparator.comparing(Student::getAge).reversed()
						.thenComparing(Student::getName))
				.map(Student::getName).toList();
	}
	
}
