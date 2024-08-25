@GetMapping("/search")
public ResponseEntity<List<Book>> searchBooks(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String author) {

    List<Book> filteredBooks = books;

    if (title != null && !title.isEmpty()) {
        filteredBooks = filteredBooks.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();
    }

    if (author != null && !author.isEmpty()) {
        filteredBooks = filteredBooks.stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .toList();
    }

    return new ResponseEntity<>(filteredBooks, HttpStatus.OK);
}
