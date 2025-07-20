import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnect {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/java_project";
        String username = "root";
        String password = "meera@1213";

        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NOW();")
        ) {
            System.out.println("Connected to MySQL successfully!");
            while (rs.next()) {
                System.out.println("Current MySQL time: " + rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
