import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveCustomObject {
	
	static public class Course implements java.io.Serializable{
		private String name;
		private int studentNumber;
		
		public Course() {
			
		}
		
		public Course(String aName, int aStudentNumber) {
			this.setName(aName);
			this.setStudentNumber(aStudentNumber);
		}

		public int getStudentNumber() {
			return studentNumber;
		}

		public void setStudentNumber(int studentNumber) {
			this.studentNumber = studentNumber;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String ToString() {
			return new String("Course info -> Name: " + this.name + " Number of students: " + this.studentNumber);
		}
	}
	public static void main(String[] args) {
		Course crsToWrite = new Course("Java Fundamentals", 400);
		Course crsToLoad = new Course();
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("res/course.save")))) {
			oos.writeObject(crsToWrite);
			System.out.println("Course crsToWrite has been written to course.save");
		}
		catch (IOException e) {
			System.out.println("File error");
		}
		try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(new File("res/course.save")))) {
			crsToLoad = (Course) ios.readObject();
			System.out.println("course.save content has been loaded to Course crsToLoad");
			System.out.println(crsToLoad.ToString());
		}
		catch (IOException | ClassNotFoundException e) {
			System.out.println("File error");
		}
	}

}
