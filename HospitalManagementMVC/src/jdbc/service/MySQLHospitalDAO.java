package jdbc.service;

import jdbc.model.Doctor;
import jdbc.model.Nurse;
import jdbc.model.Patient;
import jdbc.model.Room;
import jdbc.model.Appointment;
import jdbc.model.Bill;
import jdbc.utilities.MysqlUtility;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQLHospitalDAO — implementasi konkret HospitalDAO untuk MySQL.
 *
 * Kelas ini berperan sebagai komponen SERVICE / MODEL LAYER dalam pola MVC:
 *   - Menerima objek-objek model (Doctor, Nurse, Patient, dll.)
 *   - Menerjemahkan operasi bisnis ke SQL
 *   - Mengembalikan objek model (atau array data ringkas) ke Controller/View
 *
 * View (MainFrame) TIDAK boleh menulis SQL sendiri —
 * semua akses DB melewati kelas ini.
 */
public class MySQLHospitalDAO implements HospitalDAO {

    // ================================================================
    // =========================== DOCTOR =============================
    // ================================================================

    @Override
    public void saveDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (id, name, gender, phone_number, specialization, license_number) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, doctor.getID());
            ps.setString(2, doctor.getName());
            ps.setString(3, doctor.getGender());
            ps.setString(4, doctor.getPhoneNumber());
            ps.setString(5, doctor.getSpecialization());
            ps.setString(6, doctor.getLicenseNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal simpan dokter: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors ORDER BY id";
        try (Connection conn = MysqlUtility.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Doctor(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("phone_number"),
                    rs.getString("specialization"),
                    rs.getString("license_number")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil data dokter: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctors SET name=?, gender=?, phone_number=?, "
                   + "specialization=?, license_number=? WHERE id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getGender());
            ps.setString(3, doctor.getPhoneNumber());
            ps.setString(4, doctor.getSpecialization());
            ps.setString(5, doctor.getLicenseNumber());
            ps.setString(6, doctor.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update dokter: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteDoctor(String id) {
        String sql = "DELETE FROM doctors WHERE id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus dokter: " + e.getMessage(), e);
        }
    }

    // ================================================================
    // ============================ NURSE =============================
    // ================================================================

    @Override
    public void saveNurse(Nurse nurse) {
        String sql = "INSERT INTO nurses (id, name, gender, phone_number, shift, assigned_ward) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nurse.getID());
            ps.setString(2, nurse.getName());
            ps.setString(3, nurse.getGender());
            ps.setString(4, nurse.getPhoneNumber());
            ps.setString(5, nurse.getShift());
            ps.setString(6, nurse.getAssignedWard());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal simpan perawat: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Nurse> getAllNurses() {
        List<Nurse> list = new ArrayList<>();
        String sql = "SELECT * FROM nurses ORDER BY id";
        try (Connection conn = MysqlUtility.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Nurse(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("phone_number"),
                    rs.getString("shift"),
                    rs.getString("assigned_ward")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil data perawat: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void updateNurse(Nurse nurse) {
        String sql = "UPDATE nurses SET name=?, gender=?, phone_number=?, shift=?, assigned_ward=? WHERE id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nurse.getName());
            ps.setString(2, nurse.getGender());
            ps.setString(3, nurse.getPhoneNumber());
            ps.setString(4, nurse.getShift());
            ps.setString(5, nurse.getAssignedWard());
            ps.setString(6, nurse.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update perawat: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteNurse(String id) {
        String sql = "DELETE FROM nurses WHERE id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus perawat: " + e.getMessage(), e);
        }
    }

    // ================================================================
    // =========================== PATIENT ============================
    // ================================================================

    @Override
    public void savePatient(Patient patient) {
        String sql = "INSERT INTO patients (id, name, gender, phone_number, blood_type) "
                   + "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, patient.getID());
            ps.setString(2, patient.getName());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhoneNumber());
            ps.setString(5, patient.getBloodType());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal simpan pasien: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients ORDER BY id";
        try (Connection conn = MysqlUtility.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Patient(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("phone_number"),
                    rs.getString("blood_type")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil data pasien: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void updatePatient(Patient patient) {
        String sql = "UPDATE patients SET name=?, gender=?, phone_number=?, blood_type=? WHERE id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getGender());
            ps.setString(3, patient.getPhoneNumber());
            ps.setString(4, patient.getBloodType());
            ps.setString(5, patient.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update pasien: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletePatient(String id) {
        String sql = "DELETE FROM patients WHERE id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus pasien: " + e.getMessage(), e);
        }
    }

    // ================================================================
    // ============================ ROOM ==============================
    // ================================================================

    @Override
    public void saveRoom(Room room) {
        String sql = "INSERT INTO rooms (room_id, room_type, capacity, price_per_night) "
                   + "VALUES (?, ?, ?, ?)";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, room.getRoomId());
            ps.setString(2, room.getRoomType());
            ps.setInt(3, room.getCapacity());
            ps.setDouble(4, room.getPricePerNight());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal simpan ruangan: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms ORDER BY room_id";
        try (Connection conn = MysqlUtility.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            while (rs.next()) {
                Room r = new Room(
                    rs.getString("room_id"),
                    rs.getString("room_type"),
                    rs.getInt("capacity"),
                    rs.getDouble("price_per_night")
                );
                // Set current occupancy via refleksi sederhana
                r.setCurrentOccupancy(rs.getInt("current_occupancy"));
                list.add(r);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil data ruangan: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void updateRoom(Room room) {
        String sql = "UPDATE rooms SET room_type=?, capacity=?, price_per_night=? WHERE room_id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, room.getRoomType());
            ps.setInt(2, room.getCapacity());
            ps.setDouble(3, room.getPricePerNight());
            ps.setString(4, room.getRoomId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update ruangan: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteRoom(String id) {
        String sql = "DELETE FROM rooms WHERE room_id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus ruangan: " + e.getMessage(), e);
        }
    }

    // ================================================================
    // ========================= APPOINTMENT ==========================
    // ================================================================

    @Override
    public void saveAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments (appointment_id, patient_id, doctor_id, date, time_slot, status) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, appointment.getAppointmentID());
            ps.setString(2, appointment.getPatient().getID());
            ps.setString(3, appointment.getDoctor().getID());
            ps.setDate(4, Date.valueOf(appointment.getDate()));
            ps.setString(5, appointment.getTimeSlot());
            ps.setString(6, appointment.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal simpan appointment: " + e.getMessage(), e);
        }
    }

    @Override
    public List<String[]> getAllAppointments() {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT a.appointment_id, p.name, d.name, a.date, a.time_slot, a.status "
                   + "FROM appointments a "
                   + "JOIN patients p ON a.patient_id = p.id "
                   + "JOIN doctors d ON a.doctor_id = d.id "
                   + "ORDER BY a.date";
        try (Connection conn = MysqlUtility.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            while (rs.next()) {
                list.add(new String[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6)
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil data appointment: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void updateAppointmentStatus(String aptId, String status) {
        String sql = "UPDATE appointments SET status=? WHERE appointment_id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setString(2, aptId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update appointment: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteAppointment(String aptId) {
        String sql = "DELETE FROM appointments WHERE appointment_id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, aptId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus appointment: " + e.getMessage(), e);
        }
    }

    // ================================================================
    // ============================ BILL ==============================
    // ================================================================

    @Override
    public String createBill(String billId, String patientId) {
        String sql = "INSERT INTO bills (bill_id, patient_id, total_amount, is_paid) VALUES (?, ?, 0, false)";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, billId);
            ps.setString(2, patientId);
            ps.executeUpdate();
            return billId;
        } catch (SQLException e) {
            throw new RuntimeException("Gagal buat bill: " + e.getMessage(), e);
        }
    }

    @Override
    public List<String[]> getAllBills() {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT b.bill_id, p.name, b.total_amount, b.is_paid "
                   + "FROM bills b JOIN patients p ON b.patient_id = p.id "
                   + "ORDER BY b.bill_id";
        try (Connection conn = MysqlUtility.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            while (rs.next()) {
                list.add(new String[]{
                    rs.getString("bill_id"),
                    rs.getString("name"),
                    String.format("Rp %,.0f", rs.getDouble("total_amount")),
                    rs.getBoolean("is_paid") ? "LUNAS" : "BELUM LUNAS"
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil data bill: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void addBillItem(String billId, String description, double cost) {
        try (Connection conn = MysqlUtility.getConnection()) {
            // Tambah item
            PreparedStatement psItem = conn.prepareStatement(
                "INSERT INTO bill_items (bill_id, description, cost) VALUES (?, ?, ?)");
            psItem.setString(1, billId);
            psItem.setString(2, description);
            psItem.setDouble(3, cost);
            psItem.executeUpdate();

            // Update total bill
            PreparedStatement psTotal = conn.prepareStatement(
                "UPDATE bills SET total_amount = total_amount + ? WHERE bill_id=?");
            psTotal.setDouble(1, cost);
            psTotal.setString(2, billId);
            psTotal.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal tambah item bill: " + e.getMessage(), e);
        }
    }

    @Override
    public List<String[]> getBillItems(String billId) {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT id, description, cost FROM bill_items WHERE bill_id=? ORDER BY id";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, billId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new String[]{
                    String.valueOf(rs.getInt("id")),
                    rs.getString("description"),
                    String.format("Rp %,.0f", rs.getDouble("cost"))
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil item bill: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void deleteBillItem(int itemId, String billId, double cost) {
        try (Connection conn = MysqlUtility.getConnection()) {
            PreparedStatement psDel = conn.prepareStatement(
                "DELETE FROM bill_items WHERE id=?");
            psDel.setInt(1, itemId);
            psDel.executeUpdate();

            PreparedStatement psUpd = conn.prepareStatement(
                "UPDATE bills SET total_amount = total_amount - ? WHERE bill_id=?");
            psUpd.setDouble(1, cost);
            psUpd.setString(2, billId);
            psUpd.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus item bill: " + e.getMessage(), e);
        }
    }

    @Override
    public void payBill(String billId) {
        String sql = "UPDATE bills SET is_paid=true WHERE bill_id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, billId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal bayar bill: " + e.getMessage(), e);
        }
    }

    // ================================================================
    // ====================== MEDICAL RECORD ==========================
    // ================================================================

    @Override
    public String createMedicalRecord(String patientId) {
        String recordId = "MR-" + patientId;
        // Cek dulu apakah sudah ada
        String cek = "SELECT record_id FROM medical_records WHERE patient_id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(cek)) {
            ps.setString(1, patientId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return null; // sudah ada, kembalikan null sebagai sinyal
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal cek medical record: " + e.getMessage(), e);
        }

        String sql = "INSERT INTO medical_records (record_id, patient_id) VALUES (?, ?)";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, recordId);
            ps.setString(2, patientId);
            ps.executeUpdate();
            return recordId;
        } catch (SQLException e) {
            throw new RuntimeException("Gagal buat medical record: " + e.getMessage(), e);
        }
    }

    @Override
    public List<String[]> getAllMedicalRecords() {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT mr.record_id, mr.patient_id, p.name "
                   + "FROM medical_records mr "
                   + "JOIN patients p ON mr.patient_id = p.id "
                   + "ORDER BY mr.record_id";
        try (Connection conn = MysqlUtility.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            while (rs.next()) {
                list.add(new String[]{
                    rs.getString("record_id"),
                    rs.getString("patient_id"),
                    rs.getString("name")
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil medical record: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void addMedicalEntry(String recordId, String entry) {
        String sql = "INSERT INTO medical_record_entries (record_id, entry) VALUES (?, ?)";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, recordId);
            ps.setString(2, entry);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal tambah entry: " + e.getMessage(), e);
        }
    }

    @Override
    public List<String[]> getMedicalEntries(String recordId) {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT id, entry FROM medical_record_entries WHERE record_id=? ORDER BY id";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, recordId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new String[]{
                    String.valueOf(rs.getInt("id")),
                    rs.getString("entry")
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil entries: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void deleteMedicalEntry(int entryId) {
        String sql = "DELETE FROM medical_record_entries WHERE id=?";
        try (Connection conn = MysqlUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entryId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus entry: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteMedicalRecord(String recordId) {
        try (Connection conn = MysqlUtility.getConnection()) {
            PreparedStatement psE = conn.prepareStatement(
                "DELETE FROM medical_record_entries WHERE record_id=?");
            psE.setString(1, recordId);
            psE.executeUpdate();

            PreparedStatement psR = conn.prepareStatement(
                "DELETE FROM medical_records WHERE record_id=?");
            psR.setString(1, recordId);
            psR.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus medical record: " + e.getMessage(), e);
        }
    }
}
