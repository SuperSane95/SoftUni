package FamilyTree;

import java.util.*;

/**
 * Created by iwano on 6/22/2016.
 */
public class FamilyTree {
    static LinkedHashMap<String, Person> nameToPerson = new LinkedHashMap<>();
    static LinkedHashMap<String, Person> dateToPerson = new LinkedHashMap<>();
    static Person p;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        if (input.contains("/")) {
            p = new Person();
            p.setBirtdate(input);
            dateToPerson.put(input, p);
        } else {
            p = new Person();
            p.setName(input);
            nameToPerson.put(input, p);
        }

        input = scan.nextLine();

        while (!input.equals("End")) {
            if (input.contains("-")) {
                String[] data = input.split(" - ");
                if (data[0].contains("/")) {
                    String birthdateParent = data[0];
                    if (data[1].contains("/")) {
                        String birthdateChild = data[1];
                        updateTree(birthdateParent, birthdateChild);
                    } else {
                        String names = data[1];
                        updateTree(birthdateParent, names);
                    }
                } else {
                    String namesParent = data[0];
                    if (data[1].contains("/")) {
                        String birthdateChild = data[1];
                        updateTree(namesParent, birthdateChild);
                    } else {
                        String namesChild = data[1];
                        updateTree(namesParent, namesChild);
                    }
                }
            } else {
                String[] data = input.split("\\s+");
                String names = data[0] + " " + data[1];
                String date = data[2];

                if (!nameToPerson.containsKey(names)) {
                    Person temp = new Person();
                    temp.setName(names);
                    temp.setBirtdate(date);
                    nameToPerson.put(names, temp);
                } else {
                    nameToPerson.get(names).setBirtdate(date);
                }

                if (!dateToPerson.containsKey(date)) {
                    Person temp = new Person();
                    temp.setName(names);
                    temp.setBirtdate(date);
                    dateToPerson.put(date, temp);
                } else {
                    dateToPerson.get(date).setName(names);
                }

            }
            input = scan.nextLine();
        }

        System.out.println(p.toString());
        System.out.println("Parents:");
        if (nameToPerson.containsKey(p.getName()) && nameToPerson.get(p.getName()).getParents().size() > 0) {
            nameToPerson.get(p.getName()).getParents().stream().forEach(x -> System.out.println(x.toString()));
        } else if (dateToPerson.containsKey(p.getBirtdate()) && dateToPerson.get(p.getBirtdate()).getParents().size() > 0) {
            dateToPerson.get(p.getBirtdate()).getParents().stream().forEach(x -> System.out.println(x.toString()));
        }
        System.out.println("Children:");
        if (nameToPerson.containsKey(p.getName()) && nameToPerson.get(p.getName()).getChildren().size() > 0) {
            nameToPerson.get(p.getName()).getChildren().stream().forEach(x -> System.out.println(x.toString()));
        } else if (dateToPerson.containsKey(p.getBirtdate()) && dateToPerson.get(p.getBirtdate()).getChildren().size() > 0) {
            dateToPerson.get(p.getBirtdate()).getChildren().stream().forEach(x -> System.out.println(x.toString()));
        }

    }


    public static void updateTree(String parent, String child) {
        Person parentP = null;
        Person childP = null;

        boolean haveParent = false;
        boolean haveChild = false;


        if (parent.contains("/")) {
            if (!dateToPerson.containsKey(parent)) {
                Person temp = new Person();
                temp.setBirtdate(parent);
                dateToPerson.put(parent, temp);
            }
            parentP = dateToPerson.get(parent);
        } else {
            if (!nameToPerson.containsKey(parent)) {
                Person temp = new Person();
                temp.setName(parent);
                nameToPerson.put(parent, temp);
            }
            parentP = nameToPerson.get(parent);
        }

        if (child.contains("/")) {
            if (!dateToPerson.containsKey(child)) {
                Person temp = new Person();
                temp.setBirtdate(child);
                dateToPerson.put(child, temp);
            }
            childP = dateToPerson.get(child);
        } else {
            if (!nameToPerson.containsKey(child)) {
                Person temp = new Person();
                temp.setName(child);
                nameToPerson.put(child, temp);
            }
            childP = nameToPerson.get(child);
        }

        parentP.getChildren().add(childP);
        childP.getParents().add(parentP);

    }
}

class Person {
    private String name;
    private String birtdate;
    private LinkedList<Person> parents;
    private LinkedList<Person> children;

    public Person(String name, String birtdate) {
        this.name = name;
        this.birtdate = birtdate;
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
    }

    public Person() {
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirtdate() {
        return birtdate;
    }

    public void setBirtdate(String birtdate) {
        this.birtdate = birtdate;
    }

    public LinkedList<Person> getParents() {
        return parents;
    }

    public void setParents(LinkedList<Person> parents) {
        this.parents = parents;
    }

    public LinkedList<Person> getChildren() {
        return children;
    }

    public void setChildren(LinkedList<Person> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birtdate);
    }
}
