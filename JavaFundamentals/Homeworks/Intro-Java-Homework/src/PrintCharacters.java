import java.util.Scanner;

public class PrintCharacters {

	public static void main(String[] args) {
		for (char c = 'a'; c <= 'z'; c++) {
			System.out.printf("%c ", c);
		}
		Scanner scan = new Scanner(System.in);
		System.out.println();
		int x = scan.nextInt();
		printTriangle(x);
	}

	public static void printTriangle(int x) // Method for PrintCharacters*
											// problem.
	{
		char c = 'a';
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < i + 1; j++, c++) {

				System.out.printf("%c ", c);
			}
			c = 'a';
			System.out.println();
		}

		for (int i = x - 1; i > 0; i--) {
			for (int j = 0; j < i; j++, c++) {
				System.out.printf("%c ", c);
			}
			c = 'a';
			System.out.println();
		}
	}

}
