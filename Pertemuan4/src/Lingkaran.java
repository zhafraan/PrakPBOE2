/* Nama File    : Lingkaran.java
 * Deskripsi    : Berisi atribut dan method dalam class Lingkaran(subclass)
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 12 Maret 2026 */

public class Lingkaran extends BangunDatar {
    // Atribut jari-jari lingkaran
    private double Jari;
    // Konstruktor Lingkaran tanpa parameter
    public Lingkaran() {
        this.Jari = 0;
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
    public void getLuas(){
        double luas = Math.PI * Jari * Jari;
        System.out.println("Luas Lingkaran : " + luas);
    }
    // Method untuk menghitung keliling lingkaran
    public void getKeliling() {
        double keliling = 2 * Math.PI * Jari;
        System.out.println("Keliling Lingkaran : " + keliling);
    }
    // Override method printinfo untuk mencetak informasi lingkaran
    @Override
    public void printinfo() {
        System.out.println("Jumlah Sisi: " + getJmlSisi());
        System.out.println("Warna: " + getWarna());
        System.out.println("Border: " + getBorder());
        System.out.println("Jari-jari: " + Jari);
    }
}


