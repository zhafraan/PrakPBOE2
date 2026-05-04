/* Nama File    : Anggora.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 30 April 2026 */

package Anabul;

public class Anggora extends Kucing {
    public Anggora(String Nama, double Bobot) {
        super(Nama, Bobot);
    }
    @Override
    public String toString() {
        return "Anggora: " + nama + " (" + bobot + " kg)";
    }
}
