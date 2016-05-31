package URise.HomeWork1;

/**
 * Created by O&J on 31.05.2016.
 */
public class Resume {
    private int id;
    private String name;

    public Resume() {
    }

    public Resume(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Resume(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Номер нашего резюме: " + id + name + "\n";
    }
}
