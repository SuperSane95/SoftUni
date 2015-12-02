import java.util.Scanner;

public class MirrorNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String[] numbers = scan.nextLine().split(" ");
		for(int i = 0; i<numbers.length - 1; i++) {
			for(int j = i+1; j<numbers.length; j++) {
				
				String number1 = numbers[i];
				String number2 = numbers[j];
				String reversed = new StringBuilder(number2).reverse().toString();
//				System.out.println(number1);
//				System.out.println(number2);
				if(number1.equals(reversed)) {
					System.out.printf("%s<!>%s\n",number1,number2);
				}
			}
		}
	}

}
