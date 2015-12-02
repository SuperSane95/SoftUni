import java.util.Arrays;
import java.util.Scanner;

public class SequenceOfEqualStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			if (i == input.length - 1) {
				if (input[i].equals(input[i - 1])) {
					System.out.print(input[i]);
				} else {
					System.out.println(input[i]);
				}
			} else {
				if (input[i].equals(input[i + 1])) {
					System.out.print(input[i] + " ");
				} else {
					System.out.println(input[i]);
				}
			}
		}
	}

}
