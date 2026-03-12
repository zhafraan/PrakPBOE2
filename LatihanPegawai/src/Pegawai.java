/* Nama File    : Pegawai.java
 * Deskripsi    : Berisi atribut dan method dalam class Pegawai(superclass)
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 12 Maret 2026 */
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Pegawai {
    // Atribut untuk menyimpan nama, NIP, tanggal lahir, TMT, dan gaji pokok
    protected String nama;
    protected String NIP;
    protected LocalDate tanggalLahir;
    protected LocalDate TMT;
    protected double gajiPokok;
    private static int Counterpegawai = 0;
    public static void printCounterPegawai() {
        System.out.println("Jumlah Pegawai : " + Counterpegawai);
    }
    // Konstruktor tanpa parameter
    public Pegawai() {
        this.nama = "kosong";
        this.NIP = "000000000";
        this.tanggalLahir = LocalDate.of(1900, 1, 1);
        this.TMT = LocalDate.of(1900, 1, 1);
        this.gajiPokok = 0.0;
        Counterpegawai++;
    }
    // Konstruktor dengan parameter
    public Pegawai(String Nama, String NIP, LocalDate tanggalLahir, LocalDate TMT, double gajiPokok) {
        this.nama = Nama;
        this.NIP = NIP;
        this.tanggalLahir = tanggalLahir;
        this.TMT = TMT;
        this.gajiPokok = gajiPokok;
        Counterpegawai++;
    }
    // Selektor untuk mengembalikan nama
    public String getNama() {
        return nama;
    }
    // Mutator untuk mengubah nama
    public void setNama(String nama) {
        this.nama = nama;
    }
    // Selektor untuk mengembalikan NIP
    public String getNIP() {
        return NIP;
    }
    // Mutator untuk mengubah NIP
    public void setNIP(String NIP) {
        this.NIP = NIP;
    }
    // Selektor untuk mengembalikan tanggal lahir
    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }
    // Mutator untuk mengubah tanggal lahir
    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    // Selektor untuk mengembalikan TMT
    public LocalDate getTMT() {
        return TMT;
    }
    // Mutator untuk mengubah TMT
    public void setTMT(LocalDate TMT) {
        this.TMT = TMT;
    }
    // Selektor untuk mengembalikan gaji pokok
    public double getGajiPokok() {
        return gajiPokok;
    }
    // Mutator untuk mengubah gaji pokok
    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }
    // Method untuk menghitung masa kerja dalam format tahun dan bulan
    public String getMasaKerja() {
        Period p = Period.between(TMT, LocalDate.now());
        return p.getYears() + " tahun " + p.getMonths() + " bulan";
    }
    // Method untuk menghitung masa kerja dalam tahun saja
    public int getMasaKerjaTahun() {
        return Period.between(TMT, LocalDate.now()).getYears();
    }
    // Method untuk memformat tanggal 
    public String formatTanggal(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("id", "ID"));
        return date.format(formatter);
    }
    //Method BUP
    public String hitungBUP(){
        return hitungBUP(65); 
    }
    public String hitungBUP(int usiaPensiun) {
        // Jatuh pada tanggal 1 bulan berikutnya setelah usia BUP tercapai
        LocalDate bupDate = tanggalLahir.plusYears(usiaPensiun).plusMonths(1).withDayOfMonth(1);
        return formatTanggal(bupDate);
    }
    // Method untuk mencetak informasi pegawai
    public void printinfo() {
        System.out.println("Nama : " + nama);
        System.out.println("NIP : " + NIP);
        System.out.println("Tanggal Lahir : " + formatTanggal(tanggalLahir));
        System.out.println("TMT : " + formatTanggal(TMT));
        System.out.println("Masa Kerja : " + getMasaKerja());
        System.out.println("Gaji Pokok : " + gajiPokok);
        
       
        
    }
}
