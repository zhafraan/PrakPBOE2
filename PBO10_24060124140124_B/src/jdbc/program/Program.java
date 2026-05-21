package jdbc.program;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.model.Mahasiswa;
import jdbc.service.MysqlMahasiswaService;
/**
 *
 * @author ACER
 */

public class Program {
    static MysqlMahasiswaService service;

    public static void main(String[] args) throws SQLException {

        // Inisialisasi service di dalam main agar exception bisa ditangani
        service = new MysqlMahasiswaService();

        List<Mahasiswa> listmhs = new ArrayList<Mahasiswa>();
        System.out.println("");

        // INSERT
        System.out.println("insert");
        Mahasiswa mhsAdd = new Mahasiswa(5, "Aqil");
        service.add(mhsAdd);
        System.out.println("berhasil insert: " + mhsAdd);
        displayAll();
        
        Mahasiswa mhsAdd1 = new Mahasiswa(3, "Daffa");
        service.add(mhsAdd1);
        System.out.println("berhasil insert: " + mhsAdd1);
        displayAll();
        
        Mahasiswa mhsAdd2 = new Mahasiswa(1, "Yusuf");
        service.add(mhsAdd2);
        System.out.println("berhasil insert: " + mhsAdd2);
        displayAll();

        // UPDATE
        System.out.println("update");
        Mahasiswa mhsUpdate = service.getById(5);
        System.out.println("Akan diupdate data lama: " + mhsUpdate);
        mhsUpdate.setNama("Azka");
        System.out.println("dengan data baru: " + mhsUpdate);
        service.update(mhsUpdate);
        displayAll();

        // DELETE
        System.out.println("delete");
        System.out.println("akan di delete: " + service.getById(5));
        service.delete(5);
        displayAll();
    }

    static void displayAll() {
        System.out.println("displayAll");
        List<Mahasiswa> semuaMhs = service.getAll();
        for (Mahasiswa m : semuaMhs) {
            System.out.println(m);
        }
        System.out.println("");
    }
}