/* Nama File    : Main.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 30 April 2026 */
package Anabul;
public class Main {
    public static void main(String[] args) {
        // Ini BOLEH karena Anggora keturunan Kucing
        Datum<Anggora> d1 = new Datum<>();
        d1.setIsi(new Anggora("Doyor", 5.6));
        System.out.println(d1.getIsi().toString());

        // Ini BOLEH karena Kembangtelon keturunan Kucing
        Datum<Kembangtelon> d2 = new Datum<>();
        d2.setIsi(new Kembangtelon("Ruby", 2.5));
        System.out.println(d2.getIsi().toString());

        // Ini TIDAK BOLEH karena Anabul bukan keturunan Kucing
        // Datum<Anabul> d3 = new Datum<>(); 
        // d3.setIsi(new Anggora("Mikasa",3.2));
        // System.out.println(d3.getIsi().toString());
        

        
       
    }
}
