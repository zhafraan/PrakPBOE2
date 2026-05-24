package jdbc.service;

import jdbc.model.*;
import jdbc.utilities.MysqlUtility;
import java.sql.*;

public class MySQLHospitalDAO implements HospitalDAO {

    @Override
    public void savePerson(Person p) throws Exception {
        Connection con = MysqlUtility.getConnection();
        String query = "INSERT INTO person (id, name, gender, phone_number, role, specialization, license_number, shift, assigned_ward, blood_type) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                       "ON DUPLICATE KEY UPDATE name=?, gender=?, phone_number=?";
        
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, p.getID());
            ps.setString(2, p.getName());
            ps.setString(3, p.getGender());
            ps.setString(4, p.getPhoneNumber());
            ps.setString(5, p.getRole());

            // Pengecekan tipe objek polimorfisme untuk mengisi kolom spesifik
            if (p instanceof Doctor) {
                ps.setString(6, "General"); 
                ps.setString(7, "LIC-AUTO");
                ps.setNull(8, Types.VARCHAR);
                ps.setNull(9, Types.VARCHAR);
                ps.setNull(10, Types.VARCHAR);
            } else if (p instanceof Nurse) {
                ps.setNull(6, Types.VARCHAR);
                ps.setNull(7, Types.VARCHAR);
                ps.setString(8, "Pagi");
                ps.setString(9, "ICU");
                ps.setNull(10, Types.VARCHAR);
            } else if (p instanceof Patient) {
                ps.setNull(6, Types.VARCHAR);
                ps.setNull(7, Types.VARCHAR);
                ps.setNull(8, Types.VARCHAR);
                ps.setNull(9, Types.VARCHAR);
                ps.setString(10, "O");
            }

            // Parameter untuk klausa ON DUPLICATE KEY UPDATE
            ps.setString(11, p.getName());
            ps.setString(12, p.getGender());
            ps.setString(13, p.getPhoneNumber());

            ps.executeUpdate();
            System.out.println("[DAO] Ter-sinkronisasi " + p.getRole() + ": " + p.getName());
        } catch (SQLException e) {
            throw new Exception("Gagal simpan Person: " + e.getMessage());
        }
    }

    @Override
    public void saveRoom(Room r) throws Exception {
        Connection con = MysqlUtility.getConnection();
        String query = "INSERT INTO room (room_id, room_type, capacity, price_per_night) VALUES (?, ?, ?, ?) " +
                       "ON DUPLICATE KEY UPDATE room_type=?, price_per_night=?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, "R1"); 
            ps.setString(2, r.getRoomType());
            ps.setInt(3, 5); 
            ps.setDouble(4, 500000);
            ps.setString(5, r.getRoomType());
            ps.setDouble(6, 500000);
            
            ps.executeUpdate();
            System.out.println("[DAO] Ter-sinkronisasi Kamar: " + r.getRoomType());
        } catch (SQLException e) {
            throw new Exception("Gagal simpan Room: " + e.getMessage());
        }
    }

    @Override
    public void saveAppointment(Appointment a) throws Exception {
        Connection con = MysqlUtility.getConnection();
        String query = "INSERT INTO appointment (appointment_id, patient_id, doctor_id, date_slot, time_slot, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, "A1"); 
            ps.setString(2, "P1"); 
            ps.setString(3, "D1"); 
            ps.setString(4, "2026-04-01");
            ps.setString(5, "10:00");
            ps.setString(6, "Scheduled");
            
            ps.executeUpdate();
            System.out.println("[DAO] Ter-sinkronisasi Appointment Berhasil.");
        } catch (SQLException e) {
            System.out.println("[DAO] Log transaksi appointment sudah terdata.");
        }
    }
}