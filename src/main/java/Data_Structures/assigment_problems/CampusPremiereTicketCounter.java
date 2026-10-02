package Data_Structures.assigment_problems;

abstract class Seat {
    String number;
    boolean booked = false;

    Seat(String number) {
        this.number = number;
    }

    abstract int getPrice();
}

class RegularSeat extends Seat {
    RegularSeat(String number) {
        super(number);
    }

    int getPrice() {
        return 150;
    }
}

class PremiumSeat extends Seat {
    PremiumSeat(String number) {
        super(number);
    }

    int getPrice() {
        return 250;
    }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(String number) {
        super(number);
    }

    int getPrice() {
        return 400;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Show {
    String time;

    Show(String time) {
        this.time = time;
    }
}

class Booking {
    Customer customer;
    Show show;
    Seat[] seats;

    Booking(Customer customer, Show show, Seat... seats) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
    }

    void book() {
        if (seats.length > 6) {
            System.out.println("Maximum 6 seats allowed.");
            return;
        }

        for (Seat s : seats) {
            if (s.booked) {
                System.out.println(s.number + " is already booked.");
                return;
            }
        }

        int total = 0;

        for (Seat s : seats) {
            s.booked = true;
            total += s.getPrice();
        }

        System.out.println(customer.name + " booked seats.");
        System.out.println("Total: Rs." + total);
    }

    void cancel() {
        for (Seat s : seats)
            s.booked = false;

        System.out.println("Booking cancelled.");
    }
}

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {
        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Show show = new Show("7 PM");

        Seat a1 = new RegularSeat("A1");
        Seat a2 = new RegularSeat("A2");
        Seat f5 = new PremiumSeat("F5");
        Seat r1 = new ReclinerSeat("R1");

        Booking b1 = new Booking(asha, show, a1, a2, f5);
        b1.book();

        Booking b2 = new Booking(ravi, show, a2);
        b2.book();

        Booking b3 = new Booking(ravi, show, r1);
        b3.book();

        b1.cancel();

        Booking b4 = new Booking(new Customer("Neha"), show, a2);
        b4.book();
    }
}