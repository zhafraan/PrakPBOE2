/* Nama File    : Teman.java
 * Pembuat      : Aqiatillah Rezi Zhafran
 * NIM          : 24060124140124
 * Tanggal      : 7 Mei 2026 */

import java.util.*;

public class Teman {
    private int nbelm;
    private ArrayList<String> Lnama;

    // konstruktor
    public Teman() {
        this.Lnama = new ArrayList<String>();
        this.nbelm = 0;
    }
    // getter jumlah elemen
    public int getNbelm(){
        return nbelm;
    }

    // ambil nama berdasarkan indeks
    public String getNama(int indeks){
        return Lnama.get(indeks);
    }

    // set nama pada indeks tertentu
    public void setNama(int indeks, String nama){
        Lnama.set(indeks, nama);
    }

    // tambah nama
    public void addNama(String nama){
        Lnama.add(nama);
        nbelm++;
    }

    // hapus nama
    public void delNama(String nama){
        if(Lnama.remove(nama)){
            nbelm--;
        }
    }

    // cek apakah nama ada
    public boolean isMember(String nama){
        return Lnama.contains(nama);
    }

    // ganti nama
    public void gantiNama(String nama, String namaBaru){
        int idx = Lnama.indexOf(nama);
        if(idx != -1){
            Lnama.set(idx, namaBaru);
        }
    }

    // hitung kemunculan nama
    public int countNama(String nama){
        int count = 0;
        for(String n : Lnama){
            if(n.equals(nama)){
                count++;
            }
        }
        return count;
    }

    // tampilkan semua teman
    public void showTeman(){
        System.out.println("Daftar Teman:");
        for(String n : Lnama){
            System.out.println("- " + n);
        }
    }
}



    


