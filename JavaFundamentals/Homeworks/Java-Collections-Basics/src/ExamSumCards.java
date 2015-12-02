import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamSumCards {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		List<String> cards = new ArrayList<>();
		List<Integer> checked = new ArrayList<>();
		List<Integer> unchecked = new ArrayList<>();
		int j = 0;
		Pattern pat = Pattern.compile("\\d+|[A|J|Q|K]");
		Matcher match = pat.matcher(input);
		int sum = 0;
		int doubledSum = 0;
		while (match.find()) {
			cards.add(match.group());
		}
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).equals(new String("J"))) {
				cards.remove(i);
				cards.add(i, new String("12"));
			} else if (cards.get(i).equals(new String("Q"))) {
				cards.remove(i);
				cards.add(i, new String("13"));
			} else if (cards.get(i).equals(new String("K"))) {
				cards.remove(i);
				cards.add(i, new String("14"));
			} else if (cards.get(i).equals(new String("A"))) {
				cards.remove(i);
				cards.add(i, new String("15"));
			}
		}
		int[] arr = new int[cards.size()];
		for (int i = 0; i < cards.size(); i++) {
			arr[i] = Integer.parseInt(cards.get(i));
		}
		if(arr.length == 1) {
			System.out.println(arr[0]);
		} else {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] == arr[i + 1]) {
					checked.add(arr[i]);
					j = i + 1;
					;
					while (j != arr.length) {
						if (arr[j] == arr[i]) {
							checked.add(arr[j]);
							j++;
						} else {
							break;
						}
					}
					i = j-1;
					if (i == arr.length - 2 && arr[i] == arr[i + 1]) {
						checked.add(arr[i + 1]);
					}
				} 
			}
			for (int a : checked) {
				doubledSum += a;
			}
			sum += doubledSum * 2;
			for (int i = 0; i < arr.length; i++) {
				
				if (i == 0 && arr[i] != arr[i + 1]) {
					sum += arr[i];
				} else if (i == arr.length - 1 && arr[i] != arr[i - 1]) {
					sum += arr[i];
				} else if (i != 0 && i != arr.length - 1) {
					if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) {
						sum += arr[i];
					}
				} else {
					continue;
				}
			}
			System.out.println(sum);
		}
	}
}