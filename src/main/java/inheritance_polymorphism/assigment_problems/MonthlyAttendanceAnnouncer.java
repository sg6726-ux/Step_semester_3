package inheritance_polymorphism.assigment_problems;
class AttendanceGymMember {
    protected String memberId;
    protected int sessions;
    public AttendanceGymMember(String memberId) {
        this.memberId=memberId;
    }
    public void attendSession() {
        sessions++;
    }
    public int getSessionsAttended() {
        return sessions;
    }
    public void displayInfo() {
        System.out.println("Standard | Sessions: "+sessions);
    }
}
class AttendancePremiumMember extends AttendanceGymMember {
    private String trainerName;

    public AttendancePremiumMember(String memberId,String trainerName) {
        super(memberId);
        this.trainerName=trainerName;
    }
    public String getTrainerName() {
        return trainerName;
    }
    @Override
    public void displayInfo() {
        System.out.println("Premium | Trainer: "+trainerName+" | Sessions: "+sessions);
    }
}
public class MonthlyAttendanceAnnouncer {
    public static String batchPrint(AttendanceGymMember[] members) {
        StringBuilder report=new StringBuilder();
        for(AttendanceGymMember member:members) {
            if(member==null)
                continue;
            member.displayInfo();
            report.append("Standard | Sessions: ").append(member.getSessionsAttended());
            if(member instanceof AttendancePremiumMember) {
                AttendancePremiumMember premium=(AttendancePremiumMember)member;
                report.append(" | Premium | Trainer: ").append(premium.getTrainerName());
                report.append(" | Sessions: ").append(premium.getSessionsAttended());
                report.append(" [Trainer via downcast: ").append(premium.getTrainerName()).append("]");
            }
            report.append(" | ");
        }
        return report.toString();
    }
    public static void main(String[] args) {
        AttendanceGymMember standard=new AttendanceGymMember("GM01");
        AttendancePremiumMember premium=new AttendancePremiumMember("GM02","Coach Riya");
        AttendanceGymMember[] members={standard,premium};
        System.out.println(batchPrint(members));
    }
}