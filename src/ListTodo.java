import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ListTodo {
    private static final Scanner sc = new Scanner(System.in);
    private ArrayList<ToDo> lists;

    public ListTodo() {
        lists = new ArrayList<>();
    }

    public ArrayList<ToDo> getLists() {
        return lists;
    }

    public void todoLists() {
        if (lists.isEmpty()) {
            System.out.println("You have no more TODOs left!!!\n");
        } else {
            System.out.println("You have " + getToDoCount() +  " TODOs left.\n");
            for (ToDo t : lists) {
                System.out.println(
                        t.getId() + ": " + t.getTitle() + (t.isFinish() ? (" (Done)") : "")
                );
            }
            System.out.println("\n");
        }
    }

    public void addTodo(ToDo t) {
        lists.add(t);
    }

    public void menuAddToDo() {
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Until: ");
        LocalDate until;
        try {
            until = LocalDate.parse(sc.nextLine());
            ToDo t = new ToDo(title, until);
            addTodo(t);
            System.out.println("Saved!!!");
        } catch (Exception e) {
            System.out.println("Invalid Until Date Format !");
        }
        System.out.println("------------------------------");
    }

    public void menuEditToDo() {
        System.out.print("Edit TODO number: ");
        int todoNumber = getNumberTodo();

        ToDo find = findTodoByNumber(todoNumber);
        if (find == null) {
            System.out.println("Todo not found !");
            return;
        }
        System.out.print("Title: ");
        String title = sc.nextLine();
        if (!title.trim().isEmpty()) {
            find.setTitle(title);
        }

        System.out.print("Until: ");
        String temp = sc.nextLine();
        if (!temp.isEmpty()) {
            LocalDate until = LocalDate.parse(temp);
            find.setUntil(until);
        }

        System.out.println("Saved!!!");
        System.out.println("------------------------------");

    }

    public void finishTodo() {
        System.out.print("Finish TODO number: ");
        int todoNumber = getNumberTodo();
        ToDo find = findTodoByNumber(todoNumber);
        find.setFinish(true);
        System.out.println("------------------------------");

    }

    public void deleteTodo() {
        System.out.print("Delete TODO number: ");
        int todoNumber = getNumberTodo();
        ToDo find = findTodoByNumber(todoNumber);
        lists.remove(find);
        System.out.println("------------------------------");

    }

    public int getNumberTodo() {
        int todoNumber = sc.nextInt();
        sc.nextLine();

        return todoNumber;
    }

    public int getToDoCount() {
        return (int) lists.stream().filter(toDo -> !toDo.isFinish()).count();
    }

    public ToDo findTodoByNumber(int todoNumber) {

        return lists.stream()
                .filter(toDo -> toDo.getId() == todoNumber)
                .findFirst()
                .orElse(null);
    }
}
