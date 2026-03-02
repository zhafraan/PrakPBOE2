/* Nama File    : MGaris.java
 * Deskripsi    : Main class untuk menjalankan class Garis
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 3 Maret 2026
 */

public class MGaris {
    public static void main(String[] args) {
        //garis G1 dengan titik awal (-2,0) dan titik akhir (0,4)
        Titik t1 = new Titik(-2, 0);
        Titik t2 = new Titik(0, 4);
        Garis G1 = new Garis(t1, t2);

        G1.printGaris();
        System.out.println("Panjang Garis: " + G1.getPanjang());
        System.out.println("Gradien Garis: " + G1.getGradien());
        System.out.println("Persamaan Garis: " + G1.getPersamaanGaris());
        System.out.println("Titik Tengah Garis: " + G1.getTitikTengah().getAbsis() + ", " + G1.getTitikTengah().getOrdinat());
        
        //Garis G2 dengan titik awal (1,3) dan titik akhir (3,7)
        Titik t3 = new Titik(1, 3);
        Titik t4 = new Titik(3, 7);
        Garis G2 = new Garis(t3, t4);

        G2.printGaris();
        System.out.println("Panjang Garis    : " + G2.getPanjang());
        System.out.println("Gradien Garis    : " + G2.getGradien());
        System.out.println("Persamaan Garis  : " + G2.getPersamaanGaris());
        System.out.println("Titik Tengah Garis: " + G2.getTitikTengah().getAbsis() + ", " + G2.getTitikTengah().getOrdinat());
       
        //Garis G3 dengan titik awal (0,1) dan titik akhir (2,0)
        Titik t5 = new Titik(0, 1);
        Titik t6 = new Titik(2, 0);
        Garis G3 = new Garis(t5, t6);

        G3.printGaris();
        System.out.println("Panjang Garis    : " + G3.getPanjang());
        System.out.println("Gradien Garis    : " + G3.getGradien());
        System.out.println("Persamaan Garis  : " + G3.getPersamaanGaris());
        System.out.println("Titik Tengah Garis: " + G3.getTitikTengah().getAbsis() + ", " + G3.getTitikTengah().getOrdinat());
        System.out.println("Jumlah Garis yang dibuat: " + Garis.getCounterGaris());
        
        // Mengecek apakah G1 sejajar dengan G2 dan G3 dan apakah G1 tegak lurus dengan G3
        System.out.println("G1 sejajar G2    : " + G1.isSejajar(G2));
        System.out.println("G1 sejajar G3    : " + G1.isSejajar(G3));
        System.out.println("G1 tegak lurus G3: " + G1.isTegakLurus(G3));
        System.out.println("G2 tegak lurus G3: " + G2.isTegakLurus(G3));
        
        //Total garis yang dibuat
        System.out.println("\nTotal Garis dibuat: " + Garis.getCounterGaris());
    }

}