package LastDigitName;

import java.util.Scanner;

/**
 * Created by iwano on 6/23/2016.
 */
public class LastDigitName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Number n = new Number(Integer.parseInt(scan.nextLine()));
        System.out.println(n.lastDigit());
    }
}

class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public String lastDigit() {
        String s = String.format("%d", this.number);
        char[] arr = s.toCharArray();
        char digit = arr[arr.length-1];
        switch (digit) {
            case '0' :
                return "zero";
            case '1' :
                return "one";
            case '2' :
                return "two";
            case '3' :
                return "three";
            case '4' :
                return "four";
            case '5' :
                return "five";
            case '6' :
                return "six";
            case '7' :
                return "seven";
            case '8' :
                return "eight";
            case '9' :
                return "nine";
            default:
                return "";
        }
    }
}
