import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Student> students;
    private ArrayList<Loan> loans;

    public Library() {
        books = new ArrayList<Book>();
        students = new ArrayList<Student>();
        loans = new ArrayList<Loan>();
    }

    public void addBook(Book book) {
        if (book == null) {
            return;
        }

        if (findBookByIsbn(book.getIsbn()) == null) {
            books.add(book);
        }
    }

    public void addStudent(Student student) {
        if (student == null) {
            return;
        }

        if (findStudentById(student.getStudentId()) == null) {
            students.add(student);
        }
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    public boolean checkoutBook(String isbn, String studentId) {
        Book book = findBookByIsbn(isbn);
        Student student = findStudentById(studentId);

        if (book == null || student == null || !book.isAvailable()) {
            return false;
        }

        book.checkout();
        loans.add(new Loan(book, student));
        return true;
    }

    public boolean returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);

        if (book == null || book.isAvailable()) {
            return false;
        }

        for (Loan loan : loans) {
            if (loan.isActive()
                    && loan.getBook().getIsbn().equalsIgnoreCase(isbn)) {
                loan.closeLoan();
                book.returnBook();
                return true;
            }
        }

        return false;
    }

    public void displayBooks() {
        if (books.size() == 0) {
            System.out.println("No books in library.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayStudents() {
        if (students.size() == 0) {
            System.out.println("No students registered.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displayActiveLoans() {
        boolean found = false;

        for (Loan loan : loans) {
            if (loan.isActive()) {
                System.out.println(loan);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No active loans.");
        }
    }
}
