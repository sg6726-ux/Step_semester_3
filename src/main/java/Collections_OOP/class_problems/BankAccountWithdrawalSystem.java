package Collections_OOP.class_problems;
import java.util.*;
class BankAccount {
    String id;
    int balance;
    BankAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }
    String withdraw(int amount) {
        return "";
    }
}
class SavingsAccount extends BankAccount {
    SavingsAccount(String id, int balance) {
        super(id, balance);
    }
    String withdraw(int amount) {
        if (balance - amount < 1000)
            return id + " rejected: minimum balance 1000";
        balance -= amount;
        return id + " balance " + balance;
    }
}
class CurrentAccount extends BankAccount {
    CurrentAccount(String id, int balance) {
        super(id, balance);
    }
    String withdraw(int amount) {
        if (balance - amount < -5000)
            return id + " rejected: overdraft limit 5000";
        balance -= amount;
        return id + " balance " + balance;
    }
}
public class BankAccountWithdrawalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, BankAccount> accounts = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\\s+");
            if (p[0].equals("Savings"))
                accounts.put(p[1], new SavingsAccount(p[1], Integer.parseInt(p[2])));
            else if (p[0].equals("Current"))
                accounts.put(p[1], new CurrentAccount(p[1], Integer.parseInt(p[2])));
            else if (p[0].equals("WITHDRAW")) {
                BankAccount a = accounts.get(p[1]);
                if (a == null)
                    System.out.println("Account not found");
                else
                    System.out.println(a.withdraw(Integer.parseInt(p[2])));
            }
        }
        sc.close();
    }
}