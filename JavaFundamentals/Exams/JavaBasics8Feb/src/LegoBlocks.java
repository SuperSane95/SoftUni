import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LegoBlocks {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		List<String> array1 = new ArrayList<>();
		List<String> array2 = new ArrayList<>();
		List<String> array3 = new ArrayList<>();
		String input;
		if (n <= 2) {
			for (int i = 0; i < n; i++) {
				input = scan.nextLine().trim();
				// System.out.println("arr1 added " + input);
				array1.add(clearIt(input));
			}

			for (int i = 0; i < n; i++) {
				input = scan.nextLine().trim();
				// System.out.println("arr2 added " + input);
				array2.add(clearIt(input));
			}
		} else {
			for (int i = 0; i < n; i++) {
				input = scan.nextLine().trim();
				// System.out.println("arr1 added " + input);
				array1.add(clearIt(input));
			}

			for (int i = 0; i < n; i++) {
				input = scan.nextLine().trim();
				// System.out.println("arr2 added " + input);
				array2.add(clearIt(input));
			}
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < array1.size(); i++) {
			builder.append(array1.get(i));
			//builder.append(" ");
			builder.append(reverseIt(array2.get(i)));
			String str = builder.toString();
			array3.add(str);
			builder = new StringBuilder();
		}
		int count = 0;
		int lenghtCount = array3.get(0).length();
		boolean bool = true;
		int red = 0;
		for (String c : array3) {
			//System.out.println(c.length());
			if (c.length() != lenghtCount) {
				System.out.println("greshka na " + red);
				bool = false;
			}
			red++;
		}
		
		if (bool) {
			for (String c : array3) {
//				String[] output = c.split(" ");
				System.out.print("[");
				for(int i = 0; i<c.length(); i++)
				{
					if (i != c.length() - 1) {
						System.out.printf("%c, ", c.charAt(i));
					} else {
						System.out.printf("%c]\n", c.charAt(i));
					}
				}
//				for (int i = 0; i < output.length; i++) {
//					if (i != output.length - 1) {
//						System.out.printf("%s, ", output[i]);
//					} else {
//						System.out.printf("%s]\n", output[i]);
//					}
//				}

			}
		} else {
			for (String c : array3) {
				for(int i = 0; i<c.length(); i++)
				{
					if (c.charAt(i) != ' ') {
						count++;
					}
				}
//				String[] output = c.split(" ");
//				for (int i = 0; i < output.length; i++) {
//					if(!output[i].equals("") && !output.equals(" ")) {
//						count++;
//					}
//				}

			}
			System.out.println("The total number of cells is: " + count);
		}
	}

	public static String reverseIt(String source) {
		int i, len = source.length();
		StringBuilder dest = new StringBuilder(len);

		for (i = (len - 1); i >= 0; i--) {
			dest.append(source.charAt(i));
		}

		return dest.toString();
	}
	
	public static String clearIt (String source) {
		StringBuilder cleared = new StringBuilder();
		
		for(int i = 0; i<source.length(); i++) {
			if(source.charAt(i) != ' ') {
				cleared.append(source.charAt(i));
			}
		}
		
		return cleared.toString();
	}

}
