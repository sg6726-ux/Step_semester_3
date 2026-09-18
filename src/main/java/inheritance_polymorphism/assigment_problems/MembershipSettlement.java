package inheritance_polymorphism.assigment_problems;
class SettlementGymMember {
    private static int count=2000;
    private final String membershipNumber;
    private int totalPaid;
    public SettlementGymMember() {
        membershipNumber="GYM-"+(++count);
    }
    public String getMembershipNumber() {
        return membershipNumber;
    }
    public void payFee(int amount) {
        totalPaid+=amount;
    }
    public void payFee(int amount,String mode) {
        payFee(amount);
    }
}
class SettlementGroupMember extends SettlementGymMember {
}
public class MembershipSettlement {
    public static boolean isValidReferralCode(String code) {
        if(code==null || code.length()!=4)
            return false;
        return code.charAt(0)=='G' &&
                Character.isDigit(code.charAt(1)) &&
                Character.isDigit(code.charAt(2)) &&
                Character.isUpperCase(code.charAt(3));
    }
    public static String processWeeklyCheckIn(SettlementGymMember[] members) {
        int processed=0,nullCount=0,group=0,individual=0;
        for(SettlementGymMember member:members) {
            if(member==null) {
                nullCount++;
                continue;
            }
            processed++;
            if(member instanceof SettlementGroupMember)
                group++;
            else
                individual++;
        }
        return processed+" processed | "+nullCount+" null skipped | "+group+" group | "+individual+" individual";
    }
    public static void main(String[] args) {
        SettlementGymMember member=new SettlementGymMember();
        System.out.println(member.getMembershipNumber());
        member.payFee(500);
        member.payFee(500,"UPI");
        System.out.println(isValidReferralCode("G45B"));
        System.out.println(isValidReferralCode("G4B"));
        System.out.println(isValidReferralCode("X45B"));
        SettlementGymMember group=new SettlementGroupMember();
        SettlementGymMember[] members={member,group,null};
        System.out.println(processWeeklyCheckIn(members));
    }
}