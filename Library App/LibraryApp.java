import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();
        int choice = -1;

        while (choice != 0) {
            printMenu();

            String choiceText = input.nextLine();

            try {
                choice = Integer.parseInt(choiceText);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice.");
                System.out.println();
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter title: ");
                String title = input.nextLine();

                System.out.print("Enter author: ");
                String author = input.nextLine();

                System.out.print("Enter ISBN: ");
                String isbn = input.nextLine();

                if (library.findBookByIsbn(isbn) != null) {
                    System.out.println("A book with that ISBN already exists.");
                } else {
                    try {
                        library.addBook(new Book(title, author, isbn));
                        System.out.println("Book added.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Could not add book: " + e.getMessage());
                    }
                }

            } else if (choice == 2) {
                System.out.print("Enter student name: ");
                String name = input.nextLine();

                System.out.print("Enter student ID: ");
                String studentId = input.nextLine();

                if (library.findStudentById(studentId) != null) {
                    System.out.println("A student with that ID already exists.");
                } else {
                    try {
                        library.addStudent(new Student(name, studentId));
                        System.out.println("Student added.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Could not add student: " + e.getMessage());
                    }
                }

            } else if (choice == 3) {
                library.displayBooks();

            } else if (choice == 4) {
                library.displayStudents();

            } else if (choice == 5) {
                System.out.print("Enter ISBN or exact title: ");
                String search = input.nextLine();

                Book book = library.findBookByIsbn(search);

                if (book == null) {
                    book = library.findBookByTitle(search);
                }

                if (book == null) {
                    System.out.println("Book not found.");
                } else {
                    System.out.println(book);
                }

            } else if (choice == 6) {
                System.out.print("Enter ISBN: ");
                String isbn = input.nextLine();

                System.out.print("Enter student ID: ");
                String studentId = input.nextLine();

                Book book = library.findBookByIsbn(isbn);
                Student student = library.findStudentById(studentId);

                if (book == null) {
                    System.out.println("Checkout failed: ISBN not found.");
                } else if (student == null) {
                    System.out.println("Checkout failed: student ID not found.");
                } else if (!book.isAvailable()) {
                    System.out.println("Checkout failed: that book is not available.");
                } else if (library.checkoutBook(isbn, studentId)) {
                    System.out.println("Checkout successful.");
                    System.out.println(book.getTitle() + " is now checked out to "
                            + student.getName() + ".");
                }

            } else if (choice == 7) {
                System.out.print("Enter ISBN: ");
                String isbn = input.nextLine();

                if (library.returnBook(isbn)) {
                    System.out.println("Book returned.");
                } else {
                    System.out.println("Return failed. Check the ISBN or book status.");
                }

            } else if (choice == 8) {
                library.displayActiveLoans();

            } else if (choice == 0) {
                System.out.println("Goodbye.");

            } else {
                System.out.println("Invalid choice.");
            }

            System.out.println();
        }

        input.close();
    }

    public static void printMenu() {
        System.out.println("===== SCHOOL LIBRARY SYSTEM =====");
        System.out.println("1. Add Book");
        System.out.println("2. Add Student");
        System.out.println("3. List Books");
        System.out.println("4. List Students");
        System.out.println("5. Search for Book");
        System.out.println("6. Check Out Book");
        System.out.println("7. Return Book");
        System.out.println("8. View Active Loans");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
}
