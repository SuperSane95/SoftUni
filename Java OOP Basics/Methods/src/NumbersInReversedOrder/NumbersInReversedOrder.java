package NumbersInReversedOrder;

import java.util.Scanner;

/**
 * Created by iwano on 6/23/2016.
 */
public class NumbersInReversedOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalNumber dn = new DecimalNumber((scan.nextLine()));
        System.out.println(dn.reversed());
    }
}

class DecimalNumber {
    private String number;

    public DecimalNumber(String number) {
        this.number = number;
    }

    public String reversed() {
        return new StringBuilder(number).reverse().toString();

    }
}
