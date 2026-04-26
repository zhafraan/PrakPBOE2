/* Nama File    : Coercion.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 24 April 2026 */

public class Coercion {
    public static void main(String[] args){
         // 1a & 1b.Casting dan Konversi 
        int nilaiInteger = 65;
        char nilaiChar = (char) nilaiInteger; // Polimorfisme Coercion ke char
        double nilaiDouble = (double) nilaiInteger; // Coercion ke real
        int balikInteger = (int) nilaiDouble; // Kembali ke integer di variabel berbeda

        System.out.println("Integer: " + nilaiInteger);
        System.out.println("Karakter: " + nilaiChar); 
        System.out.println("Real: " + nilaiDouble);
        System.out.println("Kembali ke Integer: " + balikInteger);

        // 1c. String Konkatenasi vs Penjumlahan Integer 
        String X = "1234";
        String Y = "5678";
        String S = X + Y; // Konkatenasi
        Integer Z = Integer.parseInt(X) + Integer.parseInt(Y); // Penjumlahan
        System.out.println("Hasil S (String): " + S);
        System.out.println("Hasil Z (Integer): " + Z);

        // 1d. String Konkatenasi vs Penjumlahan Double 
        String P = "12.34";
        String Q = "56.78";
        String R = P + Q;
        Double D = Double.parseDouble(P) + Double.parseDouble(Q);
        System.out.println("Hasil R (String): " + R);
        System.out.println("Hasil D (Double): " + D);

        // 1e & 1f. Konversi 
        try {
            // S adalah "12345678", diubah ke Integer
            Integer A = Integer.valueOf(S); 
            System.out.println("Hasil konversi ke integer A: " + A);

            // A diubah kembali ke String T
            String T = A.toString();
            System.out.println("Hasil konversi ke string T: " + T);
        } catch (NumberFormatException e) {
            System.out.println("Error konversi: String S terlalu besar untuk Integer!");
        }
    }
}
