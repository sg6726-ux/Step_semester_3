package inheritance_polymorphism.class_problems;
class FineLibraryMember {
    protected String memberId;
    private int totalFine;
    private int[] fineHistory=new int[10];
    private int count;
    public FineLibraryMember(String memberId) {
        this.memberId=memberId;
    }
    public void chargeFine(int amount) {
        if(count<fineHistory.length)
            fineHistory[count++]=amount;
        totalFine+=amount;
    }
    public int[] getFineHistory() {
        int[] copy=new int[count];
        for(int i=0;i<count;i++)
            copy[i]=fineHistory[i];
        return copy;
    }
    public int getTotalFine() {
        return totalFine;
    }
}
class FineStudentMember extends FineLibraryMember {
    public FineStudentMember(String memberId) {
        super(memberId);
    }
    @Override
    public void chargeFine(int amount) {
        super.chargeFine(amount/2);
    }
}
public class StudentDiscountFineLedger {
    public static void main(String[] args) {
        FineStudentMember student=new FineStudentMember("STU10");
        student.chargeFine(100);
        System.out.println("Total Fine: "+student.getTotalFine());
        int[] history=student.getFineHistory();
        history[0]=999;
        System.out.println("Stored Fine: "+student.getFineHistory()[0]);
    }
}