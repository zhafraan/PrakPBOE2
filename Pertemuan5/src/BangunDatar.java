/* Nama File    : BangunDatar.java
 * Deskripsi    : Berisi atribut dan method dalam class Bangun Datar(superclass)
                  dengan method abstrak untuk menghitung luas dan keliling serta 
                  method untuk membandingkan luas dan keliling dengan bangun datar lain
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 18 Maret 2026 */

public abstract class BangunDatar {
    // Atribut untuk menyimpan jumlah sisi, warna, dan border
    protected int jmlSisi;
    protected String warna;
    protected String border;
    private static int Counterbangundatar = 0;

    public static void printCounterBangunDatar() {
        System.out.println("Jumlah Bangun Datar : " + Counterbangundatar);
    }
    // Konstruktor tanpa parameter
    public BangunDatar(){
        this.jmlSisi = 0;
        this.warna = "putih";
        this.border = "hitam";
    }
    // Konstruktor dengan parameter
    public BangunDatar(int jmlSisi, String warna, String border) {
        this.jmlSisi = jmlSisi;
        this.warna = warna;
        this.border = border;
        Counterbangundatar++;
    }
    // Selektor untuk mengembalikan jumlah sisi
    public int getJmlSisi() {
        return jmlSisi;
    } 
    // Mutator untuk mengubah jumlah sisi  
    public void setJmlSisi(int jmlSisi) {
        this.jmlSisi = jmlSisi;
    }
    // Selektor untuk mengembalikan warna
    public String getWarna() {
        return warna;
    }
    // Mutator untuk mengubah warna
    public void setWarna(String warna) {
        this.warna = warna;
    }
    // Selektor untuk mengembalikan border
    public String getBorder() {
        return border;
    }
    // Mutator untuk mengubah border
    public void setBorder(String border) {
        this.border = border;
    }
    // Method untuk mencetak informasi bangun datar
    public void printinfo() {
        System.out.println("Jumlah Sisi : " + jmlSisi);
        System.out.println("Warna : " + warna);
        System.out.println("Border : " + border);
    }
    // Method abstrak untuk menghitung luas dan keliling
    public abstract double getLuas();
    public abstract double getKeliling();
    // Method untuk membandingkan luas dan keliling dengan bangun datar lain
    public boolean isEqualLuas(BangunDatar x){
        return this.getLuas() == x.getLuas();
    }
    public boolean isEqualKeliling(BangunDatar x){
        return this.getKeliling() == x.getKeliling();
    }

}
