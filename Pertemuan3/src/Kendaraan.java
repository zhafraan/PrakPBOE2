/* Nama File    : Kendaraan.java
 * Deskripsi    : Berisi atribut dan method dalam class Kendaraan
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 5 Maret 2026 */
public class Kendaraan {
    /*******************Atribut***********************/
    private String noPlat;
    private String jenis;
    /*******************Method***********************/
    //Konstruktor kendaraan tanpa parameter
    public Kendaraan() {
        this.noPlat = "&";
        this.jenis = "&";
    }

    //Konstruktor kendaraan tanpa parameter dengan jenis antara mobil atau motor
    public Kendaraan(String Nomer, String Jenis) {
        this.noPlat = Nomer;
        this.jenis = Jenis;
    }

    //Selektor untuk mengembalikan nomor plat
    public String getNoPlat() {
        return this.noPlat;
    }

    //Selektor untuk mengembalikan jenis kendaraan;
    public String getJenis() {
        return this.jenis;
    }

    //Mutator untuk mengubah nomor plat
    public void setNoPlat(String Nomer) {
        this.noPlat = Nomer;
    }

    //Mutator untuk mengubah nomor plat
    public void setJenis(String Jenis) {
        this.jenis = Jenis;
    }

}
