import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;

public class CardsFrequencies {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		ArrayList<String> list = new ArrayList<>();
		Pattern pat = Pattern.compile("\\w+");
		Matcher matcher = pat.matcher(input);
		while (matcher.find()) {
			list.add(matcher.group());
		}
		int max = 0;
		int count = 0;
		HashMap<String, Integer> map = new HashMap<>();
		for (String a : list) {
			Pattern patt = Pattern.compile("\\b" + a + "\\b");
			Matcher matcherr = patt.matcher(input);
			while (matcherr.find()) {
				count++;
			}
			map.put(a, count);
			count = 0;
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			double d = entry.getValue();
			int n = list.size();
			System.out.printf("%s -> %.2f%%\n", entry.getKey(), (d/n)*100 );
		}
	}
}