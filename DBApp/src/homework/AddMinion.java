package homework;

import java.sql.*;
import java.util.Scanner;

public class AddMinion {

    private static final String URL = "jdbc:mysql://localhost:3306/minions";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        //Read minion info
        String[] minionsInfo = scanner.nextLine().split("\\s+");
        String minionName = minionsInfo[1];
        int minionAge = Integer.parseInt(minionsInfo[2]);
        String minionTown = minionsInfo[3];

        //Read villain info
        String[] villainInfo = scanner.nextLine().split("\\s+");
        String villainName = villainInfo[1];
        System.out.println(villainName);
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try(Statement stmt = connection.createStatement()) {

                String sql = "SELECT t.town_id\n" +
                        "FROM towns AS t\n" +
                        "WHERE t.town_name=?;";

                int townId = 0;
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, minionTown);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    resultSet.next();
                    townId = resultSet.getInt("town_id");
                    System.out.println(townId);
                }

                String minionsInsert = "INSERT INTO \n" +
                        "\tminions(minion_name, minion_age, town_id)\n" +
                        "VALUES\n" +
                        "\t (?, ? ,?);";

                String villainsInsert = "INSERT INTO \n" +
                        "\tvillains(villain_name)\n" +
                        "VALUES\n" +
                        "\t(?);";

                try(PreparedStatement preparedStatement = connection.prepareStatement(minionsInsert)) {
                    preparedStatement.setString(1, minionName);
                    preparedStatement.setInt(2, minionAge);
                    preparedStatement.setInt(3, townId);
                    preparedStatement.executeUpdate();
                }

                try(PreparedStatement preparedStatement = connection.prepareStatement(villainsInsert)) {
                    preparedStatement.setString(1, villainName);
                    preparedStatement.executeUpdate();
                }
            }
        }
    }
}
