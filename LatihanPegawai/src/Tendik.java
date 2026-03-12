/* Nama File    : Tendik.java
 * Deskripsi    : Berisi atribut dan method dalam class Tendik(subclass dari Pegawai)
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 12 Maret 2026 */
import java.time.LocalDate;

public class Tendik extends Pegawai {
    private String Bidang;
    // Konstruktor tanpa parameter
    public Tendik() {
        super();
        this.Bidang = "belum diisi";
    }
    // Konstruktor dengan parameter
    public Tendik(String nama, String NIP, LocalDate tanggalLahir, LocalDate TMT,
                  double gajiPokok, String bidang) {
        super(nama, NIP, tanggalLahir, TMT, gajiPokok);
        this.Bidang = bidang;
    }
    // Selektor untuk mengembalikan bidang
    public String getBidang() { 
        return Bidang; 
    }
    // Mutator untuk mengubah bidang
    public void setBidang(String bidang) {
         this.Bidang = bidang; 
    }
    // Method untuk menghitung tunjangan berdasarkan masa kerja
    public double getTunjangan() {
        return 0.01 * getMasaKerjaTahun() * gajiPokok;
    }
    @Override
    public void printinfo() {
        super.printinfo();
        System.out.println("Bidang: " + Bidang);
        System.out.println("jabatan: Tendik");
        System.out.println("Tanggal Pensiun : " + hitungBUP(55));
        System.out.println("Tunjangan: " + getTunjangan());
        
    }
    
}
