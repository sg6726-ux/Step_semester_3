package constructors_java_keywords_concepts.class_problems;

class CollegeStudent {
    static String collegeName;
    static String academicYear;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2026-27";
        System.out.println("College info loaded");
    }

    CollegeStudent(String name) {
        System.out.println(name + " - Student created");
    }

    public static void main(String[] args) {
        String[] students = {
                "Ravi", "Meera", "Karthik", "Divya", "Anitha"
        };

        for (String name : students) {
            new CollegeStudent(name);
        }
    }
}