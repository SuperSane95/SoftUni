import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class CombineListOfLetters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		ArrayList<Character> list1 = (ArrayList<Character>) input.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
		input = scan.nextLine();
		ArrayList<Character>  list2 = (ArrayList<Character>) input.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		ArrayList<Character> middle = new ArrayList<>();
		for (char a : list2) {
			
			if (!list1.contains(a)) {
				middle.add(a);
			}
		}
		list1.addAll(middle);
		for (char b : list1) {
			if(b == ' ') {
				continue;
			}
			System.out.print(b + " ");
		}
	}

}
