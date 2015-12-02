import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import java.util.Scanner;

public class CsvDatabase implements java.io.Serializable {

	static public class Student implements java.io.Serializable {
		public int id = 0;
		public String firstName;
		public String lastName;
		public String age;
		public String homeTown;

		public Student() {

		}

		public Student(int id, String firstName, String lastName, String age, String homeTown) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.homeTown = homeTown;
		}

		public String ToString() {
			return new String(firstName + " " + lastName + " (age: " + age + ", town: " + homeTown + ")");
		}
	}

	static public class Subject implements java.io.Serializable {

		public String subject;
		public List<Double> grades = new ArrayList<Double>();

		public Subject() {

		}

		public Subject(String subject, String grade) {
			this.subject = subject;
			this.grades.add(Double.parseDouble(grade));
		}

	}

	public static void main(String[] args) {
		String input;
		Scanner scan = new Scanner(System.in);

		HashMap<Integer, Student> students = new HashMap<Integer, Student>();
		HashMap<String, ArrayList<Subject>> grades = new HashMap<String, ArrayList<Subject>>();
		ArrayList<Subject> list = new ArrayList<Subject>();

		try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(new File("res/Students.save")));
				ObjectInputStream ios2 = new ObjectInputStream(new FileInputStream(new File("res/Grades.save")))) {
			students = (HashMap<Integer, Student>) ios.readObject();
			grades = (HashMap<String, ArrayList<Subject>>) ios2.readObject();
			System.out.println("Successfully loaded data from files.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("File error");
		}

		while (true) {
			input = scan.nextLine();
			if (input.equals(new String("end"))) {
				break;
			}
			String[] command = input.split(" ");
			switch (command[0]) {
			case "Insert-student":
				students.put(students.size(),
						new Student(students.size(), command[1], command[2], command[3], command[4]));
				System.out.println("Student added");
				break;
			case "Insert-grade-by-id":
				list.add(new Subject(command[2], command[3]));
				grades.put(command[1], list);
				System.out.println("Grade added");
				break;
			case "Delete-by-id":
				if (students.containsKey(Integer.parseInt(command[1]))) {
					students.remove(Integer.parseInt(command[1]));
					System.out.println("Student removed");
					if (grades.containsKey(command[1])) {
						grades.remove(command[1]);
						System.out.println("And it's existing grades removed");
					}
				} else {
					System.out.println("Student does not exist");
				}
			case "Search-by-id":
				if (students.containsKey(Integer.parseInt(command[1]))) {
					String studInfo = students.get(Integer.parseInt(command[1])).ToString();
					System.out.println(studInfo);
					if (grades.containsKey(command[1])) {
						List<Subject> gradeInfo = grades.get(command[1]);
						for (Subject s : gradeInfo) {
							System.out.printf(" # %s: ", s.subject);
							for (double d : s.grades) {
								System.out.print(d);
							}
						}
					}
				} else {
					System.out.println("Students does not exist");
				}
			case "Search-by-full-name":
				for (Entry<Integer, Student> entry : students.entrySet()) {
					Integer key = entry.getKey();
					Student value = entry.getValue();
					if (value.firstName.equals(command[1]) && value.lastName.equals(command[2])) {
						String studInfo = students.get(key).ToString();
						if (grades.containsKey(key)) {
							List<Subject> gradeInfo = grades.get(key);
							for (Subject s : gradeInfo) {
								System.out.printf(" # %s: ", s.subject);
								for (double d : s.grades) {
									System.out.print(d);
								}
							}
						}
					}
				}
			}
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("res/Students.save")));
				ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(new File("res/Grades.save")))) {
			oos.writeObject(students);
			oos2.writeObject(grades);
			System.out.println("Successfully saved data to files.");
		} catch (IOException e) {
			System.out.println("File error");
		}
	}

}