@GetMapping("/{id}")
public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    Book book = books.stream()
            .filter(b -> b.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

    return ResponseEntity.ok(book);
}
