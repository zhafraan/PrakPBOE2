/* Nama File    : Dosen.java
 * Deskripsi    : Berisi atribut dan method dalam class dosen(subclass dari pegawai)
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 12 Maret 2026 */
import java.time.LocalDate;
public class Dosen extends Pegawai {
    private String fakultas;
    private static int Counterdosen = 0;

    public static void printCounterDosen() {
        System.out.println("Jumlah Dosen : " + Counterdosen);
    }
    // Konstruktor tanpa parameter
    public Dosen() {
        super();
        this.fakultas = "belum diisi";
        Counterdosen++;
    }
    // Konstruktor dengan parameter
    public Dosen(String Nama, String NIP, LocalDate tanggalLahir, LocalDate TMT, double gajiPokok, String NIDN, String fakultas, String jurusan) {
        super(Nama, NIP, tanggalLahir, TMT, gajiPokok);
        this.fakultas = fakultas;
        Counterdosen++;
    }
    // Selektor untuk mengembalikan fakultas
    public String getFakultas() {
        return fakultas;
    }
    // Mutator untuk mengubah fakultas
    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
}
