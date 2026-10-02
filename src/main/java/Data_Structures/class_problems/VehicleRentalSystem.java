package Data_Structures.class_problems;
abstract class Vehicle {
    private String number;
    private boolean available = true;
    Vehicle(String number) {
        this.number = number;
    }
    public String getNumber() {
        return number;
    }
    public boolean isAvailable() {
        return available;
    }
    public void rent() {
        available = false;
    }
    public void returnVehicle() {
        available = true;
    }
    abstract double getCharge(int days);
}
class Sedan extends Vehicle {
    Sedan(String number) {
        super(number);
    }
    double getCharge(int days) {
        return days * 1500;
    }
}
class SUV extends Vehicle {
    SUV(String number) {
        super(number);
    }
    double getCharge(int days) {
        return days * 2000;
    }
}
class Truck extends Vehicle {
    Truck(String number) {
        super(number);
    }
    double getCharge(int days) {
        return days * 2500;
    }
}
class Rentcustomer {
    String name;
    Rentcustomer(String name) {
        this.name = name;
    }
}
class Rental {
    Vehicle vehicle;
    Rentcustomer customer;
    int days;
    Rental(Vehicle vehicle, Rentcustomer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }
    void rent() {
        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle " + vehicle.getNumber() + " is already rented.");
            return;
        }
        vehicle.rent();
        System.out.println(customer.name + " rented " + vehicle.getNumber());
        System.out.println("Amount: Rs." + vehicle.getCharge(days));
    }
    void returnVehicle() {
        vehicle.returnVehicle();
        System.out.println(vehicle.getNumber() + " returned.");
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle sedan = new Sedan("S101");
        Vehicle suv = new SUV("U201");
        Rentcustomer c1 = new Rentcustomer("Customer 1");
        Rentcustomer c2 = new Rentcustomer("Customer 2");
        Rental r1 = new Rental(sedan, c1, 3);
        r1.rent();
        Rental r2 = new Rental(sedan, c2, 2);
        r2.rent();
        r1.returnVehicle();
        Rental r3 = new Rental(suv, c2, 5);
        r3.rent();
    }
}