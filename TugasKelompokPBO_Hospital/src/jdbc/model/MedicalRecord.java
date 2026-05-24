package jdbc.model;
// Nama file    : MedicalRecord.java
// Deskripsi    : class untuk mengelola rekam medis pasien di rumah sakit
// Pembuat      : Kelompok 6
// Anggota      : Aditya Sultonul Ulya - 240601214120006
//                Aqiatillah Rezi Zhafran - 24060124140124
//                Claudia Meitania Putri - 24060124140188
//                Raffi Arditama - 24060124120020
//                Felicia Evelina - 24060124120012
// Tanggal      : 30 Maret 2026
import java.util.ArrayList;
 
public class MedicalRecord {
    // Atribut
    private String recordID;

    // ===============================================
    // =========== Parametric Polymorphism ===========
    // ===============================================
    private ArrayList<String> entries;

    // Konstruktor
    public MedicalRecord(String recordID) {
        this.recordID = recordID;
        this.entries = new ArrayList<>();
    }
    // Method untuk menambahkan data rekam medis baru
    public void addEntry(String entry) {
        entries.add(entry);
    }
    // Method untuk mencetak rekam medis pasien
    public void printRecord() {
        System.out.println("Record ID: " + recordID);
        for (String e : entries) {
            System.out.println("- " + e);
        }
    }
    // Selektor untuk mengambil ID rekam medis
    public String getRecordId() {
        return recordID;
    }

    // ===============================================
    // =========== Parametric Polymorphism ===========
    // ===============================================
    // Selektor untuk mengambil semua entri rekam medis
    public ArrayList<String> getEntries() {
        return entries;
    }
}
