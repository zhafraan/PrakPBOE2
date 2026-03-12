/* Nama File    : Main.java
 * Deskripsi    : Main class untuk menjalankan program latihan pegawai
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 12 Maret 2026 */
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. Membuat objek Dosen Tetap 
        // Data: Nama: Andi, NIP: 9545647548, Lahir: 5 Mei 1990, TMT: 1 Jan 2015, Gaji: 5jt
        DosenTetap dosen1 = new DosenTetap(
            "Andi", 
            "9545647548", 
            LocalDate.of(1990, 5, 5), 
            LocalDate.of(2015, 1, 1), 
            5000000.0, 
            "78647324", 
            "Fakultas Sains dan Matematika"
        );

        // 2. Membuat objek Dosen Tamu
        DosenTamu dosen2 = new DosenTamu(
            "Budi Santoso", 
            "9545647549", 
            LocalDate.of(1985, 10, 20), 
            LocalDate.of(2023, 1, 1), 
            4000000.0, 
            "12345678", 
            "Fakultas Teknik", 
            LocalDate.of(2026, 12, 31) // Tanggal akhir kontrak
        );

        // 3. Membuat objek Tendik
        Tendik tendik1 = new Tendik(
            "Siti Aminah", 
            "9545647550", 
            LocalDate.of(1995, 3, 15), 
            LocalDate.of(2020, 6, 1), 
            3500000.0, 
            "Akademik"
        );

        // Tampilkan Informasi
        System.out.println("******* DATA DOSEN TETAP *******");
        dosen1.printinfo();
        System.out.println();

        System.out.println("******* DATA DOSEN TAMU *******");
        dosen2.printinfo();
        System.out.println();

        System.out.println("******* DATA TENDIK *******");
        tendik1.printinfo();
        System.out.println();
        Pegawai.printCounterPegawai();
        Dosen.printCounterDosen();
    }
}
