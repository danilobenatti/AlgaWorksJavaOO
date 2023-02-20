package collections;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student s1, Student s2) {
		if (s1.getAge() < s2.getAge()) {
			return -1;
		} else if (s1.getAge() > s2.getAge()) {
			return 1;
		}
		return 0;
	}
	
}
