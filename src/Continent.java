import java.util.ArrayList;
import java.util.List;

class Continent {
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
        StringBuilder countryNames = new StringBuilder();
        StringBuilder citiesNames = new StringBuilder();

        if (!countries.isEmpty()) {
            Country firstCountry = countries.get(0);
            countryNames.append(firstCountry.name);

            for (City city : firstCountry.cities) {
                citiesNames.append(city.name).append(", ");
            }

            if (citiesNames.length() > 0) {
                citiesNames.setLength(citiesNames.length() - 2);
            }
        }

        return "Continent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryName=" + countryNames +
                ", citiesName=[" + citiesNames + "]" +
                '}';
    }
}