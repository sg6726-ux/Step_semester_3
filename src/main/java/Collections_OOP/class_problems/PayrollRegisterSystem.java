package Collections_OOP.class_problems;
import java.util.*;
abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }
    abstract int getPay();
    abstract String getType();
}
class FullTime extends Staff {
    int salary;
    FullTime(String name, int salary) {
        super(name);
        this.salary = salary;
    }
    int getPay() {
        return salary;
    }
    String getType() {
        return "FullTime";
    }
}
class PartTime extends Staff {
    int hours, rate;
    PartTime(String name, int hours, int rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    int getPay() {
        return hours * rate;
    }
    String getType() {
        return "PartTime";
    }
}
class Intern extends Staff {
    int stipend;
    Intern(String name, int stipend) {
        super(name);
        this.stipend = stipend;
    }
    int getPay() {
        return stipend;
    }
    String getType() {
        return "Intern";
    }
}
public class PayrollRegisterSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Staff> staff = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\\s+");
            if (p[0].equals("FullTime"))
                staff.add(new FullTime(p[1], Integer.parseInt(p[2])));
            else if (p[0].equals("PartTime"))
                staff.add(new PartTime(p[1], Integer.parseInt(p[2]),
                        Integer.parseInt(p[3])));
            else if (p[0].equals("Intern"))
                staff.add(new Intern(p[1], Integer.parseInt(p[2])));
        }
        int total = 0, max = -1;
        String topper = "";
        for (Staff s : staff) {
            int pay = s.getPay();
            total += pay;
            System.out.println("Payslip[name=" + s.name + ", type=" +
                    s.getType() + ", pay=" + pay + "]");
            if (pay > max) {
                max = pay;
                topper = s.name;
            }
        }
        System.out.println("Total " + total);
        System.out.println("top earner " + topper);

        sc.close();
    }
}