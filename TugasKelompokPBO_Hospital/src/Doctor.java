// Nama File    : Doctor.java
// Deskripsi    : class untuk mengelola data dokter di rumah sakit
// Pembuat      : Kelompok 6
// Anggota      : Aditya Sultonul Ulya - 240601214120006
//                Aqiatillah Rezi Zhafran - 24060124140124
//                Claudia Meitania Putri - 24060124140188
//                Raffi Arditama - 24060124120020
//                Felicia Evelina - 24060124120012
// Tanggal      : 30 Maret 2026
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
 
public class Doctor extends Person implements Schedulable {
    // Atribut
    private String specialization;
    private String licenseNumber;

    // =====================================================================
    // ====================== Parametric Polymorphism ======================
    // =====================================================================
    private HashMap<LocalDate, ArrayList<String>> schedule;
    // Konstruktor
    public Doctor(String id, String name, String gender, String phoneNumber,
                  String specialization, String licenseNumber) {
        super(id, name, gender, phoneNumber);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.schedule = new HashMap<>();
    }
    // override method dari kelas Person menampilakan role dokter
    @Override
    public String getRole() {
        return "Doctor";
    }
    // Implementasi method dari interface Schedulable
    @Override
    public boolean isAvailable(LocalDate date) {
        return !schedule.containsKey(date) || schedule.get(date).size() < 8;
    }
    // Implementasi method untuk menambahkan jadwal dokter
    @Override
    public void addSchedule(LocalDate date, String timeSlot) {
        schedule.putIfAbsent(date, new ArrayList<>());
        schedule.get(date).add(timeSlot);
    }
    // Method untuk mendiagnosa pasien
    public void diagnose(Patient patient, String diagnosis) {
        System.out.println("Diagnosa: " + patient.getName() + " -> " + diagnosis);
    }
    // Selektor untuk mengambil spesialisasi dokter
    public String getSpecialization() {
        return specialization;
    }
    // Selektor untuk mengambil nomor lisensi dokter
    public String getLicenseNumber() {
        return licenseNumber;
    }
    // override method untuk menampilkan informasi dokter
    @Override
    public void getInfo() {
        super.getInfo(true);
        System.out.println("Specialization: " + specialization);
        System.out.println("License: " + licenseNumber);
        System.out.println("Schedule: " + schedule);
    }
}