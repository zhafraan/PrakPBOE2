/* Nama File    : Datum.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 30 April 2026 */
public class Datum<T extends Kucing>{
    private T isi;

    public void setIsi(T isibaru) { 
        this.isi = isibaru; 
    }

    public T getIsi() { 
        return this.isi; 
    }
}