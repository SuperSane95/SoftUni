import java.util.Scanner;

public class CalculateFactorial {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int factorial = 1;
		factorial = factorial(n, factorial);
		System.out.println(factorial);

	}
	public static int factorial(int n, int factorial) {
		while(n != 0) {
			factorial *= n;
			n--;
			factorial(n,factorial);
		}
		return factorial;
	}

}
