package constructors_java_keywords_concepts.class_problems;

class LibraryBook {
    String title;
    String isbn;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    void display() {
        System.out.println(title + " - ISBN: " + isbn);
    }

    public static void main(String[] args) {
        LibraryBook b1 = new LibraryBook("Java Basics", "978-111111");
        LibraryBook b2 = new LibraryBook("Data Structures");
        LibraryBook b3 = new LibraryBook("Operating Systems", "978-333333");

        b1.display();
        b2.display();
        b3.display();
    }
}