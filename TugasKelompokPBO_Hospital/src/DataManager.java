// Nama file    : DataManager.java
// Deskripsi    : class generic untuk mengelola berbagai jenis data rumah sakit
// Pembuat      : Kelompok 6
// Tanggal      : 30 Maret 2026

// =============================================================
// ======================= Class Generik =======================
// =============================================================

import java.util.ArrayList;

public class DataManager<T> {
    // Atribut generic
    private ArrayList<T> dataList;

    // Konstruktor
    public DataManager() {
        dataList = new ArrayList<>();
    }

    // Method untuk menambahkan data
    public void addData(T data) {
        dataList.add(data);
    }

    // Method untuk menampilkan jumlah data
    public void printSize() {
        System.out.println("Jumlah data: " + dataList.size());
    }

    // Tambahan untuk Class koleksi
    // Method untuk menghapus data 
    public T deleteData() throws Exception {
        if (dataList.isEmpty()) {
            throw new Exception("Koleksi kosong, tidak ada data yang bisa dihapus");
        }
        return dataList.remove(dataList.size() - 1);
    }

    // Method untuk mengakses data berdasarkan indeks
    public T getIsi(int indeks) throws Exception {
        if (indeks < 1 || indeks > dataList.size()) {
            throw new Exception("Indeks " + indeks + " di luar batas (1.." + dataList.size() + ")");
        }
        return dataList.get(indeks - 1);
    }

    // Method untuk mengubah data berdasarkan indeks
    public void setIsi(int indeks, T data) throws Exception {
        if (indeks < 1 || indeks > dataList.size()) {
            throw new Exception("Indeks " + indeks + " di luar batas (1.." + dataList.size() + ")");
        }
        dataList.set(indeks - 1, data);
    }
    
    // Method untuk mendapatkan jumlah data
    public int getSize() {
        return dataList.size();
    }
 
    // Selektor
    public ArrayList<T> getAllData() {
        return dataList;
    }
    
}