/* Nama File    : Teman.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 7 Mei 2026 */

public class MTeman {
    public static void main(String[] args){
        Teman t = new Teman();
        // Tambah data
        System.out.println("Tambah data teman ");
        t.addNama("Agung");
        t.addNama("Budiman");
        t.addNama("Cahya");
        t.addNama("Dede");
        t.addNama("Eko");
        t.addNama("Fajar");
        t.addNama("Gibran");
        t.addNama("Haris");
        t.addNama("Indah");
        t.addNama("Jokowi");
        t.showTeman();

        // Jumlah elemen
        System.out.println("\nJumalah elemen teman ");
        System.out.println("Jumlah teman : " + t.getNbelm());

        // Akses elemen dengan getNama
        System.out.println("\nAkses elemen dengan getNama ");
        System.out.println("Indeks 0 : " + t.getNama(0));
        System.out.println("Indeks 3 : " + t.getNama(3));
        System.out.println("Indeks 5 : " + t.getNama(5));
 
        // Ubah nama dengan setNama
        System.out.println("\nUbah nama dengan setNama ");
        System.out.println("Sebelum diubah:");
        t.showTeman();

        t.setNama(2, "Puan");
        t.setNama(5, "Anies");

        System.out.println("\nSesudah diubah:");
        t.showTeman();
 
        // Cek member dengan isMember
        System.out.println("\nCek Member dengan isMember ");
        System.out.println("Apakah Agung ada?");
        System.out.println(t.isMember("Agung"));

        System.out.println("Apakah Budi ada?");
        System.out.println(t.isMember("Budi"));

 
        // Tambah data duplikat
        System.out.println("\nTambah data duplikat ");
        t.addNama("Agung");
        t.addNama("Agung");
        t.addNama("Eko");
        t.showTeman();

        // Hitung kemunculan nama dengan countNama
        System.out.println("\nHitung kemunculan nama dengan countNama ");
        System.out.println("Jumlah Agung : "
                + t.countNama("Agung"));
        System.out.println("Jumlah Eko : "
                + t.countNama("Eko"));
        System.out.println("Jumlah Jokowi : "
                + t.countNama("Jokowi"));
 
        // Ganti nama dengan gantiNama
        System.out.println("\nGanti nama dengan gantiNama ");
        System.out.println("Sebelum diganti:");
        t.showTeman();

        t.gantiNama("Haris", "Bambang");
        t.gantiNama("Indah", "Mega");

        System.out.println("\nSesudah diganti:");
        t.showTeman();

        // Hapus nama dengan delNama
        System.out.println("\nHapus nama dengan delNama ");
        System.out.println("Sebelum dihapus:");
        t.showTeman();

        t.delNama("Dede");
        t.delNama("Agung");

        System.out.println("\nSesudah dihapus:");
        t.showTeman();

        // Jumlah elemen akhir
        System.out.println("\nJumalah elemen akhir teman ");
        System.out.println("Jumlah teman akhir : "
                + t.getNbelm());

        // Data final
        System.out.println("\nData final teman ");
        t.showTeman();
    }
}