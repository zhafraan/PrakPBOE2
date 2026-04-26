/* Nama File    : MAnabul.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 26 April 2026 */

//3. kelas main anabul
public class MAnabul {
    public static void main(String[] args) {
        Anabul K = new Kucing("Persia");
        Anabul A = new Anjing("German shepherd");
        Anabul B = new Burung("Jalak");

        K.gerak(); K.bersuara();
        A.gerak(); A.bersuara();
        B.gerak(); B.bersuara(); 
    }
}
