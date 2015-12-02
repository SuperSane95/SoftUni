import java.util.ArrayList;
import java.util.Scanner;

public class LongestIncreasingSequence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int[] arr = new int[input.length];
		ArrayList<Integer> longest = new ArrayList<Integer>();
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				sequence.add(arr[i - 1]);
				System.out.print(arr[i - 1] + " ");
				if (i == arr.length - 1 && arr[i] > arr[i - 1]) {
					sequence.add(arr[i]);
					System.out.print(arr[i] + " ");
					if (sequence.size() > longest.size()) {
						longest = new ArrayList<Integer>(sequence);
					}
				}
			} else {
				sequence.add(arr[i - 1]);
				System.out.print(arr[i - 1]);
				if (i == arr.length - 1 && arr[i] > arr[i - 1]) {
					sequence.add(arr[i]);
					System.out.print(arr[i] + " ");
				}
				if (sequence.size() > longest.size()) {
					longest = new ArrayList<Integer>(sequence);
				}
				System.out.println();
				sequence.clear();
			}
		}
		System.out.println();
		System.out.print("Longest: ");
		for (int i : longest) {
			System.out.print(i + " ");
		}
	}

}
