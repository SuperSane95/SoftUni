import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		String sortType = scan.nextLine();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i<input.length; i++) {
			list.add(Integer.parseInt(input[i]));
		}
		switch (sortType) {
		case "Ascending":
			list.stream().sorted((a,b) -> a.compareTo(b)).forEach(System.out::println);
			break;
		case "Descending":
			list.stream().sorted((a,b) -> b.compareTo(a)).forEach(System.out::println);
			break;
		default:
			System.out.println("Wrong sorting input");
			break;
		}
	}

}
