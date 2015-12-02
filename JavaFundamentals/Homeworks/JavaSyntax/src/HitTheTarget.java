import java.util.Scanner;

public class HitTheTarget {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int target = scan.nextInt();
		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 20; j++) {
				if (i + j == target) {
					System.out.printf("%d + %d = %d", i, j, target);
					System.out.println();
				}
				if (i > j) {
					if ((i - j) == target) {
						System.out.printf("%d - %d = %d", i, j, target);
						System.out.println();
					}
				} else {
					if ((j - i) == target) {
						System.out.printf("%d - %d = %d", j, i, target);
						System.out.println();
					}
				}
			}
		}
	}

}
