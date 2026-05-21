import java.util.*;

class CR_model{
    double konversi(double sc){
        return sc*0.8;
    }
    double hitung(double sc){
        return sc*0.8;
    }
}
class CR_view{
    double suhuC; 
    double suhuR;
    CR_controller CC;
    CR_view(){
        CC = new CR_controller();
        suhuC = this.getSuhu();
        suhuR = CC.konv(suhuC);
        this.show(suhuR);
    }
    void show(double sr){
        System.out.println("Nilai Konversi : "+sr);
    }
    double getSuhu(){
       double cc;
       Scanner ss;
       String t;

       System.out.print("Masukkan Suhu celcius : ");
       ss = new Scanner(System.in);
       t = ss.nextLine().toString();
       cc = Double.parseDouble(t);
       return cc;
    }
}
class CR_controller{
    double suhuC;
    double suhuR;
    CR_model M;
    CR_view V;
    CR_controller(){
        M = new CR_model();
        V = new CR_view();
        suhuC = V.getSuhu();
        suhuR = M.konversi(suhuC);
        V.show(suhuR);
    }
    double konv(double sc){
        return M.hitung(sc);
    }
}
public class CR_Main {
    public static void main(String[] args) {
        CR_view V;
        V = new CR_view();
    }
}