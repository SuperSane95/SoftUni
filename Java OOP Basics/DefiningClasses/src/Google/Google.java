package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by iwano on 6/22/2016.
 */
public class Google {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Person> people = new HashMap<>();

        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            Person p;
            if (!people.containsKey(name)) {
                p = new Person(name);
                people.put(name, p);
            }
            p = people.get(name);
            switch (data[1]) {
                case "company":
                    Company com = new Company(data[2], data[3], Double.parseDouble(data[4]));
                    p.setCompany(com);
                    break;
                case "pokemon":
                    Pokemon pok = new Pokemon(data[2], data[3]);
                    p.getPokemons().add(pok);
                    break;
                case "parents":
                    Parent par = new Parent(data[2], data[3]);
                    p.getParents().add(par);
                    break;
                case "children":
                    Children child = new Children(data[2], data[3]);
                    p.getChildren().add(child);
                    break;
                case "car":
                    Car car = new Car(data[2], Integer.parseInt(data[3]));
                    p.setCar(car);
                    break;
            }
            input = scan.nextLine();
        }

        String name = scan.nextLine();
        Person p = people.get(name);

        System.out.println(p.getName());
        System.out.println("Company:");
        if (p.getCompany() != null) {
            System.out.println(p.getCompany().toString());
        }
        System.out.println("Car:");
        if (p.getCar() != null) {
            System.out.println(p.getCar().toString());
        }
        System.out.println("Pokemon:");
        if (p.getPokemons().size() > 0) {
            p.getPokemons().stream().forEach(pokemon -> System.out.println(pokemon.toString()));
        }
        System.out.println("Parents:");
        if (p.getParents().size() > 0) {
            p.getParents().stream().forEach(parent -> System.out.println(parent.toString()));
        }
        System.out.println("Children:");
        if (p.getChildren().size() > 0) {
            p.getChildren().stream().forEach(child -> System.out.println(child.toString()));
        }

    }
}

class Person {
    private String name;
    private Car car;
    private Company company;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Parent> parents;
    private ArrayList<Children> children;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public ArrayList<Parent> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Parent> parents) {
        this.parents = parents;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Children> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return String.format("%d\nCompany:%s\nCar:%s\nPokemon:%s\nParents:%s\nChildren:%s");
    }
}

class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.type);
    }
}

class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.model, this.speed);
    }
}

class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.name, this.department, this.salary);
    }
}

class Parent {
    private String name;
    private String birthday;

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthday);
    }
}

class Children {
    private String name;
    private String birthday;

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthday);
    }
}