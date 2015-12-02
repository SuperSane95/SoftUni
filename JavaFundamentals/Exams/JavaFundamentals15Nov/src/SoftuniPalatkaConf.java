import java.util.Scanner;

public class SoftuniPalatkaConf {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int people = Integer.parseInt(scan.nextLine());
		int n = Integer.parseInt(scan.nextLine());
		int meals = 0;
		int beds = 0;
		for(int i = 0; i<n; i++) {
			String[] input = scan.nextLine().split(" ");
			int quantity = Integer.parseInt(input[1]);
			String type = input[2];
			switch (input[0]) {
			case "tents":
				if(type.equals("normal")) {
					beds += quantity*2;
				} else if (type.equals("firstClass")) {
					beds+= quantity*3;
				}
				break;
				
			case "rooms":
				if(type.equals("single")) {
					beds += quantity*1;
				} else if(type.equals("double")) {
					beds += quantity*2;
				} else if(type.equals("triple")) {
					beds += quantity*3;
				}
				break;
				
			case "food":
				if(type.equals("musaka")) {
					meals += quantity*2;
				} else if(type.equals("zakuska")) {
					meals += 0;
				}
				break;
			default:
				break;
			}
		}
		if(beds - people >= 0) {
			System.out.printf("Everyone is happy and sleeping well. Beds left: %d\n", beds-people);
		} else {
			System.out.printf("Some people are freezing cold. Beds needed: %d\n", Math.abs(beds-people));
		}
		if(meals - people >= 0) {
			System.out.printf("Nobody left hungry. Meals left: %d", meals-people);
		} else {
			System.out.printf("People are starving. Meals needed: %d", Math.abs(meals-people));
		}
	}

}
