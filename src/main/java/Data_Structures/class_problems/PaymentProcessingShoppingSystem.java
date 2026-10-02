package Data_Structures.class_problems;

interface PaymentMethod {
    boolean pay(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("Credit Card payment successful.");
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("PayPal payment failed.");
        return false;
    }
}

class BankTransferPayment implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("Bank Transfer payment successful.");
        return true;
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    double total = 0;
    String status = "Pending";

    void addProduct(Product p, int quantity) {
        total += p.price * quantity;
    }

    void pay(PaymentMethod method) {
        if (total == 0) {
            System.out.println("Order is empty.");
            return;
        }

        if (method.pay(total)) {
            status = "Paid";
        }

        System.out.println("Order status: " + status);
    }
}

class Paymentcustomer {
    String name;

    Paymentcustomer(String name) {
        this.name = name;
    }
}

public class PaymentProcessingShoppingSystem {
    public static void main(String[] args) {
        Paymentcustomer c1 = new Paymentcustomer("Customer X");

        Product p1 = new Product("Product A", 500);
        Product p2 = new Product("Product B", 300);

        Order order = new Order();
        order.addProduct(p1, 2);
        order.addProduct(p2, 1);

        System.out.println(c1.name + " order total: Rs." + order.total);
        order.pay(new CreditCardPayment());

        Order empty = new Order();
        empty.pay(new CreditCardPayment());

        Order failed = new Order();
        failed.addProduct(p1, 1);
        failed.pay(new PayPalPayment());
    }
}