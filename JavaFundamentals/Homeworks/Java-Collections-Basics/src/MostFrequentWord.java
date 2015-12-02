import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;

public class MostFrequentWord {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		input = new String(input.toLowerCase());
		String[] words = input.split("\\W+");
		int max = 0;
		int count = 0;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			Pattern pat = Pattern.compile("\\b" + words[i] + "\\b");
			Matcher matcher = pat.matcher(input);
			while (matcher.find()) {
				count++;
			}
			map.put(words[i], count);
			count = 0;
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if (value > max) {
				max = value;
			}
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
			}
		}
	}

}
