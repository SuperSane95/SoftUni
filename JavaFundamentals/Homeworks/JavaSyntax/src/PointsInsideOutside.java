import java.util.Scanner;

public class PointsInsideOutside 
{

	public static void main(String[] args) 
	{
		String end = "End";
		Scanner scan = new Scanner(System.in);
		String input;
		String[] coords;
		while(true)
		{
			input = scan.nextLine();
			coords = input.split(" ");
			double x = Double.parseDouble(coords[0]);
			double y = Double.parseDouble(coords[1]);
			if(x>=12.5 && x<=22.5)
			{
				if(y>=6.0 && y<=13.5)
				{
					if(x>=17.5 && x<=20.0)
					{
						if (y>=8.5 && y<=13.5)
						{
							System.out.println("OUTSIDE");
						}
					}
					else
					{
						System.out.println("INSIDE");
					}
				}
				else
				{
					System.out.println("OUTSIDE");
				}
			}
			else
			{
				System.out.println("OUTSIDE");
			}
		}
	}

}
