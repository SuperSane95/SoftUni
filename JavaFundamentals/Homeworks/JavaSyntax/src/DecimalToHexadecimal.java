import java.util.Scanner;

public class DecimalToHexadecimal 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int a;
		String hex;
		a = scan.nextInt();
		hex = Integer.toHexString(a);
		System.out.println(hex);
	}

}
