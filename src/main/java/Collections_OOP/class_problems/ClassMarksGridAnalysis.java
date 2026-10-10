package Collections_OOP.class_problems;
import java.util.*;
public class ClassMarksGridAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<int[]> marks = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\\s+");
            names.add(p[0]);
            String[] m = line.substring(line.indexOf('[') + 1,
                    line.indexOf(']')).split(",");
            marks.add(new int[]{
                    Integer.parseInt(m[0].trim()),
                    Integer.parseInt(m[1].trim()),
                    Integer.parseInt(m[2].trim())
            });
        }
        int[] totals = new int[names.size()];
        double[] sums = new double[3];
        int topper = 0;
        System.out.print("Totals ");
        for (int i = 0; i < marks.size(); i++) {
            int[] m = marks.get(i);
            totals[i] = m[0] + m[1] + m[2];
            for (int j = 0; j < 3; j++)
                sums[j] += m[j];
            if (totals[i] > totals[topper])
                topper = i;
            System.out.print(names.get(i) + " " + totals[i]);
            if (i < marks.size() - 1) System.out.print(", ");
        }
        System.out.printf("%naverages %.2f, %.2f, %.2f%n",
                sums[0] / marks.size(),
                sums[1] / marks.size(),
                sums[2] / marks.size());
        System.out.println("topper " + names.get(topper) +
                " (" + totals[topper] + ")");
        sc.close();
    }
}