/* Nama File    : MPiaraan.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 7 Mei 2026 */
public class MPiaraan {
    public static void main(String[] args) {
        Piaraan p = new Piaraan();
      
        // Tambah data anabul
        System.out.println("\nTambah data anabul ");
        Kucing k1 = new Kucing("Milo", 3.5);
        Kucing k2 = new Kucing("Oyen", 4.2);
        Kucing k3 = new Kucing("Yuppy", 2.8);

        p.enqueueAnabul(k1);
        p.enqueueAnabul(k2);
        p.enqueueAnabul(k3);

        p.showAnabul();
        // Jumalah elemen anabul
        System.out.println("\nJumalah elemen anabul");
        System.out.println("Jumlah anabul : " + p.getNbelm());
    
        // Cek member anabul
        System.out.println("\nCek Member Anabul :");
        System.out.println("Apakah Milo ada?");
        System.out.println(p.isMember(k1));
        Kucing k4 = new Kucing("Oreo", 5.0);

        System.out.println("Apakah Oreo ada?");
        System.out.println(p.isMember(k4));

        // Lihat anabul paling depan
        System.out.println("\nLihat anabul paling depan ");
        Anabul depan = p.getanabul();

        System.out.println("Nama : " + depan.getNama());
        System.out.println("Bobot : " + depan.getBobot());

        // Jumalh kucing
        System.out.println("\nJumlah kucing ");
        System.out.println("Jumlah kucing : "
                + p.countKucing());

        // Total bobot kucing
        System.out.println("\nTotal bobot kucing ");
        System.out.println("Total bobot kucing : "
                + p.bobotKucing() + " kg");

        // Tampilkan jenis anabul
        System.out.println("\nJenis anabul ");
        p.showJenisAnabul();
      
        // Dequeue anabul
        System.out.println("\nDequeue anabul");
        Anabul keluar = p.dequeueAnabul();
        System.out.println("Anabul keluar : "
                + keluar.getNama());

        // Data setelah dequeue
        System.out.println("\nData setelah dequeue");
        p.showAnabul();

        // Jumalah elemen setelah dequeue
        System.out.println("\nJumalah elemen setelah dequeue");
        System.out.println("Jumlah anabul akhir : "+ p.getNbelm());

      
        // Data final
        System.out.println("\nData final anabul ");
        p.showAnabul();
    }
}
