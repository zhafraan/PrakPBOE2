package PersonDAO;
/**
 * File: PersonDAO.java
 * Deskripsi: Implementasu PersonDAO untuk MYSQL
 * @author Zhafran
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLPersonDAO implements PersonDAO {
    public void savePerson(Person person) {
        try {
            String name = person.getName();
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/pbo";
            try (Connection con = DriverManager.getConnection(url,"root","Zhafran05")) {
                String query ="INSERT INTO person(name) VALUES('" + name + "')";
                Statement s = con.createStatement();
                
                s.executeUpdate(query);
                System.out.println("Data berhasil disimpan");
                s.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}