import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class LetterChangeNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		double sum = 0;
		double temp = 1;
		double number = 0;
		StringBuilder numb = new StringBuilder();
		int i = 1;
		TreeMap<Character, Integer> alphabet = new TreeMap<>();
		for(char c = 'a'; c<='z'; c++, i++) {
			alphabet.put(c, i);
		}
		i = 0;
		
		for(i = 0; i<input.length; i++) {
			input[i] = new String(input[i].trim());
			if(!input[i].equals("") && !input[i].equals(" ")) {
			char[] arr = input[i].toCharArray();
			for(int j = 1; j<arr.length-1; j++) {
				if(arr[j] != ' ' && arr[j] != '\t') {
				numb.append(arr[j]);
				}
			}
			String num = numb.toString();
			if(!num.equals("")) {
			number = Double.parseDouble(num);
			} else {
				continue;
			}
			//System.out.println(number);
			
			if(Character.isUpperCase(arr[0])) {
				
				temp = number/alphabet.get(Character.toLowerCase(arr[0]));
				
			} else if (Character.isLowerCase(arr[0])) {
				
				temp = number*alphabet.get(arr[0]);
				
			}
			if(Character.isUpperCase(arr[arr.length-1])) {
				
				temp -= alphabet.get(Character.toLowerCase(arr[arr.length-1]));
				
			} else if(Character.isLowerCase(arr[arr.length-1])) {
				
				temp += alphabet.get(arr[arr.length-1]);
				
			}
			numb = new StringBuilder();
			//System.out.println(temp);
			sum += temp;
			}
		}
		System.out.printf("%.2f",sum);
	}

}
