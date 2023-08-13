package p1;

import java.util.HashSet;
import java.util.Set;

public class App {
	public static void main(String[] args) {
		Course c1 = new Course();
		c1.setCname("Java");
		
		Course c2 = new Course();
		c2.setCname("C++");
		
		Course c3 = new Course();
		c3.setCname("XML");
		
		Set<Course> set1 = new HashSet<Course>();
		set1.add(c1);
		set1.add(c2);
		set1.add(c3);
		
		Student s1 = new Student();
		s1.setSname("A");
		s1.setCou(set1);
		
		Student s2 = new Student();
		s2.setSname("B");
		s2.setCou(set1);
		
		Student s3 = new Student();
		s3.setSname("C");
		s3.setCou(set1);
		
		HibernateMapping h = new HibernateMapping();
		h.insert(s1);
		h.insert(s2);
		h.insert(s3);
		
		
	}
}
