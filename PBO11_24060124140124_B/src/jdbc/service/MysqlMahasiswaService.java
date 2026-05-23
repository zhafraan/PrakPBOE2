package jdbc.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.model.Mahasiswa;
import jdbc.utilities.MysqlUtility;

/**
 *
 * @author ACER
 */
public class MysqlMahasiswaService {
    Connection koneksi = null;
 
    // Constructor
    public MysqlMahasiswaService() throws SQLException {
        koneksi = MysqlUtility.getConnection();
    }
 
    // Membuat objek Mahasiswa baru (kosong)
    public Mahasiswa makeMhsObject() {
        return new Mahasiswa();
    }
 
    // CREATE - Menambahkan data mahasiswa baru
    public void add(Mahasiswa mhs) {
        // Query INSERT dengan placeholder ?
        String sql = "INSERT INTO mahasiswa (id, nama) VALUES (?, ?)";
        try {
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, mhs.getId());       // parameter pertama: id
            ps.setString(2, mhs.getNama());  // parameter kedua: nama
            ps.executeUpdate();
            System.out.println("Berhasil insert");
        } catch (SQLException sqle) {
            System.out.println("Gagal insert : " + sqle.getMessage());
        }
    }
 
    // Mengubah data mahasiswa berdasarkan id
    public void update(Mahasiswa mhs) {
        // Query UPDATE berdasarkan id
        String sql = "UPDATE mahasiswa SET nama = ? WHERE id = ?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, mhs.getNama());  // parameter pertama: nama baru
            ps.setInt(2, mhs.getId());       // parameter kedua: id target
            ps.executeUpdate();
            System.out.println("Berhasil update");
        } catch (SQLException sqle) {
            System.out.println("Gagal update : " + sqle.getMessage());
        }
    }
 
    // Menghapus data mahasiswa berdasarkan id
    public void delete(int id) {
        // Query DELETE berdasarkan id
        String sql = "DELETE FROM mahasiswa WHERE id = ?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, id);  // parameter: id yang akan dihapus
            ps.executeUpdate();
            System.out.println("Berhasil delete");
        } catch (SQLException sqle) {
            System.out.println("Gagal delete : " + sqle.getMessage());
        }
    }
 
    // Mengambil satu mahasiswa berdasarkan id
    public Mahasiswa getById(int id) {
        Mahasiswa mhs = null;
        // Query SELECT berdasarkan id
        String sql = "SELECT * FROM mahasiswa WHERE id = ?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, id);  // parameter: id yang dicari
            ResultSet rs = ps.executeQuery();
 
            // Jika data ditemukan, buat objek Mahasiswa dari ResultSet
            if (rs.next()) {
                int idHasil   = rs.getInt("id");
                String namaHasil = rs.getString("nama");
                mhs = new Mahasiswa(idHasil, namaHasil);
            }
        } catch (SQLException sqle) {
            System.out.println("Gagal getById : " + sqle.getMessage());
        }
        return mhs;
    }
 
    //Mengambil semua data mahasiswa
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> listMhs = new ArrayList<>();
        // Query SELECT semua baris
        String sql = "SELECT * FROM mahasiswa";
        try {
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Iterasi semua baris hasil query
            while (rs.next()) {
                int idHasil      = rs.getInt("id");
                String namaHasil = rs.getString("nama");
                Mahasiswa mhs    = new Mahasiswa(idHasil, namaHasil);
                listMhs.add(mhs);
            }
        } catch (SQLException sqle) {
            System.out.println("Gagal getAll : " + sqle.getMessage());
        }
        return listMhs;
    }
    // Cek data
    public boolean isExist(int id) {
        String sql ="SELECT * FROM mahasiswa WHERE id=?";
        try {
            PreparedStatement ps =
            koneksi.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs =
            ps.executeQuery();
            return rs.next();

        } catch (SQLException sqle) {
            System.out.println(
            "Gagal cek data : " + sqle.getMessage());
        }

        return false;
    }

    // Cari nama
    public List<Mahasiswa> search(String keyword) {

        List<Mahasiswa> listMhs =
        new ArrayList<>();

        String sql =
        "SELECT * FROM mahasiswa WHERE nama LIKE ?";

        try {
            PreparedStatement ps =
            koneksi.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs =
            ps.executeQuery();

            while(rs.next()) {
                Mahasiswa mhs =
                new Mahasiswa(
                    rs.getInt("id"),
                    rs.getString("nama")
                );
                listMhs.add(mhs);
            }
        } catch (SQLException sqle) {
            System.out.println(
            "Gagal search : " + sqle.getMessage());
        }
        return listMhs;
    }
}


