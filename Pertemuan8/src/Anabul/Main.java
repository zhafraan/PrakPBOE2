/* Nama File    : Main.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 30 April 2026 */
public class Main {
    public static void main(String[] args) {
        // Ini BOLEH karena Anggora keturunan Kucing
        Datum<Anggora> d1 = new Datum<>();
        d1.setIsi(new Anggora("Dior", 5.4));
        System.out.println(d1.getIsi().toString());

        // Ini BOLEH karena Kembangtelon keturunan Kucing
        Datum<Kembangtelon> d2 = new Datum<>();
        d2.setIsi(new Kembangtelon("Ruby", 2.5));
        System.out.println(d2.getIsi().toString());

        /*
        Datum<Anabul> d3 = new Datum<>(); 
        */
       
    }
}