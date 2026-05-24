package jdbc.service;

public class DAOManager {
    private HospitalDAO hospitalDAO;

    public void setHospitalDAO(HospitalDAO dao) {
        this.hospitalDAO = dao;
    }

    public HospitalDAO getHospitalDAO() {
        return hospitalDAO;
    }
}