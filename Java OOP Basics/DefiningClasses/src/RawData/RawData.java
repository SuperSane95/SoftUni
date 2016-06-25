package RawData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by iwano on 6/22/2016.
 */
public class RawData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, Cars> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] d = scan.nextLine().split("\\s+");
            Cars c = new Cars(d[0], Integer.parseInt(d[1]), Integer.parseInt(d[2]), Integer.parseInt(d[3]), d[4],
                    Integer.parseInt(d[6]), Double.parseDouble(d[5]),
                    Integer.parseInt(d[8]), Double.parseDouble(d[7]),
                    Integer.parseInt(d[10]), Double.parseDouble(d[9]),
                    Integer.parseInt(d[12]), Double.parseDouble(d[11]));
            map.put(d[0], c);
        }

        String option = scan.nextLine();
        if (option.equals("fragile")) {
            for(Map.Entry<String, Cars> entry1 : map.entrySet()) {
                if (entry1.getValue().getCargoType().equals("fragile")) {
                    if(entry1.getValue().checkPressure()) {
                        System.out.println(entry1.getValue().toString());
                    }
                }
            }
        } else if (option.equals("flamable")) {
            for (Map.Entry<String, Cars> entry1 : map.entrySet()) {
                if(entry1.getValue().getCargoType().equals("flamable")) {
                    if (entry1.getValue().getEnginePower() > 250) {
                        System.out.println(entry1.getValue().toString());
                    }
                }
            }
        }
    }
}

class Cars {
    private String model;
    private int engineSpeed;
    private int enginePower;
    private int cargoWeight;
    private String cargoType;
    private ArrayList<Tire> list;

    public Cars(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
                int age1, double pressure1, int age2, double pressure2, int age3, double pressure3, int age4, double pressure4) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        list = new ArrayList<>();
        list.add(new Tire(age1, pressure1));
        list.add(new Tire(age2, pressure2));
        list.add(new Tire(age3, pressure3));
        list.add(new Tire(age4, pressure4));
    }

    public String getCargoType() {
        return cargoType;
    }

    public ArrayList<Tire> getList() {
        return list;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public boolean checkPressure() {
        for (Tire t : list) {
            if (t.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }
}

class Tire {
    private int age;
    private double pressure;

    public Tire(int age, double pressure) {
        this.age = age;
        this.pressure = pressure;
    }

    public int getAge() {
        return age;
    }

    public double getPressure() {
        return pressure;
    }
}