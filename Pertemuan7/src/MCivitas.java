/* Nama File    : MCivitas.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 26 April 2026 */

//4e & 4f. Kelas Main untuk menguji kelas CivitasAkademika, Dosen, Mahasiswa, dan Seminar
public class MCivitas {
    public static void main(String[] args) {
        //Membuat objek dosen dan mahasiswa
        Dosen2 d1 = new Dosen2("Edy Suharto", "831029384");
        Dosen2 d2 = new Dosen2("Yunila", "963847562");
        
        Mahasiswa2 m1 = new Mahasiswa2("Budi", "24060124");
        Mahasiswa2 m2 = new Mahasiswa2("Andi", "24060125");
        Mahasiswa2 m3 = new Mahasiswa2("Daffa", "24060126");
        Mahasiswa2 m4 = new Mahasiswa2("Atik", "24060127");
        Mahasiswa2 m5 = new Mahasiswa2("Aulia", "24060128");
        //Mengatur dosen wali untuk setiap mahasiswa
        m1.setDosenWali(d1);
        m2.setDosenWali(d1);
        m3.setDosenWali(d2);
        m4.setDosenWali(d2);
        m5.setDosenWali(d2);
        //Membuat objek seminar dan mendaftarkan peserta
        Seminar s = new Seminar();
        s.registrasi(d1);
        s.registrasi(d2);
        s.registrasi(m1);
        s.registrasi(m2);
        s.registrasi(m3);
        s.registrasi(m4);
        s.registrasi(m5);
        //Tampilkan jumlah peserta seminar
        System.out.println("Jumlah peserta: " + s.countPeserta());
        //Tampilkan data peserta seminar
        System.out.println("\nDaftar Peserta:");
        s.tampilPeserta();
        //Tampilkan jumlah mahasiswa yang terdaftar
        System.out.println("\nJumlah Mahasiswa: " + s.countMahasiswa());
        //Tampilkan data mahasiswa beserta dosen walinya
        System.out.println("\nData Mahasiswa:");
        m1.tampilDataMahasiswa();
        m2.tampilDataMahasiswa();
        m3.tampilDataMahasiswa();
        m4.tampilDataMahasiswa();
        m5.tampilDataMahasiswa();
    }
}