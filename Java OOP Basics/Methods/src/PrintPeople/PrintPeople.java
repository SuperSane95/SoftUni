package PrintPeople;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by iwano on 6/25/2016.
 */
public class PrintPeople {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            Person p = new Person(data[0], Integer.parseInt(data[1]), data[2]);
            people.add(p);
            input = scan.nextLine();
        }

        people.stream().sorted().forEach(p -> System.out.println(p.toString()));
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }


    @Override
    public int compareTo(Person o) {
        if (Integer.compare(this.age, o.age) == 0) {
            return this.name.compareTo(o.name);
        }
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return String.format("%s - age: %d, occupation: %s", this.name, this.age, this.occupation);
    }
}
