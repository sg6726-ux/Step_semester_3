package constructors_java_keywords_concepts.assigment_problems;

class Payment {
    void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }

    void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment card = (CardPayment) payment;
            card.payWithProcessingFee(amount);
        } else {
            payment.pay(amount);
        }
    }

    double getActualAmount(double amount) {
        return amount;
    }

    public static void main(String[] args) {
        Payment[] payments = {
                new CardPayment(),
                new Payment(),
                new CardPayment(),
                new Payment(),
                new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};

        Payment processor = new Payment();
        double totalCollected = 0;

        for (int i = 0; i < payments.length; i++) {
            processor.processTransaction(payments[i], amounts[i]);
            totalCollected += payments[i].getActualAmount(amounts[i]);
        }

        System.out.println("Total Collected: Rs " + totalCollected);
    }
}

class CardPayment extends Payment {

    void payWithProcessingFee(double amount) {
        double total = amount * 1.02;
        System.out.println("Charged (card, incl. fee): Rs " + total);
    }

    @Override
    double getActualAmount(double amount) {
        return amount * 1.02;
    }
}