import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GandalfsStash {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int mood = Integer.parseInt(scan.nextLine());
		String input = scan.nextLine();
		input = new String(input.toLowerCase());
		Pattern pat = Pattern.compile("[a-z]+");
		Matcher match = pat.matcher(input);
		while (match.find()) {
			switch (match.group()) {
			case "cram":
				mood += 2;
				break;
			case "lembas":
				mood += 3;
				break;
			case "apple":
				mood+= 1;
				break;
			case "melon":
				mood+= 1;
				break;
			case "honeycake":
				mood += 5;
				break;
			case "mushrooms":
				mood -= 10;
				break;
			default:
				mood -= 1;
				break;
			}
		}
		if(mood < -5) {
			System.out.println(mood);
			System.out.println("Angry");
		} else if(mood >= -5 && mood < 0) {
			System.out.println(mood);
			System.out.println("Sad");
		} else if(mood >= 0 && mood < 15) {
			System.out.println(mood);
			System.out.println("Happy");
		} else if(mood >= 15) {
			System.out.println(mood);
			System.out.println("Special JavaScript mood");
		}
		
	}

}
