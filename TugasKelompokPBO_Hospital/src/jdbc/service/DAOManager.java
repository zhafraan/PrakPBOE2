package jdbc.service;

public class DAOManager {
    private HospitalDAO hospitalDAO;

    public DAOManager() {
        this.hospitalDAO = new MySQLHospitalDAO();
    }

    public HospitalDAO getHospitalDAO() {
        return hospitalDAO;
    }
}