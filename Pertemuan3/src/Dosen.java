public class Dosen {
    /*******************Atribut***********************/
    private String nip;
    private String nama;
    private String prodi;

    /*******************Method***********************/
    //Konstruktor dosen tanpa parameter
    public Dosen() {
        this.nip = "&";
        this.nama = "&";
        this.prodi = "&";
    }
    //Konstruktor dosen menggunakan parameter nip, nama, dan string
    public Dosen(String NIP, String Nama, String Prodi) {
        this.nip = NIP;
        this.nama = Nama;
        this.prodi = Prodi;
    }

    //Selektor untuk mengembalikan nip
    public String getNIP() {
        return this.nip;
    }
    //Selektor untuk mengembalikan nama
    public String getNama() {
        return this.nama;
    }
    //Selektor untuk mengembalikan prodi
    public String getProdi() {
        return this.prodi;
    }
    //Mutator untuk mengubah nip
    public void setNIP(String NIP) {
        this.nip = NIP;
    }
    //Mutator untuk mengubah nama
    public void setNama(String Nama) {
        this.nama = Nama;
    }
    //Mutator untuk mengubah prodi
    public void setProdi(String Prodi) {
        this.prodi = Prodi;
    }
}
