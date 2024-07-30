import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LibraryManagementTest {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(3, "1984", "George Orwell"));
        books.add(new Book(4, "Moby Dick", "Herman Melville"));

        // Linear Search
        System.out.println("Linear Search:");
        Book book = LinearSearch.searchByTitle(books, "1984");
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }

        // Sort books by title for Binary Search
        books.sort(Comparator.comparing(Book::getTitle));

        // Binary Search
        System.out.println("\nBinary Search:");
        book = BinarySearch.searchByTitle(books, "To Kill a Mockingbird");
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }
}
