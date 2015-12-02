import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FilterArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		List<String> list =  Arrays.asList(input);
		list.stream().filter(a -> a.length() > 3).forEach(System.out::println);
	}

}
