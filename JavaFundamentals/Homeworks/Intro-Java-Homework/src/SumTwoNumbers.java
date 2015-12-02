import java.util.Scanner;

public class SumTwoNumbers {

	public static void main(String[] args) {
		int a, b, c;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a =");
		a = scan.nextInt();
		System.out.println("Enter a =");
		b = scan.nextInt();
		c = a + b;
		System.out.printf("%d + %d = %d", a, b, c);
	}

}
