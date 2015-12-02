import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;



public class ExamScore {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeMap<Integer, TreeMap<String, Double>> scoreMap = new TreeMap<>();
		String input = scan.nextLine();
		String stopper = "--";
		input = scan.nextLine();
		input = scan.nextLine();
		input = new String();
		input = scan.nextLine();
		while (true) {
			String[] info = input.split("\\|");
////			for(String s : info) {
////				System.out.println();
////			}
//			for(int i = 0; i<info.length; i++) {
//				System.out.printf("%d -",i);
//				System.out.print(info[i]);
//				System.out.println();
//			}
			String name = info[1].trim();
			int score = Integer.parseInt(info[2].trim());
			Double grade = Double.parseDouble(info[3].trim());
			TreeMap<String, Double> tempMap = new TreeMap<>();
			if (scoreMap.containsKey(score)) {
				tempMap = scoreMap.get(score);
				tempMap.put(name, grade);
				scoreMap.put(score, tempMap);
			} else {
				tempMap.put(name, grade);
				scoreMap.put(score, tempMap);
			}

			input = scan.nextLine();
			if (input.contains(stopper)) {
				break;
			}
		}
		
		for (Entry<Integer, TreeMap<String, Double>> entry : scoreMap.entrySet()) {
			double sum = 0;
			double count = 0;
			List<String> names = new ArrayList<>();
			for(Entry<String, Double> entry2 : entry.getValue().entrySet()) {
				names.add(entry2.getKey());
				sum+=entry2.getValue();
				count++;
			}
			String output = String.format("%d -> %s; avg=%.2f",entry.getKey(), names.toString(), sum/count );
			System.out.println(output);
		}
		
	}

}
