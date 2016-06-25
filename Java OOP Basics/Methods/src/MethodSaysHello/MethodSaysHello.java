package MethodSaysHello;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by iwano on 6/23/2016.
 */
public class MethodSaysHello {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        Person person = new Person();
        person.name = name;
        System.out.println(person.hello());
        Field[] fields = Class.forName("Person").getDeclaredFields();
        Method[] methods = Class.forName("Person").getDeclaredMethods();
        if (fields.length != 1 || methods.length != 1) {
            throw new ClassFormatError();
        }
    }
}

class Person {

    public String name;

    public String hello() {
        return this.name + " says \"Hello\"!";
    }
}
