package jdbc.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlUtility {
    // Sesuaikan dengan konfigurasi MySQL kamu
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "root";      // username MySQL kamu
    private static final String PASSWORD = "";       // password MySQL kamu

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver tidak ditemukan: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}