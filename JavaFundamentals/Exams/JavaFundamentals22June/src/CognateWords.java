import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CognateWords {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		Pattern pat = Pattern.compile("[a-zA-Z]+");
		Matcher match = pat.matcher(input);
		List<String> words = new ArrayList<>();
		boolean containsAny = false;
		while (match.find()) {
			words.add(match.group());
		}
		List<String> duplicateWords = new ArrayList<>(words);
		for (int i = 0; i < words.size() - 1; i++) {
			for (int j = i + 1; j < words.size(); j++) {
				String word1 = words.get(i);
				String word2 = words.get(j);
				String word3 = word1 + word2;
				String output = "";
				boolean contains = false;
				if(duplicateWords.contains(word3)) {
					output = word1+"|"+word2+"="+word3;
					System.out.println(output);
					words.set(i, "-999");
					words.set(j, "-999");
					duplicateWords.remove(word3);
					contains = true;
					containsAny = true;
				}
				word1 = words.get(j);
				word2 = words.get(i);
				word3 = word1+word2;
				if(duplicateWords.contains(word3)) {
					output = word1+"|"+word2+"="+word3;
					System.out.println(output);
					words.set(i, "-999");
					words.set(j, "-999");
					duplicateWords.remove(word3);
					contains = true;
					containsAny = true;
				}
				if(contains) {
					words.set(i, "-999");
					words.set(j, "-999");
				}
			}
		}
		if(!containsAny) {
			System.out.println("No");
		}
	}

}
