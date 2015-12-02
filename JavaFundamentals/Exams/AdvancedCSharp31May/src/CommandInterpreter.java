import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CommandInterpreter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		String input = scan.nextLine();
		input = input.replaceAll("\\s+", " ");
		String[] numbers = input.split(" ");
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		input = scan.nextLine();
		input = input.replaceAll("\\s+", " ");
		while (!input.equals("end")) {
			input = input.replaceAll("\\s+", " ");
			String[] cmds = input.split(" ");
			List<String> tempList = new ArrayList<>();
			int k = 0;
			switch (cmds[0].trim()) {
			case "reverse":
				int start = Integer.parseInt(cmds[2]);
				int count = Integer.parseInt(cmds[4]);
				if (start < 0 || start > list.size()-1 || count >= (list.size() - start) || count < 0  ) {
					System.out.println("Invalid input parameters.");

				} else {
					for (int i = count; i >= start; i--) {
						tempList.add(list.get(i));
					}
					for (int i = start; i <= count; i++, k++) {
						list.set(i, tempList.get(k));
					}
				}
				break;

			case "sort":
				int startSort = Integer.parseInt(cmds[2]);
				int countSort = Integer.parseInt(cmds[4]);
				if (startSort < 0 || startSort > list.size()-1 || countSort > list.size() - startSort || countSort < 0) {
					System.out.println("Invalid input parameters.");
				} else {
					for (int i = startSort; i < startSort + countSort; i++) {
						tempList.add(list.get(i));
					}
					tempList.sort((a, b) -> a.compareTo(b));
					for (int i = startSort; i < startSort + countSort; i++, k++) {
						list.set(i, tempList.get(k));
					}
				}
				break;

			case "rollLeft":
				int countRollLeft = Integer.parseInt(cmds[1]);
				if (countRollLeft < 0) {
					System.out.println("Invalid input parameters.");
				} else {
					while (k != countRollLeft) {
						tempList = new ArrayList<>(list);
						int j;
						for (int i = list.size() - 1; i >= 0; i--) {
							if (i != 0) {
								j = i - 1;
							} else {
								j = list.size() - 1;
							}
							tempList.set(j, list.get(i));
						}
						list = new ArrayList<>(tempList);
						tempList = new ArrayList<>();
						k++;
					}
				}
				break;
				
			case "rollRight":
				int countRollRight = Integer.parseInt(cmds[1]);
				if (countRollRight < 0) {
					System.out.println("Invalid input parameters.");
				} else {
					while (k != countRollRight) {
						tempList = new ArrayList<>(list);
						int j;
						for (int i = list.size() - 1; i >= 0; i--) {
							if (i != list.size()-1) {
								j = i + 1;
							} else {
								j = 0;
							}
							tempList.set(j, list.get(i));
						}
						list = new ArrayList<>(tempList);
						tempList = new ArrayList<>();
						k++;
					}
				}
				break;
			default:
				break;
			}
			input = scan.nextLine();
		}
		System.out.println(list);
	}

}
