package Data_Structures.class_problems;

abstract class Question {
    String question;
    int marks;

    Question(String question, int marks) {
        this.question = question;
        this.marks = marks;
    }

    abstract int evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    String correct;

    MultipleChoiceQuestion(String q, int marks, String correct) {
        super(q, marks);
        this.correct = correct;
    }

    int evaluate(String answer) {
        return answer.equalsIgnoreCase(correct) ? marks : 0;
    }
}

class TrueFalseQuestion extends Question {
    boolean correct;

    TrueFalseQuestion(String q, int marks, boolean correct) {
        super(q, marks);
        this.correct = correct;
    }

    int evaluate(String answer) {
        return Boolean.parseBoolean(answer) == correct ? marks : 0;
    }
}

class ShortAnswerQuestion extends Question {
    String correct;

    ShortAnswerQuestion(String q, int marks, String correct) {
        super(q, marks);
        this.correct = correct;
    }

    int evaluate(String answer) {
        return answer.equalsIgnoreCase(correct) ? marks : 0;
    }
}

class Attempt {
    boolean submitted = false;
    int score = 0;

    void answer(Question q, String answer) {
        if (submitted) {
            System.out.println("Attempt already submitted.");
            return;
        }

        score += q.evaluate(answer);
    }

    void submit() {
        submitted = true;
        System.out.println("Exam submitted.");
        System.out.println("Score: " + score);
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Examination {
    String name;

    Examination(String name) {
        this.name = name;
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Student student = new Student("Asha");
        Examination exam = new Examination("Java Exam");

        Question q1 = new MultipleChoiceQuestion("Java is OOP?", 5, "C");
        Question q2 = new TrueFalseQuestion("Java supports threads?", 5, true);

        Attempt attempt = new Attempt();

        System.out.println(student.name + " started " + exam.name);

        attempt.answer(q1, "C");
        attempt.answer(q2, "false");

        attempt.submit();

        attempt.answer(q1, "C");
    }
}