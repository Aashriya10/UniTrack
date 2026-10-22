
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:unitrack.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS universities ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "program TEXT NOT NULL, "
                + "status TEXT NOT NULL"
                + ")";

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {

            statement.execute(sql);
            System.out.println("Database connected and table is ready!");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Add a university to SQLite
    public static boolean addUniversity(University university) {
        String sql = "INSERT INTO universities (name, program, status) "
                + "VALUES (?, ?, ?)";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, university.name);
            statement.setString(2, university.program);
            statement.setString(3, university.status);

            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error adding university: " + e.getMessage());
            return false;
        }
    }

    // Read all universities from SQLite
    public static ArrayList<University> getAllUniversities() {
        ArrayList<University> universities = new ArrayList<>();

        String sql = "SELECT name, program, status "
                + "FROM universities ORDER BY id";

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                University university = new University(
                        result.getString("name"),
                        result.getString("program")
                );

                university.status = result.getString("status");
                universities.add(university);
            }

        } catch (SQLException e) {
            System.out.println("Error loading universities: " + e.getMessage());
        }

        return universities;
    }

    // Update a university's application status
    public static boolean updateStatus(
            String name, String program, String newStatus) {

        String sql = "UPDATE universities SET status = ? "
                + "WHERE id = (SELECT id FROM universities "
                + "WHERE name = ? AND program = ? ORDER BY id LIMIT 1)";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newStatus);
            statement.setString(2, name);
            statement.setString(3, program);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating status: " + e.getMessage());
            return false;
        }
    }

    // Delete a university from SQLite
    public static boolean deleteUniversity(String name, String program) {
        String sql = "DELETE FROM universities WHERE id = "
                + "(SELECT id FROM universities WHERE name = ? "
                + "AND program = ? ORDER BY id LIMIT 1)";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, program);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting university: " + e.getMessage());
            return false;
        }
    }
}
