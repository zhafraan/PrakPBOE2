/* Nama File    : CivitasAkademika.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 26 April 2026 */

//4a. Membuat Class CivitasAkademika, Dosen, dan Mahasiswa 
class CivitasAkademika {
    protected String Nama;

    public CivitasAkademika(String Nama) {
        this.Nama = Nama;
    }

    public String getNomor() {
        return "";
    }

    public String getNama() {
        return Nama;
    }
}

class Dosen2 extends CivitasAkademika {
    private String NIP;

    public Dosen2(String Nama, String NIP) {
        super(Nama);
        this.NIP = NIP;
    }

    @Override
    public String getNomor() {
        return NIP;
    }
}

class Mahasiswa2 extends CivitasAkademika {
    private String NIM;
    private Dosen2 DosenWali;

    public Mahasiswa2(String Nama, String NIM) {
        super(Nama);
        this.NIM = NIM;
    }

    @Override
    public String getNomor() {
        return NIM;
    }
    //4i. Method untuk mengubah dan mendapatkan data dosen wali mahasiswa
    public void setDosenWali(Dosen2 Wali) {
        this.DosenWali = Wali;
    }

    public Dosen2 getDosenWali() {
        return DosenWali;
    }

    void tampilDataMahasiswa() {
        System.out.println("NIM: " + NIM);
        System.out.println("Nama: " + Nama);
        System.out.println("Dosen Wali: " + DosenWali.getNama());
    }
}
    
