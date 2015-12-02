import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FireTheArrows {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<char[]> matrix = new ArrayList<>();
		int n = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < n; i++) {
			matrix.add(scan.nextLine().toCharArray());
		}
		int count = 0;
		while (count != 20) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < matrix.get(0).length; j++) {
					char cell = matrix.get(i)[j];
					switch (cell) {
					case '<':
						if (j > 0) {
							char nextCell = matrix.get(i)[j - 1];
							if (nextCell == 'o') {
								nextCell = '<';
								matrix.get(i)[j - 1] = nextCell;
								cell = 'o';
								matrix.get(i)[j] = cell;
							} else {
							}
						} else {
						}
						break;

					case '^':
						if (i > 0) {
							char nextCell = matrix.get(i - 1)[j];
							if (nextCell == 'o') {
								nextCell = '^';
								matrix.get(i - 1)[j] = nextCell;
								cell = 'o';
								matrix.get(i)[j] = cell;
							} else {
							}
						} else {
						}
						break;

					case '>':
						if (j < matrix.get(0).length -1) {
							char nextCell = matrix.get(i)[j + 1];
							if (nextCell == 'o') {
								nextCell = '>';
								matrix.get(i)[j + 1] = nextCell;
								cell = 'o';
								matrix.get(i)[j] = cell;
							} else {
							}
						} else {
						}
						break;

					case 'v':
						if (i < n-1) {
							char nextCell = matrix.get(i + 1)[j];
							if (nextCell == 'o') {
								nextCell = 'v';
								matrix.get(i + 1)[j] = nextCell;
								cell = 'o';
								matrix.get(i)[j] = cell;
							} else {
							}
						} else {
						}
						break;

					default:
						break;

					}
				}
			}
			count++;
		}
		for (char[] arr : matrix) {
			System.out.println(arr);
		}

	}

}
