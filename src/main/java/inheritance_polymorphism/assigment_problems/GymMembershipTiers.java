package inheritance_polymorphism.assigment_problems;
class TierGymMember {
    protected String memberId;
    protected int sessions;
    public TierGymMember(String memberId) {
        this.memberId=memberId;
    }
    public void attendSession() {
        sessions++;
    }
    public int getSessionsAttended() {
        return sessions;
    }
    public void displayInfo() {
        System.out.println("Standard Member | Sessions: "+sessions);
    }
}
class TierPremiumMember extends TierGymMember {
    protected String trainerName;
    public TierPremiumMember(String memberId,String trainerName) {
        super(memberId);
        this.trainerName=trainerName;
    }
    @Override
    public void displayInfo() {
        System.out.println("Premium Member | Trainer: "+trainerName+" | Sessions: "+sessions);
    }
}
class EliteMember extends TierPremiumMember {
    private String locker;
    public EliteMember(String memberId,String trainerName,String locker) {
        super(memberId,trainerName);
        this.locker=locker;
    }
    @Override
    public void displayInfo() {
        System.out.println("Elite Member | Trainer: "+trainerName+" | Locker: "+locker+" | Sessions: "+sessions);
    }
}
class GroupClassMember extends TierGymMember {
    private String className;
    public GroupClassMember(String memberId,String className) {
        super(memberId);
        this.className=className;
    }
    @Override
    public void displayInfo() {
        System.out.println("Group Class Member | Class: "+className+" | Sessions: "+sessions);
    }
}
public class GymMembershipTiers {
    public static String classifyGeneration(TierGymMember member) {
        if(member instanceof EliteMember)
            return "Multilevel descendant (3 generations deep)";
        if(member instanceof GroupClassMember)
            return "Hierarchical sibling (independent branch)";
        return "Standard member";
    }
    public static int getTotalSessionsAttended(TierGymMember[] members) {
        int total=0;
        for(TierGymMember member:members)
            if(member!=null)
                total+=member.getSessionsAttended();
        return total;
    }
    public static void main(String[] args) {
        TierGymMember standard=new TierGymMember("G01");
        TierPremiumMember premium=new TierPremiumMember("G02","Coach Riya");
        EliteMember elite=new EliteMember("G03","Coach Arjun","L12");
        GroupClassMember group=new GroupClassMember("G04","Zumba");
        premium.attendSession();
        premium.attendSession();
        elite.attendSession();
        elite.attendSession();
        elite.attendSession();
        group.attendSession();
        group.attendSession();
        group.attendSession();
        standard.attendSession();
        TierGymMember[] members={standard,premium,elite,group};
        standard.displayInfo();
        premium.displayInfo();
        elite.displayInfo();
        group.displayInfo();
        System.out.println(classifyGeneration(elite));
        System.out.println(classifyGeneration(group));
        System.out.println("Total Sessions: "+getTotalSessionsAttended(members));
    }
}