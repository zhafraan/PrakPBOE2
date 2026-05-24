package jdbc.service;

import jdbc.model.Hospital;
import jdbc.model.MedicalRecord;
import jdbc.model.Doctor;
import jdbc.model.Nurse;
import jdbc.model.Patient;
import jdbc.model.Room;
import jdbc.model.Appointment;
import jdbc.model.Bill;
import jdbc.utilities.MysqlUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLHospitalDAO implements HospitalDAO {
    private Connection connection;

    public MySQLHospitalDAO() {
        this.connection = MysqlUtility.getConnection();
    }

    @Override
    public void saveHospital(Hospital hospital) {
        String sql = "INSERT INTO hospital (name) VALUES (?) ON DUPLICATE KEY UPDATE name = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, hospital.getHospitalName());
            ps.setString(2, hospital.getHospitalName());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal simpan hospital: " + e.getMessage());
        }
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        String sql = "INSERT INTO person (id, name, gender, phone, role, attribute1, attribute2) " +
                     "VALUES (?, ?, ?, ?, 'Doctor', ?, ?) " +
                     "ON DUPLICATE KEY UPDATE name=?, gender=?, phone=?, attribute1=?, attribute2=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, doctor.getID());
            ps.setString(2, doctor.getName());
            ps.setString(3, doctor.getGender());
            ps.setString(4, doctor.getPhoneNumber());
            ps.setString(5, doctor.getSpecialization());
            ps.setString(6, doctor.getLicenseNumber());
            
            ps.setString(7, doctor.getName());
            ps.setString(8, doctor.getGender());
            ps.setString(9, doctor.getPhoneNumber());
            ps.setString(10, doctor.getSpecialization());
            ps.setString(11, doctor.getLicenseNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal simpan doctor: " + e.getMessage());
        }
    }

    @Override
    public void saveNurse(Nurse nurse) {
        String sql = "INSERT INTO person (id, name, gender, phone, role, attribute1, attribute2) " +
                     "VALUES (?, ?, ?, ?, 'Nurse', ?, ?) " +
                     "ON DUPLICATE KEY UPDATE name=?, gender=?, phone=?, attribute1=?, attribute2=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nurse.getID());
            ps.setString(2, nurse.getName());
            ps.setString(3, nurse.getGender());
            ps.setString(4, nurse.getPhoneNumber());
            ps.setString(5, nurse.getShift());
            ps.setString(6, nurse.getAssignedWard());
            
            ps.setString(7, nurse.getName());
            ps.setString(8, nurse.getGender());
            ps.setString(9, nurse.getPhoneNumber());
            ps.setString(10, nurse.getShift());
            ps.setString(11, nurse.getAssignedWard());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal simpan nurse: " + e.getMessage());
        }
    }

    @Override
    public void savePatient(Patient patient) {
        String sql = "INSERT INTO person (id, name, gender, phone, role, attribute1) " +
                     "VALUES (?, ?, ?, ?, 'Patient', ?) " +
                     "ON DUPLICATE KEY UPDATE name=?, gender=?, phone=?, attribute1=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, patient.getID());
            ps.setString(2, patient.getName());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhoneNumber());
            ps.setString(5, patient.getBloodType());
            
            ps.setString(6, patient.getName());
            ps.setString(7, patient.getGender());
            ps.setString(8, patient.getPhoneNumber());
            ps.setString(9, patient.getBloodType());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal simpan patient: " + e.getMessage());
        }
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointment (id, patient_id, doctor_id, date, time_slot, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE status = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, appointment.getAppointmentID());
            ps.setString(2, appointment.getPatient().getID());
            ps.setString(3, appointment.getDoctor().getID());
            ps.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now())); 
            ps.setString(5, "08:00"); 
            ps.setString(6, appointment.getStatus());
            ps.setString(7, appointment.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal simpan appointment: " + e.getMessage());
        }
    }
    @Override
    public void saveRoom(Room room) {
        String sql = "INSERT INTO room (id, type, capacity, current_occupancy, price_per_night) " +
                     "VALUES (?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE type=?, capacity=?, current_occupancy=?, price_per_night=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, room.getRoomId());
            ps.setString(2, room.getRoomType());
            ps.setInt(3, 1); // kapasitas default / bisa pakai room.isFull() logic jika tidak ada getter capacity utuh
            ps.setInt(4, 0); // current occupancy awal
            ps.setDouble(5, room.getPricePerNight());
            
            // Untuk Update jika data sudah ada
            ps.setString(6, room.getRoomType());
            ps.setInt(7, 1);
            ps.setInt(8, 0);
            ps.setDouble(9, room.getPricePerNight());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal simpan room: " + e.getMessage());
        }
    }
    @Override
    public void saveBill(Bill bill) {
        String sql = "INSERT INTO bill (id, patient_id, total_amount, is_paid) " +
                     "VALUES (?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE total_amount=?, is_paid=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, bill.getBillID()); // Mengambil ID Bill
            
            // Mengambil ID Pasien dari relasi objek Patient di dalam Bill
            ps.setString(2, bill.getPatient() != null ? bill.getPatient().getID() : null); 
            
            ps.setDouble(3, bill.getTotalAmount()); // Mengambil total tagihan
            ps.setBoolean(4, bill.isPaid()); // Mengambil status pembayaran (true/false)
            
            // Untuk kebutuhan UPDATE jika data dengan ID tersebut sudah ada
            ps.setDouble(5, bill.getTotalAmount());
            ps.setBoolean(6, bill.isPaid());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal simpan bill: " + e.getMessage());
        }
    }
    @Override
    public void saveMedicalRecord(Patient patient) {
        String sql = "INSERT INTO medical_record (id, patient_id, entries) " +
                     "VALUES (?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE entries = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            MedicalRecord mr = patient.getMedicalRecord(); // Mengambil objek MedicalRecord dari Pasien
            
            ps.setString(1, mr.getRecordId()); // Mengambil ID Rekam Medis (Format: MR-P001)
            ps.setString(2, patient.getID());  // Mengambil ID Pasien
            
            // Menggabungkan semua list entri rekam medis menjadi satu string dipisahkan koma
            String semuaEntries = String.join(", ", mr.getEntries()); 
            ps.setString(3, semuaEntries);
            ps.setString(4, semuaEntries); // Untuk kebutuhan UPDATE jika data sudah ada
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal simpan medical record: " + e.getMessage());
        }
    }
}