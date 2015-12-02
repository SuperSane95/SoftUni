import java.util.ArrayList;
import java.util.Scanner;

public class LargestSequenceOfEqualStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		if (input.length == 1) {
			System.out.println(input[0]);
			return;
		}
		String word = input[0];
		int max = 1;
		int count = 1;
		for (int i = 1; i < input.length; i++) {
			if (input[i].equals(input[i - 1])) {
				count++;
			} else {
				if (count > max) {
					max = count;
					word = input[i - 1];
				}
				count = 1;
			}
		}
		for (int i = 0; i < max; i++) {
			System.out.print(word + " ");

		}
		System.out.println("Max = " + max);
	}
}
