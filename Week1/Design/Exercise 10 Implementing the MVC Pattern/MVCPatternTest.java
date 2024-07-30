public class MVCPatternTest {
    public static void main(String[] args) {
        // Create a student
        Student student = new Student("John Doe", 123, "A");

        // Create a view to display student details
        StudentView view = new StudentView();

        // Create a controller to manage the student and view
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Smith");
        controller.setStudentId(456);
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }
}
