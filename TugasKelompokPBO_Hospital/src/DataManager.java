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

    // Selektor
    public ArrayList<T> getAllData() {
        return dataList;
    }
}