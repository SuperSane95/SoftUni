package Fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by iwano on 6/23/2016.
 */
public class Fibonacci {
    private static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int low = Integer.parseInt(scan.nextLine());
        int high = Integer.parseInt(scan.nextLine());
        create(high);
        List<Long> cut = getNumbersInRange(low, high);
        StringBuilder sb = new StringBuilder();
        for (Long l : cut) {
            sb.append(l);
            sb.append(", ");
        }
        sb.replace(sb.length()-2, sb.length()-1, "");
        System.out.println(sb.toString());
    }

    public static void create(long high) {
        long first = 0;
        long second = 1;
        list.add(first);
        list.add(second);

        for (int i = 2; i < high; i++) {
            long newNumber = first + second;
            list.add(newNumber);
            first = second;
            second = newNumber;
        }
    }

    public static List<Long> getNumbersInRange(int startPosition, int endPosition) {
        return list.subList(startPosition, endPosition);
    }
}
