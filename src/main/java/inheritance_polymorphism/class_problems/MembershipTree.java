package inheritance_polymorphism.class_problems;
class TreeLibraryMember {
    protected String memberId;
    protected int booksBorrowed;
    public TreeLibraryMember(String memberId) {
        this.memberId=memberId;
    }
    public void borrowBook() {
        booksBorrowed++;
    }
    public int getBooksBorrowed() {
        return booksBorrowed;
    }
    public void displayInfo() {
        System.out.println("Library Member");
    }
}
class TreeStudentMember extends TreeLibraryMember {
    protected String course;
    public TreeStudentMember(String memberId,String course) {
        super(memberId);
        this.course=course;
    }
    @Override
    public void displayInfo() {
        System.out.println("Student Member | Course: "+course);
    }
}
class HonorsStudentMember extends TreeStudentMember {
    private String honors;
    public HonorsStudentMember(String memberId,String course,String honors) {
        super(memberId,course);
        this.honors=honors;
    }
    @Override
    public void displayInfo() {
        System.out.println("Honors Student | Course: "+course+" | Honors: "+honors);
    }
}
class FacultyMember extends TreeLibraryMember {
    private String department;
    public FacultyMember(String memberId,String department) {
        super(memberId);
        this.department=department;
    }
    @Override
    public void displayInfo() {
        System.out.println("Faculty Member | Department: "+department);
    }
}
public class MembershipTree {
    public static String classifyGeneration(TreeLibraryMember member) {
        if(member instanceof HonorsStudentMember)
            return "Multilevel descendant (3 generations deep)";
        if(member instanceof FacultyMember)
            return "Hierarchical sibling (independent branch)";
        return "Standard member";
    }
    public static int getTotalBooksBorrowed(TreeLibraryMember[] members) {
        int total=0;
        for(TreeLibraryMember member:members)
            if(member!=null)
                total+=member.getBooksBorrowed();
        return total;
    }
    public static void main(String[] args) {
        HonorsStudentMember honors=new HonorsStudentMember("H01","CSE","Gold");
        FacultyMember faculty=new FacultyMember("F01","CSE");
        TreeStudentMember student=new TreeStudentMember("S01","ECE");
        honors.borrowBook();
        honors.borrowBook();
        honors.borrowBook();
        student.borrowBook();
        student.borrowBook();
        faculty.borrowBook();
        TreeLibraryMember[] members={honors,student,faculty};
        honors.displayInfo();
        faculty.displayInfo();
        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));
        System.out.println("Total: "+getTotalBooksBorrowed(members));
    }
}