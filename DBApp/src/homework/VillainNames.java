package homework;

import java.sql.*;

public class VillainNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try(Statement statement = connection.createStatement()) {
                String sql = "SELECT \n" +
                        "\tv.villain_name, COUNT(m.minion_id) AS cnt\n" +
                        "FROM \n" +
                        "\tvillains AS v\n" +
                        "INNER JOIN \n" +
                        "\tvillains_minions AS vm\n" +
                        "ON\n" +
                        "\tv.villain_id=vm.villain_id\n" +
                        "INNER JOIN\n" +
                        "\tminions AS m\n" +
                        "ON\n" +
                        "\tvm.minion_id=m.minion_id\n" +
                        "GROUP BY\n" +
                        "\tv.villain_id\n" +
                        "ORDER BY \n" +
                        "\tcnt DESC;";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    String villainName = resultSet.getString("villain_name");
                    int count = resultSet.getInt("cnt");
                    System.out.println(String.format("%s %d", villainName, count));
                }
            }
        }
    }
}
