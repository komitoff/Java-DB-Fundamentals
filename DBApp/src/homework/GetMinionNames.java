package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GetMinionNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int minionId = scanner.nextInt();

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try(Statement statement = connection.createStatement()) {
                String sql = "";
                
            }
        }
    }
}
