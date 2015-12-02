import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class ExtractAllUniqueWords {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("\\W+");
		TreeSet<String> set = new TreeSet<>();
		for (String s : input) {
			s = new String(s.toLowerCase());
			set.add(s);
		}
		System.out.println(set);
	}

}
