import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractWords {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		//Pattern pat = Pattern.compile("[a-zA-Z]+");
		Pattern pat = Pattern.compile("\\bodd|even\\b");
		Matcher match = pat.matcher(input);
		while(match.find()) {
			System.out.print(match.group() + " ");
		}
	}

}
