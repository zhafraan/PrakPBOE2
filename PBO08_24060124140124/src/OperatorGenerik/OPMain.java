/* Nama File    : OPMain.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 4 Mei 2026 */

package OperatorGenerik;
import Anabul.*;

public class OPMain {
    public static void main(String[] args) {
        // Membuat objek Datum untuk tipe data Integer
        Datum<Integer> datumInt1 = new Datum<>();
        datumInt1.setIsi(10);
        Datum<Integer> datumInt2 = new Datum<>();
        datumInt2.setIsi(20);

        // Membuat objek OperatorGenerik
        OperatorGenerik opGen = new OperatorGenerik();

        // Menukar isi dari dua Datum Integer
        System.out.println("Sebelum tukar: " + datumInt1.getIsi() + ", " + datumInt2.getIsi());
        opGen.Tukar(datumInt1, datumInt2);
        System.out.println("Setelah tukar: " + datumInt1.getIsi() + ", " + datumInt2.getIsi());

        // Membuat objek Datum untuk tipe data Kucing
        Kucing kucing1 = new Kucing("Mikasa", 4.5);
        Kucing kucing2 = new Kucing("Yuppy", 3.2);
        Datum<Kucing> datumKucing1 = new Datum<>();
        datumKucing1.setIsi(kucing1);
        Datum<Kucing> datumKucing2 = new Datum<>();
        datumKucing2.setIsi(kucing2);

        // Menghitung bobot total dari dua Kucing menggunakan Bobot2
        double totalBobot = opGen.Bobot2(datumKucing1, datumKucing2);
        System.out.println("Total bobot kedua kucing: " + totalBobot);
    }
}
