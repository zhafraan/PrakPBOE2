/* Nama         : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 24 April 2026 */
public class Main {
    public static void main(String[] args) {
        // 2c. Aplikasi Konstruktor Tanpa Parameter
        Mahasiswa m1 = new Mahasiswa();
        System.out.print("M1 (Default): ");
        m1.tampilData();

        // 2d. Aplikasi Konstruktor 3 Parameter
        Mahasiswa m2 = new Mahasiswa("24060124140124", "Zhafran", "Informatika");
        System.out.print("M2 (Input): ");
        m2.tampilData();

        // 2e. Aplikasi Konstruktor Kloning
        Mahasiswa m3 = new Mahasiswa(m2);
        System.out.print("M3 (Kloning M2): ");
        m3.tampilData();

        System.out.println("Test Overloading Method setProgramStudi");

        // Overloading Varian 1: Tanpa Parameter
        m1.setProgramStudi(); 
        System.out.print("M1 setelah setProgramStudi(): ");
        m1.tampilData();

        // Overloading Varian 2: Parameter String
        m1.setProgramStudi("Sistem Informasi");
        System.out.print("M1 setelah setProgramStudi(String): ");
        m1.tampilData();

        // Overloading Varian 3: Parameter Objek Mahasiswa
        m1.setProgramStudi(m2);
        System.out.print("M1 setelah setProgramStudi(m2): ");
        m1.tampilData();
    }
    
}
