import java.util.ArrayList;
import java.util.List;

public class Continent {
    int id;
    String name;
    List<Country> countries;

    public Continent(int id, String name) {
        this.id = id;
        this.name = name;
        this.countries = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Continent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}