public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create an instance of the concrete repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to get customer details
        String customerDetails = customerService.getCustomerDetails(101);
        System.out.println(customerDetails);
    }
}
