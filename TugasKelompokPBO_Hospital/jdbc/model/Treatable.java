package jdbc.model;
// Nama file    : Treatable.java
// Deskripsi    : interface untuk mengelola perawatan pasien di rumah sakit
// Pembuat      : Kelompok 6
// Anggota      : Aditya Sultonul Ulya - 240601214120006
//                Aqiatillah Rezi Zhafran - 24060124140124
//                Claudia Meitania Putri - 24060124140188
//                Raffi Arditama - 24060124120020
//                Felicia Evelina - 24060124120012
// Tanggal      : 30 Maret 2026

public interface Treatable {
    void receiveExamination(Doctor doctor);
    void receiveTreatment(String treatment);
    String getMedicalHistory();
}
