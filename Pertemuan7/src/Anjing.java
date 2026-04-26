/* Nama File    : Anjing.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 24 April 2026 */

//3. kelas turunan dari Anabul
class Anjing extends Anabul {
    Anjing(String nama) {
        super(nama);
    }

    @Override
    void gerak() {
        System.out.println(nama + " bergerak dengan melata.");
    }
    @Override
    void bersuara() {
        System.out.println(nama + " bersuara : guk-guk.");
    }

 
}
