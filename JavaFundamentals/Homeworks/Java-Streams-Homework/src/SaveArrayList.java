import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SaveArrayList {

	public static void main(String[] args) {
		List<Double> myList = new ArrayList<Double>();
		List<Double> loadedList = new ArrayList<Double>();
		Random rn = new Random();
		double dd;
		for(int i = 0; i<10; i++) {
			dd = rn.nextDouble();
			System.out.printf("Adding %.2f to myList\n", dd);
			myList.add(dd);
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("res/doubles.list")))) {
			oos.writeObject(myList);
			System.out.println("myList has been written to doubles.list");
		}
		catch (IOException e) {
			System.out.println("File error");
		}
		try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(new File("res/doubles.list")))) {
			loadedList = (List<Double>) ios.readObject();
			System.out.println("doubles.list content has been loaded to loadedList");
		}
		catch (IOException | ClassNotFoundException e) {
			System.out.println("File error");
		}
		for(double d : loadedList) {
			System.out.printf("loadedList: %.2f\n",d);
		}
	}

}
