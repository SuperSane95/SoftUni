package SpeedRacing;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by iwano on 6/22/2016.
 */


public class CarProblem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, Car> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            Car car = new Car(input[0], Integer.parseInt(input[1]), Double.parseDouble(input[2]));
            map.put(input[0], car);
        }

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[1];
            int travel = Integer.parseInt(data[2]);
            Car car = map.get(name);
            boolean b = car.calculate(travel);
            input = scan.nextLine();
        }
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

}



class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distance = 0;


    public Car(String model, int fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance += distance;
    }

    public boolean calculate(int travel) {

        double travelFuel = (travel * this.fuelCost);
        if (travelFuel <= this.fuelAmount) {
            this.fuelAmount -= travelFuel;
            this.distance += travel;
            return true;
        } else {
            System.out.println("Insufficient fuel for the drive");
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }

    public static void main(String[] args) {

    }
}
