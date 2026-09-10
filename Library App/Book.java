public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String isbn) {
        if (title == null || title.trim().equals("")) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        if (author == null || author.trim().equals("")) {
            throw new IllegalArgumentException("Author cannot be blank.");
        }
        if (isbn == null || isbn.trim().equals("")) {
            throw new IllegalArgumentException("ISBN cannot be blank.");
        }

        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void checkout() {
        if (!available) {
            throw new IllegalStateException("Book is already checked out.");
        }
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String toString() {
        String status = available ? "Available" : "Checked Out";
        return title + " by " + author + " | ISBN: " + isbn + " | " + status;
    }
}
