import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class PopulationCounter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedHashMap<String, LinkedHashMap<String, Long>> all = new LinkedHashMap<>();
		LinkedHashMap<String, Long> countries = new LinkedHashMap<>();
		String input = scan.nextLine();
		while (!input.equals("report")) {
			String[] info = input.split("\\|");
			String city = info[0];
			String country = info[1];
			long count = Long.parseLong(info[2]);
			long tempCount;
			LinkedHashMap<String, Long> tempMap = new LinkedHashMap<>();
			if (all.containsKey(country)) {
				tempCount = countries.get(country);
				tempCount += count;
				countries.put(country, tempCount);
				tempMap = all.get(country);
				tempMap.put(city, count);
				all.put(country, tempMap);
			} else {
				countries.put(country, count);
				tempMap.put(city, count);
				all.put(country, tempMap);
			}
			input = scan.nextLine();
		}
		LinkedHashMap<String, Long> tempMap = new LinkedHashMap<>();
		LinkedHashMap<String, Long> sortedCountries = new LinkedHashMap<>();
		countries.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue()))
				.forEachOrdered(entry -> sortedCountries.put(entry.getKey(), entry.getValue()));
		for(Entry<String, Long> country : sortedCountries.entrySet()) {
			System.out.printf("%s (total population: %d)\n",country.getKey(),country.getValue());
			tempMap = all.get(country.getKey());
			tempMap.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue()))
				.forEachOrdered(e -> System.out.printf("=>%s: %d\n",e.getKey(),e.getValue()));
		}

	}

}
