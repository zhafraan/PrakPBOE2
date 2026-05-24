package jdbc.model;
// Nama File    : Bill.java
// Deskripsi    : class untuk mengelola tagihan pasien di rumah sakit
// Pembuat      : Kelompok 6
// Anggota      : Aditya Sultonul Ulya - 240601214120006
//                Aqiatillah Rezi Zhafran - 24060124140124
//                Claudia Meitania Putri - 24060124140188
//                Raffi Arditama - 24060124120020
//                Felicia Evelina - 24060124120012
// Tanggal      : 30 Maret 2026
import java.util.ArrayList;
 
public class Bill {
    // Atribut
    private String billID;
    private Patient patient;
    private ArrayList<String> itemDescriptions;
    private ArrayList<Double> itemCosts;
    private double totalAmount;
    private boolean isPaid;
    // Konstruktor
    public Bill(String billID, Patient patient) {
        this.billID = billID;
        this.patient = patient;
        this.itemDescriptions = new ArrayList<>();
        this.itemCosts = new ArrayList<>();
        this.totalAmount = 0;
        this.isPaid = false;
    }
 
    // Overloading deskripsi dan biaya langsung
    public void addItem(String description, double cost) 
        throws Exception {
        if (cost < 0 || description == null || description.isEmpty()) {
            throw new Exception("Deskripsi tidak boleh kosong dan biaya tidak boleh negatif");
        }
        itemDescriptions.add(description);
        itemCosts.add(cost);
        totalAmount += cost;
    }
 
    // Overloading  berdasarkan harga satuan dan jumlah
    public void addItem(String description, double unitCost, int quantity) throws Exception {
        if (quantity <= 0) {
            throw new Exception("Quantity harus lebih dari 0");
        }
        addItem(description, unitCost * quantity);
    }
    // Method untuk melakukan pembayaran tagihan
    public void pay() throws Exception {
        if (isPaid || totalAmount == 0) {
            throw new Exception("Tagihan Invalid");
        }
        isPaid = true;
        
    }
    // Method untuk mencetak rincian tagihan
    public void printBill() {
        System.out.println("Bill ID: " + billID);
        System.out.println("Patient: " + patient.getName());
        for (int i = 0; i < itemDescriptions.size(); i++) {
            System.out.println(itemDescriptions.get(i) + " : " + itemCosts.get(i));
        }
        System.out.println("Total: " + totalAmount);
        System.out.println("Status: " + (isPaid ? "LUNAS" : "BELUM LUNAS"));
    }
    // Selektor untuk mengambil total tagihan 
    public double getTotalAmount() {
        return totalAmount;
    }
    // Selektor untuk mengambil status pembayaran
    public boolean isPaid() {
        return isPaid;
    }
    // Selektor untuk mengambil ID Bill
    public String getBillID() {
        return billID;
    }
}
 