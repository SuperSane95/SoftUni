import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicCard {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		String type = scan.nextLine();
		String[] magicCard = scan.nextLine().split("");
		String magicSuit = "";
		String magicFace = "";
		int totalValue = 0;
		int cardValue = 0;

		if (magicCard.length == 2) {
			magicFace = magicCard[0];
			magicSuit = magicCard[1];
		} else if (magicCard.length == 3) {
			magicFace = "10";
			magicSuit = magicCard[2];
		}

		List<String> validDeck = new ArrayList<>();

		if (type.equals("odd")) {
			for (int i = 0; i < input.length; i++) {
				if (i % 2 != 0) {
					validDeck.add(input[i]);
				}
			}
			for (String s : validDeck) {
				cardValue = cardValue(s);
				String[] card = s.split("");

				if (card.length == 2) {
					if (card[0].equals(magicFace)) {
						cardValue *= 3;
					} else if (card[1].equals(magicSuit)) {
						cardValue *= 2;
					}
				} else if (card.length == 3) {
					if ((card[0] + card[1]).equals(magicFace)) {
						cardValue *= 3;
					} else if (card[1].equals(magicSuit)) {
						cardValue *= 2;
					}
				}

				totalValue += cardValue;
				cardValue = 0;
			}

		} else if (type.equals("even")) {
			for (int i = 0; i < input.length; i++) {
				if (i % 2 == 0) {
					validDeck.add(input[i]);
				}
			}

			for (String s : validDeck) {
				cardValue = cardValue(s);
				String[] card = s.split("");

				if (card.length == 2) {
					if (card[0].equals(magicFace)) {
						cardValue *= 3;
					} else if (card[1].equals(magicSuit)) {
						cardValue *= 2;
					}
				} else if (card.length == 3) {
					if ((card[0] + card[1]).equals(magicFace)) {
						cardValue *= 3;
					} else if (card[1].equals(magicSuit)) {
						cardValue *= 2;
					}
				}

				totalValue += cardValue;
				cardValue = 0;
			}

		}

		System.out.println(totalValue);

	}

	public static int cardValue(String card) {
		int value = -1;
		if (card.length() == 2) {
			switch (card.charAt(0)) {
			case 'J':
				value = 12;
				break;
			case 'Q':
				value = 13;
				break;
			case 'K':
				value = 14;
				break;
			case 'A':
				value = 15;
				break;
			default:
				value = Integer.parseInt(new String(String.valueOf(card.charAt(0))));
				break;
			}
		} else if (card.length() == 3) {
			value = 10;
		}
		return value * 10;
	}

}
