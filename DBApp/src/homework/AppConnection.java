package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/minions";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try(Statement statement = connection.createStatement()) {
                String sql = "CREATE TABLE countries(\n" +
                        "\tcountry_id INT PRIMARY KEY,\n" +
                        "\tcountry_name VARCHAR(150)\n" +
                        ");";
                statement.executeUpdate(sql);
            }
        }
    }
}
