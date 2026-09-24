package Abstraction_Interface.class_problems;
abstract class DeliveryNote {
    public abstract String confirmDelivery();
    public String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }
}
class ParcelNote extends DeliveryNote {
    private String trackingId;
    public ParcelNote(String trackingId) {
        this.trackingId = trackingId;
    }
    public String confirmDelivery() {
        return "Parcel " + trackingId + " delivered";
    }
}
class LetterNote extends DeliveryNote {
    private String trackingId;
    public LetterNote(String trackingId) {
        this.trackingId = trackingId;
    }
    public String confirmDelivery() {
        return "Letter " + trackingId + " delivered";
    }
}
public class PackageDropOffLog {
    static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }
    public static void main(String[] args) {
        ParcelNote parcel = new ParcelNote("TRK-1");
        LetterNote letter = new LetterNote("TRK-2");
        System.out.println(parcel.confirmDelivery());
        System.out.println(parcel.confirmDelivery("J. Smith"));
        DeliveryNote[] notes = {parcel, letter};
        logAll(notes);
    }
}