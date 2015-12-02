import java.io.*;

public class SumLines {

	public static void main(String[] args) {
		int sum = 0;
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader("res/SumLines.txt"))) {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				for (int i = 0; i < line.length(); i++) {
					sum += line.charAt(i);
				}
				System.out.println(sum);
				sum = 0;
			}
		} catch (FileNotFoundException fnf) {
			System.out.println("FileNotFound");
		} catch (IOException io) {
			System.out.println("IO Error");
		}
	}
}
