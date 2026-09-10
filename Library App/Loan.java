public class Loan {
    private Book book;
    private Student student;
    private boolean active;

    public Loan(Book book, Student student) {
        if (book == null || student == null) {
            throw new IllegalArgumentException("Book and student are required.");
        }

        this.book = book;
        this.student = student;
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void closeLoan() {
        active = false;
    }

    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }

    public String toString() {
        String status = active ? "Active" : "Returned";
        return book.getTitle() + " -> " + student.getName() + " | " + status;
    }
}
