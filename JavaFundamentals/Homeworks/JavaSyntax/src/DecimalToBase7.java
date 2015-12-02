import java.util.Scanner;

public class DecimalToBase7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		String toBase7 = Integer.toString(x,7);
		System.out.println(toBase7);
	}

}
