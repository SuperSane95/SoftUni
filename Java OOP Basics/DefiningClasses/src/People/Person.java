package People;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by iwano on 6/21/2016.
 */
public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "No name";
        this.age = 1;
    }

    public Person(int age) {
        this.name = "No name";
        this.age = age;
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream().filter(p -> p.getAge() > 30).sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).forEach((p) -> {
            System.out.println(p.toString());
        });
    }

}

