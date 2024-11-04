package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
    // Constants per a la connexio amb la base de dades
    private static final String URL = "jdbc:mysql://localhost:3306/botiga";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection = null;

    // Metode per obtenir la connexió
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
