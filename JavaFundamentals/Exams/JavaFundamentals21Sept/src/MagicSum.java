import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int D = Integer.parseInt(scan.nextLine());
		List<Integer> list = new ArrayList<>();
		// List<Integer> list1 = new ArrayList<>();
		int[] sequence = new int[3];
		int a = -1, b = -1, c = -1;
		int d, max = -10000;
		boolean haveSequence = false;
		String input = scan.nextLine();

		while (!input.equals("End")) {
			list.add(Integer.parseInt(input));
			input = scan.nextLine();
		}

		for (int i = 0; i < list.size() - 2; i++) {

			for (int j = i+1; j < list.size() - 1; j++) {

				for (int k = j+1; k < list.size(); k++) {
					a = list.get(i);
					b = list.get(j);
					c = list.get(k);
					d = a + b + c;
					if (d % D == 0) {
						haveSequence = true;
						if (d > max) {
							max = d;
							sequence[0] = a;
							sequence[1] = b;
							sequence[2] = c;
						}
					}
				}
			}
		}
		if (haveSequence) {
			System.out.printf("(%d + %d + %d) %% %d = 0", sequence[0], sequence[1], sequence[2], D);
		} else {
			System.out.println("No");
		}
	}
}
