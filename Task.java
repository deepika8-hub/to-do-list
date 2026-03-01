public class Task {

    private int id;
    private String title;
    private boolean isCompleted;

    // Constructor
    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.isCompleted = false;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Setter for completion
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // toString method
    @Override
    public String toString() {
        return "ID: " + id +
               " | Title: " + title +
               " | Status: " + (isCompleted ? "Completed" : "Pending");
    }
}