import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Pattern pat = Pattern.compile("\\w+");
		Matcher match = pat.matcher(input);
		List<String> valid = new ArrayList<>();

		while (match.find()) {
			String name = match.group();
			if (!startsWithDigit(name)) {
				if (name.length() >= 3 && name.length() <= 25) {
					valid.add(name);
				}
			}
		}
		int sum = 0;
		int max = 0;
		int sum1, sum2;
		String name1 = "";
		String name2 = "";

		for (int i = 0; i < valid.size() - 1; i++) {
			sum1 = valid.get(i).length();
			sum2 = valid.get(i+1).length();
			sum = sum1 + sum2;
			if (sum > max) {
				max = sum;
				name1 = valid.get(i);
				name2 = valid.get(i+1);
			}

		}

		System.out.println(name1);
		System.out.println(name2);

	}

	public static boolean startsWithDigit(String name) {
		if (name.charAt(0) == '0' || name.charAt(0) == '1' || name.charAt(0) == '2' || name.charAt(0) == '3'
				|| name.charAt(0) == '4' || name.charAt(0) == '5' || name.charAt(0) == '6' || name.charAt(0) == '7'
				|| name.charAt(0) == '8' || name.charAt(0) == '8') {
			return true;
		} else {
			return false;
		}
	}

}
