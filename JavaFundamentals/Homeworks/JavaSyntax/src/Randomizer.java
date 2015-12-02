import java.util.Random;
import java.util.Scanner;

public class Randomizer {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int x = 0;
		if (n > m) {
			for (int i = 0; i < (n - m) + 1; i++) {
				x = random.nextInt((n - m) + 1) + m;
				System.out.printf("%d ", x);
			}
		} else {
			for (int i = 0; i < (m - n) + 1; i++) {
				x = random.nextInt((m - n) + 1) + n;
				System.out.printf("%d ", x);
			}
		}
	}
}
