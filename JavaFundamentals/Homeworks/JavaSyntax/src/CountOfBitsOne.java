import java.util.Scanner;

public class CountOfBitsOne 
{

	public static void main(String[] args) 
	{
		int count = 0;
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		String bin = Integer.toBinaryString(number);
		char[] arr = bin.toCharArray();
		for(int i = 0; i<arr.length; i++)
		{
			if(arr[i] == '1')
			{
				count++;
			}
		}
		System.out.printf("Count = %d",count);
	}

}
