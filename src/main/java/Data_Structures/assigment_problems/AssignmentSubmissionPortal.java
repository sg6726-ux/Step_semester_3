package Data_Structures.assigment_problems;

abstract class Assignment {
    String name;
    double maxMarks;

    Assignment(String name, double maxMarks) {
        this.name = name;
        this.maxMarks = maxMarks;
    }

    abstract double penalty(int lateDays);
}

class CodingAssignment extends Assignment {
    CodingAssignment(String name, double marks) {
        super(name, marks);
    }

    double penalty(int lateDays) {
        return lateDays * 10;
    }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String name, double marks) {
        super(name, marks);
    }

    double penalty(int lateDays) {
        return lateDays * 20;
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Submission {
    Student student;
    Assignment assignment;
    boolean submitted = false;
    boolean graded = false;
    double marks;

    Submission(Student student, Assignment assignment) {
        this.student = student;
        this.assignment = assignment;
    }

    void submit(int lateDays) {
        if (graded) {
            System.out.println("Cannot resubmit after grading.");
            return;
        }

        submitted = true;
        System.out.println(student.name + " submitted " + assignment.name);

        if (lateDays > 0)
            System.out.println("Late submission.");
    }

    void grade(double awarded, int lateDays) {
        if (!submitted) {
            System.out.println("Cannot grade before submission.");
            return;
        }

        if (graded) {
            System.out.println("Already graded.");
            return;
        }

        double penalty = awarded * assignment.penalty(lateDays) / 100;
        marks = awarded - penalty;
        graded = true;

        System.out.println("Final marks: " + marks + "/" + assignment.maxMarks);
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding = new CodingAssignment("Linked List Lab", 50);
        Assignment written = new WrittenAssignment("Design Essay", 50);

        Submission s1 = new Submission(asha, coding);
        s1.submit(0);
        s1.grade(45, 0);
        s1.submit(0);

        Submission s2 = new Submission(ravi, written);
        s2.submit(2);
        s2.grade(40, 2);
    }
}