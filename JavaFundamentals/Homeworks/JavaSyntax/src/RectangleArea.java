import java.util.Scanner;

public class RectangleArea 
{

	public static void main(String[] args) 
	{
		int a,b;
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();
		System.out.printf("Rectangle's area = %d", a*b);
	}

}
