import java.util.Scanner;

public class Base7ToDecimal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String base7 = scan.nextLine();
		char[] base7array = base7.toCharArray();
		int result = 0, digit;
		for (int i = 0; i < base7array.length; i++) {
			digit = Integer.parseInt(String.valueOf(base7array[i]));
			result += digit;
			if (i == base7array.length - 1) {
				break;
			}
			result *= 7;
		}
		System.out.println(result);
	}

}
