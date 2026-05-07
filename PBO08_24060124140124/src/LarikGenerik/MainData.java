/* Nama File    : MainData.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 4 Mei 2026 */
package LarikGenerik;
import Anabul.*;
public class MainData {
    public static void main(String[] args) {
        // Membuat objek Data untuk tipe data Kucing
        Data<Kucing> dataKucing = new Data<>();

        dataKucing.setIsi(0, new Kucing("Mikasa", 4.5));
        dataKucing.setIsi(1, new Kucing("Yuppy", 3.2));
        dataKucing.setIsi(2, new Kucing("Doyor", 5.6));
        dataKucing.setIsi(3, new Kucing("Ruby", 3.5));
        // Menampilkan data kucing yang telah disimpan
        System.out.println("Data Kucing:");
        for (int i = 0; i < dataKucing.getSize(); i++) {
            System.out.println("Data ke-" + i + ":");
            System.out.println(dataKucing.getIsi(i));
        }
    }
    
}
