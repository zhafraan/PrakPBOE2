public class MataKuliah {
    /*******************Atribut***********************/
    private String idMatKul;
    private String namaMatKul;
    private int sks;
    /*******************Method***********************/
    //Konstruktor matkul tanpa parameter
    public MataKuliah() {
        this.idMatKul = "&";
        this.namaMatKul = "&";
        this.sks = -1;
    }
    //Konstruktor matkul dengan parameter idMatKul, namaMatKul, sks
    public MataKuliah(String ID, String NamaM, int S) {
        this.idMatKul = ID;
        this.namaMatKul = NamaM;
        this.sks = S;
    } 

    //Selektor untuk mengembalikan idmatkul
    public String getIDMatKul() {
        return this.idMatKul;
    }

    //Selektor untuk mengembalikan nama matkul
    public String getNamaMatKul() {
        return this.namaMatKul;
    }

    //Selektor untuk mengembalikan sks
    public int getSKS() {
        return this.sks;
    }

    //Mutator untuk mengubah idmatkul
    public void setIDMatkul(String ID) {
        this.idMatKul = ID;
    }

    //Mutator untuk mengubah nama matkul
    public void setNamaMatkul(String Nama) {
        this.namaMatKul = Nama;
    }

    //Mutator untuk mengubah prodi
    public void setSKS(int S) {
        this.sks = S;
    }
}

