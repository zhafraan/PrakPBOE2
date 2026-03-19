/* Nama File    : Persegi.java
 * Deskripsi    : Berisi atribut dan method dalam class Persegi(subclass) 
                  dangan mengimplementasikan interface IResize
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 19 Maret 2026 */

public class Persegi extends BangunDatar implements IResize {
    // Atribut sisi persegi
    private double sisi;
    // Konstruktor Persegi tanpa parameter
    public Persegi(){
        setJmlSisi(4);
    }
    // Konstruktor Persegi dengan parameter sisi
    public Persegi(double sisi){
        super(4, "Putih", "Hitam");
        this.sisi = sisi;
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
    @Override
    public double  getLuas() {
        return sisi * sisi;
    }
    // Method untuk menghitung keliling persegi
    @Override
    public double getKeliling() {
        return 4 * sisi;
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
        System.out.println("Luas : " + getLuas());
        System.out.println("Keliling : " + getKeliling());
    }
    // Implementasi method dari interface IResize untuk memperbesar dan memperkecil ukuran persegi
    @Override
    public void zoomIn() {
        sisi = sisi * 1.1;
    }

    @Override
    public void zoomOut() {
        sisi = sisi * 0.9;
    }

    @Override
    public void zoom(int percent) {
        sisi = sisi * (percent / 100.0);
    }
}
