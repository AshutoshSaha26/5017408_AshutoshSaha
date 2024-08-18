//Example for GET by ID (Including a Custom Header)
@GetMapping("/{id}")
public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    Book book = books.stream()
            .filter(b -> b.getId().equals(id))
            .findFirst()
            .orElse(null);

    if (book == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header("X-Book-Error", "Book not found")
                .build();
    }

    return ResponseEntity.ok()
            .header("X-Book-Header", "Fetched book details")
            .body(book);
}
