import java.util.Scanner;

public class GetAverage {

	public static void main(String[] args) {
		double a, b, c;
		Scanner scan = new Scanner(System.in);
		a = scan.nextDouble();
		b = scan.nextDouble();
		c = scan.nextDouble();
		double result = getAverage(a, b, c);
		System.out.printf("The average from a,b,c is: %.2f", result);
	}

	public static double getAverage(double a, double b, double c) {
		return ((a + b + c) / 3);
	}

}
