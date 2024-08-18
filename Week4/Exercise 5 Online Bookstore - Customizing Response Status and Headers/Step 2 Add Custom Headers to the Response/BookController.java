//Example for POST (Creating a New Book)
@PostMapping
public ResponseEntity<Book> createBook(@RequestBody Book book) {
    books.add(book);
    return ResponseEntity.status(HttpStatus.CREATED)
            .header("X-Custom-Header", "CustomHeaderValue")
            .body(book);
}
