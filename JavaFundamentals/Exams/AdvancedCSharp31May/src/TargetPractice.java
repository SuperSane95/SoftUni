import java.util.Scanner;

public class TargetPractice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] dimensions = scan.nextLine().split(" ");
		int n = Integer.parseInt(dimensions[0]);
		int m = Integer.parseInt(dimensions[1]);
		String snake = scan.nextLine();
		String[] shotInfo = scan.nextLine().split(" ");
		int row = Integer.parseInt(shotInfo[0]);
		int col = Integer.parseInt(shotInfo[1]);
		int radius = Integer.parseInt(shotInfo[2]);
		String[][] matrix = new String[n][m];
		boolean goesLeft = true;
		int count = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (goesLeft) {
				for (int j = m - 1; j >= 0; j--) {
					matrix[i][j] = String.valueOf(snake.charAt(count));
					count++;
					if (count == snake.length()) {
						count = 0;
					}
				}
				goesLeft = false;
			} else {
				for (int j = 0; j < m; j++) {
					matrix[i][j] = String.valueOf(snake.charAt(count));
					count++;
					if (count == snake.length()) {
						count = 0;
					}
				}
				goesLeft = true;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int equation = ((i - row) * (i - row)) + ((j - col) * (j - col));
				if (equation <= (radius * radius)) {
					matrix[i][j] = " ";
				}
			}

		}
		int counter = 0;
		while (counter != 20) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (i < n - 1) {
						String currentSymbol = matrix[i][j];
						String nextSymbol = matrix[i + 1][j];
						if (nextSymbol.equals(" ")) {
							matrix[i + 1][j] = currentSymbol;
							matrix[i][j] = " ";
						}
					}
				}

			}
			counter++;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

	}

}
