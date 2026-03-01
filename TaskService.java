import java.util.ArrayList;

public class TaskService {

    private ArrayList<Task> taskList = new ArrayList<>();
    private int taskIdCounter = 1;

    public void addTask(String title) {
        Task task = new Task(taskIdCounter++, title);
        taskList.add(task);
        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n--- Task List ---");
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    public void markTaskCompleted(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                task.setCompleted(true);
                System.out.println("Task marked as completed!");
                return;
            }
        }
        System.out.println("Task with given ID not found.");
    }

    public void deleteTask(int id) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                taskList.remove(i);
                System.out.println("Task deleted successfully!");
                return;
            }
        }
        System.out.println("Task with given ID not found.");
    }

    public boolean isEmpty() {
        return taskList.isEmpty();
    }
}