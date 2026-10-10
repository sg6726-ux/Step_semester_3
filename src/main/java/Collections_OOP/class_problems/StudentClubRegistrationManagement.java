package Collections_OOP.class_problems;
import java.util.*;
public class StudentClubRegistrationManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> members = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\\s+");
            if (p[0].equals("ADD")) {
                if (members.containsKey(p[1]))
                    System.out.println("duplicate rejected");
                else {
                    members.put(p[1], p[2]);
                    System.out.println("Added");
                }
            } else if (p[0].equals("CONTAINS")) {
                System.out.println("contains: " + members.containsKey(p[1]));
            }
        }
        System.out.println("member count " + members.size());
        sc.close();
    }
}