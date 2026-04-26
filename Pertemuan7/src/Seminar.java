/* Nama File    : Seminar.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 26 April 2026 */

//4b. Kelas Seminar yang memiliki atribut sebuah larik (array) statis
class Seminar {
    private CivitasAkademika [] pesertas;
    private int banyakPeserta = 0;

    public Seminar() {
        this.pesertas = new CivitasAkademika[100];
        this.banyakPeserta = 0;

    }
    //4c.menghitung jumlah peserta seminar 
    public int countPeserta() {
        return banyakPeserta;
    }
    //4d. Method untuk menambahkan peserta seminar
    void registrasi(CivitasAkademika ca) {
        if (banyakPeserta < 100) {
            pesertas[banyakPeserta] = ca;
            banyakPeserta++;
        }
    }
    //4g. Method untuk menampilkan data peserta seminar
    void tampilPeserta() {
        for (int i = 0; i < banyakPeserta; i++) {
            System.out.println("Nomor: " + pesertas[i].getNomor());
            System.out.println("Nama: " + pesertas[i].getNama());
        }
    }
    //4h. Method untuk menghitung jumlah mahasiswa yang terdaftar
    public int countMahasiswa() {
        int count = 0;
        for (int i = 0; i < banyakPeserta; i++) {
            if (pesertas[i] instanceof Mahasiswa2) {
                count++;
            }
        }
        return count;
    }

  

    
}
