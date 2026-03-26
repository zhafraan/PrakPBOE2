/*  File        : Asersi2.java 
    Deskripsi   : Program untuk menunjukkan penggunaan asersi 
                  pada java dengan kasus Lingkaran*/

class Lingkaran{
    private double jariJari;
    public Lingkaran(double jariJari){
        this.jariJari = jariJari;
    }
    public double hitungKeliling(){
        double keliling = 2 * Math.PI * jariJari;
        return keliling;
    }
}

public class Asersi2 {
    public static void main(String[] args) {
        double jariJari = 12.0;
        assert(jariJari > 0): "Jari-jari harus lebih besar dari 0";
        Lingkaran l = new Lingkaran(jariJari);
        double keliling = l.hitungKeliling();
        System.out.println("Keliling lingkaran: " + keliling);
    }
    
}
