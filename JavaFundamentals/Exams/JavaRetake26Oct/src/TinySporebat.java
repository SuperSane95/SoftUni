import java.util.Scanner;

public class TinySporebat {

	public static void main(String[] args) {
		int health = 5800;
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int glowcaps = 0;
		while (!input.equals("Sporeggar")) {
			char[] arr = input.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (health <= 0) {
					System.out.printf("Died. Glowcaps: %d", glowcaps);
					return;
				} else if (i == arr.length - 1) {
					switch (arr[i]) {
					case '1':
						glowcaps += 1;
						break;
					case '2':
						glowcaps += 2;
						break;
					case '3':
						glowcaps += 3;
						break;
					case '4':
						glowcaps += 4;
						break;
					case '5':
						glowcaps += 5;
						break;
					case '6':
						glowcaps += 6;
						break;
					case '7':
						glowcaps += 7;
						break;
					case '8':
						glowcaps += 8;
						break;
					case '9':
						glowcaps += 9;
						break;
					case '0':
						glowcaps += 0;
						break;
					}
				} else {
					switch (arr[i]) {
					case 'L':
						health += 200;
						break;
					default:
						health = health - Math.abs(input.charAt(i));
						if (health <= 0) {
							System.out.printf("Died. Glowcaps: %d", glowcaps);
							return;
						}
					}
				}
			}
			input = scan.nextLine();
		}
		if (glowcaps >= 30) {
			glowcaps -= 30;
			System.out.println("Health left: " + health);
			System.out.println("Bought the sporebat. Glowcaps left: " + glowcaps);

		} else {
			glowcaps -= 30;
			System.out.println("Health left: " + health);
			System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", Math.abs(glowcaps));
		}

	}

}
