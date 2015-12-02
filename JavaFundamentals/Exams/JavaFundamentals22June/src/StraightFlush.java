import java.util.LinkedHashSet;
import java.util.Scanner;

public class StraightFlush {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean hasSF = false;
		LinkedHashSet<String> sequence = new LinkedHashSet<>();
		String[] clubsSeq = { "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC", "AC" };
		String[] spadesSeq = { "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS", "AS" };
		String[] diamondsSeq = { "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD", "AD" };
		String[] heartsSeq = { "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH", "AH" };
		String input = scan.nextLine();
		input = input.replace(",", "");
		for (int i = 0; i < clubsSeq.length - 1; i++) {
			if (input.contains(clubsSeq[i])) {
				sequence.add(clubsSeq[i]);
				for (int j = i + 1; j < clubsSeq.length; j++) {
					if (input.contains(clubsSeq[j])) {
						sequence.add(clubsSeq[j]);
						if (sequence.size() == 5) {
							hasSF = true;
							System.out.println(sequence);
							sequence.clear();
							break;
						}
					} else {
						sequence.clear();
						break;
					}
				}
			} else {
				sequence.clear();
			}
		}
		sequence.clear();
		for (int i = 0; i < spadesSeq.length - 1; i++) {
			if (input.contains(spadesSeq[i])) {
				sequence.add(spadesSeq[i]);
				for (int j = i + 1; j < spadesSeq.length; j++) {
					if (input.contains(spadesSeq[j])) {
						sequence.add(spadesSeq[j]);
						if (sequence.size() == 5) {
							hasSF = true;
							System.out.println(sequence);
							sequence.clear();
							break;
						}
					} else {
						sequence.clear();
						break;
					}
				}
			} else {
				sequence.clear();
			}
		}
		sequence.clear();
		for (int i = 0; i < diamondsSeq.length; i++) {
			if (input.contains(diamondsSeq[i])) {
				sequence.add(diamondsSeq[i]);
				for (int j = i + 1; j < diamondsSeq.length; j++) {
					if (input.contains(diamondsSeq[j])) {
						sequence.add(diamondsSeq[j]);
						if (sequence.size() == 5) {
							hasSF = true;
							System.out.println(sequence);
							sequence.clear();
							break;
						}
					} else {
						sequence.clear();
						break;
					}
				}
			} else {
				sequence.clear();
			}
		}
		sequence.clear();
		for (int i = 0; i < heartsSeq.length - 1; i++) {
			if (input.contains(heartsSeq[i])) {
				sequence.add(heartsSeq[i]);
				for (int j = i + 1; j < heartsSeq.length; j++) {
					if (input.contains(heartsSeq[j])) {
						sequence.add(heartsSeq[j]);
						if (sequence.size() == 5) {
							hasSF = true;
							System.out.println(sequence);
							sequence.clear();
							break;
						}
					} else {
						sequence.clear();
						break;
					}
				}
			} else {
				sequence.clear();
			}
		}
		sequence.clear();
		if (!hasSF) {
			System.out.println("No Straight Flushes");
		}
	}
}
