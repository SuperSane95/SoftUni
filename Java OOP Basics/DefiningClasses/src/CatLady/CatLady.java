package CatLady;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by iwano on 6/22/2016.
 */
public class CatLady {
    public static void main(String[] args) {
        HashMap<String, Cat> cats = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String type = data[0];
            String name = data[1];
            String m = data[2];

            switch (type) {
                case "Siamese":
                    Siamese s = new Siamese(name, m);
                    cats.put(name, s);
                    break;
                case "Cymric":
                    Cymric c = new Cymric(name, m);
                    cats.put(name, c);
                    break;
                case "StreetExtraordinaire":
                    StreetExtraordinaire st = new StreetExtraordinaire(name, m);
                    cats.put(name, st);
                    break;
            }
            input = scan.nextLine();
        }
        String name = scan.nextLine();
        System.out.println(cats.get(name).toString());
    }
}

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}

class Siamese extends Cat {
    private final String type = "Siamese";
    private String earSize;

    public Siamese(String name, String earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return this.type + " " + super.toString() + " " + this.earSize;
    }
}

class Cymric extends Cat {
    private final String type = "Cymric";
    private String furLenght;

    public Cymric(String name, String furLenght) {
        super(name);
        this.furLenght = furLenght;
    }

    @Override
    public String toString() {
        return this.type + " " + super.toString() + " " + this.furLenght;
    }
}

class StreetExtraordinaire extends Cat {
    private final String type = "StreetExtraordinaire";
    private String decibels;

    public StreetExtraordinaire(String name, String decibels) {
        super(name);
        this.decibels = decibels;
    }

    @Override
    public String toString() {
        return this.type + " " + super.toString() + " " + this.decibels;
    }
}