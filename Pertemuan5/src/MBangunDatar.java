/* Nama File    : MBangunDatar.java
 * Deskripsi    : Main class untuk menjalankan program Bangun Datar
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 19 Maret 2026 */
public class MBangunDatar {
    public static void main(String[] args) {
        // Baris berikut tidak valid karena BangunDatar adalah abstract class:
        // BangunDatar b1 = new BangunDatar();

        BangunDatar p1 = new Persegi(10);
        Persegi p2 = new Persegi(5);
        BangunDatar l1 = new Lingkaran(7);
        Lingkaran l2 = new Lingkaran(14);

        System.out.println("Persegi p1");
        p1.printinfo();
        System.out.println();

        System.out.println("Persegi p2");
        p2.printinfo();
        p2.getDiagonal();
        System.out.println();

        System.out.println("Lingkaran l1");
        l1.printinfo();
        System.out.println();

        System.out.println("Lingkaran l2");
        l2.printinfo();
        System.out.println();

        System.out.println("Perbandingan Luas dan Keliling");
        System.out.println("p1 sama luas dengan p2? " + p1.isEqualLuas(p2));
        System.out.println("p1 sama keliling dengan p2? " + p1.isEqualKeliling(p2));
        System.out.println("p1 sama luas dengan l1? " + p1.isEqualLuas(l1));
        System.out.println("p1 sama keliling dengan l1? " + p1.isEqualKeliling(l1));
        System.out.println();

        System.out.println("Eksperimen IResize");
        System.out.println("Sisi p2 awal: " + p2.getSisi());
        p2.zoomIn();
        System.out.println("Sisi p2 setelah zoomIn(): " + p2.getSisi());
        p2.zoomOut();
        System.out.println("Sisi p2 setelah zoomOut(): " + p2.getSisi());
        p2.zoom(200);
        System.out.println("Sisi p2 setelah zoom(200): " + p2.getSisi());
        System.out.println();

        System.out.println("Jari-jari l2 awal: " + l2.getJari());
        l2.zoomIn();
        System.out.println("Jari-jari l2 setelah zoomIn(): " + l2.getJari());
        l2.zoomOut();
        System.out.println("Jari-jari l2 setelah zoomOut(): " + l2.getJari());
        l2.zoom(50);
        System.out.println("Jari-jari l2 setelah zoom(50): " + l2.getJari());
    }
}