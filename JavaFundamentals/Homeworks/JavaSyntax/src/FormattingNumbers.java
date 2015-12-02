import java.util.Scanner;

public class FormattingNumbers 
{

	public static void main(String[] args) 
	{
		int a;
		double b,c;
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextDouble();
		c = scan.nextDouble();
		String hexA = Integer.toHexString(a);
		String binA = Integer.toBinaryString(a);
		int intBinA = Integer.parseInt(binA);
		System.out.println(binA);
		System.out.printf("|%-10s|%010d|%10.2f|%-10.3f|",hexA,intBinA,b,c);
	}

}
