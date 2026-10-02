package Data_Structures.assigment_problems;

interface NotificationChannel {
    void send(String student, String title);
}

class EmailChannel implements NotificationChannel {
    public void send(String student, String title) {
        System.out.println("Email to " + student + ": " + title);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String student, String title) {
        System.out.println("SMS to " + student + ": " + title);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String student, String title) {
        System.out.println("App to " + student + ": " + title);
    }
}

class NoticeStudent {
    String name;
    String department;
    NotificationChannel[] channels;

    NoticeStudent(String name, String department, NotificationChannel... channels) {
        this.name = name;
        this.department = department;
        this.channels = channels;
    }

    void notifyStudent(String title) {
        for (NotificationChannel c : channels)
            c.send(name, title);
    }
}

class Notice {
    String title;
    String[] departments;

    Notice(String title, String... departments) {
        this.title = title;
        this.departments = departments;
    }

    boolean valid() {
        return !title.isEmpty() && departments.length > 0;
    }

    boolean targets(String department) {
        for (String d : departments) {
            if (d.equals(department))
                return true;
        }
        return false;
    }
}

class NoticeBoard {
    NoticeStudent[] students;

    NoticeBoard(NoticeStudent... students) {
        this.students = students;
    }

    void post(Notice notice) {
        if (!notice.valid()) {
            System.out.println("Notice rejected.");
            return;
        }

        System.out.println("Notice: " + notice.title);

        for (NoticeStudent s : students) {
            if (notice.targets(s.department))
                s.notifyStudent(notice.title);
        }
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeStudent asha = new NoticeStudent(
                "Asha", "CSE",
                new EmailChannel(), new AppChannel());

        NoticeStudent ravi = new NoticeStudent(
                "Ravi", "ECE",
                new SmsChannel());

        NoticeBoard board = new NoticeBoard(asha, ravi);

        board.post(new Notice("Lab Closed Tomorrow", "CSE"));
        board.post(new Notice("Fee Deadline Extended", "CSE", "ECE"));
        board.post(new Notice("Sports Day"));
    }
}