import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AllCapitals {

	public static void main(String[] args) {
		String line;
		List<String> lines = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader("res/AllCapitals.txt"))) {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				lines.add(line);
			}
		} catch (IOException e) {
			System.out.println("File error 1");
		}

		try (PrintWriter pw = new PrintWriter(new FileWriter("res/AllCapitals.txt"))) {
			for (String s : lines) {
				pw.write(new String(s.toUpperCase()) + "\n");
			}

		} catch (IOException e) {
			System.out.println("File error 2");
		}

	}
}
