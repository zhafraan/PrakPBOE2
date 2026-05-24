package jdbc.model;
// Nama File    : Appointment.java
// Deskripsi    : class untuk mengelola janji temu antara pasien dan dokter
// Pembuat      : kelompok 6
// Anggota      : Aditya Sultonul Ulya - 240601214120006
//                Aqiatillah Rezi Zhafran - 24060124140124
//                Claudia Meitania Putri - 24060124140188
//                Raffi Arditama - 24060124120020
//                Felicia Evelina - 24060124120012
// Tanggal      : 30 Maret 2026
import java.time.LocalDate;
 
public class Appointment {
    // Atribut
    private String appointmentID;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private String timeSlot;
    private String status;
    // Konstruktor
    public Appointment(String appointmentID, Patient patient, Doctor doctor,LocalDate date, String timeSlot) 
        throws Exception {
            if (!doctor.isAvailable(date)) {
                throw new Exception("Dokter tidak tersedia di tanggal " + date);
            }
        this.appointmentID = appointmentID;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.timeSlot = timeSlot;
        this.status = "Scheduled";
        doctor.addSchedule(date, timeSlot);
    }
    // Method untuk mengubah status janji temu
    public void complete() {
        status = "Selesai";
    }
 
    public void cancel() {
        status = "Dibatalkan";
    }
 
    // Overloading
    public void printInfo() {
        System.out.println("Appointment ID: " + appointmentID);
        System.out.println("Patient: " + patient.getName());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Date: " + date);
        System.out.println("Time: " + timeSlot);
        System.out.println("Status: " + status);
    }
 
    // Overloading dengan detail dokter
    public void printInfo(boolean withDoctorDetail) {
        printInfo();
        if (withDoctorDetail) {
            System.out.println("--- Detail Dokter ---");
            doctor.getInfo();
        }
    }
    // Selektor
    // Selektor untuk mengambil ID janji temu
    public String getAppointmentID() {
        return appointmentID;
    }
    // Selektor untuk mengambil status janji temu
    public String getStatus() {
        return status;
    }
    // Selektor untuk mengambil nilai atribut pasien 
    public Patient getPatient() {
        return patient;
    }
    // Selektor untuk mengambil nilai atribut dokter
    public Doctor getDoctor() {
        return doctor;
    }
}
