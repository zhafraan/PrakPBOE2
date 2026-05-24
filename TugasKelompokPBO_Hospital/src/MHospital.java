// Nama File    : MHospital.java
// Deskripsi    : Main Program Sistem Manajemen Rumah Sakit
// Pembuat      : Kelompok 6
// Anggota      : Aditya Sultonul Ulya - 240601214120006
//                Aqiatillah Rezi Zhafran - 24060124140124
//                Claudia Meitania Putri - 24060124140188
//                Raffi Arditama - 24060124120020
//                Felicia Evelina - 24060124120012
// Tanggal      : 30 Maret 2026

import java.time.LocalDate;

public class MHospital {
    public static void main(String[] args) {
        try {
            // MEMBUAT OBJEK RUMAH SAKIT
            Hospital hospital = new Hospital("RS Diponegoro", "Jl. Kesehatan No.1, Semarang");
            // Dokter 1: Spesialis Jantung
            Doctor dokter1 = new Doctor("D001", "Ahmad Fauzi","L","081234567890","Jantung",
                "SIP-001");
            // Dokter 2: Spesialis Anak
            Doctor dokter2 = new Doctor("D002","Sari Dewi","P","081234567891","Anak",
                "SIP-002");

            // Dokter 3: Spesialis Bedah
            Doctor dokter3 = new Doctor("D003","Budi Santoso","L","081234567892","Bedah",
                "SIP-003");

            // Perawat 1: Shift Pagi, ICU
            Nurse perawat1 = new Nurse("N001","Rina Wati","P","082111111111","Pagi",
                "ICU");

            // Perawat 2: Shift Malam, Ruang Melati
            Nurse perawat2 = new Nurse("N002","Hendra Putra","L","082111111112",
                "Malam","Ruang Melati");

            // Ruang VIP: kapasitas 1, Rp750.000/malam
            Room ruangVIP = new Room("R201", "VIP", 1, 750000);

            // Ruang Kelas 1: kapasitas 3, Rp350.000/malam
            Room ruangKelas1 = new Room("R302", "Kelas 2", 3, 350000);

            // Ruang ICU: kapasitas 2, Rp1.500.000/malam
            Room ruangICU = new Room("R103", "ICU", 2, 1500000);

            // Pasien 1: Budi Hartono, gol. darah O
            Patient pasien1 = new Patient("P001","Budi Hartono","L","085111111111","O");
            // Pasien 2: Dewi Rahayu, gol. darah A
            Patient pasien2 = new Patient("P002","Dewi Rahayu","P","085111111112","A");

            // Pasien 3: Agus Setiawan, gol. darah B
            Patient pasien3 = new Patient("P003","Agus Setiawan","L","085111111113","B");
            
            //Daftarkan semua objek ke rumah sakit
            hospital.addDoctor(dokter1);
            hospital.addDoctor(dokter2);
            hospital.addDoctor(dokter3);
            hospital.addNurse(perawat1);
            hospital.addNurse(perawat2);
            hospital.addRoom(ruangVIP);
            hospital.addRoom(ruangKelas1);
            hospital.addRoom(ruangICU);
            hospital.registerPatient(pasien1);
            hospital.registerPatient(pasien2);
            hospital.registerPatient(pasien3);

            // Appointment 1: Pasien 1 dengan Dokter 1
            Appointment apt1 = new Appointment("APT001",pasien1,dokter1,LocalDate.of(2026, 4, 1),
                "08:00");

            // Appointment 2: Pasien 2 dengan Dokter 2
            Appointment apt2 = new Appointment("APT002",pasien2,dokter2,LocalDate.of(2026, 4, 2),
                "10:00");

            // Appointment 3: Pasien 3 dengan Dokter 1, 
            // Dokter1 masih tersedia karena slot < 8
            Appointment apt3 = new Appointment("APT003",pasien3,dokter1,LocalDate.of(2026, 4, 1),
                "09:00");

            // Pasien 1
            pasien1.receiveExamination(dokter1);
            dokter1.diagnose(pasien1, "Aritmia Jantung");
            pasien1.receiveTreatment("Pemberian obat antiaritmia");
            pasien1.getMedicalRecord().addEntry("Hasil EKG: Tidak normal");
            pasien1.getMedicalRecord().addEntry("Tekanan darah: 140/90 mmHg");

            // Pasien 2
            pasien2.receiveExamination(dokter2);
            dokter2.diagnose(pasien2, "Infeksi Saluran Pernapasan");
            pasien2.receiveTreatment("Pemberian antibiotik dan vitamin C");
            pasien2.getMedicalRecord().addEntry("Suhu tubuh: 38.5 derajat Celsius");

            // Pasien 3
            pasien3.receiveExamination(dokter3);
            dokter3.diagnose(pasien3, "Appendicitis");
            pasien3.receiveTreatment("Persiapan operasi appendektomi");
            pasien3.getMedicalRecord().addEntry("Nyeri tekan titik McBurney positif");

            // Aktivitas Perawat
            perawat1.assistDoctor(dokter1);
            perawat1.monitorPatient(pasien1);
            perawat2.assistDoctor(dokter3);
            perawat2.monitorPatient(pasien3);

           
            ruangVIP.checkIn(pasien1);
            ruangKelas1.checkIn(pasien2);
            ruangICU.checkIn(pasien3);

            // Tagihan Pasien 1 
            Bill tagihan1 = new Bill("BILL001", pasien1);
            tagihan1.addItem("Biaya Konsultasi Dokter Jantung", 300000);       
            tagihan1.addItem("Biaya Kamar VIP", 750000);                      
            tagihan1.addItem("Obat Antiaritmia", 85000, 3);                    
            tagihan1.addItem("Biaya EKG", 150000);                             

            // Tagihan Pasien 2 
            Bill tagihan2 = new Bill("BILL002", pasien2);
            tagihan2.addItem("Biaya Konsultasi Dokter Anak", 250000);          
            tagihan2.addItem("Biaya Kamar Kelas 1", 350000);                   
            tagihan2.addItem("Antibiotik", 45000, 5);                         
            tagihan2.addItem("Vitamin C", 15000, 10);                          

            // Tagihan Pasien 3 
            Bill tagihan3 = new Bill("BILL003", pasien3);
            tagihan3.addItem("Biaya Konsultasi Dokter Bedah", 350000);         
            tagihan3.addItem("Biaya Kamar ICU", 1500000);                      
            tagihan3.addItem("Biaya Operasi Appendektomi", 5000000);           
            tagihan3.addItem("Obat Pasca Operasi", 75000, 7);                  

            //Bayar tagihan
            tagihan1.pay();
            tagihan2.pay();
            tagihan3.pay();

            //Update status appointment
            apt1.complete();  // Selesai
            apt2.cancel();    // Dibatalkan
            apt3.complete();  // Selesai

            // Check out pasien dari ruangan
            ruangVIP.checkOut(pasien1);
            ruangKelas1.checkOut(pasien2);
            ruangICU.checkOut(pasien3);

            //tampilkan informasi semua data yang sudah dibuat
            System.out.println("******* DATA RUMAH SAKIT *******");
            hospital.printSummary();
            System.out.println();

            System.out.println("******* DATA DOKTER *******");
            dokter1.getInfo();
            System.out.println();
            dokter2.getInfo();
            System.out.println();
            dokter3.getInfo();
            System.out.println();

            System.out.println("******* DATA PERAWAT *******");
            perawat1.getInfo();
            System.out.println();
            perawat2.getInfo();
            System.out.println();

            System.out.println("******* DATA RUANGAN *******");
            ruangVIP.printInfo();
            System.out.println();
            ruangKelas1.printInfo();
            System.out.println();
            ruangICU.printInfo();
            System.out.println();

            System.out.println("******* DATA PASIEN *******");
            pasien1.getInfo();
            System.out.println();
            pasien2.getInfo();
            System.out.println();
            pasien3.getInfo();
            System.out.println();

            System.out.println("******* DATA APPOINTMENT *******");
            apt1.printInfo();
            System.out.println();
            apt2.printInfo(true);
            System.out.println();
            apt3.printInfo();
            System.out.println();

            System.out.println("******* DATA TAGIHAN *******");
            tagihan1.printBill();
            System.out.println();
            tagihan2.printBill();
            System.out.println();
            tagihan3.printBill();
            System.out.println();

            // ======================================================================================
            // =============================== Polimorfisme Inclusion ===============================
            // ======================================================================================
            System.out.println("******* PENERAPAN POLYMORPHISM *******");
            Person[] semuaOrang = { dokter1, dokter2, perawat1, perawat2, pasien1, pasien2, pasien3 };
            for (Person orang : semuaOrang) {
                System.out.println("Nama: " + orang.getName() + " | Role: " + orang.getRole());
            }
            System.out.println();

            System.out.println("******* PENERAPAN FIND DOCTOR & FIND ROOM *******");
            Doctor ditemukan = hospital.findDoctor("D002");
            System.out.println("Dokter ditemukan: " + ditemukan.getName()
                + " | Spesialisasi: " + ditemukan.getSpecialization());
            Room ruanganTersedia = hospital.findAvailableRoom("VIP");
            System.out.println("Ruangan tersedia: " + ruanganTersedia.getRoomType()
                + " | Harga: Rp" + ruanganTersedia.getPricePerNight() + "/malam");
            System.out.println();

            // ===========================================================
            // ================= Coercion Polymorphism ===================
            // ===========================================================
            System.out.println("******* COERCION POLYMORPHISM *******");
            double pajak = tagihan1.calculateTax(10);
            System.out.println("Pajak Tagihan 1 (10%) : " + pajak);
            System.out.println();

 
            // ===========================================================
            // ==================== Class Generik ========================
            // ===========================================================
            System.out.println("******* GENERIC PADA KELAS *******");
 
            // Generic untuk Doctor
            DataManager<Doctor> doctorData = new DataManager<>();
            doctorData.addData(dokter1);
            doctorData.addData(dokter2);
            System.out.println("Data Doctor:");
            doctorData.printSize();
 
            // Generic untuk Patient
            DataManager<Patient> patientData = new DataManager<>();
            patientData.addData(pasien1);
            patientData.addData(pasien2);
            patientData.addData(pasien3);
            System.out.println("Data Patient:");
            patientData.printSize();
            System.out.println();

             // ===========================================================
            // ================ Demonstrasi Koleksi ======================
            // ===========================================================
            System.out.println("******* DEMONSTRASI KOLEKSI *******");
 
            // Buat DataManager<Doctor> dan isi data dengan add
            DataManager<Doctor> koleksiDokter = new DataManager<>();
            koleksiDokter.addData(dokter1);
            koleksiDokter.addData(dokter2);
            koleksiDokter.addData(dokter3);
 
            // tampilkan jumlah elemen setelah 3x add
            System.out.println("Jumlah dokter setelah add (getSize) : " + koleksiDokter.getSize());
 
            // akses elemen berdasarkan indeks 1-based
            System.out.println("Dokter ke-1 (getIsi(1)) : " + koleksiDokter.getIsi(1).getName());
            System.out.println("Dokter ke-2 (getIsi(2)) : " + koleksiDokter.getIsi(2).getName());
            System.out.println("Dokter ke-3 (getIsi(3)) : " + koleksiDokter.getIsi(3).getName());
 
            // ubah elemen pada posisi tertentu
            Doctor dokterBaru = new Doctor("D004", "Tuti Rahayu", "P", "081299999999", "Saraf", "SIP-004");
            System.out.println("Sebelum setIsi(2) : Dokter ke-2 = " + koleksiDokter.getIsi(2).getName());
            koleksiDokter.setIsi(2, dokterBaru);
            System.out.println("Setelah setIsi(2) : Dokter ke-2 = " + koleksiDokter.getIsi(2).getName());
            koleksiDokter.setIsi(2, dokter2);
            System.out.println("Dikembalikan      : Dokter ke-2 = " + koleksiDokter.getIsi(2).getName());
 
            // tambah dokter baru di akhir koleksi
            Doctor dokterTambahan = new Doctor("D005", "Eko Prasetyo", "L", "081288888888", "Kulit", "SIP-005");
            koleksiDokter.addData(dokterTambahan);
            System.out.println("Setelah add dokter baru, jumlah : " + koleksiDokter.getSize());
            System.out.println("Elemen terakhir (getIsi(4))     : " + koleksiDokter.getIsi(koleksiDokter.getSize()).getName());
 
            // hapus dan kembalikan elemen terakhir
            Doctor dokterDihapus = koleksiDokter.deleteData();
            System.out.println("deleteData() -> dokter dihapus  : " + dokterDihapus.getName());
            System.out.println("Jumlah dokter setelah delete    : " + koleksiDokter.getSize());
 
            // Iterasi seluruh elemen koleksi
            System.out.println("--- Isi koleksi dokter saat ini ---");
            for (int i = 1; i <= koleksiDokter.getSize(); i++) {
                Doctor d = koleksiDokter.getIsi(i);
                System.out.println("  [" + i + "] " + d.getName() + " | " + d.getSpecialization());
            }
            System.out.println();
 
            // ===========================================================
            // ==================== Method Generik =======================
            // ===========================================================
            System.out.println("******* GENERIC PADA METHOD *******");
            hospital.printGenericData("Rumah Sakit Diponegoro");
            hospital.printGenericData(dokter1.getName());
            hospital.printGenericData(pasien1.getName());
            hospital.printGenericData(1500000);
            System.out.println();
 
        } catch (Exception e) {
            System.out.println("Error tidak terduga: " + e.getMessage());
        }
        
    }
}