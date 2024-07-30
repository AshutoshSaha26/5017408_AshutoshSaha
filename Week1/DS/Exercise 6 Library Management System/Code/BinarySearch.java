import java.util.List;

public class BinarySearch {
    public static Book searchByTitle(List<Book> books, String title) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Book midBook = books.get(mid);

            int compareResult = midBook.getTitle().compareToIgnoreCase(title);

            if (compareResult == 0) {
                return midBook;
            } else if (compareResult < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // Book not found
    }
}
