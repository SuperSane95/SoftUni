import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextFormatter {
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder();
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		StringBuilder sb = new StringBuilder();
		while (!input.equals("burp")) {
			sb.append(input);
			input = scan.nextLine();
		}
		String text = sb.toString();
		text = text.replaceAll("\\s+", " ");
//		System.out.println(text);
		Pattern pat = Pattern
				.compile("(\\$[^$]+\\$)|(\\%[^%]+\\%)|(\\&[^&]+\\&)|(\\'[^']+\\')");
		Matcher match = pat.matcher(text);
		int weight;
		while (match.find()) {
			String sequence = match.group();
			if (sequence.charAt(0) == '$') {
				weight = 1;
				sequence = sequence.replace("$", "");
				String decypher = "";
				for (int i = 0; i < sequence.length(); i++) {
					if (i % 2 == 0 || i == 0) {
						int value = (int) sequence.charAt(i);
						value += weight;
						decypher += (char) value;
					} else if (i % 2 != 0) {
						int value = (int) sequence.charAt(i);
						value -= weight;
						decypher += (char) value;
					}
				}
				list.add(decypher);
				sb1.append(decypher + " ");
			} else if (sequence.charAt(0) == '%') {
				weight = 2;
				sequence = sequence.replace("%", "");
				String decypher = "";
				for (int i = 0; i < sequence.length(); i++) {
					if (i % 2 == 0 || i == 0) {
						int value = (int) sequence.charAt(i);
						value += weight;
						decypher += (char) value;
					} else if (i % 2 != 0) {
						int value = (int) sequence.charAt(i);
						value -= weight;
						decypher += (char) value;
					}
				}
				list.add(decypher);
				sb1.append(decypher + " ");
			} else if (sequence.charAt(0) == '&') {
				sequence = sequence.replace("&", "");
				weight = 3;
				String decypher = "";
				for (int i = 0; i < sequence.length(); i++) {
					if (i % 2 == 0 || i == 0) {
						int value = (int) sequence.charAt(i);
						value += weight;
						decypher += (char) value;
					} else if (i % 2 != 0) {
						int value = (int) sequence.charAt(i);
						value -= weight;
						decypher += (char) value;
					}
				}
				list.add(decypher);
				sb1.append(decypher + " ");
			} else if (sequence.charAt(0) == '\'') {
				sequence = sequence.replace("'", "");
				weight = 4;
				// System.out.println(sequence);
				String decypher = "";
				for (int i = 0; i < sequence.length(); i++) {
					if (i % 2 == 0 || i == 0) {
						int value = (int) sequence.charAt(i);
						value += weight;
						decypher += (char) value;
					} else if (i % 2 != 0) {
						int value = (int) sequence.charAt(i);
						value -= weight;
						decypher += (char) value;
					}
				}
				list.add(decypher);
				sb1.append(decypher + " ");
			}
		}
//		String output = sb1.toString().trim();
		System.out.println(list);
//		System.out.println(output);
	}
}
