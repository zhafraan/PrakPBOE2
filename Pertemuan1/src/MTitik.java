/* Nama File    : MTitik.java
 * Deskripsi    : Main class untuk menjalankan class Titik
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 19 Februari 2025
 */

public class MTitik {
    public static void main(String[] args) {
        Titik T1 = new Titik(); // Membuat objek titik T1 (0,0)
        T1.setAbsis(3);         // Mengubah absis T1 dengan nilai 3
        T1.setOrdinat(4);       // Mengubah ordinat T1 dengan nilai 4
        T1.printTitik();        // Mencetak koordinat T1 ke layar

        T1.geser(3, 4);         // Menggeser T1 sejauh (3,4)
        T1.printTitik();        // Menampilkan koordinat T1 setelah digeser
        Titik T2 = T1;
        T2.printTitik();        // Menampilkan koordinat T2 (sama dengan T1)
        T1.setAbsis(10);         // Mengubah absis T1 dengan nilai 10
        T1.setOrdinat(10);       // Mengubah ordinat T1 dengan nilai 10
        T2.printTitik();        // Menampilkan koordinat T2 setelah T1 diubah (sama dengan T1)
        
        System.err.println("Titik berada pada kuadran " + T1.getkuadran());
        System.err.println("Jarak titik T1 dari titik pusat adalah " + T1.getjarakPusat());
        // Membuat objek Titik T2 dan mengatur koordinatnya
        Titik T3 = new Titik();
        T3.setAbsis(-3);
        T3.setOrdinat(4);
        T3.printTitik();
        System.out.println("Titik berada pada kuadran: " + T3.getkuadran());
        System.out.println("Jarak T3 dari titik pusat: " + T3.getjarakPusat());
        // Menghitung jarak antara T1 dan T3
        double jarak = T1.getjarak(T3);
        System.out.println("Jarak antara T1 dan T3: " + jarak);
        // Menggeser T1 
        T1.geser(2, -3);
        T1.printTitik();
        System.out.println("Kuadran setelah digeser: " + T1.getkuadran());
        // Mencari refleksi T3 terhadap sumbu X dan Y
        Titik refleksiX = T3.getRefleksiX();
        System.out.print("T3 asli     : ");
        T3.printTitik();
        System.out.print("Refleksi X  : ");
        refleksiX.printTitik();
        // Mencari refleksi T3 terhadap sumbu Y
        Titik refleksiY = T3.getRefleksiY();
        System.out.print("T3 asli     : ");
        T3.printTitik();
        System.out.print("Refleksi Y  : ");
        refleksiY.printTitik();
        // Refleksi T3 terhadap sumbu X dan Y secara langsung
        System.out.print("Sebelum refleksi: ");
        T3.printTitik();
        T3.refleksiX();
        System.out.print("Setelah refleksiX: ");
        T3.printTitik();
        T3.refleksiY();
        System.out.print("Setelah refleksiY: ");
        T3.printTitik();
        // Membuat objek Titik T4 dengan koordinat default (0,0)
        Titik T4 = new Titik();
        T4.printTitik();
        System.out.println("Kuadran: " + T4.getkuadran() + " (0 = titik pusat/sumbu)");
        System.out.println("Jarak dari pusat: " + T4.getjarakPusat());
    }
}
