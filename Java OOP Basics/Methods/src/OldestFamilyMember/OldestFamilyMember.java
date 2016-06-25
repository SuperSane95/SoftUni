package OldestFamilyMember;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by iwano on 6/23/2016.
 */
public class OldestFamilyMember {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Family family = new Family();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            family.addFamilyMember(new Person(input[0], Integer.parseInt(input[1])));
        }
        System.out.println(family.getOldestMember().toString());
        Method getOldestMethod = Class.forName("Family").getMethod("getOldestMember");
        Method addMemberMethod = Class.forName("Family").getMethod("addFamilyMember", Person.class);

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
        return this.name + " " + this.age;
    }
}

class Family {
    private ArrayList<Person> people = new ArrayList<>();

    public void addFamilyMember(Person p) {
        this.people.add(p);
    }

    public Person getOldestMember() {
        int oldestAge = Integer.MIN_VALUE;
        Person p = null;
        for (Person pers : people) {
            if (pers.getAge() > oldestAge) {
                oldestAge = pers.getAge();
                p = pers;
            }
        }
        return p;
    }
}
