
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class OfficeStuff {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		TreeMap<String, LinkedHashMap<String, Integer>> companies = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			String line = scan.nextLine();
			line = line.replace("|", "");
			line = line.replace("- ", "");
			// System.out.println(line);
			String[] cmds = line.split(" ");
			String company = cmds[0];
			int amount = Integer.parseInt(cmds[1]);
			String product = cmds[2];
			LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

			if (companies.containsKey(company)) {
				map = companies.get(company);
				if (map.containsKey(product)) {
					amount += map.get(product);
					map.put(product, amount);
				} else {
					map.put(product, amount);
				}
			} else {
				map.put(product, amount);
				companies.put(company, map);
			}

		}

		for (Entry<String, LinkedHashMap<String, Integer>> entry : companies.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			String output = entry.getValue().toString();
			output = output.replace("=", "-");
			output = output.replace("{", "");
			output = output.replace("}", "");
			System.out.print(output + "\n");
		}

	}

}
