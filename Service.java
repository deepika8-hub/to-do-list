import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Service {

    private LocalDate dueDate;
    private ArrayList<model> taskList = new ArrayList<>();
    private int taskIdCounter = 1;
    private final String FILE_NAME = "tasks.txt";

    public Service() {
    loadFromFile();
    }

    public void addTask(String title) {
        model task = new model(taskIdCounter++, title);
        taskList.add(task);
        System.out.println("Task added successfully!");
        saveToFile();
    }


    public void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n--- Task List ---");
        for (model task : taskList) {
            System.out.println(task);
        }
    }

    public void markTaskCompleted(int id) {
        for (model task : taskList) {
            if (task.getId() == id) {
                task.setCompleted(true);
                System.out.println("Task marked as completed!");
                saveToFile();
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
                saveToFile();
                return;
            }   
        }
        System.out.println("Task with given ID not found.");

    }

    public boolean isEmpty() {
        return taskList.isEmpty();
    }
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (model task : taskList) {
                writer.write(task.getId() + "," +
                            task.getTitle() + "," +
                            task.isCompleted());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
    } 
    private void loadFromFile() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return; // No file yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                boolean completed = Boolean.parseBoolean(parts[2]);

                model task = new model(id, title);
                task.setCompleted(completed);

                taskList.add(task);

                if (id >= taskIdCounter) {
                    taskIdCounter = id + 1;
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading tasks from file.");
        }
    }   
} 
