package homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetMinionNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int villainId = scanner.nextInt();
        List<String> minions = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try(Statement statement = connection.createStatement()) {
                String sql = "SELECT \n" +
                        "\tv.villain_name, m.minion_id, m.minion_name, m.minion_age\n" +
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
                        "WHERE \n" +
                        "\tv.villain_id=?;";

                try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, villainId);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    String villainName = "";
                    while (resultSet.next()) {
                        villainName = resultSet.getString("villain_name");
                        int minionId = resultSet.getInt("minion_id");
                        String minionName = resultSet.getString("minion_name");
                        int minionAge = resultSet.getInt("minion_age");
                        minions.add(String.format("%d. %s %d", minionId, minionName, minionAge));
                    }
                    if (villainName.equals("")) {
                        System.out.println(String.format("No villain with ID %d exists in the database.", villainId));
                    } else {
                        System.out.println("Villain: " + villainName);
                        minions.forEach(System.out::println);
                    }

                }
            }
        }
    }
}
