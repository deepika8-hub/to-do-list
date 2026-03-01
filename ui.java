import java.util.Scanner;

public class ui {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int choice;
        Service service = new Service();
        while (true) {

            System.out.println("\n===== TO DO LIST MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // clear invalid input
                continue;
            }
             switch (choice) {

                case 1:
                    scanner.nextLine();
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    service.addTask(title);
                    break;

                case 2:
                    service.viewTasks();
                    break;

               case 3:
                       if (service.isEmpty()) {
                            System.out.println("No tasks available to update.");
                            break;
                        }

                        System.out.print("Enter Task ID to mark as completed: ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid input!");
                            scanner.next();
                            break;
                        }

                        int idToComplete = scanner.nextInt();
                        service.markTaskCompleted(idToComplete);
                        break;
                case 4:
                    if (service.isEmpty()) {
                    System.out.println("No tasks available to delete.");
                    break;
                }

                System.out.print("Enter Task ID to delete: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input!");
                    scanner.next();
                    break;
                }

                int idToDelete = scanner.nextInt();
                service.deleteTask(idToDelete);
                break;

                case 5:
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        }
    }
}