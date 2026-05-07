/* Nama File    : Data.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 4 Mei 2026 */
package LarikGenerik;

public class Data<T> {
    private Object[] ruang = new Object[100];
    private int banyak = 0;
    @SuppressWarnings("unchecked")
    public T getIsi(int idx) {
        return (T) ruang[idx];
    }
    public void setIsi(int idx, T isi) {
        ruang[idx] = isi;
        if (idx >= banyak) {
            banyak = idx + 1;
        }
    }
    public int getSize() {
        return banyak;
    }
}
