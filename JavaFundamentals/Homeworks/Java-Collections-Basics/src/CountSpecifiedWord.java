import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSpecifiedWord {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("\\W+");
		String word = scan.nextLine();
		int count = 0;
		for(int i = 0; i<input.length; i++) {
			String toCheck = input[i].toLowerCase();
			if(toCheck.equals(word)) {
				count++;
			}
		}
		System.out.println(count);
	}

}
