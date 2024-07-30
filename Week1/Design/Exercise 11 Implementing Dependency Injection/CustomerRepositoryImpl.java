public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // In a real application, this might fetch data from a database
        return "Customer with ID: " + id;
    }
}
