package PersonDAO;
/**
 * File: DAOManager.java
 * Deskripsi: Pengelola DAO dalam program
 * @author Zhafran
 */
public class DAOManager {
    private PersonDAO personDAO; 

    public void setPersonDAO(PersonDAO person) {
        personDAO = person; 
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }
    
}
