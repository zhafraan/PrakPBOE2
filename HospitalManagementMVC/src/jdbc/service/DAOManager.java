package jdbc.service;

/**
 * DAOManager — komponen CONTROLLER dalam pola MVC.
 *
 * Bertugas menjadi penghubung antara View (MainFrame) dan
 * Service/Model (HospitalDAO + kelas-kelas model).
 *
 * Alur MVC pada project ini:
 *   View (gui.MainFrame)
 *     → memanggil DAOManager (Controller)
 *       → DAOManager memegang HospitalDAO (Service)
 *         → MySQLHospitalDAO menggunakan kelas Model (Doctor, Patient, dll.)
 *           → MySQLHospitalDAO mengakses database via MysqlUtility
 */
public class DAOManager {

    // Controller memegang referensi ke Service layer
    private final HospitalDAO hospitalDAO;

    public DAOManager() {
        this.hospitalDAO = new MySQLHospitalDAO();
    }

    /**
     * Mengembalikan objek DAO agar View dapat memanggil
     * operasi CRUD tanpa tahu detail implementasi SQL-nya.
     */
    public HospitalDAO getDAO() {
        return hospitalDAO;
    }
}
