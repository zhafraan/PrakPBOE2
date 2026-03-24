/* Nama File    : Pengusaha.java
 * Deskripsi    : Berisi atribut dan method dalam class Pengusaha(subclass) yang mengimplementasikan interface Pajak
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 25 Maret 2026 */
import java.time.LocalDate;

public class Pengusaha extends Manusia implements Pajak {
    //Atribut
    private String npwp;
    private static int counterPengusaha = 0;
    
    //Konstruktor
    public Pengusaha(String nama, LocalDate tglMulaiKerja, String alamat,double pendapatan, String npwp){
            super(nama, tglMulaiKerja, alamat, pendapatan);
            this.npwp = npwp;
            counterPengusaha++;
    }

    //selektor dan mutator
    public String getNPWP(){
        return npwp;
    }
    public void setNPWP(String npwp){
        this.npwp = npwp;
    }
    public static int getCounterPengusaha(){
        return counterPengusaha;
    }

    //Method untuk menghitung pajak dan masa kerja
    @Override
    public double hitungPajak(){
        return 0.15 * pendapatan;
    }
    public int hitungMasaKerja(){
        return LocalDate.now().getYear() - tgl_mulai_Kerja .getYear() + 2; //NIM digit ke 13 jadi masa kerja ditambah 2 tahun
    }

    //Method untuk mencetak informasi Pengusaha
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("NPWP                : " + getNPWP());
        System.out.println("Pajak               : " + hitungPajak());
        System.out.println("Masa Kerja          : " + hitungMasaKerja() + " tahun");
    }

    
}
