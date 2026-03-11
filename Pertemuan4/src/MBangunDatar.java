public class MBangunDatar {
    public static void main(String[] args) {
        // Membuat objek Persegi
        Persegi persegi1 = new Persegi(5, "merah", "hitam");
        System.out.println("Informasi Persegi:");
        persegi1.printinfo();
        persegi1.getLuas();
        persegi1.getKeliling();
        persegi1.getDiagonal();
        System.out.println();
        // Membuat objek Lingkaran
        Lingkaran lingkaran1 = new Lingkaran(3, "biru", "putih");
        System.out.println("Informasi Lingkaran:");
        lingkaran1.printinfo();
        lingkaran1.getLuas();
        lingkaran1.getKeliling();
        System.out.println();
        // Menampilkan jumlah bangun datar yang telah dibuat
        BangunDatar.printCounterBangunDatar();
    }
    
}
