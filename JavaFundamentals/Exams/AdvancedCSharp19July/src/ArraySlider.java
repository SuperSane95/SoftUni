import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArraySlider {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String numbers = scan.nextLine();
		List<Long> list = new ArrayList<>();
		Pattern pat = Pattern.compile("\\S+");
		Matcher match = pat.matcher(numbers);
		while(match.find()) {
			list.add(Long.parseLong(match.group()));
		}
		int currentIndex = 0;
		String input = scan.nextLine();
		while (!input.equals("stop")) {
			String[] cmds = input.split(" ");
			int operand = Integer.parseInt(cmds[2]);
			int offset = Integer.parseInt(cmds[0]);
			String symbol = cmds[1];
			currentIndex += offset;
			long newNumber = 0;
			while (true) {
				if (currentIndex > list.size() - 1) {
					currentIndex -= (list.size());
				} else if (currentIndex < 0) {
					currentIndex = (list.size()) + currentIndex;
				} else {
					break;
				}
			}
			switch (symbol) {
			case "*":
				newNumber = list.get(currentIndex);
				newNumber = newNumber * operand;
				if (newNumber < 0) {
					newNumber = 0;
				}
				// list.set(currentIndex, newNumber);
				break;

			case "/":
				newNumber = list.get(currentIndex);
				newNumber = newNumber / operand;
				if (newNumber < 0) {
					newNumber = 0;
				}
				// list.set(currentIndex, newNumber);
				break;

			case "+":
				newNumber = list.get(currentIndex);
				newNumber = newNumber + operand;
				if (newNumber < 0) {
					newNumber = 0;
				}
				// list.set(currentIndex, newNumber);
				break;

			case "-":
				newNumber = list.get(currentIndex);
				newNumber = newNumber - operand;
				if (newNumber < 0) {
					newNumber = 0;
				}
				// list.set(currentIndex, newNumber);
				break;

			case "|":
				newNumber = list.get(currentIndex);
				newNumber = newNumber | operand;
				if (newNumber < 0) {
					newNumber = 0;
				}
				// list.set(currentIndex, newNumber);
				break;

			case "&":
				newNumber = list.get(currentIndex);
				newNumber = newNumber & operand;
				if (newNumber < 0) {
					newNumber = 0;
				}
				// list.set(currentIndex, newNumber);
				break;

			case "^":
				newNumber = list.get(currentIndex);
				newNumber = newNumber ^ operand;
				if (newNumber < 0) {
					newNumber = 0;
				}
				// list.set(currentIndex, newNumber);
				break;

			default:
				break;
			}
			list.set(currentIndex, newNumber);
//			 System.out.println(newNumber + " " + currentIndex);
			input = scan.nextLine();
		}
		System.out.println(list);
	}

}
