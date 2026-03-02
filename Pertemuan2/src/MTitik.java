/* Nama File    : MTitik.java
 * Deskripsi    : Main class untuk menjalankan class Titik
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 27 Februari 2026
 */
public class MTitik {
    public static void main(String[] args) {
        // Membuat objek Titik T1 dan mengatur koordinatnya
        Titik T1 = new Titik(); 
        T1.setAbsis(5);         
        T1.setOrdinat(6);       
        T1.printTitik();   
        
        System.err.println("Titik berada pada kuadran " + T1.getkuadran());
        System.err.println("Jarak titik T1 dari titik pusat adalah " + T1.getjarakPusat());
        // Membuat objek Titik T2 dan mengatur koordinatnya
        Titik T2 = new Titik();
        T2.setAbsis(-3);
        T2.setOrdinat(4);
        T2.printTitik();
        System.out.println("Titik berada pada kuadran: " + T2.getkuadran());
        System.out.println("Jarak T2 dari titik pusat: " + T2.getjarakPusat());
        // Menghitung jarak antara T1 dan T2
        double jarak = T1.getjarak(T2);
        System.out.println("Jarak antara T1 dan T2: " + jarak);
        // Menggeser T1 
        T1.geser(2, -3);
        T1.printTitik();
        System.out.println("Kuadran setelah digeser: " + T1.getkuadran());
        // Mencari refleksi T2 terhadap sumbu X dan Y
        Titik refleksiX = T2.getRefleksiX();
        System.out.print("T2 asli     : ");
        T2.printTitik();
        System.out.print("Refleksi X  : ");
        refleksiX.printTitik();
        // Mencari refleksi T2 terhadap sumbu Y
        Titik refleksiY = T2.getRefleksiY();
        System.out.print("T2 asli     : ");
        T2.printTitik();
        System.out.print("Refleksi Y  : ");
        refleksiY.printTitik();
        // Refleksi T2 terhadap sumbu X dan Y secara langsung
        System.out.print("Sebelum refleksi: ");
        T2.printTitik();
        T2.refleksiX();
        System.out.print("Setelah refleksiX: ");
        T2.printTitik();
        T2.refleksiY();
        System.out.print("Setelah refleksiY: ");
        T2.printTitik();
        // Membuat objek Titik T3 dengan koordinat default (0,0)
        Titik T3 = new Titik();
        T3.printTitik();
        System.out.println("Kuadran: " + T3.getkuadran() + " (0 = titik pusat/sumbu)");
        System.out.println("Jarak dari pusat: " + T3.getjarakPusat());

    }
}
