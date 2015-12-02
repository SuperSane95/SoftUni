
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftuniDefenseSystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		double liters = 0;
		while (!input.equals("OK KoftiShans")) {
			Pattern pat = Pattern.compile("(?:.?)([A-Z][a-z]*[a-z]).*?([A-Z][a-z]*[A-Z]).*?(\\d+)L");
			Matcher match = pat.matcher(input);
			String name ;
			String alcohol;
			String liter;
			while(match.find()) {
				name = match.group(1);
				alcohol = match.group(2);
				liter = match.group(3);
				liter = liter.replace("L", "");
				alcohol = alcohol.toLowerCase();
				
					System.out.printf("%s brought %s liters of %s!\n",name,liter,alcohol);
					liters += Integer.parseInt(liter);
			}
			

			input = scan.nextLine();
		}
		System.out.printf("%.3f softuni liters",liters/1000);
	}

}
