package Collection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Show {
    private static String DB_URL = "jdbc:mysql://localhost:3306/javasqlTraining";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";

    public static void show() {
        try {

            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from building");
            // show data
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "   " + rs.getString(4));
            }
            // close connection
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
