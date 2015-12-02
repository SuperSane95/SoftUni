import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class OlympicsAreComing {

	public static void main(String[] args) {
		LinkedHashMap<String, LinkedHashMap<String, Integer>> all = new LinkedHashMap<>();
		LinkedHashMap<String, Integer> countries = new LinkedHashMap<>();
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		while(!input.equals("report")) {
			String[] cmds = input.split("\\|");
			String name = cmds[0].trim();
			name = name.replaceAll("\\s+", " ");
			String country = cmds[1].trim();
			country = country.replaceAll("\\s+", " ");
			LinkedHashMap<String, Integer> tempMap = new LinkedHashMap<>();
			int count = 0;
			int totalCount = 0;
			if(all.containsKey(country)) {
				tempMap = all.get(country);
				totalCount = countries.get(country);
				totalCount++;
				countries.put(country, totalCount);
				if(tempMap.containsKey(name)) {
					count = tempMap.get(name);
					count++;
					tempMap.put(name, count);
				} else {
					tempMap.put(name, 1);
				}
			} else {
				countries.put(country, 1);
				tempMap.put(name, 1);
				all.put(country, tempMap);
			}
			input = scan.nextLine();
		}
		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		countries.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue()))
				.forEach(e -> sortedMap.put(e.getKey(), e.getValue()));
		for(Entry<String, Integer> entry : sortedMap.entrySet()) {
			int count = 0;
			count = all.get(entry.getKey()).size();
			System.out.printf("%s (%d participants): %d wins\n",entry.getKey(),count,entry.getValue());
		}
//		System.out.println(all);
//		System.out.println(countries);
	}

}
