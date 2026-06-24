public class Main {
    public static void main(String[] args) {

        EmployeeManagement em = new EmployeeManagement(5);

        em.addEmployee(new Employee(101, "John", "Manager", 60000));
        em.addEmployee(new Employee(102, "Alice", "Developer", 50000));
        em.addEmployee(new Employee(103, "Bob", "Tester", 40000));

        System.out.println("\nEmployee Records:");
        em.traverseEmployees();

        System.out.println("\nSearching Employee ID 102:");
        Employee emp = em.searchEmployee(102);

        if (emp != null) {
            emp.display();
        } else {
            System.out.println("Employee Not Found");
        }

        System.out.println("\nDeleting Employee ID 102");
        em.deleteEmployee(102);

        System.out.println("\nEmployee Records After Deletion:");
        em.traverseEmployees();
    }
}