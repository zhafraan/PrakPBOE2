// Nama file    : Patient.java
// Deskripsi    : class untuk mengelola data pasien di rumah sakit
// Pembuat      : Kelompok 6
// Anggota      : Aditya Sultonul Ulya - 240601214120006
//                Aqiatillah Rezi Zhafran - 24060124140124
//                Claudia Meitania Putri - 24060124140188
//                Raffi Arditama - 24060124120020
//                Felicia Evelina - 24060124120012
// Tanggal      : 30 Maret 2026
import java.util.ArrayList;
 
public class Patient extends Person implements Treatable {
    // Atribut 
    private String bloodType;
    private ArrayList<String> medicalHistory;
    private MedicalRecord medicalRecord;
    // Konstruktor 
    public Patient(String id, String name, String gender, String phoneNumber, String bloodType) {
        super(id, name, gender, phoneNumber);
        assert bloodType != null : "Blood type tidak boleh null";
 
        this.bloodType = bloodType;
        this.medicalHistory = new ArrayList<>();
        this.medicalRecord = new MedicalRecord("MR-" + id);
    }
    // Override method getRole untuk mengembalikan peran sebagai pasien
    @Override
    public String getRole() {
        return "Patient";
    }
    // Override method untuk mencetak informasi pasien 
    public void getInfo() {
        super.getInfo(true);
        System.out.println("Blood Type: " + bloodType);
        System.out.println("Medical History: " + getMedicalHistory());
        medicalRecord.printRecord();
    }
    // Implementasi method dari interface Treatable
    // Method untuk menerima pemeriksaan dari dokter dan mencatatnya dalam riwayat medis
    @Override
    public void receiveExamination(Doctor doctor) {
        medicalHistory.add("Diperiksa oleh Dr. " + doctor.getName());
    }
    // Method untuk menerima perawatan dan mencatatnya dalam riwayat medis
    @Override
    public void receiveTreatment(String treatment) {
        medicalHistory.add("Treatment: " + treatment);
    }
    // Method untuk mendapatkan riwayat medis 
    @Override
    public String getMedicalHistory() {
        return String.join(", ", medicalHistory);
    }
    // Selektor untuk mendapatkan medical record
    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }
    // Selektor untuk mendapatkan golongan darah
    public String getBloodType() {
        return bloodType;
    }
}
