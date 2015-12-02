import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetOddOrEven {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] numbersString = input.split(" ");
		String oddEven = "none", countString = "0";
		int count = 0;
		input = scan.nextLine();
		Pattern pat = Pattern.compile("(\\d+)");
		Matcher matcher = pat.matcher(input);
		while (matcher.find()) {
			countString = matcher.group();
		}
		pat = Pattern.compile("\\bodd|even\\b");
		matcher = pat.matcher(input);
		while (matcher.find()) {
			oddEven = matcher.group();
		}
		count = Integer.parseInt(countString);
		int result[] = resultReturn(numbersString, count, oddEven);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static int[] resultReturn(String[] numbersString, int count, String oddEven) {
		int[] numbers = new int[numbersString.length];
		int[] arr = new int[count];
		int j = 0;
		for (int i = 0; i < numbersString.length; i++) {
			numbers[i] = Integer.parseInt(numbersString[i]);
		}
		if (oddEven.equals(new String("even"))) {
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] % 2 == 0) {
					arr[j] = numbers[i];
					j++;
				}
			}
		} else if (oddEven.equals(new String("odd"))) {
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] % 2 != 0) {
					arr[j] = numbers[i];
					j++;
				}
			}
		}
		int[] result = new int[j];
		for (int i = 0; i<j; i++) {
			result[i] = arr[i];
		}
		return result;
	}
}
