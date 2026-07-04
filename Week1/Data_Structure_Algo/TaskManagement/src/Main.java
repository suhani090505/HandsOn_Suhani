public class Main {
    public static void main(String[] args) {

        TaskLinkedList list = new TaskLinkedList();

        list.addTask(new Task(1, "Design UI", "Pending"));
        list.addTask(new Task(2, "Write Code", "In Progress"));
        list.addTask(new Task(3, "Testing", "Pending"));

        System.out.println("Tasks:");
        list.displayTasks();

        System.out.println("\nSearching Task ID 2:");
        Task task = list.searchTask(2);

        if (task != null) {
            System.out.println(
                    task.taskId + " " +
                            task.taskName + " " +
                            task.status
            );
        } else {
            System.out.println("Task Not Found");
        }

        System.out.println("\nDeleting Task ID 2");
        list.deleteTask(2);

        System.out.println("\nTasks After Deletion:");
        list.displayTasks();
    }
}