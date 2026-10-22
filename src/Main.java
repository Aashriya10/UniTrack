import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        DatabaseManager.createTable();

        Scanner scanner = new Scanner(System.in);
        ArrayList<University> universities = DatabaseManager.getAllUniversities();
        boolean running = true;

        while (running) {
            System.out.println("\n===== UniTrack =====");
            System.out.println("1. Add University");
            System.out.println("2. View Universities");
            System.out.println("3. Update Application Status");
            System.out.println("4. Delete University");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {

                case 1:
                    System.out.print("Enter university name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Master's programme: ");
                    String program = scanner.nextLine();

                    University university = new University(name, program);

                    if (DatabaseManager.addUniversity(university)) {
                        universities.add(university);
                        System.out.println("University added successfully!");
                    }
                    break;

                case 2:
                    if (universities.isEmpty()) {
                        System.out.println("No universities added yet.");
                    } else {
                        System.out.println("\n--- Your Universities ---");

                        for (int i = 0; i < universities.size(); i++) {
                            System.out.println("\nUniversity " + (i + 1));
                            universities.get(i).display();
                            System.out.println("------------------------");
                        }
                    }
                    break;

                case 3:
                    if (universities.isEmpty()) {
                        System.out.println("No universities available to update.");
                        break;
                    }

                    System.out.println("\n--- Select a University ---");

                    for (int i = 0; i < universities.size(); i++) {
                        System.out.println((i + 1) + ". " + universities.get(i).name);
                    }

                    System.out.print("Enter university number: ");
                    int universityNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (universityNumber < 1 || universityNumber > universities.size()) {
                        System.out.println("Invalid university number.");
                        break;
                    }

                    System.out.println("\nChoose new status:");
                    System.out.println("1. Planned");
                    System.out.println("2. Applying");
                    System.out.println("3. Applied");
                    System.out.println("4. Accepted");
                    System.out.println("5. Rejected");
                    System.out.print("Enter status choice: ");

                    int statusChoice = scanner.nextInt();
                    scanner.nextLine();

                    String newStatus = "";

                    switch (statusChoice)
                    {
                        case 1:
                            newStatus = "Planned";
                            break;
                        case 2:
                            newStatus = "Applying";
                            break;
                        case 3:
                            newStatus = "Applied";
                            break;
                        case 4:
                            newStatus = "Accepted";
                            break;
                        case 5:
                            newStatus = "Rejected";
                            break;
                        default:
                            System.out.println("Invalid status choice.");
                            break;
                    }

                    if (statusChoice >= 1 && statusChoice <= 5)
                    {
                        University selected = universities.get(universityNumber - 1);

                        boolean updated = DatabaseManager.updateStatus(
                                selected.name, selected.program, newStatus);

                        if (updated) {
                            selected.status = newStatus;
                            System.out.println("Application status updated successfully!");
                        } else {
                            System.out.println("Could not update status in the database.");
                        }
                    }
                    break;

                case 4:
                    if (universities.isEmpty()) {
                        System.out.println("No universities available to delete.");
                        break;
                    }

                    System.out.println("\n--- Delete University ---");

                    for (int i = 0; i < universities.size(); i++) {
                        System.out.println((i + 1) + ". " + universities.get(i).name);
                    }

                    System.out.print("Enter university number to delete: ");
                    int deleteNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (deleteNumber < 1 || deleteNumber > universities.size()) {
                        System.out.println("Invalid university number.");
                        break;
                    }

                    System.out.print("Are you sure you want to delete this university? (yes/no): ");
                    String confirmation = scanner.nextLine();

                    if (confirmation.equalsIgnoreCase("yes")) {
                        University selected = universities.get(deleteNumber - 1);

                        boolean deleted = DatabaseManager.deleteUniversity(
                                selected.name, selected.program);

                        if (deleted) {
                            universities.remove(deleteNumber - 1);
                            System.out.println(selected.name + " deleted successfully!");
                        } else {
                            System.out.println("Could not delete university from the database.");
                        }
                    } else {
                        System.out.println("Deletion cancelled.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for using UniTrack!");
                    break;

                    default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, 4 or 5 .");
            }
        }
        scanner.close();
    }
}
