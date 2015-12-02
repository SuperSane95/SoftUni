import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class PossibleTriangles {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		boolean haveTriangle = false;
		
		while(!input.equals("End")) {
			String[] numbers = input.split(" ");
			List<Double> list = new ArrayList<>();
			list.add(Double.parseDouble(numbers[0]));
			list.add(Double.parseDouble(numbers[1]));
			list.add(Double.parseDouble(numbers[2]));
			list.sort((a,b) -> a.compareTo(b));
			if(list.get(0) + list.get(1) > list.get(2)) {
				haveTriangle = true;
				System.out.printf("%.2f+%.2f>%.2f\n",list.get(0),list.get(1),list.get(2));
			}
			input = scan.nextLine();
		}
		
		if(!haveTriangle) {
			System.out.println("No");
		}
	}

}
