import java.util.ArrayList;
public class Mahasiswa {
    /*******************Atribut***********************/
    private String nim;
    private String nama;
    private String prodi;
    ArrayList<MataKuliah> listMatkul;
    private Dosen dosenWali;
    private Kendaraan kendaraan;
    /*******************Method***********************/
    //Konstruktor mahasiswa tanpa parameter
    public Mahasiswa() {
        this.listMatkul = new ArrayList<>();
    }

    //Konstruktor mahasiswa menggunakan parameter nim, nama, dan prodi
    public Mahasiswa(String NIM, String NamaMHS, String ProdiMHS) {
        this.nim = NIM;
        this.nama = NamaMHS;
        this.prodi = ProdiMHS;
        this.listMatkul = new ArrayList<>();
    }

    //Selektor untuk mengembalikan nim mahasiswa
    public String getNIM() {
        return this.nim;
    }

    //Selektor untuk mengembalikan nama mahasiswa
    public String getNamaMhs() {
        return this.nama;
    }

    //Selektor untuk mengembalikan prodi mahasiswa
    public String getProdiMhs() {
        return this.nama;
    }

    //Selektor untuk mengembalikan dosen wali mahasiswa
    public Dosen getDosenWali() {
        return this.dosenWali;
    }

    //Selektor untuk mengembalikan kendaraan mahasiswa
    public Kendaraan getKendaraan() {
        return this.kendaraan;
    }

    //Mutator untuk mengubah nim mahasiswa
    public void setNIM(String NIM) {
        this.nim = NIM;
    }

    //Mutator untuk mengubah nama mahasiswa
    public void setNamaMhs(String Nama) {
        this.nama = Nama;
    }

    //Mutator untuk mengubah prodi mahasiswa
    public void setProdiMhs(String Prodi) {
        this.prodi = Prodi;
    }

    //Mutator untuk mengubah dosen wali mahasiswa
    public void setDosenWaliMhs(Dosen D) {
        this.dosenWali = D;
    }

    //Mutator untuk mengubah kendaraan mahasiswa
    public void setkendaraan(Kendaraan K) {
        this.kendaraan = K;
    }

    //Method untuk menambahkan sebuah matkul ke dalam list matkul
    public void addMatKul(MataKuliah newMatkul) {
        listMatkul.add(newMatkul);
    }

    //Method untuk mengembalikan jumlah sks mahasiswa
    public int getJumlahSks() {
        int total = 0;
        int i;
        for (i = 0; i < listMatkul.size(); i++) {
            total += listMatkul.get(i).getSKS();
        }

        return total;
    }

    //Method untuk mengembalikan jumlah matkul
    public int getJumlahMatKul() {
        int total = 0;
        int i;
        for (i = 0; i < listMatkul.size(); i++) {
            if (listMatkul.get(i).getNamaMatKul() != "&") {
                total++;
            }
        }
        return total;
    }

    //Method untuk menampilkan nim, nama, dan prodi mahasiswa
    public void printMhs() {
        System.out.println("NIM: " + this.nim);
        System.out.println("Nama: " + this.nama);
        System.out.println("Prodi" + this.prodi);
    }

    //Method untuk menampilkan nim, nama, prodi, daftar mata kuliah yang diambil, data dosen wali, serta data kendaraan yang dimiliki mahasiswa
    public void printDetailMhs() {
        System.out.println("NIM: " + this.nim);
        System.out.println("Nama: " + this.nama);
        System.out.println("Prodi: " + this.prodi);
        System.out.println("Dosen Wali: " + this.dosenWali.getNama());
        System.out.println("Kendaraan: " + this.kendaraan.getJenis());
        int i;
        for (i = 0; i < listMatkul.size(); i++) {
            System.out.println(listMatkul.get(i).getNamaMatKul());
        }
    }

    
}
