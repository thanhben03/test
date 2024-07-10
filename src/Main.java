import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ListTodo managerList = new ListTodo();

    public static void main(String[] args) {
        int choose;
        boolean running = true;
        while (running) {
            System.out.println("Welcome!\n");
            managerList.todoLists();
            mainMenu();
            System.out.print("Input: ");
            choose = getUserChoice();

            switch (choose) {
                case 1:
                    managerList.menuAddToDo();
                    break;
                case 2:
                    managerList.menuEditToDo();
                    break;
                case 3:
                    managerList.finishTodo();
                    break;
                case 4:
                    managerList.deleteTodo();
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }

    private static void mainMenu() {
        System.out.println(
                "1. Create TODO\n" +
                "2. Edit TODO\n" +
                "3. Finish TODO\n" +
                "4. Delete TODO\n" +
                "5. Exit");

    }

    private static int getUserChoice() {
        int choice = -1;
        try {
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            System.out.println("Invalid please select again!");
            sc.nextLine(); // Clear the invalid input
        }
        return choice;
    }


}
