// Nama File    : Hospital.java
// Deskripsi    : class untuk mengelola data rumah sakit, termasuk dokter, perawat, ruangan, dan pasien
// Pembuat      : Kelompok 6
// Anggota      : Aditya Sultonul Ulya - 240601214120006
//                Aqiatillah Rezi Zhafran - 24060124140124
//                Claudia Meitania Putri - 24060124140188
//                Raffi Arditama - 24060124120020
//                Felicia Evelina - 24060124120012
// Tanggal      : 30 Maret 2026
import java.util.ArrayList;
 
public class Hospital {
    // Atribut
    private String hospitalName;
    private String address;

    // =====================================================
    // ============== Parametric Polymorphism ==============
    // =====================================================
    private ArrayList<Doctor> doctors;
    private ArrayList<Nurse> nurses;
    private ArrayList<Room> rooms;
    private ArrayList<Patient> patients;
    
    // Konstruktor
    public Hospital(String hospitalName, String address) {
        this.hospitalName = hospitalName;
        this.address = address;
        this.doctors = new ArrayList<>();
        this.nurses = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
    // Selektor untuk mengambil nama rumah sakit
    public String getHospitalName() {
        return hospitalName;
    }
    // method untuk menambahkan dokter
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    // method untuk menambahkan perawat
    public void addNurse(Nurse nurse) {
        nurses.add(nurse);
    }
    // method untuk menambahkan ruangan
    public void addRoom(Room room) {
        rooms.add(room);
    }
    // method untuk mendaftarkan pasien
    public void registerPatient(Patient patient) {
        patients.add(patient);
    }
    // method untuk mencari dokter berdasarkan ID
    public Doctor findDoctor(String doctorId) throws Exception {
        for (Doctor d : doctors) {
            if (d.getID().equals(doctorId)) {
                return d;
            }
        }
        throw new Exception("Dokter dengan ID '" + doctorId + "' tidak ditemukan");
    }
    //method untuk mencari kamar yang tersedia berdasarkan tipe kamar 
    public Room findAvailableRoom(String roomType) throws Exception {
        for (Room r : rooms) {
            if (!r.isFull() && r.getRoomType().equalsIgnoreCase(roomType)) {
                return r;
            }
        }
        throw new Exception("Ruangan tipe '" + roomType + "' tidak tersedia");
    }
    //untuk mencetak informasi rumah sakit 
    public void printSummary() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Address: " + address);
        System.out.println("Doctors: " + doctors.size());
        System.out.println("Nurses: " + nurses.size());
        System.out.println("Rooms: " + rooms.size());
        System.out.println("Patients: " + patients.size());
    }
 
  
}
