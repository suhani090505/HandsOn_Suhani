public class MVCPatternTest {

    public static void main(String[] args) {

        // Create Model
        Student student =
                new Student("Suhani", 101, "A");

        // Create View
        StudentView view =
                new StudentView();

        // Create Controller
        StudentController controller =
                new StudentController(
                        student, view);

        System.out.println("Initial Student Data:");
        controller.updateView();

        // Update Student Details
        controller.setStudentName("Priya");
        controller.setStudentGrade("A+");

        System.out.println("\nUpdated Student Data:");
        controller.updateView();
    }
}