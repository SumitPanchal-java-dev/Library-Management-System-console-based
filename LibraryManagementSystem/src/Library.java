import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void updateBook(String isbn, String newTitle, String newAuthor) {
        Optional<Book> bookOptional = books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            System.out.println("Book updated.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void deleteBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("Book deleted.");
    }

    public void searchBook(String title) {
        Optional<Book> bookOptional = books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
        if (bookOptional.isPresent()) {
            System.out.println(bookOptional.get());
        } else {
            System.out.println("Book not found.");
        }
    }
}
