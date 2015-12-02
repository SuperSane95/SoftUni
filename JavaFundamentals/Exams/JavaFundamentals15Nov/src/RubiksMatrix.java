
import java.util.Arrays;
import java.util.Scanner;


public class RubiksMatrix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] dims = scan.nextLine().split(" "); 
		int rows = Integer.parseInt(dims[0]);
		int cols = Integer.parseInt(dims[1]);

		int counter = 1;
		int[][] matrix = new int[rows][cols];
		int[][] constMatrix = new int[rows][cols];
		boolean areEquals = false;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = counter++;
			}
		}

		int n = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < n; i++) {
			String[] commands = scan.nextLine().split(" ");
			int position = Integer.parseInt(commands[0]);
			String direction = commands[1];
			int moves = Integer.parseInt(commands[2]);

			if (direction.equals("up")) {
				for (int j = 0; j < moves%cols; j++) {
					int first = matrix[0][position];
					for (int g = 0; g < rows - 1; g++) {
						matrix[g][position] = matrix[g + 1][position];
					}
					matrix[rows - 1][position] = first;
				}
			} else if (direction.equals("down")) {
				for (int j = 0; j < moves%cols; j++) {
					int last = matrix[rows - 1][position];
					for (int g = rows - 1; g > 0; g--) {
						matrix[g][position] = matrix[g - 1][position];
					}
					matrix[0][position] = last;
				}
			} else if (direction.equals("right")) {
				for (int j = 0; j < moves%rows; j++) {
					int last = matrix[position][cols - 1];
					for (int g = cols - 1; g > 0; g--) {
						matrix[position][g] = matrix[position][g - 1];
					}
					matrix[position][0] = last;
				}
			} else {
				for (int j = 0; j < moves%rows; j++) {
					int first = matrix[position][0];
					for (int g = 0; g < cols - 1; g++) {
						matrix[position][g] = matrix[position][g + 1];
					}
					matrix[position][cols - 1] = first;
				}
			}
		}
		counter = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] != counter) {
					for (int g = i; g < rows; g++) {
						for (int k = 0; k < cols; k++) {
							if (matrix[g][k] == counter) {
								System.out.printf("Swap (%d, %d) with (%d, %d)\n", i, j, g, k);
								int temp = matrix[i][j];
								matrix[i][j] = matrix[g][k];
								matrix[g][k] = temp;
								
							}
							
						}
						
					}
				} else {
					System.out.println("No swap required");
				}
				counter++;
			}
		}
	}
}