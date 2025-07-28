import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertStudent {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter subject: ");
            String subject = scanner.nextLine();

            System.out.print("Enter marks: ");
            int marks = scanner.nextInt();

            String query = "INSERT INTO students (name, subject, marks) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, subject);
            stmt.setInt(3, marks);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " student record inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
