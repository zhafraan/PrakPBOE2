package PersonDAO;
/**
 * File: MainDAO.java
 * Deskripsi: Main program untuk akses DAO
 * @author Zhafran
 */
public class MainDAO {
    public static void main(String args[]) {
        Person person = new Person("Zhafran");
        DAOManager m = new DAOManager();
        m.setPersonDAO(new MySQLPersonDAO());
        
        try {
            m.getPersonDAO().savePerson(person);
            System.out.println("Data person berhasil disimpan ke database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    

