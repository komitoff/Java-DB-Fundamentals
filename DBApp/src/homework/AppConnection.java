package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/the_nerd_herd";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Connected");
        try {
            
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
