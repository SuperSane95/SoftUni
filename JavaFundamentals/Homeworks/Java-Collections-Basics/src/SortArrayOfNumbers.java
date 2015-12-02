import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortArrayOfNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter how much numbers you gonna enter: ");
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter number: ");
			arr[i] = scanner.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			System.out.printf("Sorted array[%d]: %d", i, arr[i]);
			System.out.println();

		}
	}
}
