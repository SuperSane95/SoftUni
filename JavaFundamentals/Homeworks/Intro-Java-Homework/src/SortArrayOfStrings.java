import java.util.Scanner;

public class SortArrayOfStrings {

	public static void main(String[] args) {
		System.out.println("Enter how much strings you want to sort");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] array = new String[n];
		Scanner stringScan = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			System.out.println("Enter string");
			array[i] = stringScan.nextLine();
		}

		String[] sortedArray = arraySort(array);
		for (int i = 0; i < n; i++) {
			System.out.println(sortedArray[i]);
		}

	}

	public static String[] arraySort(String[] array) {
		String temp;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {

				if (array[j].compareTo(array[j + 1]) > 0) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

}
