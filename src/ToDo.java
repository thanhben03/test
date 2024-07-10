import java.time.LocalDate;

public class ToDo {
    private String title;
    private LocalDate until;
    private boolean finish;
    private int id;
    private static int count = 1;

    public ToDo(String title, LocalDate until) {
        this.title = title;
        this.until = until;
        this.finish = false;
        this.id = count++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setUntil(LocalDate until) {
        this.until = until;
    }

    public int getId() {
        return id;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean isFinish() {
        return finish;
    }
}
