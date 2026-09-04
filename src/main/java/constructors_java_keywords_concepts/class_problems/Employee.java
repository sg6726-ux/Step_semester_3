package constructors_java_keywords_concepts.class_problems;

class Employee {
    String id;
    double salary;

    Employee(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    void display() {
        System.out.println(id + " - Final Salary: " + this.salary);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("E-101", 40000);
        Employee e2 = new Employee("E-102", 55000);
        Employee e3 = new Employee("E-103", 62000);
        Employee e4 = new Employee("E-104", 48000);

        Employee[] employees = {e1, e2, e3, e4};

        for (Employee e : employees) {
            e.raiseSalary(5000);
            e.display();
        }
    }
}