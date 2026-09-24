package Abstraction_Interface.class_problems;
abstract class Toy {
    private static int counter = 1000;
    private final String toyId;
    protected String name;
    public Toy(String name) {
        this.name = name;
        counter++;
        toyId = "TOY-" + counter;
    }
    public String getToyId() {
        return toyId;
    }
    public abstract String makeSound();
}
class ToyCar extends Toy {
    public ToyCar(String name) {
        super(name);
    }
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}
class ToyRobot extends Toy {
    public ToyRobot(String name) {
        super(name);
    }
    public String makeSound() {
        return name + ": Beep boop!";
    }
}
public class TalkingToyBox {
    public static void main(String[] args) {
        ToyCar car = new ToyCar("Speedster");
        ToyRobot robot = new ToyRobot("Bolt");
        System.out.println(car.makeSound());
        System.out.println(robot.makeSound());
        System.out.println(car.getToyId());
        System.out.println(robot.getToyId());
    }
}