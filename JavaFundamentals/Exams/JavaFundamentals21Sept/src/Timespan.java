import java.util.Scanner;

public class Timespan {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] startTime = scan.nextLine().split(":");
		String[] endTime = scan.nextLine().split(":");
		int[] timespan = new int[3];
		int startHours = Integer.parseInt(startTime[0]), startMinutes = Integer.parseInt(startTime[1]),
				startSeconds = Integer.parseInt(startTime[2]), endHours = Integer.parseInt(endTime[0]),
				endMinutes = Integer.parseInt(endTime[1]), endSeconds = Integer.parseInt(endTime[2]);
		int tsHours, tsMinutes, tsSeconds;

		if (startSeconds > endSeconds) {
			tsSeconds = startSeconds - endSeconds;
		} else if (startSeconds == endSeconds) {
			tsSeconds = 0;
		} else {
			tsSeconds = 60 - Math.abs(startSeconds - endSeconds);
			endMinutes++;
		}

		if (startMinutes > endMinutes) {
			tsMinutes = startMinutes - endMinutes;
		} else if (startMinutes == endMinutes) {
			tsMinutes = 0;
		} else {
			tsMinutes = 60 - Math.abs(startMinutes - endMinutes);
			endHours++;
		}

		tsHours = startHours - endHours;

		timespan[0] = tsHours;
		timespan[1] = tsMinutes;
		timespan[2] = tsSeconds;

		System.out.printf("%d:%02d:%02d", timespan[0], timespan[1], timespan[2]);

	}

}
