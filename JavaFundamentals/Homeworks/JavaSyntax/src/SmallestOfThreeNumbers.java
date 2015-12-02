import java.util.Scanner;

public class SmallestOfThreeNumbers 
{

	public static void main(String[] args) 
	{
		double a,b,c,min;
		Scanner scan = new Scanner(System.in);
		a = scan.nextDouble();
		b = scan.nextDouble();
		c = scan.nextDouble();
		if(a > b)
		{
			if(b > c)
			{
				min = c;
			}
			else
			{
				min = b;
			}
		}
		else if (a > c)
		{
			if (c > b)
			{
				min = b;
			}
			else
			{
				min = c;
			}
		}
		else
		{
			min = a;
		}
		System.out.println(min);
	}

}
