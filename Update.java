package Collection;

import java.sql.*;

public class Update {
    private static String DB_URL = "jdbc:mysql://localhost:3306/javasqlTraining";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";

    public static void update() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            // dem so dong cua cot
            int count = 0;
            ResultSet rs = statement.executeQuery("select * from building");
            while (rs.next()) {
                count++;
            }
            statement.executeUpdate("update building \n" +
                    "set namee = 'tbq'\n" +
                    "where id = "  + 1 );


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
