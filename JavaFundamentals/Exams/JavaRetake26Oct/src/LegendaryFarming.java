import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.*;

public class LegendaryFarming {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeMap<String, Integer> keys = new TreeMap<>();
		TreeMap<String, Integer> junks = new TreeMap<>();
		
		
		keys.put("shards", 0);
		keys.put("fragments", 0);
		keys.put("motes", 0);
		
		int quantity = 0;
		String obtained = null;
		boolean obtainedBoolean = false;
		String input = scan.nextLine();
		while (!obtainedBoolean) {
			String[] arr = input.split(" ");
			for (int i = 0; i < arr.length; i++) {
				if (i % 2 != 0) {
					String material = arr[i].toLowerCase();
					quantity = Integer.parseInt(arr[i - 1]);
					if (material.equals("fragments") || material.equals("shards") || material.equals("motes")) {
						if (keys.containsKey(material)) {
							quantity += keys.get(material);
							keys.put(material, quantity);
							//System.out.println("dobavih " + material);
							if(quantity >= 250) {
								obtained = material;
								obtainedBoolean = true;
								break;
							}
							quantity = 0;
						} else {
							keys.put(material, quantity);
							//System.out.println("dobavih " + material);
							if(quantity >= 250) {
								obtained = material;
								obtainedBoolean = true;
								break;
							}
							quantity = 0;
						}
					} else {
						if (junks.containsKey(material)) {
							quantity += junks.get(material);
							junks.put(material, quantity);
							quantity = 0;
							//System.out.println("dobavih " + material);
						} else {
							junks.put(material, quantity);
							//System.out.println("dobavih " + material);
							quantity = 0;
						}
					}
				}

				for (Entry<String, Integer> entry : keys.entrySet()) {
					if (entry.getValue() >= 250) {
						obtained = entry.getKey();
						obtainedBoolean = true;
						System.out.println("obtained");
						break;
					}
				}

			}

			if (obtainedBoolean) {
				break;
			} else {
				input = scan.nextLine();
			}

		}
		
		int newSum;
		
		if (obtained.equals("shards")) {
			newSum = keys.get("shards");
			newSum = newSum - 250;
			keys.remove("shards");
			keys.put("shards", newSum);
			System.out.println("Shadowmourne obtained!");
			
		} else if (obtained.equals("fragments")) {
			newSum = keys.get("fragments");
			newSum = newSum - 250;
			keys.remove("fragments");
			keys.put("fragments", newSum);
			System.out.println("Valanyr obtained!");
			
			
		} else if (obtained.equals("motes")) {
			newSum = keys.get("motes");
			newSum = newSum - 250;
			keys.remove("motes");
			keys.put("motes", newSum);
			System.out.println("Dragonwrath obtained!");
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
		for(Entry<String, Integer> entry : keys.entrySet()) {
			list.add(entry);
		}
		
		Comparator<? super Entry<String, Integer>> byMapValues = new Comparator<Map.Entry<String, Integer>>() {
	        @Override
	        public int compare(Map.Entry<String, Integer> left, Map.Entry<String, Integer> right) {
	            return right.getValue().compareTo(left.getValue());
	        }
		};
		Collections.sort(list, byMapValues);
		
		for (Entry<String, Integer> entry : list) {
				System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
		}
		for (Entry<String, Integer> entry : junks.entrySet()) {
			System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
		}

	}

}
