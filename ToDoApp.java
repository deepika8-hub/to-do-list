import java.util.Scanner;

public class ToDoApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {

            System.out.println("\n===== TO DO LIST MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Exit");
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
                    System.out.println("Add Task selected");
                    break;

                case 2:
                    System.out.println("View Tasks selected");
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        }
    }
}