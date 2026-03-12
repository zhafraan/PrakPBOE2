/* Nama File    : DosenTetap.java
 * Deskripsi    : Berisi atribut dan method dalam class DosenTetap(subclass dari Dosen)
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 12 Maret 2026 */
import java.time.LocalDate;

public class DosenTetap extends Dosen {
        private String NIDN;
       // Konstruktor tanpa parameter
        public DosenTetap() {
            super();
            this.NIDN = "000000000";
        }
        // Konstruktor dengan parameter
        public DosenTetap(String Nama, String NIP, LocalDate tanggalLahir, LocalDate TMT, double gajiPokok, String NIDN, String fakultas) {
            super(Nama, NIP, tanggalLahir, TMT, gajiPokok, NIDN, fakultas, "belum diisi");
            this.NIDN = NIDN;
        }
        // Getter dan Setter
        public String getNIDN() {
            return NIDN;
        }
        public void setNIDN(String NIDN) {
            this.NIDN = NIDN;
        }
        // Tunjangan untuk Dosen Tetap
        public double getTunjangan() {
            return 0.02 * getMasaKerjaTahun() * gajiPokok;
        }
        @Override
        public void printinfo() {
            super.printinfo();
            System.out.println("NIDN: " + NIDN);
            System.out.println("Fakultas : " + getFakultas());
            System.out.println("Jabatan : Dosen Tetap");
            System.out.println("Tanggal Pensiun : " + hitungBUP(65));
            System.out.println("Tunjangan: " + getTunjangan());
        }
       
    }
    