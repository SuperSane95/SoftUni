import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WierdScript {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = Integer.parseInt(scan.nextLine());

		HashMap<Integer, Character> map = new HashMap<>();
		char c = 'a';

		for (int i = 1; i < x; i++) {
			if (c == 'z') {
				c = 'A';
			} else if (c == 'Z') {
				c = 'a';
			} else {
				c++;
			}
		}
		char key = c;
		String sKey = ""+key+key;
		String input = scan.nextLine();
		List<String> list = new ArrayList<>();
		while (!input.equals("End")) {
			list.add(input);
			input = scan.nextLine();
		}

		StringBuilder str = new StringBuilder();
		for(String a : list) {
			str.append(a);
		}
		
		Pattern pat = Pattern.compile("(" + key + "{2})(.*)(" + key + "{2})");
		Matcher match = pat.matcher(str);
		while (match.find()) {
			String[] arr = match.group().split(sKey);
			for (String u : arr) {
				if (!u.equals("")) {
					if(!containsDigits(u)) {
						System.out.println(u);
					} 
				} 
			}
		}
		
	}
	public static boolean containsDigits(String s) {
		if(s.contains("0") || s.contains("1") || s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || 
				s.contains("6") || s.contains("7") || s.contains("8") || s.contains("9") ) {
			if (s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || 
					s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9")) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}
