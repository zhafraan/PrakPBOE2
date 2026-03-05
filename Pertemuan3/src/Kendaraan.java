public class Kendaraan {
    /*******************Atribut***********************/
    private String NoPlat;
    private String jenis;
    /*******************Method***********************/
    //Konstruktor kendaraan tanpa parameter
    public Kendaraan() {
        this.NoPlat = "&";
        this.jenis = "&";
    }

    //Konstruktor kendaraan tanpa parameter dengan jenis antara mobil atau motor
    public Kendaraan(String Nomer, String Jenis) {
        this.NoPlat = Nomer;
        this.jenis = Jenis;
    }

    //Selektor untuk mengembalikan nomor plat
    public String getNoPlat() {
        return this.NoPlat;
    }

    //Selektor untuk mengembalikan jenis kendaraan;
    public String getJenis() {
        return this.jenis;
    }

    //Mutator untuk mengubah nomor plat
    public void setNoPlat(String Nomer) {
        this.NoPlat = Nomer;
    }

    //Mutator untuk mengubah nomor plat
    public void setJenis(String Jenis) {
        this.jenis = Jenis;
    }

}
