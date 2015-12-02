import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String input = read.nextLine();
		int count = 0;
		Pattern pat = Pattern.compile("[a-z]+[\\.|\\-|\\_]{1}[a-z]+@([a-z]+[\\-]{0,1}[a-z]\\.[a-z]+)(\\.{0,1}[a-z]+)+");
		Matcher match = pat.matcher(input);
		while(match.find()){
			System.out.println(match.group());
		}
	}
}
