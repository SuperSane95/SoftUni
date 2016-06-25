import java.util.Date;
import java.util.Scanner;

/**
 * Created by iwano on 6/23/2016.
 */
public class CarProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split("\\s+");
        Car c = new Car(Integer.parseInt(data[0]), Double.parseDouble(data[1]), Integer.parseInt(data[2]));
        String input = scan.nextLine();
        while(!input.equals("END")) {
            data = input.split("\\s+");
            switch (data[0]) {
                case "Travel":
                    c.travel(Double.parseDouble(data[1]));
                    break;
                case "Refuel":
                    c.refuel(Double.parseDouble(data[1]));
                    break;
                case "Distance":
                    System.out.println("Total distance: " + c.getDistance() + " kilometers");
                    break;
                case "Time":

                    int hours = (int) c.getTime();
                    int minutes = (int) ((hours - c.getTime()) * 60);
                    double result = ((hours - c.getTime()) * 60) - minutes;
                    if (result >= 0.5) {
                        minutes++;
                    }
                    if (hours < 0) {
                        minutes += hours*60;
                        hours = 0;
                        if (minutes < 0) {
                            minutes = 0;
                        }
                    } else if (minutes < 0) {
                        hours--;
                        if (hours < 0) {
                            hours = 0;
                        }
                        minutes = -minutes;
                    }

                    System.out.println("Total time: " +  hours + " hours and " + minutes + " minutes");
                    break;
                case "Fuel":
                    System.out.println("Fuel left: " + c.getFuel() + " liters");
                    break;
            }
            input = scan.nextLine();
        }
    }
}

class Car {
    private int speed;
    private double fuel;
    private int fuelEconomy;
    private double distance;
    private double time;

    public Car(int speed, double fuel, int fuelEconomy) {
        this.speed = speed;
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
    }

    public void travel(double distance) {
        double possibleDistance = fuel * (100/fuelEconomy);
        double neededFuel = distance / (100/fuelEconomy);
        double possibleFuel = possibleDistance / (100/fuelEconomy);
        if (possibleDistance >= distance) {
            this.distance += distance;
            this.fuel -= neededFuel;
            this.time += distance/this.speed;
        } else {
            this.distance += possibleDistance;
            this.fuel -= possibleFuel;
            this.time += possibleDistance/this.speed;
        }
    }

    public void refuel (double fuel) {
        this.fuel += fuel;
    }

    public double getFuel() {
        return this.fuel;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }
}
