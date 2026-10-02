package Data_Structures.assigment_problems;

interface MembershipPlan {
    double calculateFee();
}

class MonthlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 1000;
    }
}

class QuarterlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 2700;
    }
}

class AnnualPlan implements MembershipPlan {
    public double calculateFee() {
        return 9000;
    }
}

class Member {
    String name;

    Member(String name) {
        this.name = name;
    }
}

class Membership {
    Member member;
    MembershipPlan plan;
    String status = "Active";

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
    }

    void showFee() {
        System.out.println(member.name + " fee: Rs." + plan.calculateFee());
    }

    void checkIn() {
        if (status.equals("Active"))
            System.out.println(member.name + " checked in.");
        else
            System.out.println("Check-in denied.");
    }

    void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println("Membership frozen.");
        } else {
            System.out.println("Cannot freeze membership.");
        }
    }

    void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println("Membership active.");
        } else {
            System.out.println("Cannot unfreeze membership.");
        }
    }

    void expire() {
        status = "Expired";
        System.out.println("Membership expired.");
    }
}

public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Membership m1 = new Membership(asha, new QuarterlyPlan());

        m1.showFee();
        m1.checkIn();
        m1.freeze();
        m1.checkIn();
        m1.unfreeze();
        m1.checkIn();

        Member ravi = new Member("Ravi");
        Membership m2 = new Membership(ravi, new MonthlyPlan());

        m2.showFee();
        m2.expire();
        m2.checkIn();
        m2.freeze();
    }
}