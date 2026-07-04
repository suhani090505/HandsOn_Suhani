class TaskLinkedList {
    Node head;

    // Add Task
    void addTask(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Search Task
    Task searchTask(int taskId) {
        Node temp = head;

        while (temp != null) {
            if (temp.task.taskId == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }

        return null;
    }

    // Traverse Tasks
    void displayTasks() {
        Node temp = head;

        while (temp != null) {
            System.out.println(
                    "Task ID: " + temp.task.taskId +
                            ", Task Name: " + temp.task.taskName +
                            ", Status: " + temp.task.status
            );
            temp = temp.next;
        }
    }

    // Delete Task
    void deleteTask(int taskId) {

        if (head == null)
            return;

        if (head.task.taskId == taskId) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null &&
                temp.next.task.taskId != taskId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}