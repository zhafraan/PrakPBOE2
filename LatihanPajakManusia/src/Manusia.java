/* Nama File    : Manusia.java
 * Deskripsi    : Berisi atribut dan method dalam class Manusia(superclass)
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 25 Maret 2026 */
import java.time.LocalDate;

public abstract class Manusia {
    //Atribut
    protected String nama;
    protected LocalDate tgl_mulai_Kerja;
    protected String alamat;
    protected double pendapatan;
    protected static int counterMns = 0;

    //Konstruktor
    public Manusia(){
        this.nama = "";
        this.tgl_mulai_Kerja = LocalDate.now();
        this.alamat = "";
        this.pendapatan = 0.0; 
    }

    //Konstruktor dengan parameter
     public Manusia(String nama, LocalDate tgl_mulai_Kerja, String alamat, double pendapatan){
        this.nama = nama;
        this.tgl_mulai_Kerja = tgl_mulai_Kerja;
        this.alamat = alamat;
        this.pendapatan = pendapatan;
        counterMns++;
    }
    
    //Selektor dan Mutator
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LocalDate getTgl_mulai_Kerja() {
        return tgl_mulai_Kerja;
    }

    public void setTgl_mulai_Kerja(LocalDate tgl_mulai_Kerja) {
        this.tgl_mulai_Kerja = tgl_mulai_Kerja;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


    public double getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(double pendapatan) {
        this.pendapatan = pendapatan;
    }

    public static int getCounterMns(){
        return counterMns;
    }
    //Abstract method 
    public abstract  int hitungMasaKerja();

    //Method untuk mencetak informasi manusia
    public void printInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("Tanggal Mulai Kerja: " + getTgl_mulai_Kerja());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("Pendapatan: " + getPendapatan());
    }
}
