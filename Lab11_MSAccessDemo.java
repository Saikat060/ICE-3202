import java.sql.*;

public class Lab11_MSAccessDemo {

    private static final String DB_URL = "jdbc:ucanaccess://ICE_PUST.accdb";

    public static void insertStudent(String name, String email, String phone) {
        String sql = "INSERT INTO Students (Name, Email, Phone) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("[SUCCESS] New student record inserted successfully!");
            }

        } catch (SQLException e) {
            System.err.println("Insert Error: " + e.getMessage());
        }
    }

    public static void displayAllStudents() {
        String sql = "SELECT * FROM Student";

        System.out.println("\n--- All Student Records from ICE_PUST Database ---");
        try (Connection conn = DriverManager.getConnection(DB_URL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            System.out.printf("%-20s %-25s %-15s\n", "Name", "Email", "Phone");
            System.out.println("---------------------------------------------------------------");

            while (rs.next()) {
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");

                System.out.printf("%-20s %-25s %-15s\n", name, email, phone);
            }

        } catch (SQLException e) {
            System.err.println("Display Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Lab Experiment 11: MS Access Database Operations ===");

        insertStudent("Sharmin", "sharmin@ice.pust.ac.bd", "01711000000");
        insertStudent("Sumon", "sumon@ice.pust.ac.bd", "01822000000");
        insertStudent("Saikat", "saikat@ice.pust.ac.bd", "01933000000");
        insertStudent("Bonu", "bonu@ice.pust.ac.bd", "01984233000");
        insertStudent("Antor", "Antor@ice.pust.ac.bd", "019843434433000");

        displayAllStudents();
    }
}
