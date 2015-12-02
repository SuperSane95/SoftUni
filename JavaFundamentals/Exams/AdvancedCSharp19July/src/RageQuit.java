import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.java.swing.plaf.windows.WindowsTableHeaderUI;


public class RageQuit {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		List<String> letters = new ArrayList<>();
		List<Integer> counts = new ArrayList<>();
		Pattern pat = Pattern.compile("\\d+");
		Matcher match = pat.matcher(input);
		while (match.find()) {
			counts.add(Integer.parseInt(match.group()));
		}
		pat = Pattern.compile("\\D+");
		match = pat.matcher(input);
		while (match.find()) {
			String sequence = match.group();
			sequence = sequence.toUpperCase();
			letters.add(sequence);
		}
		HashSet<Character> unique = new HashSet<>();
		for(String s : letters) {
			for(int i = 0; i<s.length(); i++) {
				unique.add(s.charAt(i));
			}
		}
		StringBuilder sb = new StringBuilder();
		System.out.println("Unique symbols used: " + unique.size());
		for(int i = 0; i<letters.size(); i++) {
			for(int j = 0; j<counts.get(i); j++) {
				sb.append(letters.get(i));
			}
			System.out.print(sb.toString());
			sb = new StringBuilder();
		}
		
		
	}

}
