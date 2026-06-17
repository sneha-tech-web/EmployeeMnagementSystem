import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {

        try {
            if (con == null || con.isClosed()) {

                // Load MySQL Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Change DB name, username, password as per your setup
                String url = "jdbc:mysql://localhost:3306/employee_db";
                String user = "root";
                String password = "root";

                con = DriverManager.getConnection(url, user, password);

                System.out.println("Database Connected Successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
