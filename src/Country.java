public class Country {
    int id;
    String name;
    Continent continent;

    public Country(int id, String name, Continent continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continentName=" + continent.name +
                '}';
    }
}