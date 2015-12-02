import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VideoDurations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		List<String> list = new ArrayList<>();
		while(!input.equals("End")) {
			list.add(input);
			input = scan.nextLine();
		}
		int hours = 0;
		int minutes = 0;
		for(String duration : list) {
			String[] data = duration.split(":");
			hours += Integer.parseInt(data[0]);
			minutes += Integer.parseInt(data[1]);
		}
		hours += minutes / 60;
		minutes = minutes % 60;
		System.out.printf("%d:%02d", hours, minutes);
	}

}
