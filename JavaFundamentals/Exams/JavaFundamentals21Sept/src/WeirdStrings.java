import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdStrings {

	public static void main(String[] args) {
		HashMap<Character, Integer> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		List<String> words = new ArrayList<>();
		int k = 1;
		for(char c = 'a'; c<='z'; c++, k++) {
			map.put(c, k);
		}
		k = 1;
		for(char c = 'A'; c<='Z'; c++, k++) {
			map.put(c, k);
		}
		
		input = input.replace("(", "");
		input = input.replace(")", "");
		input = input.replace("\\", "");
		input = input.replace("/", "");
		input = input.replace("|", "");
		input = input.replace(" ", "");
		
		Pattern pat = Pattern.compile("[a-zA-Z]+");
		Matcher match = pat.matcher(input);
		
		while(match.find()) {
			words.add(match.group());
		}
		
		int sum = 0;
		int max = 0;
		String a = "";
		String b = "";
		
		for(int i = 0; i<words.size()-1; i++) {
			for(int j = 0; j<words.get(i).length(); j++) {
				sum+=map.get(words.get(i).charAt(j));
			}
			for(int j = 0; j<words.get(i+1).length(); j++) {
				sum+=map.get(words.get(i+1).charAt(j));
			}
			if(sum >= max) {
				max = sum;
				a = words.get(i);
				b = words.get(i+1);
			}
			sum = 0;
		}
		
		System.out.println(a);
		System.out.println(b);
		
	}

}
