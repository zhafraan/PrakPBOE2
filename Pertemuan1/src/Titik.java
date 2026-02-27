/* Nama File    : Titik.java
 * Deskripsi    : Berisi atribut dan method dalam class Titik
 * Pembuat      : Aqiatillah Rezi Zhafran/24060124140124
 * Tanggal      : 19 Februari 2025
 */
public class Titik {
    /****** ATRIBUT ******/
    double absis;
    double ordinat;

    /****** METHOD ******/
    // Konstruktor untuk membuat titik (0,0)
    Titik() {
        absis = 0;
        ordinat = 0;
    }

    // Mengembalikan nilai absis
    double getAbsis() {
        return absis;
    }

    // Mengembalikan nilai ordinat
    double getOrdinat() {
        return ordinat;
    }

    // Mengeset absis titik dengan nilai baru x
    void setAbsis(double x) {
        absis = x;
    }

    // Mengeset ordinat titik dengan nilai baru y
    void setOrdinat(double y) {
        ordinat = y;
    }

    // Menggeser nilai absis dan ordinat titik masing-masing sejauh x dan y
    void geser(double x, double y) {
        absis = absis + x;
        ordinat = ordinat + y;
    }

    // Mencetak koordinat titik
    void printTitik() {
        System.out.println("Titik (" + absis + "," + ordinat + ")");
    }

    //Mencari Kuadran dari titik
    int getkuadran() {
        if (absis > 0 && ordinat > 0) {
            return 1; // Kuadran I
        } else if (absis < 0 && ordinat > 0) {
            return 2; // Kuadran II
        } else if (absis < 0 && ordinat < 0) {
            return 3; // Kuadran III
        } else if (absis > 0 && ordinat < 0) {
            return 4; // Kuadran IV
        } else {
            return 0; 
        }
    }

    //Mencari jarak dari titik pusat
    double getjarakPusat() {
        return Math.sqrt(absis * absis + ordinat * ordinat);
    }

    //Mencari jarak antara titik ini 
    double getjarak(Titik T) {
        double dx =this. absis - T.getAbsis();
        double dy = this.ordinat - T.getOrdinat();
        return Math.sqrt(dx * dx + dy * dy);
    }
    //Refleksi titik terhadap sumbu X
    void refleksiX() {
        ordinat = -ordinat;
    }
    //Refleksi titik terhadap sumbu Y
    void refleksiY() {
        absis = -absis;
    }

    // getRefleksiX()
    Titik getRefleksiX() {
        Titik refleksi = new Titik();
        refleksi.setAbsis(absis);
        refleksi.setOrdinat(-ordinat);
        return refleksi;
        }

    // getRefleksiY() 
    Titik getRefleksiY() {
        Titik refleksi = new Titik();
        refleksi.setAbsis(-absis);
        refleksi.setOrdinat(ordinat);
        return refleksi;
    }
   
} // end class Titik