/* Nama File    : Lingkaran.java
 * Deskripsi    : Berisi atribut dan method dalam class Lingkaran(subclass)
                  dengan mengimplementasikan interface IResize
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 19 Maret 2026 */

public class Lingkaran extends BangunDatar implements IResize {
    // Atribut jari-jari lingkaran
    private double Jari;
    // Konstruktor Lingkaran tanpa parameter
    public Lingkaran() {
        super(0, "Putih", "Hitam");
        this.Jari = 0;
    }
    // Konstruktor Lingkaran dengan parameter diameter
    public Lingkaran(double diameter) {
        super(0, "Putih", "Hitam");
        this.Jari = diameter / 2;
    }
    // Konstruktor Lingkaran dengan parameter
    public Lingkaran(double diameter, String warna, String border) {
        super(0, warna, border);
        this.Jari = diameter / 2;
    }
    // Selektor untuk mengembalikan jari-jari
    public double getJari() {
        return Jari;
    }
    // Mutator untuk mengubah jari-jari
    public void setJari(double jari) {
        this.Jari = jari;
    }
    // Method untuk menghitung luas dan keliling lingkaran
    @Override
    public double getLuas(){
        return Math.PI * Jari * Jari;
    }
    // Method untuk menghitung keliling lingkaran
    @Override
    public double getKeliling() {
        return 2 * Math.PI * Jari;
    }
    // Override method printinfo untuk mencetak informasi lingkaran
    @Override
    public void printinfo() {
        System.out.println("Jumlah Sisi: " + getJmlSisi());
        System.out.println("Warna: " + getWarna());
        System.out.println("Border: " + getBorder());
        System.out.println("Jari-jari: " + Jari);
        System.out.println("Luas: " + getLuas());
        System.out.println("Keliling: " + getKeliling());
    }
    // Implementasi method dari interface IResize untuk memperbesar dan memperkecil ukuran lingkaran
    @Override
    public void zoomIn() {
        Jari = Jari * 1.1;
    }

    @Override
    public void zoomOut() {
        Jari = Jari * 0.9;
    }

    @Override
    public void zoom(int percent) {
        Jari = Jari * (percent / 100.0);
    }

}


