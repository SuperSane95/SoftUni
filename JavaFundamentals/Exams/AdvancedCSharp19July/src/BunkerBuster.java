import java.util.Scanner;


public class BunkerBuster {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] dimensions = scan.nextLine().split(" ");
		int n = Integer.parseInt(dimensions[0]);
		int m = Integer.parseInt(dimensions[1]);
		int allCells = n * m;
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] strenght = scan.nextLine().split(" ");
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(strenght[j]);
			}
		}
		String input = scan.nextLine();
		while (!input.equals("cease fire!")) {
			String[] splitter = input.split(" ");
			int row = Integer.parseInt(splitter[0]);
			int col = Integer.parseInt(splitter[1]);
			int power = (int) splitter[2].charAt(0);
			long halfPower = Math.round((double) power / 2);
			matrix[row][col] -= power;
			try {
				matrix[row][col - 1] -= halfPower;
			} catch (IndexOutOfBoundsException iooe) {
				
			}
			try {
				matrix[row][col + 1] -= halfPower;
			} catch (IndexOutOfBoundsException iooe) {
				
			}
			try {
				matrix[row - 1][col] -= halfPower;
			} catch (IndexOutOfBoundsException iooe) {
				
			}
			try {
				matrix[row - 1][col-1] -= halfPower;
			} catch (IndexOutOfBoundsException iooe) {
				
			}
			try {
				matrix[row - 1][col + 1] -= halfPower;
			} catch (IndexOutOfBoundsException iooe) {
				
			}
			try {
				matrix[row + 1][col] -= halfPower;
			} catch (IndexOutOfBoundsException iooe) {
				
			}
			try {
				matrix[row + 1][col-1] -= halfPower;
			} catch (IndexOutOfBoundsException iooe) {
				
			}
			try {
				matrix[row + 1][col+1] -= halfPower;
			} catch (IndexOutOfBoundsException iooe) {
				
			}
			input = scan.nextLine();
		}
		int destroyedBunkers = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] <= 0) {
					destroyedBunkers++;
				}
			}
		}
		double dmgDone = (double) destroyedBunkers / allCells;
		System.out.println("Destroyed bunkers: " + destroyedBunkers);
		System.out.printf("Damage done: %.1f %%", dmgDone * 100);
	}

}
