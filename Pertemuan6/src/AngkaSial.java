/*  File        : AngkaSial.java
    Deskripsi   : program penggunaan exception buatan sendiri 
    pengenalan kalusa 'throw' dan 'throws' */

public class AngkaSial {
    public void cobaAngka(int angka) throws AngkaSialException {
        if(angka == 13){
            throw new AngkaSialException();
        } else {
            System.out.println("Selamat, Anda tidak memasukkan angka sial");
        }
    }
    
    public static void main(String[] args) {
        AngkaSial as = new AngkaSial();
        try {
            as.cobaAngka(1);
            as.cobaAngka(133);
            as.cobaAngka(26);
            as.cobaAngka(13);
        } 
        catch (AngkaSialException ase) {
            System.out.println(ase.getMessage());
            System.out.println("hati-hati memasukkan angka 13");
        }
    }
}