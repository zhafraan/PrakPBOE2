/* Nama File    : Piaraan.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 7 Mei 2026 */
import java.util.LinkedList;
import java.util.Queue;

public class Piaraan {
    private int nbelm;
    private Queue<Anabul> Lanabul; // Menggunakan Queue untuk antrean 

    public Piaraan() {
        this.Lanabul = new LinkedList<>(); // Instansiasi pada konstruktor 
        this.nbelm = 0;
    }

    // B. I
    public int getNbelm(){
        return this.nbelm;
    }

    // b. II
    public void enqueueAnabul (Anabul anabul) {
        this.Lanabul.add(anabul);
        this.nbelm++;
    }

    //b III
    public boolean isMember(Anabul anabul) {
        return Lanabul.contains(anabul);
    }

    //b IV
    public Anabul getanabul(){
        return this.Lanabul.peek();
    }

    // b V
    public Anabul dequeueAnabul() {
        Anabul a = this.Lanabul.poll();
        if (a != null) {
            this.nbelm--;
        }
        return a;
    }

    // c
    public void showAnabul() {
        for (Anabul a : this.Lanabul) {
            System.out.println("Anabul: " + a.getNama());
        }
    }
    
    public int countKucing(){
        int count = 0;
        for (Anabul a : this.Lanabul){
            if (a instanceof Kucing){
                count++;
            }
        }
        return count;
    }

    public double bobotKucing(){
        double bobot = 0;
        for (Anabul a : this.Lanabul){
            if (a instanceof Kucing){
                bobot = bobot + a.getBobot();
            }
        }
        return bobot;
    }

    public void showJenisAnabul() {
        for (Anabul a : this.Lanabul) {
            System.out.println("Panggilan" + a.getNama() + "Jenis" + a.getClass().getName());
        }
    }  
}
