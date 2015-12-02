import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Weightlifting {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String[] input = new String[n];
		TreeMap<String, TreeMap<String, Long>> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			input[i] = scan.nextLine();
		}

		for (int i = 0; i < input.length; i++) {
			String[] data = input[i].split(" ");
			TreeMap<String, Long> map1 = new TreeMap<>();
			long weight = Long.parseLong(data[2]);
			String name = data[0];
			String exercise = data[1];

			if (map.containsKey(name)) {
				map1 = map.get(name);
				if (map1.containsKey(exercise)) {
					weight += map1.get(exercise);
					map1.put(exercise, weight);
				} else {
					map1.put(exercise, weight);
				}
				map.put(name, map1);
			} else {
				map1.put(exercise, weight);
				map.put(name, map1);
			}

		}
		
		for(Entry<String, TreeMap<String, Long>> entry : map.entrySet()) {
			System.out.printf("%s : ",entry.getKey());
			String s = entry.getValue().toString();
			s = new String(s.replace("{", ""));
			s = new String(s.replace("}", ""));
			s = new String(s.replace("}", ""));
			s = new String(s.replace("=", " - "));
			s = new String(s.replace(",", " kg,"));
			System.out.println(s + " kg");
		}

	}

}
