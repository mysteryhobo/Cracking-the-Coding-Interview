import java.util.*;

public class HashMapTest {
	public static void main(String[] args) {
		Student[] students = new Student[5];
		HashMapTest tester = new HashMapTest();
		students[0] = tester.new Student("peter", 1);
		students[1] = tester.new Student("emma", 2);
		students[2] = tester.new Student("craig", 3);
		students[3] = tester.new Student("brett", 4);
		students[4] = tester.new Student("luka", 5);

		HashMap<Integer, Student> map = tester.buildMap(students);

		System.out.printf("HashMap: %s %n", map.toString());

		map.put(6, tester.new Student("ralph", 6));

		System.out.printf("HashMap: %s %n", map.toString());

	}

	public HashMap<Integer, Student> buildMap(Student[] students) {
		HashMap<Integer, Student> map = new HashMap<Integer, Student>();
		for (Student s : students) {
			map.put(s.getid(), s);
		}
		return map;
	}

	private class Student {
		private String name;
		private int id;

		private Student(String name, int id){
			this.name = name;
			this.id = id;
		}

		public int getid(){
			return id;
		}

		@Override
		public String toString(){
			return "Student: " + id + ", name: " + name;
		}
	}
}