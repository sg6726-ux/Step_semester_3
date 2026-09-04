package constructors_java_keywords_concepts.class_problems;

class FeeAccount {
    void pay(double amount) {
        System.out.println("Day-scholar payment: " + amount);
    }

    void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            ((HostelFeeAccount) account).pay(amount);
        } else {
            account.pay(amount);
        }
    }

    public static void main(String[] args) {
        FeeAccount account = new FeeAccount();

        FeeAccount[] accounts = {
                new HostelFeeAccount(),
                new HostelFeeAccount(),
                new FeeAccount(),
                new FeeAccount()
        };

        int hostelCount = 0;
        int plainCount = 0;

        for (FeeAccount a : accounts) {
            account.processPayment(a, 60000);

            if (a instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                plainCount++;
            }
        }

        System.out.println("Hostel accounts: " + hostelCount);
        System.out.println("Plain accounts: " + plainCount);
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    void pay(double amount) {
        System.out.println("Hostel payment: " + amount + " in installments");
    }
}