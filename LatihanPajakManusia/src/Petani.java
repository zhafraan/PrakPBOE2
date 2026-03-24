/* Nama File    : Petani.java
 * Deskripsi    : Berisi atribut dan method dalam class Petani(subclass) 
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 25 Maret 2026 */
import java.time.LocalDate;

public class Petani extends Manusia implements Pajak {
    //Atribut
    private static int counterPetani = 0;
    private String asal_kota;

    //Konstruktor
    public Petani(String nama, LocalDate tglMulaiKerja, String alamat, double pendapatan, String asal_kota) {
        super(nama, tglMulaiKerja, alamat, pendapatan);
        this.asal_kota = asal_kota;
        counterPetani++;
    }
    //selektor dan mutator
    public String getAsalKota(){
        return asal_kota;
    }

    public void setAsalKota(String asal_kota){
        this.asal_kota = asal_kota;
    }

     public static int getCounterPetani(){
        return counterPetani;
    }
    //Method untuk menghitung pajak dan masa kerja
    @Override
    public double hitungPajak(){
        return 0.0 ; //Petani tidak dikenakan pajak
    }

    public int hitungMasaKerja(){
        return LocalDate.now().getYear() - tgl_mulai_Kerja .getYear() + 1; //NIM digit ke 12 jadi masa kerja ditambah 1 tahun
    }
    //Method untuk mencetak informasi Petani
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Asal Kota           : " + getAsalKota());
        System.out.println("Pajak               : " + hitungPajak());
        System.out.println("Masa Kerja          : " + hitungMasaKerja() + " Tahun");
    }
}
