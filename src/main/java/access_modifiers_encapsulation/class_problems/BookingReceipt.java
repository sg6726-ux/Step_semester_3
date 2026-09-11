package access_modifiers_encapsulation.class_problems;
public class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;
    public BookingReceipt(String bookingId, String[] seatNumbers) {

        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone();
    }
    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }
    public BookingReceipt withUpdatedSeat(
            int index, String newSeat) {
        String[] updatedSeats = seatNumbers.clone();
        if (index >= 0 && index < updatedSeats.length) {
            updatedSeats[index] = newSeat;
        }
        return new BookingReceipt(
                bookingId,
                updatedSeats
        );
    }
    public static String processNightlySettlement(
            BookingReceipt[] receipts) {
        int processed = 0;
        int nullCount = 0;
        int group = 0;
        int individual = 0;
        for (BookingReceipt receipt : receipts) {
            if (receipt == null) {
                nullCount++;
                continue;
            }
            processed++;
            if (receipt instanceof GroupBookingReceipt) {
                group++;
            } else {
                individual++;
            }
        }
        return processed + " processed | "
                + nullCount + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }
    public static void main(String[] args) {
        BookingReceipt booking =
                new BookingReceipt(
                        "CH-1001",
                        new String[]{"A1", "A2"}
                );
        String[] seats = booking.getSeatNumbers();
        seats[0] = "X";
        System.out.println(booking.getSeatNumbers()[0]);
        BookingReceipt updated =
                booking.withUpdatedSeat(1, "A3");
        System.out.println(
                booking.getSeatNumbers()[0] + " "
                        + booking.getSeatNumbers()[1]
        );
        System.out.println(
                updated.getSeatNumbers()[0] + " "
                        + updated.getSeatNumbers()[1]
        );
        BookingReceipt[] receipts = {
                new GroupBookingReceipt(
                        "CH-2002",
                        new String[]{"B1", "B2"},
                        2
                ),
                null,
                new BookingReceipt(
                        "CH-3003",
                        new String[]{"C1"}
                )
        };
        System.out.println(
                processNightlySettlement(receipts)
        );
    }
}
class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;
    public GroupBookingReceipt(
            String bookingId,
            String[] seatNumbers,
            int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}
