/* Nama File    : Kembangtelon.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 30 April 2026 */
public class Kembangtelon extends Kucing {
    public Kembangtelon(String nama, double bobot) { 
        super(nama, bobot); 
    }

    @Override 
    public String toString() { 
        return "Kembangtelon: " + nama + " (" + bobot + " kg)"; 
    }
}