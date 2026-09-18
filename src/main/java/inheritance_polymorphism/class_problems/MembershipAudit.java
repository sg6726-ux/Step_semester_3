package inheritance_polymorphism.class_problems;
class AuditLibraryMember {
    private static int count=100;
    private final String memberNumber;
    private int booksBorrowed;
    public AuditLibraryMember() {
        memberNumber="LIB-"+(++count);
    }
    public String getMemberNumber() {
        return memberNumber;
    }
    public void borrowBook() {
        booksBorrowed++;
    }
    public void borrowBook(String genre) {
        borrowBook();
    }
    public int getBooksBorrowed() {
        return booksBorrowed;
    }
}
class AuditFacultyMember extends AuditLibraryMember {
}
public class MembershipAudit {
    public static boolean isValidRenewalCode(String code) {
        if(code==null || code.length()!=4)
            return false;
        return code.charAt(0)=='R' &&
                Character.isDigit(code.charAt(1)) &&
                Character.isDigit(code.charAt(2)) &&
                Character.isUpperCase(code.charAt(3));
    }
    public static String processNightlyAudit(AuditLibraryMember[] members) {
        int processed=0,nullCount=0,faculty=0,regular=0;
        for(AuditLibraryMember member:members) {
            if(member==null) {
                nullCount++;
                continue;
            }
            processed++;
            if(member instanceof AuditFacultyMember)
                faculty++;
            else
                regular++;
        }
        return processed+" processed | "+nullCount+" null skipped | "+faculty+" faculty | "+regular+" regular";
    }
    public static void main(String[] args) {
        AuditLibraryMember member=new AuditLibraryMember();
        System.out.println(member.getMemberNumber());
        member.borrowBook();
        member.borrowBook("Fiction");
        System.out.println(member.getBooksBorrowed());
        System.out.println(isValidRenewalCode("R12A"));
        System.out.println(isValidRenewalCode("R1A"));
        System.out.println(isValidRenewalCode("X12A"));
        AuditLibraryMember faculty=new AuditFacultyMember();
        AuditLibraryMember[] members={member,faculty,null};
        System.out.println(processNightlyAudit(members));
    }
}