package PrimeChecker;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by iwano on 6/23/2016.
 */
public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Number num = new Number(n, true);

        System.out.print(num.nextPrime().toString() + ", ");
        System.out.print(num.checkIsPrime());

        Field[] fields = Number.class.getDeclaredFields();

        List<Field> filedsDeclared = Arrays.stream(fields)
                .filter(f -> f.getName().contains("prime") || f.getName().contains("number"))
                .collect(Collectors.toList());

        List<Constructor<?>> constructors = Arrays.stream(Number.class.getDeclaredConstructors())
                .filter(c -> c.getParameterCount() > 1)
                .collect(Collectors.toList());

        if (filedsDeclared.size() <= 1 || constructors.size() < 1) {
            throw new ClassFormatException();
        }

    }
}

class Number {
    private int number;
    private boolean prime;

    public Number(int number, boolean prime) {
        this.number = number;
        this.prime = checkIsPrime();

    }

    public boolean checkIsPrime() {
        for (int i = 2; i < number; i++ ) {
            if (number % i == 0) {
                return  false;
            }
        }
        return  true;
    }

    public Number nextPrime() {
        int newPrime = number + 1;
        while (true) {
            Number n = new Number(newPrime, true);
            if (n.checkIsPrime()) {
                return n;
            }
            newPrime += 1;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
