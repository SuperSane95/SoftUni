import java.util.Scanner;

public class Enigma {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String[] input = new String[n];
		for (int i = 0; i < n; i++) {
			input[i] = scan.nextLine();
		}
		int lenght = 0;
		int asciiValue = -1;
		for (int i = 0; i < input.length; i++) {
			char[] word = input[i].toCharArray();
			lenght = getHalfLenght(word);
			for (int j = 0; j < word.length; j++) {
				if (word[j] != ' ' && (word[j] < '0' || word[j] > '9')) {
					asciiValue = word[j] + lenght;
					word[j] = (char) asciiValue;
					System.out.print(word[j]);
				} else {
					System.out.print(word[j]);
				}
			}
			System.out.println();
		}

	}

	public static int getHalfLenght(char[] word) {
		int lenght = 0;
		for (int i = 0; i < word.length; i++) {
			if (word[i] != ' ') {
				if (word[i] < '0' || word[i] > '9') {
					lenght++;
				}
			}
		}
		return lenght / 2;
	}

}
