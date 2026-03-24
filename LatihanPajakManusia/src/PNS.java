/* Nama File    : PNS.java
 * Deskripsi    : Berisi atribut dan method dalam class PNS(subclass) yang mengimplementasikan interface Pajak
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 25 Maret 2026 */
import java.time.LocalDate;

public class PNS extends Manusia implements Pajak {
    //Atribut
    private static int counterPNS = 0;
    private String nip;

    //Konstruktor
    public PNS(String nama, LocalDate tglMulaiKerja, String alamat, double pendapatan, String nip) {
        super(nama, tglMulaiKerja, alamat, pendapatan);
        this.nip = nip;
        counterPNS++;
    }

    //selektor dan mutator
    public String getNIP(){
        return nip;
    }

    public void setNIP(String nip){
        this.nip = nip;
    }
    public static int getCounterPNS(){
        return counterPNS;
    }

    //Method untuk menghitung pajak dan masa kerja
    @Override
    public double hitungPajak(){
        return 0.10 * pendapatan;
    }

    public int hitungMasaKerja(){
        return LocalDate.now().getYear() - tgl_mulai_Kerja .getYear() + 4; //NIM digit ke 14 jadi masa kerja ditambah 4 tahun
    }

    //Method untuk mencetak informasi PNS
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("NIP                 : " + getNIP());
        System.out.println("Pajak               : " + hitungPajak());
        System.out.println("Masa Kerja          : " + hitungMasaKerja() + " tahun");
    }
}
    

