/* Nama File    : Garis.java
 * Deskripsi    : Berisi atribut dan method dalam class Garis
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 27 Februari 2026
 */

public class Garis {
    private Titik titikAwal;
    private Titik titikAkhir;
    private static int counterGaris = 0;

    // Konstruktor tanpa parameter
    public Garis() {
        this.titikAwal = new Titik(0,0);
        this.titikAkhir = new Titik(1,1);
        counterGaris++;
    }

    // Konstruktor dengan parameter
    public Garis(Titik awal, Titik akhir) {
        this.titikAwal = awal;
        this.titikAkhir = akhir;
        counterGaris++;
    }

    // Selektor dan Mutator
    public Titik getTitikAwal() { 
        return titikAwal; 
    }

    public void setTitikAwal(Titik awal) { 
        this.titikAwal = awal; 
    }

    public Titik getTitikAkhir() { 
        return titikAkhir; 
    }

    public void setTitikAkhir(Titik akhir) { 
        this.titikAkhir = akhir; 
    }

    public static int getCounterGaris() { 
        return counterGaris; 
    }

    // Method Operasional
    public double getPanjang() {
        return titikAwal.getjarak(titikAkhir);
    }

    public double getGradien() {
        return (titikAkhir.getOrdinat() - titikAwal.getOrdinat()) / 
               (titikAkhir.getAbsis() - titikAwal.getAbsis());
    }

    public Titik getTitikTengah() {
        return new Titik((titikAwal.getAbsis() + titikAkhir.getAbsis()) / 2, 
                         (titikAwal.getOrdinat() + titikAkhir.getOrdinat()) / 2);
    }

    public boolean isSejajar(Garis G) {
        return this.getGradien() == G.getGradien();
    }

    public boolean isTegakLurus(Garis G) {
        return this.getGradien() * G.getGradien() == -1;
    }

    public void printGaris() {
        System.out.print("Garis dari ");
        titikAwal.printTitik();
        System.out.print(" ke ");
        titikAkhir.printTitik();
    }

    public String getPersamaanGaris() {
        double m = getGradien();
        double c = titikAwal.getOrdinat() - (m * titikAwal.getAbsis());
        return "y = " + m + "x + " + c;
    }
}