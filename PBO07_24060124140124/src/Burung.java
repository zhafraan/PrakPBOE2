/* Nama File    : Burung.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 24 April 2026 */

//3. kelas turunan dari Anabul
class Burung extends Anabul {
    Burung(String nama) {
        super(nama);
    }

    @Override
    void gerak() {
        System.out.println(nama + " bergerak dengan terbang.");
    }

    @Override
    void bersuara() {
        System.out.println(nama + " bersuara : cuit-cuit.");
    }
}
