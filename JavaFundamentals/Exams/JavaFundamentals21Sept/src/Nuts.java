import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Nuts {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeMap<String, LinkedHashMap<String, Integer>> companies = new TreeMap<>();
		int n = Integer.parseInt(scan.nextLine());
		HashMap<String, Integer> orderedNuts = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String[] input = scan.nextLine().split(" ");
			LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
			String company = input[0];
			String nuts = input[1];
			int amount = Integer.parseInt(input[2].replace("kg", ""));

			if (companies.containsKey(company)) {
				map = companies.get(company);
				if (map.containsKey(nuts)) {
					amount += map.get(nuts);
					map.put(nuts, amount);
					companies.put(company, map);
				} else {
					map.put(nuts, amount);
					companies.put(company, map);
				}
			} else {
				map.put(nuts, amount);
				companies.put(company, map);
			}

		}

		for (Entry<String, LinkedHashMap<String, Integer>> entry1 : companies.entrySet()) {
			System.out.print(entry1.getKey() + ": ");
			String output = entry1.getValue().toString();
			output = output.replace("{", "");
			output = output.replace(",", "kg,");
			output = output.replace("}", "");
			output = output.replace("=", "-");
			output = output + "kg";
			System.out.print(output + "\n");
		}

	}

}
