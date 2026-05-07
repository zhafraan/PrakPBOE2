/* Nama File    : Anabul.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 24 April 2026 */

//3. kelas induk anabul
abstract class Anabul {
    protected String nama;

    Anabul(String nama) {
        this.nama = nama;
    }

    void gerak() {
        System.out.println(nama + " sedang bergerak.");
    }

    void bersuara() {
        System.out.println(nama + " bersuara.");
    } 
}
