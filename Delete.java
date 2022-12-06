package Collection;

import java.sql.*;

public class Delete {
    public Delete() {
    }

    private static String DB_URL = "jdbc:mysql://localhost:3306/javasqlTraining";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";

    public static void delete() {
        try {

            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("delete from building where id=" + 4);
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

}

