// POST - Register a customer using form data
@PostMapping("/register")
public ResponseEntity<Customer> registerCustomer(
        @RequestParam("name") String name,
        @RequestParam("email") String email,
        @RequestParam("password") String password) {

    Customer customer = new Customer(null, name, email, password);
    customers.add(customer);
    return new ResponseEntity<>(customer, HttpStatus.CREATED);
}
