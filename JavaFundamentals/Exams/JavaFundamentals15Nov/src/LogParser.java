import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import sun.print.resources.serviceui_zh_TW;

import java.util.Scanner;

public class LogParser {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, HashMap<String, Integer>> map1 = new HashMap<>();
		HashMap<String, HashMap<String, ArrayList<String>>> map2 = new HashMap<>();
		String input = scan.nextLine();
		while (!input.equals("END")) {
			HashMap<String, Integer> tempMap1 = new HashMap<>();
			HashMap<String, ArrayList<String>> tempMap2 = new HashMap<>();
			ArrayList<String> tempList = new ArrayList<>();
			int count = 0;
			String[] line = input.split(", ");
			String projectName = line[0];
			projectName = projectName.replace("{\"Project\": [\"", "");
			projectName = projectName.replace("\"]", "");
			String typeError = line[1];
			typeError = typeError.replace("\"Type\": [\"", "");
			typeError = typeError.replace("\"]", "");
			String errorMsg = line[2];
			errorMsg = errorMsg.replace("\"Message\": [\"", "");
			errorMsg = errorMsg.replace("\"]}", "");

			if (map1.containsKey(projectName)) {
				tempMap1 = map1.get(projectName);
				tempMap2 = map2.get(projectName);
				if (tempMap1.containsKey(typeError)) {
					count = tempMap1.get(typeError) + 1;
					tempMap1.put(typeError, count);
					map1.put(projectName, tempMap1);
				} else {
					tempMap1.put(typeError, 1);
					map1.put(projectName, tempMap1);
				}
				if (tempMap2.containsKey(typeError)) {
					tempList = tempMap2.get(typeError);
					tempList.add(errorMsg);
					tempMap2.put(typeError, tempList);
					map2.put(projectName, tempMap2);
				} else {
					tempList.add(errorMsg);
					tempMap2.put(typeError, tempList);
					map2.put(projectName, tempMap2);
				}
			} else {
				tempMap1.put(typeError, 1);
				map1.put(projectName, tempMap1);
				tempList.add(errorMsg);
				tempMap2.put(typeError, tempList);
				map2.put(projectName, tempMap2);
			}

			input = scan.nextLine();
		}
		// Comparator<ArrayList<String>> lengthComparator = new
		// Comparator<ArrayList<String>>() {
		// @Override
		// public int compare(ArrayList<String> a, ArrayList<String> b) {
		// return a.size() - b.size();
		// }
		// };
		List<Map.Entry<String, Integer>> totalErrors = new ArrayList<Map.Entry<String, Integer>>();
		List<Map.Entry<String, Integer>> sortedMsgs = new ArrayList<Map.Entry<String, Integer>>();
		HashMap<String, Integer> hm = new HashMap<>();
		for (Entry<String, HashMap<String, Integer>> entry : map1.entrySet()) {
			int count = 0;
			for (Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
				count += entry2.getValue();
			}
			hm.put(entry.getKey(), count);
		}
		totalErrors = new ArrayList<>(hm.entrySet());
		Collections.sort(totalErrors, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				int cmp1 = o2.getValue().compareTo(o1.getValue());
				if (cmp1 != 0) {
					return cmp1;
				} else {
					return o1.getKey().compareTo(o2.getKey());
				}
			}
		});

		Comparator<String> sortNames = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				Integer lenght1 = o1.length();
				Integer lenghg2 = o2.length();
				int cmp = lenght1.compareTo(lenghg2);
				if (cmp != 0) {
					return cmp;
				} else {
					return o1.compareTo(o2);
				}
			}
		};
		for (Entry<String, Integer> projects : totalErrors) {
			ArrayList<String> warnMsgs = new ArrayList<>();
			ArrayList<String> critMsgs = new ArrayList<>();
			String projectName = projects.getKey();
			int projectErrors = projects.getValue();
			int critErrors = 0;
			int warns = 0;
			if (map1.get(projectName).containsKey("Critical")) {
				critErrors = map1.get(projectName).get("Critical");
				for (String msg : map2.get(projectName).get("Critical")) {
					critMsgs.add(msg);
				}
			}
			if (map1.get(projectName).containsKey("Warning")) {
				warns = map1.get(projectName).get("Warning");
				for (String msg : map2.get(projectName).get("Warning")) {
					warnMsgs.add(msg);
				}
			}

			Collections.sort(critMsgs, sortNames);
			Collections.sort(warnMsgs, sortNames);
			System.out.println(projectName + ":");
			System.out.println("Total Errors: " + projectErrors);
			System.out.println("Critical: " + critErrors);
			System.out.println("Warnings: " + warns);
			System.out.println("Critical Messages:");
			if (critErrors != 0) {
				for (String msg : critMsgs) {
					System.out.println("--->" + msg);
				}
			} else {
				System.out.println("--->None");
			}
			System.out.println("Warning Messages:");
			if (warns != 0) {
				for (String msg : warnMsgs) {
					System.out.println("--->" + msg);
				}
			} else {
				System.out.println("--->None");
			}
			System.out.println();
		}

	}

}
