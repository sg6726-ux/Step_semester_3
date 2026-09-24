package Abstraction_Interface.class_problems;
abstract class Instrument {
    public abstract String play();
}
class StringInstrument extends Instrument {
    public String play() {
        return "Strumming the strings";
    }
}
class Violin extends StringInstrument {
    public String play() {
        return super.play() + ", with a bow drawn across four strings";
    }
}
public class OrchestraWarmUpRoutine {
    public static void main(String[] args) {
        Violin violin = new Violin();
        System.out.println(violin.play());
    }
}