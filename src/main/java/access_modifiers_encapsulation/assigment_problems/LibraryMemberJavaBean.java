package access_modifiers_encapsulation.assigment_problems;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class LibraryMemberJavaBean {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;
    public LibraryMemberJavaBean() {
    }
    public String getMembershipId() {
        return membershipId;
    }
    public void setMembershipId(String id) {
        if (membershipId == null) {
            membershipId = id;
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isPremiumMember() {
        return premiumMember;
    }
    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }
    public void setSecurityAnswer(String answer) {
        if (answer == null) {
            securityAnswer = null;
            return;
        }
        securityAnswer = transform(answer);
    }
    private String transform(String value) {
        try {
            MessageDigest digest =
                    MessageDigest.getInstance("SHA-256");
            byte[] result = digest.digest(
                    value.getBytes(StandardCharsets.UTF_8)
            );
            StringBuilder output = new StringBuilder();
            for (byte b : result) {
                output.append(String.format("%02x", b));
            }
            return output.toString();
        } catch (NoSuchAlgorithmException e) {
            return Integer.toHexString(value.hashCode());
        }
    }
    public static void main(String[] args) {
        LibraryMemberJavaBean member =
                new LibraryMemberJavaBean();
        member.setMembershipId("LIB-8841");
        member.setName("Priya Nair");
        member.setPremiumMember(true);
        System.out.println(member.getMembershipId());
        member.setMembershipId("FAKE-0000");
        System.out.println(member.getMembershipId());
        System.out.println(member.isPremiumMember());
        member.setSecurityAnswer("BlueMountain");
    }
}