import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine().trim());
		String[] pyramid = new String[n];
		List<Integer> sequence = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			pyramid[i] = scan.nextLine();
		}
		int lastNumber = Integer.parseInt(pyramid[0].trim());
		int min = lastNumber;
		sequence.add(lastNumber);
		for (int i = 1; i < pyramid.length; i++) {
			String[] line = pyramid[i].trim().split(" ");
			List<Integer> tempList = new ArrayList<>();
			for (int j = 0; j < line.length; j++) {
				if (!line[j].equals(" ") && !line[j].equals("")) {
					int number = Integer.parseInt(line[j]);
					if (number > lastNumber) {
						tempList.add(number);
					}
				}
			}
			if (!tempList.isEmpty()) {
				lastNumber = tempList.get(0);
				for (int a : tempList) {
					if (lastNumber > a) {
						lastNumber = a;
					}
				}
				sequence.add(lastNumber);
			}

		}
		String output = sequence.toString();
		output = output.replace("[", "");
		output = output.replace("]", "");
		System.out.println(output);
	}

}
