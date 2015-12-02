import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerroristsWin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		Pattern pat = Pattern.compile("\\|.*?\\|");
		Matcher match = pat.matcher(input);
		while (match.find()) {

			String bomb = match.group();
			bomb = new String(bomb.replace("|", ""));
			long bombPower = 0;
			for (int i = 0; i < bomb.length(); i++) {
				bombPower += bomb.charAt(i);
			}
			bombPower = bombPower % 10;
			bomb = new String("|" + bomb + "|");
			long firstIndex = input.indexOf(bomb) - bombPower;
			if (firstIndex < 0) {
				firstIndex = 0;
			}
			long lastIndex = input.indexOf(bomb) + bomb.length() - 1 + bombPower;
			if (lastIndex > input.length() - 1) {
				lastIndex = input.length() - 1;
			}
			char[] inputArray = input.toCharArray();
			for (int i = (int) firstIndex; i <= lastIndex; i++) {
				inputArray[i] = '.';
			}
			input = new String(inputArray);
		}
		System.out.println(input);
	}

}
