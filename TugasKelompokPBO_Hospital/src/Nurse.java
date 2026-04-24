// Nama file    : Nurse.java
// Deskripsi    : class untuk mengelola data perawat di rumah sakit
// Pembuat      : Kelompok 6
// Anggota      : Aditya Sultonul Ulya - 240601214120006
//                Aqiatillah Rezi Zhafran - 24060124140124
//                Claudia Meitania Putri - 24060124140188
//                Raffi Arditama - 24060124120020
//                Felicia Evelina - 24060124120012
// Tanggal      : 30 Maret 2026
public class Nurse extends Person {
    // Atribut
    private String shift;
    private String assignedWard;
    // Konstruktor
    public Nurse(String id, String name, String gender, String phoneNumber,
                 String shift, String assignedWard) {
        super(id, name, gender, phoneNumber);
        this.shift = shift;
        this.assignedWard = assignedWard;
    }
    // override method dari kelas Person menampilakan role perawat
    @Override
    public String getRole() {
        return "Nurse";
    }
    // override method untuk menampilkan informasi perawat
    @Override
    public void getInfo() {
        super.getInfo(true);
        System.out.println("Shift: " + shift);
        System.out.println("Ward: " + assignedWard);
    }
    // method untuk menampilkan dokter yang didampingi perawat tertentu. 
    public void assistDoctor(Doctor doctor) {
        System.out.println(name + " membantu Dr. " + doctor.getName());
    }
    // method untuk memonitor pasien yang dirawat oleh perawat tertentu.
    public void monitorPatient(Patient patient) {
        System.out.println(name + " memonitor " + patient.getName());
    }
    // Selektor untuk mengambil shift perawat
    public String getShift() {
        return shift;
    }
    // Selektor untuk mengambil assigned ward yang ditugaskan perawat
    public String getAssignedWard() {
        return assignedWard;
    }
}