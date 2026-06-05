package jdbc.service;

import jdbc.model.Doctor;
import jdbc.model.Nurse;
import jdbc.model.Patient;
import jdbc.model.Room;
import jdbc.model.Appointment;
import jdbc.model.Bill;

import java.util.List;

/**
 * HospitalDAO — interface yang mendefinisikan kontrak operasi CRUD
 * untuk seluruh entitas rumah sakit.
 *
 * Dalam pola MVC:
 *   View (MainFrame) → Controller (DAOManager) → Model (HospitalDAO + class-class model)
 *
 * Dengan demikian View tidak perlu tahu implementasi SQL-nya,
 * cukup memanggil method yang ada di sini.
 */
public interface HospitalDAO {

    // ===================== DOCTOR =====================
    void saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    void updateDoctor(Doctor doctor);
    void deleteDoctor(String id);

    // ===================== NURSE =====================
    void saveNurse(Nurse nurse);
    List<Nurse> getAllNurses();
    void updateNurse(Nurse nurse);
    void deleteNurse(String id);

    // ===================== PATIENT =====================
    void savePatient(Patient patient);
    List<Patient> getAllPatients();
    void updatePatient(Patient patient);
    void deletePatient(String id);

    // ===================== ROOM =====================
    void saveRoom(Room room);
    List<Room> getAllRooms();
    void updateRoom(Room room);
    void deleteRoom(String id);

    // ===================== APPOINTMENT =====================
    void saveAppointment(Appointment appointment);
    List<String[]> getAllAppointments();   // [aptId, pasienNama, dokterNama, tanggal, jam, status]
    void updateAppointmentStatus(String aptId, String status);
    void deleteAppointment(String aptId);

    // ===================== BILL =====================
    String createBill(String billId, String patientId);
    List<String[]> getAllBills();           // [billId, pasienNama, total, status]
    void addBillItem(String billId, String description, double cost);
    List<String[]> getBillItems(String billId); // [itemId, deskripsi, cost]
    void deleteBillItem(int itemId, String billId, double cost);
    void payBill(String billId);

    // ===================== MEDICAL RECORD =====================
    String createMedicalRecord(String patientId);
    List<String[]> getAllMedicalRecords();  // [recordId, patientId, namaPassien]
    void addMedicalEntry(String recordId, String entry);
    List<String[]> getMedicalEntries(String recordId); // [entryId, entry]
    void deleteMedicalEntry(int entryId);
    void deleteMedicalRecord(String recordId);
}
