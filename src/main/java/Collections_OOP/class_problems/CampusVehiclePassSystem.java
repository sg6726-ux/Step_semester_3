package Collections_OOP.class_problems;
import java.util.*;
interface Chargeable {
    void charge();
}
class Vehicle {
    String type, pass, owner;
    int fee;
    Vehicle(String type, String pass, String owner, int fee) {
        this.type = type;
        this.pass = pass;
        this.owner = owner;
        this.fee = fee;
    }
    void showPass() {
        System.out.println(pass + " (" + type + ") pass fee " + fee);
    }
}
class ElectricBike extends Vehicle implements Chargeable {
    ElectricBike(String pass, String owner) {
        super("EBike", pass, owner, 300);
    }
    public void charge() {
        System.out.println(pass + " charging bay allotted");
    }
}
class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String pass, String owner) {
        super("ECar", pass, owner, 1000);
    }
    public void charge() {
        System.out.println(pass + " charging bay allotted");
    }
}
public class CampusVehiclePassSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Vehicle> vehicles = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\\s+");
            if (p[0].equals("PASS")) {
                Vehicle v = null;
                if (p[1].equals("Bike"))
                    v = new Vehicle("Bike", p[2], p[3], 300);
                else if (p[1].equals("Car"))
                    v = new Vehicle("Car", p[2], p[3], 1000);
                else if (p[1].equals("EBike"))
                    v = new ElectricBike(p[2], p[3]);
                else if (p[1].equals("ECar"))
                    v = new ElectricCar(p[2], p[3]);
                if (v != null) {
                    vehicles.put(p[2], v);
                    v.showPass();
                }
            } else if (p[0].equals("CHARGE")) {
                Vehicle v = vehicles.get(p[1]);
                if (v == null)
                    System.out.println("Vehicle not found");
                else if (v instanceof Chargeable)
                    ((Chargeable) v).charge();
                else
                    System.out.println(p[1] + " rejected: charging unsupported");
            }
        }
        sc.close();
    }
}