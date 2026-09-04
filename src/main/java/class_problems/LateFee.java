package constructors_java_keywords_concepts.class_problems;

class LateFee {
    String accountNo;
    double amount;

    LateFee(String accountNo, double amount) {
        this.accountNo = accountNo;
        this.amount = amount;
    }

    final double calculateLateFee(int daysLate) {
        return amount * 0.01 * daysLate;
    }

    final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(accountNo + " - On Time");
        } else {
            double fee = calculateLateFee(daysLate);
            System.out.println(accountNo + " - Late Fee: " + fee);
        }
    }

    public static void main(String[] args) {
        LateFee[] accounts = {
                new LateFee("RA001", 200000),
                new LateFee("RA002", 150000),
                new LateFee("RA003", 180000),
                new LateFee("RA004", 220000)
        };

        int[] days = {10, 0, -2, 5};

        for (int i = 0; i < accounts.length; i++) {
            accounts[i].printSummary(days[i]);
        }
    }
}