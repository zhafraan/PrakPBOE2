/* Nama File    : DosenTamu.java
 * Deskripsi    : Berisi atribut dan method dalam class DosenTamu(subclass dari Dosen)
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 12 Maret 2026 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DosenTamu extends Dosen {
    private String NIDK;
    private LocalDate tanggalBerakhirKontrak;

    // Konstruktor tanpa parameter
    public DosenTamu() {
        super();
        this.NIDK = "000000000";
        this.tanggalBerakhirKontrak = LocalDate.of(1900, 1, 1);

    }
    // Konstruktor dengan parameter
    public DosenTamu(String nama, String NIP, LocalDate tanggalLahir, LocalDate TMT,
                     double gajiPokok, String NIDK, String fakultas, LocalDate tanggalBerakhirKontrak) {
        super(nama, NIP, tanggalLahir, TMT, gajiPokok, NIDK, fakultas, "belum diisi");
        this.NIDK = NIDK;
        this.tanggalBerakhirKontrak = tanggalBerakhirKontrak;
    }
    // Getter dan Setter
    public String getNIDK() {
        return NIDK;
    }
    public void setNIDK(String NIDK) {
        this.NIDK = NIDK;
    }
    public LocalDate getTanggalBerakhirKontrak() { 
        return tanggalBerakhirKontrak;
    }
    public void setTanggalBerakhirKontrak(LocalDate t) {
        this.tanggalBerakhirKontrak = t; 
    }
    // Method untuk menghitung sisa kontrak dalam bulan
    public String getSisaKontrak() {
        long totalBulan = ChronoUnit.MONTHS.between(LocalDate.now(), tanggalBerakhirKontrak);
        if (totalBulan < 0) {
            return "Kontrak habis";
        }
        return totalBulan + " bulan";
    }
    //Tunjangan untuk Dosen Tamu
    public double getTunjangan() {
        return 0.025 * gajiPokok;
    }
    @Override
    public void printinfo() {
        super.printinfo();
        System.out.println("NIDK : " + NIDK);
        System.out.println("Fakultas : " + getFakultas());
        System.out.println("Jabatan : Dosen Tamu");
        System.out.println("Sisa Kontrak : " + getSisaKontrak());
        System.out.println("Tunjangan : " + getTunjangan());
    }
}


    

