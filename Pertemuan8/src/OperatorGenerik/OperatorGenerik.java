/* Nama File    : OperatorGenerik.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 4 Mei 2026 */
package OperatorGenerik;
import Anabul.Datum;
import Anabul.Kucing;


public class OperatorGenerik {
    // Menukar isi dari dua objek Datum untuk tipe data apa pun
    public <T> void Tukar(Datum<T> a, Datum<T> b) {
        T temp = a.getIsi();
        a.setIsi(b.getIsi());
        b.setIsi(temp);
    }

    // Menghitung bobot khusus untuk Datum yang berisi objek turunan Kucing
    public <T extends Kucing> double Bobot2(Datum<T> d1, Datum<T> d2) {
        return d1.getIsi().getBobot() + d2.getIsi().getBobot();
    }
}
