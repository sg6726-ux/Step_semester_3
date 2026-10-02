package Data_Structures.class_problems;
abstract class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
    abstract boolean canTakeLeave(int days);
}
class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) {
        super(name);
    }
    boolean canTakeLeave(int days) {
        return days <= 20;
    }
}
class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) {
        super(name);
    }

    boolean canTakeLeave(int days) {
        return days <= 10;
    }
}
class Contractor extends Employee {
    Contractor(String name) {
        super(name);
    }
    boolean canTakeLeave(int days) {
        return days <= 5;
    }
}
class LeaveRequest {
    Employee employee;
    String start, end, status = "Pending";
    LeaveRequest(Employee employee, String start, String end) {
        this.employee = employee;
        this.start = start;
        this.end = end;
    }
    void approve(int days) {
        if (!status.equals("Pending")) {
            System.out.println("Request cannot be changed.");
        } else if (employee.canTakeLeave(days)) {
            status = "Approved";
            System.out.println(employee.name + " leave approved.");
        } else {
            System.out.println("Leave policy does not allow this request.");
        }
    }
    void reject() {
        if (status.equals("Pending")) {
            status = "Rejected";
            System.out.println(employee.name + " leave rejected.");
        } else {
            System.out.println("Request cannot be changed.");
        }
    }
    void review() {
        System.out.println("Status: " + status);
    }
}
public class EmployeeLeaveRequestWorkflow {
    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");
        LeaveRequest r1 = new LeaveRequest(john, "Jan 1", "Jan 5");
        r1.review();
        r1.approve(5);
        r1.review();
        LeaveRequest r2 = new LeaveRequest(jane, "Feb 10", "Feb 11");
        r2.reject();
        r2.review();
        r1.reject();
    }
}