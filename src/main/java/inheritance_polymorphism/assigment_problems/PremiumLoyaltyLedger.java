package inheritance_polymorphism.assigment_problems;
class LoyaltyGymMember {
    protected String memberId;
    private int totalFee;
    private int[] feeHistory=new int[10];
    private int count;
    public LoyaltyGymMember(String memberId) {
        this.memberId=memberId;
    }
    public void chargeLateFee(int amount) {
        if(count<feeHistory.length)
            feeHistory[count++]=amount;
        totalFee+=amount;
    }
    public int[] getLateFeeHistory() {
        int[] copy=new int[count];
        for(int i=0;i<count;i++)
            copy[i]=feeHistory[i];
        return copy;
    }
    public int getTotalLateFees() {
        return totalFee;
    }
}
class LoyaltyPremiumMember extends LoyaltyGymMember {
    public LoyaltyPremiumMember(String memberId) {
        super(memberId);
    }
    @Override
    public void chargeLateFee(int amount) {
        super.chargeLateFee(amount/2);
    }
}
public class PremiumLoyaltyLedger {
    public static void main(String[] args) {
        LoyaltyPremiumMember member=new LoyaltyPremiumMember("MEM01");
        member.chargeLateFee(200);
        System.out.println("Total Late Fee: "+member.getTotalLateFees());
        int[] history=member.getLateFeeHistory();
        history[0]=999;
        System.out.println("Stored Fee: "+member.getLateFeeHistory()[0]);
    }
}