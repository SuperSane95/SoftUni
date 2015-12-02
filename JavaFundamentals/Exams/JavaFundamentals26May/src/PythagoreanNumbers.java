import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PythagoreanNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			numbers.add(Integer.parseInt(scan.nextLine()));
		}
		boolean hasEquation = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					int number1 = numbers.get(i);
					int number2 = numbers.get(j);
					int number3 = numbers.get(k);
					if (number1 * number1 + number2 * number2 == number3 * number3) {
						if (number1 <= number2) {
							System.out.printf("%d*%d + %d*%d = %d*%d\n", number1, number1, number2, number2, number3,
									number3);
							hasEquation = true;
						}
					}

				}
			}
		}
		if (!hasEquation) {
			System.out.println("No");
		}
	}

}
