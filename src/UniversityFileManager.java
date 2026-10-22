
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class UniversityFileManager {

    private static final String FILE_NAME = "universities.txt";

    // Save universities to a file
    public static void saveUniversities(ArrayList<University> universities) {

        try (FileWriter writer = new FileWriter(FILE_NAME)) {

            for (University university : universities) {
                writer.write(university.name + "\n");
                writer.write(university.program + "\n");
                writer.write(university.status + "\n");
            }

            System.out.println("Universities saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving universities: " + e.getMessage());
        }
    }

    // Load universities from a file
    public static ArrayList<University> loadUniversities() {

        ArrayList<University> universities = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String name;

            while ((name = reader.readLine()) != null) {

                String program = reader.readLine();
                String status = reader.readLine();

                if (program == null || status == null) {
                    System.out.println("Warning: Incomplete university record.");
                    break;
                }

                University university = new University(name, program);
                university.status = status;

                universities.add(university);
            }

            System.out.println("Universities loaded: " + universities.size());

        } catch (FileNotFoundException e) {
            System.out.println("No saved universities found yet.");
        } catch (IOException e) {
            System.out.println("Error loading universities: " + e.getMessage());
        }

        return universities;
    }
}
