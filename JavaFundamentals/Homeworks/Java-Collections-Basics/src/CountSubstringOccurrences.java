import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurrences {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String input = read.nextLine();
		String word = read.nextLine();
		int count = 0;
		int lastIndex = 0;
		input = new String(input.toLowerCase());
		while (true) {
			lastIndex = input.indexOf(word, lastIndex);
			if (lastIndex != -1) {
				count++;
				lastIndex++;
			} else {
				break;
			}
		}
		System.out.println(count);
	}

}
