import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class SchoolSystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String[] input = new String[n];
		TreeMap<String, TreeMap<String, List<Double>>> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			input[i] = scan.nextLine();
		}
		for (int i = 0; i < input.length; i++) {
			String[] line = input[i].split(" ");
			String name = line[0] + " " + line[1];
			String subject = line[2];
			double grade = Double.parseDouble(line[3]);
			TreeMap<String, List<Double>> map1 = new TreeMap<>();
			List<Double> grades = new ArrayList<>();
			if (map.containsKey(name)) {
				map1 = map.get(name);
				if (map1.containsKey(subject)) {
					grades = new ArrayList<>(map1.get(subject));
					grades.add(grade);
					map1.put(subject, grades);
				} else {
					grades.add(grade);
					map1.put(subject, grades);
				}
			} else {
				grades.add(grade);
				map1.put(subject, grades);
				map.put(name, map1);
			}
		}
		double avg = 0;
		String output = "";
		TreeMap<String, Double> average = new TreeMap<>();
		for (Entry<String, TreeMap<String, List<Double>>> entry : map.entrySet()) {
			output += entry.getKey() + ": [";
			for (Entry<String, List<Double>> entry2 : entry.getValue().entrySet()) {
				for (int i = 0; i < entry2.getValue().size(); i++) {
					avg += entry2.getValue().get(i);
				}
				avg = avg / entry2.getValue().size();
				average.put(entry2.getKey(), avg);
				avg = 0;

			}
			for (Entry<String, Double> entry3 : average.entrySet()) {
				output += entry3.getKey() + " - " + String.format("%.2f", entry3.getValue()) + ", ";
			}
			output += "]";
			output = output.replace(", ]", "]");
			System.out.println(output);
			output = "";
			average.clear();
		}

	}

}
