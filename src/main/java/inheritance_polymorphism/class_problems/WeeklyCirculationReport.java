package inheritance_polymorphism.class_problems;
class ReportLibraryMember {
    protected String memberId;
    public ReportLibraryMember(String memberId) {
        this.memberId=memberId;
    }
    public void displayInfo() {
        System.out.println("Library Member");
    }
}
class ReportStudentMember extends ReportLibraryMember {
    private String course;
    public ReportStudentMember(String memberId,String course) {
        super(memberId);
        this.course=course;
    }
    public String getCourse() {
        return course;
    }
    @Override
    public void displayInfo() {
        System.out.println("Student Member | Course: "+course);
    }
}
public class WeeklyCirculationReport {
    public static String batchPrint(ReportLibraryMember[] members) {
        StringBuilder report=new StringBuilder();
        for(ReportLibraryMember member:members) {
            if(member==null)
                continue;
            member.displayInfo();
            report.append(member.memberId).append(" | ");
            if(member instanceof ReportStudentMember) {
                ReportStudentMember student=(ReportStudentMember)member;
                report.append("Course: ").append(student.getCourse());
            } else {
                report.append("Regular Member");
            }
            report.append(" | ");
        }
        return report.toString();
    }
    public static void main(String[] args) {
        ReportLibraryMember member1=new ReportLibraryMember("LB1");
        ReportStudentMember member2=new ReportStudentMember("STU1","CSE");
        ReportLibraryMember[] members={member1,member2};
        System.out.println(batchPrint(members));
    }
}