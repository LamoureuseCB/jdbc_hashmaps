public class City {
    int id;
    String name;
    int countryId;

    public City(int id, String name, int countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryName=" + Main.countries.get(countryId).name +
                ", continentName=" + Main.countries.get(countryId).continent.name +
                '}';
    }
}
