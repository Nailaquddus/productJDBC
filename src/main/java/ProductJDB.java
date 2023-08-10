import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductJDB {


    private static final String DB_URL = "jdbc:mysql://localhost:3306/product_db";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "naila2023";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connection is established: " + connection.isValid(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}