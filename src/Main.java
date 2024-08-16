import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<Integer, Continent> continents = new HashMap<>();
    static Map<Integer, Country> countries = new HashMap<>();
    static Map<Integer, City> cities = new HashMap<>();

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(getContinents(connection));
    }

    static List<Continent> getContinents(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        List<Continent> continentList = new ArrayList<>();
        ResultSet rsContinent = statement.executeQuery("SELECT * FROM continents");
        while (rsContinent.next()) {
            int id = rsContinent.getInt("id");
            continents.put(id, new Continent(id, rsContinent.getString("name")));
        }

        ResultSet rsCountry = statement.executeQuery("SELECT * FROM countries");
        while (rsCountry.next()) {
            int id = rsCountry.getInt("id");
            int continentId = rsCountry.getInt("continent_id");
            Continent continent = continents.get(continentId);
            Country country = new Country(id, rsCountry.getString("name"), continent);
            countries.put(id, country);
            continent.countries.add(country);
        }

        ResultSet rsCity = statement.executeQuery("SELECT * FROM cities");
        while (rsCity.next()) {
            int id = rsCity.getInt("id");
            int countryId = rsCity.getInt("country_id");
            City city = new City(id, rsCity.getString("name"), countryId);
            cities.put(id, city);

            Country country = countries.get(countryId);
            if (country != null) {
                country.addCity(city);
            }
        }
        for (Continent continent : continents.values()) {
            continentList.add(continent);
        }

        return continentList;
    }
}



