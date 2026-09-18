package inheritance_polymorphism.assigment_problems;
class GymMember {
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;
    public GymMember(String memberId,int monthlyFee) {
        if(memberId==null || memberId.trim().length()<4)
            throw new IllegalArgumentException("Invalid member ID");
        this.memberId=memberId;
        this.monthlyFee=monthlyFee;
    }
    public void attendSession() {
        sessionsAttended++;
    }
    public int getSessionsAttended() {
        return sessionsAttended;
    }
    public void displayInfo() {
        System.out.println("Standard Member | Sessions: "+sessionsAttended);
    }
}
class PremiumMember extends GymMember {
    private String trainerName;
    public PremiumMember(String memberId,int monthlyFee,String trainerName) {
        super(memberId,monthlyFee);
        this.trainerName=trainerName;
    }
    public String getTrainerName() {
        return trainerName;
    }
    @Override
    public void displayInfo() {
        System.out.println("Premium Member | Trainer: "+trainerName+" | Sessions: "+getSessionsAttended());
    }
}
public class GymMembershipFoundation {
    public static String signUpBatch(String[] memberIds,int monthlyFee) {
        int signed=0,rejected=0;
        for(String id:memberIds) {
            try {
                new GymMember(id,monthlyFee);
                signed++;
            } catch(IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Signed Up: "+signed+" | Rejected: "+rejected;
    }
    public static void main(String[] args) {
        try {
            new GymMember("GM1",1000);
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid member rejected");
        }
        PremiumMember member=new PremiumMember("MEM01",2000,"Coach Riya");
        member.attendSession();
        member.attendSession();
        System.out.println(member.getSessionsAttended());
        String[] ids={"MEM1","GM1","MEM2"," ","MEM3"};
        System.out.println(signUpBatch(ids,1000));
    }
}