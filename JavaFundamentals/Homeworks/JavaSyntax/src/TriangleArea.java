import java.util.Scanner;

public class TriangleArea 
{

	public static void main(String[] args) 
	{
		int[][] array = new int[3][2];
		String input;
		String numbers[];
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i<3; i++)
		{
			input = scan.nextLine();
			numbers = input.split(" ");
			for(int j = 0; j<2; j++)
			{
				array[i][j] = Integer.parseInt(numbers[j]); 
			}
		}
		double area;
		area = (array[0][0] * (array[1][1] - array[2][1]) + array[1][0] * (array[2][1] - array [0][1])
				+ array[2][0] * (array[0][1] - array[1][1])) / 2;
		area = Math.abs(area);
		long roundedArea = Math.round(area);
		System.out.println(roundedArea);
		
	}

}
