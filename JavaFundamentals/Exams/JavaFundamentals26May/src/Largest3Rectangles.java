import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Largest3Rectangles {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("[\\[\\]]+");
		List<Integer> list = new ArrayList<>();
		for (String pair : input) {
			String ss = pair.replaceAll("\\s+", "");
			if (!ss.equals("")) {
				String[] s = ss.trim().split("x");
				int number = Integer.parseInt(s[0].trim()) * Integer.parseInt(s[1].trim());
				list.add(number);
			}
		}
		int max = 0;
		for (int i = 0; i < list.size() - 2; i++) {
			int number1 = list.get(i);
			int number2 = list.get(i + 1);
			int number3 = list.get(i + 2);
			if (number1 + number2 + number3 > max) {
				max = number1 + number2 + number3;
			}
		}
		System.out.println(max);
	}

}
