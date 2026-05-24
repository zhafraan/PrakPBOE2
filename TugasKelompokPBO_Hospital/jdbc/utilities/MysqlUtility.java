package jdbc.utilities;

import java.sql.*;

public class MysqlUtility {
    private static Connection koneksi = null;

    public static Connection getConnection() {
        if (koneksi == null) {
            try {
                // Menggunakan driver MySQL modern
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                String url = "jdbc:mysql://localhost:3307/pbokelompok"; 
                String user = "root"; 
                String password = ""; 
                
                koneksi = DriverManager.getConnection(url, user, password);
                if (koneksi != null) {
                    System.out.println("[UTILITY] Koneksi ke database 'pbo' berhasil.");
                }
            } catch (ClassNotFoundException cne) {
                System.out.println("Gagal load driver: " + cne.getMessage());
            } catch (SQLException sqle) {
                System.out.println("Gagal koneksi: " + sqle.getMessage());
            }
        }
        return koneksi;
    }
}