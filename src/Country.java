import java.util.ArrayList;
import java.util.List;

    public class Country {
        int id;
        String name;
        Continent continent;
        List<City> cities;

        public Country(int id, String name, Continent continent) {
            this.id = id;
            this.name = name;
            this.continent = continent;
            this.cities = new ArrayList<>();
        }

        public void addCity(City city) {
            cities.add(city);
        }

        @Override
        public String toString() {
            return "Country{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
}