/* Nama File    : Persegi.java
 * Deskripsi    : Berisi atribut dan method dalam class Persegi(subclass)
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 12 Maret 2026 */

public class Persegi extends BangunDatar {
    // Atribut sisi persegi
    private double sisi;
    // Konstruktor Persegi tanpa parameter
    public Persegi(){
    setJmlSisi(4);
    }
    // Konstruktor Persegi dengan parameter
    public Persegi(double sisi, String warna, String border){
    super(4, warna, border);
    this.sisi = sisi;   
    }
    // Selektor untuk mengembalikan sisi
    public double getSisi() {
     return sisi;
    }
    // Mutator untuk mengubah sisi
    public void setSisi(double sisi) {
     this.sisi = sisi;
    }
    // Method untuk menghitung luas, keliling, dan diagonal persegi
    public void getLuas() {
     double luas = sisi * sisi;
     System.out.println("Luas Persegi : " + luas);
    }
    // Method untuk menghitung keliling persegi
    public void getKeliling() {
     double keliling = 4 * sisi;
     System.out.println("Keliling Persegi : " + keliling);
    }
    // Method untuk menghitung diagonal persegi
    public void getDiagonal() {
     double diagonal = sisi * Math.sqrt(2);
     System.out.println("Diagonal Persegi : " + diagonal);
    }
    // Override method printinfo untuk mencetak informasi persegi
    @Override
    public void printinfo() {
        super.printinfo();
        System.out.println("Sisi : " + sisi);
    }
}
