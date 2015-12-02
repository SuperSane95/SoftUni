
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MagicWords {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String string1 = scan.nextLine();
		String string2 = scan.nextLine();
		boolean result = exchange(string1, string2);
		System.out.println(result);
	}

	public static boolean exchange(String string1, String string2) {
		boolean result = false;
		HashMap<Character, Character> dictionary = new HashMap<>();

		if (string1.length() != string2.length()) {
			System.out.println("Incorrect format!");
			return false;
		} else {
			for (int i = 0; i < string1.length(); i++) {
				if (!dictionary.containsKey(string1.charAt(i))) {
					if (!dictionary.containsValue(string2.charAt(i))) {
						dictionary.put(string1.charAt(i), string2.charAt(i));
					}
				}
			}
			for (int i = 0; i < string1.length(); i++) {
				if (dictionary.containsKey(string1.charAt(i))) {
					if (dictionary.get(string1.charAt(i)) != string2.charAt(i)) {
						result = false;
						return result;
					} else {
						result = true;
					}
				} else {
					result = false;
					return result;
				}
			}
		}
		return result;
	}

}
