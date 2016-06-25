package People;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by iwano on 6/21/2016.
 */
public class Employee {
    private String name;
    private Double salary;
    private String position;
    private String department;
    private String email = "n/a";
    private int age = -1;

    public Employee(String name, Double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public Employee(String name, Double salary, String position, String department, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
    }

    public Employee(String name, Double salary, String position, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
    }

    public Employee(String name, Double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee() {

    }


    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }

    private static Double getAverageSalaray(ArrayList<Employee> l) {
        List<Double> lista = new ArrayList<>();
        lista = l.stream()
                .map(Employee::getSalary)
                .collect(Collectors.toList());
        double sum = 0;
        for (Double d : lista) {
            sum += d;
        }
        return sum/lista.size();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        double max = Double.MIN_VALUE;
        String maxDep = "";


        HashMap<String, ArrayList<Employee>> depToPerson = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input[] = scan.nextLine().split("\\s+");
            Employee employee = new Employee();
            if (input.length == 4) {
                employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3]);
            } else if (input.length == 5) {
                if(input[4].contains("@")) {
                    employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4]);
                } else {
                    employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], Integer.parseInt(input[4]));
                }

            } else if (input.length == 6) {
                employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4], Integer.parseInt(input[5]));
            }

            if (!depToPerson.containsKey(employee.department)) {
                depToPerson.put(employee.department, new ArrayList<>());
            }
            depToPerson.get(employee.department).add(employee);
        }

        for (Map.Entry<String, ArrayList<Employee>> entry : depToPerson.entrySet()) {
            Double tempmax = Employee.getAverageSalaray(entry.getValue());
            if (tempmax > max) {
                max = tempmax;
                maxDep = entry.getKey();
            }
        }

        System.out.printf("Highest Average Salary: %s\n", maxDep);

        depToPerson.get(maxDep).stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e -> {
                    System.out.println(e.toString());
                });
    }
}
