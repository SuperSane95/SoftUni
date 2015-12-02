import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sun.print.resources.serviceui;

public class Durts {
	static int x = 1001;
	static int y = 1001;
	static int r = -1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = -1;
		while (x == 1001) {
			x = scan.nextInt();
		}
		while (y == 1001) {
			y = scan.nextInt();
		}
		while (r == -1) {
			r = scan.nextInt();
		}
		while (n == -1) {
			n = scan.nextInt();
		}
//		 System.out.println(x);
//		 System.out.println(y);
//		 System.out.println(r);
//		 System.out.println(n);

		int[] rowCoords = new int[2];
		rowCoords[0] = x - r;
		rowCoords[1] = x + r;
		int[] colCoords = new int[2];
		colCoords[0] = y - r;
		colCoords[1] = y + r;
		List<Integer> xList = new ArrayList<>();
		List<Integer> yList = new ArrayList<>();
		int count = 0;
		boolean xWait = true;
		while (count != n) {
			int number = 1001;
			if (xWait) {
				while (number == 1001) {
					number = scan.nextInt();
					xList.add(number);
					xWait = false;
				}
			} else {
				while (number == 1001) {
					number = scan.nextInt();
					yList.add(number);
					xWait = true;
					count++;
				}
			}
		}
		for (int i = 0; i < xList.size(); i++) {
			int xTry = xList.get(i);
			int yTry = yList.get(i);
			if(tryRect1(xTry, yTry)) {
				System.out.println("yes");
			} else if(tryRect2(xTry, yTry)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		}
	}

	public static boolean tryRect1(int xTry, int yTry) {
		if (xTry >= x - r && xTry <= x + r) {
			if (yTry >= y - (r/2) && yTry <= y + (r/2)) {
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}

	public static boolean tryRect2(int xTry, int yTry) {
		if (xTry >= x - (r/2) && xTry <= x + (r/2)) {
			if (yTry >= y - r && yTry <= y + r) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
