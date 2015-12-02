import java.util.Scanner;

public class OddEvenPairs {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] stringNumbers = input.split(" ");
		int[] numbers = new int[stringNumbers.length];
		int[] pair = new int[2];
		int count = 0;
		int a, b;
		if ((stringNumbers.length % 2) != 0) {
			System.out.println("Invalid length");
		} else {
			for (int i = 0; i < stringNumbers.length; i++) {
				numbers[i] = Integer.parseInt(stringNumbers[i]);
			}
			for (int i = 0; i < numbers.length; i++) {
				count++;
				if (count == 2) {
					if ((numbers[i] % 2 == 0) && (numbers[i - 1] % 2 == 0)) {
						System.out.printf("%d, %d -> Both are even", numbers[i - 1], numbers[i]);
						System.out.println();
						count = 0;
					} else if ((numbers[i] % 2 != 0) && (numbers[i - 1] % 2 != 0)) {
						System.out.printf("%d, %d -> Both are odd", numbers[i - 1], numbers[i]);
						System.out.println();
						count = 0;
					} else {
						System.out.printf("%d, %d -> Different", numbers[i - 1], numbers[i]);
						System.out.println();
						count = 0;
					}
				}
			}
		}
	}
}
