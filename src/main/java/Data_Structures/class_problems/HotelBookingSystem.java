package Data_Structures.class_problems;

abstract class Room {
    int number;
    boolean booked = false;

    Room(int number) {
        this.number = number;
    }

    abstract double getPrice(int days);

    boolean isAvailable() {
        return !booked;
    }

    void book() {
        booked = true;
    }

    void cancel() {
        booked = false;
    }
}

class StandardRoom extends Room {
    StandardRoom(int number) {
        super(number);
    }

    double getPrice(int days) {
        return days * 2000;
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int number) {
        super(number);
    }

    double getPrice(int days) {
        return days * 3000;
    }
}

class Suite extends Room {
    Suite(int number) {
        super(number);
    }

    double getPrice(int days) {
        return days * 5000;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Reservation {
    Room room;
    Customer customer;
    int days;

    Reservation(Room room, Customer customer, int days) {
        this.room = room;
        this.customer = customer;
        this.days = days;
    }

    void book() {
        if (!room.isAvailable()) {
            System.out.println("Room " + room.number + " is not available.");
            return;
        }

        room.book();
        System.out.println(customer.name + " booked room " + room.number);
        System.out.println("Amount: Rs." + room.getPrice(days));
    }

    void cancel() {
        room.cancel();
        System.out.println("Reservation cancelled.");
    }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        Room standard = new StandardRoom(101);
        Room deluxe = new DeluxeRoom(201);

        Customer c1 = new Customer("Asha");
        Customer c2 = new Customer("Ravi");

        Reservation r1 = new Reservation(standard, c1, 4);
        r1.book();

        Reservation r2 = new Reservation(standard, c2, 2);
        r2.book();

        r1.cancel();

        Reservation r3 = new Reservation(deluxe, c2, 2);
        r3.book();
    }
}