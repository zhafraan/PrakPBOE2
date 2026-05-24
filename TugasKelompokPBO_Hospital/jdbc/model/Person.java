package jdbc.model;
// Nama file    : Person.java
// Deskripsi    : class abstrak untuk merepresentasikan orang di rumah sakit
// Pembuat      : Kelompok 6
// Anggota      : Aditya Sultonul Ulya - 240601214120006
//                Aqiatillah Rezi Zhafran - 24060124140124
//                Claudia Meitania Putri - 24060124140188
//                Raffi Arditama - 24060124120020
//                Felicia Evelina - 24060124120012
// Tanggal      : 30 Maret 2026
public abstract class Person {
    //Atribut dengan enskapsulasi 
    protected String id;
    protected String name;
    protected String gender;
    protected String phoneNumber;
    // Konstruktor 
    public Person(String id, String name, String gender, String phoneNumber) {
        assert id != null && name != null : "ID dan Name tidak boleh null";
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }
    // Method abstrak untuk mendapatkan peran (role) dari person
    public abstract String getRole();
 
    // Overloading 
    public void getInfo() {
        System.out.println(id + " - " + name);
    }
 
    // Overloading lengkap
    public void getInfo(boolean detail) {
        if (detail) {
            System.out.println("ID: " + id);
            System.out.println("Nama: " + name);
            System.out.println("Gender: " + gender);
            System.out.println("Phone: " + phoneNumber);
        } else {
            getInfo();
        }
    }
    // selektor untuk mengembalikan ID
    public String getID() {
        return id;
    }
    // selektor untuk mengembalikan nama
    public String getName() {
        return name;
    }
    // selektor untuk mengembalikan gender
    public String getGender() {
        return gender;
    }
    // selektor untuk mengembalikan nomor telepon
    public String getPhoneNumber() {
        return phoneNumber;
    }
    // Mutator untuk mengubah nomor telepon
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
