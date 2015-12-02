import java.util.Scanner;

public class CharacterMultiplier {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String string1 = scan.nextLine();
		String string2 = scan.nextLine();
		int result = multiplier(string1, string2);
		System.out.println(result);
	}

	public static int multiplier(String string1, String string2) {
		int sum = 0;
		if (string1.length() > string2.length()) {
			for (int i = 0; i < string1.length(); i++) {
				try {
					sum += string1.charAt(i) * string2.charAt(i);
				} catch (StringIndexOutOfBoundsException e) {
					sum += string1.charAt(i);
				}
			}
		} else {
			for (int i = 0; i < string2.length(); i++) {
				try {
					sum += string2.charAt(i) * string1.charAt(i);
				} catch (StringIndexOutOfBoundsException e) {
					sum += string2.charAt(i);
				}
			}
		}
		return sum;
	}
}
