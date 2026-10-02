package Data_Structures.assigment_problems;

interface WashType {
    int getDuration();
    int getCharge();
    String getName();
}

class QuickWash implements WashType {
    public int getDuration() {
        return 30;
    }

    public int getCharge() {
        return 20;
    }

    public String getName() {
        return "Quick";
    }
}

class NormalWash implements WashType {
    public int getDuration() {
        return 45;
    }

    public int getCharge() {
        return 30;
    }

    public String getName() {
        return "Normal";
    }
}

class HeavyWash implements WashType {
    public int getDuration() {
        return 60;
    }

    public int getCharge() {
        return 45;
    }

    public String getName() {
        return "Heavy";
    }
}

class LaundryStudent {
    String name;

    LaundryStudent(String name) {
        this.name = name;
    }
}

class WashingMachine {
    String id;
    boolean busy = false;

    WashingMachine(String id) {
        this.id = id;
    }

    void complete() {
        busy = false;
        System.out.println(id + " is now free.");
    }
}

class WashCycle {
    LaundryStudent student;
    WashingMachine machine;
    WashType type;

    WashCycle(LaundryStudent student, WashingMachine machine, WashType type) {
        this.student = student;
        this.machine = machine;
        this.type = type;
    }

    void start() {
        if (machine.busy) {
            System.out.println(machine.id + " is busy.");
            return;
        }

        machine.busy = true;
        System.out.println(student.name + " started " + type.getName()
                + " wash on " + machine.id);
        System.out.println("Duration: " + type.getDuration()
                + " minutes, Charge: Rs." + type.getCharge());
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {
        LaundryStudent asha = new LaundryStudent("Asha");
        LaundryStudent ravi = new LaundryStudent("Ravi");
        LaundryStudent neha = new LaundryStudent("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        new WashCycle(asha, m1, new QuickWash()).start();
        new WashCycle(ravi, m1, new HeavyWash()).start();
        new WashCycle(ravi, m2, new HeavyWash()).start();

        m1.complete();

        new WashCycle(neha, m1, new NormalWash()).start();
    }
}