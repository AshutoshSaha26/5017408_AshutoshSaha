//Example for GET by ID (Book Not Found)
@GetMapping("/{id}")
public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    Book book = books.stream()
            .filter(b -> b.getId().equals(id))
            .findFirst()
            .orElse(null);

    if (book == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Returns 404 Not Found
    }

    return new ResponseEntity<>(book, HttpStatus.OK);
}
