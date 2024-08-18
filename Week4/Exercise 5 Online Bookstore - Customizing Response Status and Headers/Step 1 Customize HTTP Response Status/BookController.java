//Example for POST (Creating a New Book)
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@PostMapping
@ResponseStatus(HttpStatus.CREATED)  // Sets the status to 201 Created
public Book createBook(@RequestBody Book book) {
    books.add(book);
    return book;
}
