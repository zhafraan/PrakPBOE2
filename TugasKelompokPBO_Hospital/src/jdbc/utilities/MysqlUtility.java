package jdbc.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlUtility {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3307/pbokelompokfix";
                String user = "root";
                String password = ""; 
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Gagal koneksi ke database: " + e.getMessage());
            }
        }
        return connection;
    }
}