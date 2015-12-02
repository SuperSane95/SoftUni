import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class CouplesFrequency {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		input = input.replace("{ ", "");
		input = input.replace(" }", "");
		String[] numbers = input.split(" ");
		List<Integer> list = new ArrayList<>();
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		int couples = 0;
		for (String number : numbers) {
			list.add(Integer.parseInt(number));
		}
		for (int i = 0; i < list.size() - 1; i++) {
			int number1 = list.get(i);
			int number2 = list.get(i + 1);
			couples++;
			String couple = String.format("%d %d", number1, number2);
			int count;
			if(map.containsKey(couple)) {
				count = map.get(couple);
				map.put(couple, count+1);
			} else {
				map.put(couple, 1);
			}
		}
		for(Entry<String, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			double d = ((double)value/couples)*100;
			System.out.printf("%s -> %.2f%%\n",entry.getKey(), d);
		}
	}

}
