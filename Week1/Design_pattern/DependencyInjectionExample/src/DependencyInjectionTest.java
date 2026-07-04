public class DependencyInjectionTest {

    public static void main(String[] args) {

        // Create Repository
        CustomerRepository repository =
                new CustomerRepositoryImpl();

        // Inject Repository into Service
        CustomerService service =
                new CustomerService(repository);

        service.getCustomer(101);
        service.getCustomer(200);
    }
}