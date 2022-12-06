package Collection;

import java.sql.*;

public class Delete {
    public Delete() {
    }

    private static String DB_URL = "jdbc:mysql://localhost:3306/javasqlTraining";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";

    public static void delete()  {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate("delete from building where id=" + 6);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
           try {
               statement.close();
               connection.close();
           }catch (Exception e)
           {
               e.printStackTrace();
           }
        }




    }
}

