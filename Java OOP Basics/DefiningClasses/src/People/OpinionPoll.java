package People;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by iwano on 6/21/2016.
 */
public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for(int i = 0; i<n; i++) {
            String[] input = scan.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
        }

        people.stream().filter(p -> p.getAge() > 30).forEach((p) -> {
        System.out.println(p.toString());
        });
    }
}
