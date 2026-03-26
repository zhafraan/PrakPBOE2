import java.time.LocalDate;
public class Mmanusia {
    public static void main(String[] args) {
        // Inisialisasi objek sesuai contoh modul
        PNS p1 = new PNS("Budhi", LocalDate.of(2006, 4, 1), "Jl. Tembalang", 15000000, "198302032006041002");
        Pengusaha pe1 = new Pengusaha("Aris", LocalDate.of(2000, 1, 1), "Jl. Gondang", 55000000, "2000-556-773-212");
        Petani pt1 = new Petani("Santoso", LocalDate.of(1977, 1, 9), "Jl. Bulusan 9 Tembalang", 5000000, "Wonogiri");
        PNS p2 = new PNS("Ari", LocalDate.of(2010, 4, 1), "Meteseh", 10000000, "198004212010041002");

        p2.setAlamat("Jl. Tembalang selatan 35 Tembalang");

        // Mencetak jumlah static counter 
        System.out.println("Jumlah Manusia = " + Manusia.getCounterMns());
        System.out.println("Jumlah PNS = " + PNS.getCounterPNS());
        System.out.println("Jumlah Pengusaha = " + Pengusaha.getCounterPengusaha());
        System.out.println("Jumlah Petani = " + Petani.getCounterPetani());
        System.out.println();

        // Menampilkan pajak 
        System.out.println("Pajak PNS p1 = " + p1.hitungPajak());
        System.out.println("Pajak Pengusaha pe1 = " + pe1.hitungPajak());
        System.out.println("Pajak Petani pt1 = " + pt1.hitungPajak());
        System.out.println();

        // Menampilkan masa kerja
        System.out.println("Masa Kerja p1 = " + p1.hitungMasaKerja());
        System.out.println("Masa Kerja pe1 = " + pe1.hitungMasaKerja());
        System.out.println("Masa Kerja pt1 = " + pt1.hitungMasaKerja());
        System.out.println();

        // Menampilkan informasi lengkap
        System.out.println("=== Detail Informasi ===");
        p1.printInfo();
        pe1.printInfo();
        pt1.printInfo();
    }
}
