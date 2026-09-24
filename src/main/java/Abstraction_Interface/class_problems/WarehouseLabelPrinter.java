package Abstraction_Interface.class_problems;
interface Printable {
    String printLabel();
}
class PackageBox implements Printable {
    private String trackingId;
    public PackageBox(String trackingId) {
        this.trackingId = trackingId;
    }
    public String printLabel() {
        return "Package label: " + trackingId;
    }
}
class Invoice implements Printable {
    private String invoiceNumber;
    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    public String printLabel() {
        return "Invoice label: " + invoiceNumber;
    }
}
public class WarehouseLabelPrinter {
    static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }
    public static void main(String[] args) {
        PackageBox box = new PackageBox("TRK-88");
        Invoice invoice = new Invoice("INV-42");
        Printable[] items = {box, invoice};
        printAll(items);
    }
}