package jdbc.model;
// Nama file    : Room.java
// Deskripsi    : class untuk mengelola data ruangan di rumah sakit, termasuk tipe,kapasitas, harga, dan jadwal 
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
 
public class Room implements Schedulable {
    // Atribut
    private String roomID;
    private String roomType;
    private int capacity;
    private int currentOccupancy;
    private double pricePerNight;

    // ===============================================================================
    // =========================== Parametric Polymorphism ===========================
    // ===============================================================================
    private HashMap<LocalDate, ArrayList<String>> reservations;
    
    // Konstruktor
    public Room(String roomID, String roomType, int capacity, double pricePerNight) {
        assert capacity > 0 : "Capacity harus > 0";
        assert pricePerNight >= 0 : "Harga tidak boleh negatif";
 
        this.roomID = roomID;
        this.roomType = roomType;
        this.capacity = capacity;
        this.currentOccupancy = 0;
        this.pricePerNight = pricePerNight;
        this.reservations = new HashMap<>();
    }
    // override method dari interface Schedulable untuk mengecek ketersediaan ruangan berdasarkan tanggal
    @Override
    public boolean isAvailable(LocalDate date) {
        return !reservations.containsKey(date) || reservations.get(date).size() < capacity;
    }
    // override method dari interface Schedulable untuk menambahkan jadwal reservasi ruangan berdasarkan tanggal dan time slot
    @Override
    public void addSchedule(LocalDate date, String timeSlot) {
        reservations.putIfAbsent(date, new ArrayList<>());
        reservations.get(date).add(timeSlot);
    }
    // method untuk check in pasien ke ruangan jika masih tersedia
    public void checkIn(Patient patient) throws Exception {
        if (currentOccupancy >= capacity) {
            throw new Exception("Ruangan tipe '" + roomType + "' tidak tersedia");
        }
        currentOccupancy++;
        System.out.println(patient.getName() + " check in ke ruangan " + roomID);
    }
    // method untuk check out pasien dari ruangan dan mengurangi jumlah penghuni saat pasien keluar
    public void checkOut(Patient patient) {
        if (currentOccupancy > 0) {
            currentOccupancy--;
            System.out.println(patient.getName() + " check out dari ruangan " + roomID);
        }
    }
    // method untuk mengecek apakah ruangan sudah penuh atau belum
    public boolean isFull() {
        return currentOccupancy >= capacity;
    }
    // method untuk menampilkan informasi ruangan
    public void printInfo() {
        System.out.println("Room ID: " + roomID);
        System.out.println("Type: " + roomType);
        System.out.println("Price/Night: " + pricePerNight);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current Occupancy: " + currentOccupancy);
    }
    // Selektor untuk mengambil ID ruangan
    public String getRoomId() {
        return roomID;
    }
    // Selektor untuk mengambil tipe ruangan
    public String getRoomType() {
        return roomType;
    }
    // Selektor untuk mengambil harga per malam ruangan
    public double getPricePerNight() {
        return pricePerNight;
    }
    // Mutator untuk mengubah harga per malam ruangan dengan validasi bahwa harga tidak boleh negatif
    public void setPricePerNight(double price) {
        assert price >= 0 : "Harga tidak boleh negatif";
        this.pricePerNight = price;
    }
}
