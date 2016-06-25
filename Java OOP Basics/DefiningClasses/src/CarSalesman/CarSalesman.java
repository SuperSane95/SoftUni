package CarSalesman;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by iwano on 6/22/2016.
 */
public class CarSalesman {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        HashMap<String, Engine> engines = new HashMap<>();
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        LinkedList<Car> carList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            Engine e;
            switch (input.length) {
                case 2:
                    e = new Engine(input[0], Integer.parseInt(input[1]));
                    engines.put(input[0], e);
                    break;
                case 3:
                    String efficiency;
                    int displacement;
                    try {
                        displacement = Integer.parseInt(input[2]);
                        e = new Engine(input[0], Integer.parseInt(input[1]), displacement);
                        engines.put(input[0], e);
                    } catch (Exception ex) {
                        efficiency = input[2];
                        e = new Engine(input[0], Integer.parseInt(input[1]), efficiency);
                        engines.put(input[0], e);
                    }
                    break;
                case 4:
                    e = new Engine(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), input[3]);
                    engines.put(input[0], e);
                    break;
            }
        }

        n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            Car c;
            switch (input.length) {
                case 2:
                    c = new Car(input[0], engines.get(input[1]));
                    //cars.put(input[0], c);
                    carList.add(c);
                    break;

                case 3:
                    String color;
                    int weight;
                    try {
                        weight = Integer.parseInt(input[2]);
                        c = new Car(input[0], engines.get(input[1]), weight);
                        //cars.put(input[0], c);
                        carList.add(c);
                    } catch (Exception ex) {
                        color = input[2];
                        c = new Car(input[0], engines.get(input[1]), color);
                        //cars.put(input[0], c);
                        carList.add(c);
                    }
                    break;

                case 4:
                    c = new Car(input[0], engines.get(input[1]), Integer.parseInt(input[2]), input[3]);
                    //cars.put(input[0], c);
                    carList.add(c);
                    break;
            }

        }

        for (Car c : carList) {
            System.out.println(c.toString());
        }
    }
}

class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color = "n/a";

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.weight != 0) {
            return String.format("%s:\n  %s\n  Weight: %d\n  Color: %s", this.model, this.engine.toString(), this.weight, this.color);
        } else {
            return String.format("%s:\n  %s\n  Weight: n/a\n  Color: %s", this.model, this.engine.toString(), this.color);
        }
    }
}

class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency = "n/a";

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        if (this.displacement != 0) {
            return String.format("%s:\n    Power: %d\n    Displacement: %d\n    Efficiency: %s", this.model, this.power, this.displacement, this.efficiency);
        } else {
            return String.format("%s:\n    Power: %d\n    Displacement: n/a\n    Efficiency: %s", this.model, this.power,this.efficiency);
        }
    }
}
