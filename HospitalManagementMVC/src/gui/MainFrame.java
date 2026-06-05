package gui;

// =====================================================================
// Nama File    : MainFrame.java
// Deskripsi    : Komponen VIEW dalam pola MVC Hospital Management System.
//                Kelas ini HANYA bertanggung jawab atas tampilan dan
//                interaksi dengan pengguna. Semua operasi data dilakukan
//                melalui DAOManager (Controller) yang meneruskan ke
//                HospitalDAO (Service/Model).
//
// Alur MVC:
//   MainFrame (View)
//     → DAOManager (Controller)
//       → HospitalDAO / MySQLHospitalDAO (Service)
//         → Doctor, Patient, Nurse, dll. (Model)
//           → MysqlUtility → MySQL Database
// =====================================================================

import jdbc.model.*;
import jdbc.service.DAOManager;
import jdbc.service.HospitalDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class MainFrame extends JFrame {

    // ================================================================
    // Controller — satu-satunya pintu masuk ke layer data
    // View tidak pernah menulis SQL, semua lewat controller ini
    // ================================================================
    private final DAOManager controller = new DAOManager();
    private final HospitalDAO dao       = controller.getDAO();

    // ==================== Komponen UI Dokter ====================
    private JTextField txtDokterID, txtDokterNama, txtDokterTelp,
                       txtDokterSpesialis, txtDokterLisensi;
    private JComboBox<String> cmbDokterGender;
    private JButton btnDokterTambah, btnDokterUpdate, btnDokterHapus, btnDokterClear;
    private JTable tblDokter;
    private DefaultTableModel modelDokter;

    // ==================== Komponen UI Perawat ====================
    private JTextField txtPerawatID, txtPerawatNama, txtPerawatTelp, txtPerawatWard;
    private JComboBox<String> cmbPerawatGender, cmbPerawatShift;
    private JButton btnPerawatTambah, btnPerawatUpdate, btnPerawatHapus, btnPerawatClear;
    private JTable tblPerawat;
    private DefaultTableModel modelPerawat;

    // ==================== Komponen UI Pasien ====================
    private JTextField txtPasienID, txtPasienNama, txtPasienTelp;
    private JComboBox<String> cmbPasienGender, cmbPasienGolDarah;
    private JButton btnPasienTambah, btnPasienUpdate, btnPasienHapus, btnPasienClear;
    private JTable tblPasien;
    private DefaultTableModel modelPasien;

    // ==================== Komponen UI Ruangan ====================
    private JTextField txtRuanganID, txtRuanganKapasitas, txtRuanganHarga;
    private JComboBox<String> cmbRuanganTipe;
    private JButton btnRuanganTambah, btnRuanganUpdate, btnRuanganHapus, btnRuanganClear;
    private JTable tblRuangan;
    private DefaultTableModel modelRuangan;

    // ==================== Komponen UI Appointment ====================
    private JTextField txtAptID, txtAptTanggal, txtAptJam;
    private JComboBox<String> cmbAptPasien, cmbAptDokter, cmbAptStatus;
    private JButton btnAptTambah, btnAptUpdate, btnAptHapus, btnAptClear;
    private JTable tblAppointment;
    private DefaultTableModel modelAppointment;

    // ==================== Komponen UI Bill ====================
    private JTextField txtBillID, txtItemDeskripsi, txtItemHarga, txtItemQty;
    private JComboBox<String> cmbBillPasien;
    private JButton btnBillBuat, btnBillBayar, btnBillClear;
    private JButton btnItemTambah, btnItemHapus;
    private JTable tblBill, tblBillItem;
    private DefaultTableModel modelBill, modelBillItem;

    // ==================== Komponen UI Medical Record ====================
    private JComboBox<String> cmbMRPasien;
    private JTextField txtMREntry;
    private JButton btnMRTambahEntry, btnMRClear;
    private JTable tblMR, tblMREntry;
    private DefaultTableModel modelMR, modelMREntry;

    // ================================================================
    // Konstruktor
    // ================================================================
    public MainFrame() {
        initUI();
        loadAllData();
    }

    // ================================================================
    // Inisialisasi seluruh komponen UI
    // ================================================================
    private void initUI() {
        setTitle("Hospital Management System - RS Diponegoro");
        setSize(1050, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JPanel pnlHeader = new JPanel(new BorderLayout());
        pnlHeader.setBackground(new Color(25, 80, 150));
        pnlHeader.setPreferredSize(new Dimension(1050, 60));
        JLabel lblTitle = new JLabel("   \uD83C\uDFE5  Hospital Management System - RS Diponegoro");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        pnlHeader.add(lblTitle, BorderLayout.WEST);
        add(pnlHeader, BorderLayout.NORTH);

        // Tab pane
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabs.addTab("Dokter",         createDokterPanel());
        tabs.addTab("Perawat",        createPerawatPanel());
        tabs.addTab("Pasien",         createPasienPanel());
        tabs.addTab("Ruangan",        createRuanganPanel());
        tabs.addTab("Appointment",    createAppointmentPanel());
        tabs.addTab("Bill & Tagihan", createBillPanel());
        tabs.addTab("Medical Record", createMedicalRecordPanel());
        add(tabs, BorderLayout.CENTER);
    }

    // ================================================================
    // Load semua data saat aplikasi pertama kali dibuka
    // ================================================================
    private void loadAllData() {
        loadDokter();
        loadPerawat();
        loadPasien();
        loadRuangan();
        loadAppointment();
        refreshComboPasienDokter();
        loadBill();
        refreshComboPasien(cmbBillPasien);
        loadMR();
        refreshComboPasien(cmbMRPasien);
    }

    // ================================================================
    // ==================== HELPER UI BUILDER =========================
    // ================================================================
    private void addFormField(JPanel panel, String label, JComponent field, int row) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 8, 5, 8);
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(field, gbc);
    }

    private JButton createButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        if (bg != null) {
            btn.setBackground(bg);
            btn.setForeground(Color.WHITE);
        }
        return btn;
    }

    private JTable createTable(DefaultTableModel model) {
        JTable table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setReorderingAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setGridColor(new Color(220, 220, 220));
        return table;
    }

    /** Tampilkan error dari layer DAO ke user dengan dialog */
    private void showError(String context, RuntimeException e) {
        JOptionPane.showMessageDialog(this,
            context + ":\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    // ================================================================
    // Refresh combo pasien & dokter untuk panel Appointment
    // ================================================================
    private void refreshComboPasienDokter() {
        cmbAptPasien.removeAllItems();
        cmbAptDokter.removeAllItems();
        try {
            for (Patient p : dao.getAllPatients())
                cmbAptPasien.addItem(p.getID() + " - " + p.getName());
            for (Doctor d : dao.getAllDoctors())
                cmbAptDokter.addItem(d.getID() + " - " + d.getName());
        } catch (RuntimeException e) {
            showError("Gagal refresh combo", e);
        }
    }

    /** Isi ulang combo pasien generik (digunakan Bill & Medical Record) */
    private void refreshComboPasien(JComboBox<String> cmb) {
        cmb.removeAllItems();
        try {
            for (Patient p : dao.getAllPatients())
                cmb.addItem(p.getID() + " - " + p.getName());
        } catch (RuntimeException e) {
            showError("Gagal refresh combo pasien", e);
        }
    }

    // ================================================================
    // ======================== PANEL DOKTER ==========================
    // ================================================================
    private JPanel createDokterPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnlForm = new JPanel(new BorderLayout());
        pnlForm.setBorder(BorderFactory.createTitledBorder("Data Dokter"));
        JPanel pnlInput = new JPanel(new GridBagLayout());

        txtDokterID        = new JTextField(15);
        txtDokterNama      = new JTextField(15);
        cmbDokterGender    = new JComboBox<>(new String[]{"L", "P"});
        txtDokterTelp      = new JTextField(15);
        txtDokterSpesialis = new JTextField(15);
        txtDokterLisensi   = new JTextField(15);

        addFormField(pnlInput, "ID Dokter:",    txtDokterID,        0);
        addFormField(pnlInput, "Nama:",         txtDokterNama,      1);
        addFormField(pnlInput, "Gender:",       cmbDokterGender,    2);
        addFormField(pnlInput, "No. Telepon:",  txtDokterTelp,      3);
        addFormField(pnlInput, "Spesialisasi:", txtDokterSpesialis, 4);
        addFormField(pnlInput, "No. Lisensi:",  txtDokterLisensi,   5);

        JPanel pnlBtn = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        btnDokterTambah = createButton("Tambah", new Color(46, 139, 87));
        btnDokterUpdate = createButton("Update",  new Color(30, 144, 255));
        btnDokterHapus  = createButton("Hapus",   new Color(200, 30, 50));
        btnDokterClear  = createButton("Clear",   null);
        pnlBtn.add(btnDokterTambah); pnlBtn.add(btnDokterUpdate);
        pnlBtn.add(btnDokterHapus);  pnlBtn.add(btnDokterClear);

        pnlForm.add(pnlInput, BorderLayout.CENTER);
        pnlForm.add(pnlBtn,   BorderLayout.SOUTH);
        panel.add(pnlForm, BorderLayout.NORTH);

        modelDokter = new DefaultTableModel(
            new String[]{"ID", "Nama", "Gender", "Telepon", "Spesialisasi", "No. Lisensi"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblDokter = createTable(modelDokter);
        JScrollPane scroll = new JScrollPane(tblDokter);
        scroll.setBorder(BorderFactory.createTitledBorder("Daftar Dokter"));
        panel.add(scroll, BorderLayout.CENTER);

        tblDokter.getSelectionModel().addListSelectionListener(
            e -> { if (!e.getValueIsAdjusting()) fillFormDokter(); });
        btnDokterTambah.addActionListener(e -> tambahDokter());
        btnDokterUpdate.addActionListener(e -> updateDokter());
        btnDokterHapus .addActionListener(e -> hapusDokter());
        btnDokterClear .addActionListener(e -> clearFormDokter());

        return panel;
    }

    /**
     * VIEW memanggil dao.getAllDoctors() via Controller (DAOManager).
     * DAO mengembalikan List<Doctor> (objek Model), View tinggal tampilkan.
     */
    private void loadDokter() {
        modelDokter.setRowCount(0);
        try {
            for (Doctor d : dao.getAllDoctors()) {
                modelDokter.addRow(new Object[]{
                    d.getID(), d.getName(), d.getGender(),
                    d.getPhoneNumber(), d.getSpecialization(), d.getLicenseNumber()
                });
            }
        } catch (RuntimeException e) {
            showError("Gagal load data dokter", e);
        }
    }

    private void fillFormDokter() {
        int row = tblDokter.getSelectedRow();
        if (row < 0) return;
        txtDokterID.setText((String) modelDokter.getValueAt(row, 0));
        txtDokterID.setEditable(false);
        txtDokterNama.setText((String) modelDokter.getValueAt(row, 1));
        cmbDokterGender.setSelectedItem(modelDokter.getValueAt(row, 2));
        txtDokterTelp.setText((String) modelDokter.getValueAt(row, 3));
        txtDokterSpesialis.setText((String) modelDokter.getValueAt(row, 4));
        txtDokterLisensi.setText((String) modelDokter.getValueAt(row, 5));
    }

    private void clearFormDokter() {
        txtDokterID.setText(""); txtDokterID.setEditable(true);
        txtDokterNama.setText(""); txtDokterTelp.setText("");
        txtDokterSpesialis.setText(""); txtDokterLisensi.setText("");
        cmbDokterGender.setSelectedIndex(0);
        tblDokter.clearSelection();
    }

    /**
     * View membuat objek Doctor (Model), lalu menyerahkannya ke DAO via Controller.
     * View sama sekali tidak tahu SQL yang dieksekusi.
     */
    private void tambahDokter() {
        String id = txtDokterID.getText().trim();
        String nama = txtDokterNama.getText().trim();
        if (id.isEmpty() || nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID dan Nama tidak boleh kosong!"); return;
        }
        Doctor doctor = new Doctor(
            id, nama,
            (String) cmbDokterGender.getSelectedItem(),
            txtDokterTelp.getText().trim(),
            txtDokterSpesialis.getText().trim(),
            txtDokterLisensi.getText().trim()
        );
        try {
            dao.saveDoctor(doctor);
            JOptionPane.showMessageDialog(this, "Dokter berhasil ditambahkan!");
            clearFormDokter();
            loadDokter();
            refreshComboPasienDokter();
        } catch (RuntimeException e) {
            showError("Gagal tambah dokter", e);
        }
    }

    private void updateDokter() {
        if (tblDokter.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Pilih dokter dulu!"); return;
        }
        Doctor doctor = new Doctor(
            txtDokterID.getText().trim(),
            txtDokterNama.getText().trim(),
            (String) cmbDokterGender.getSelectedItem(),
            txtDokterTelp.getText().trim(),
            txtDokterSpesialis.getText().trim(),
            txtDokterLisensi.getText().trim()
        );
        try {
            dao.updateDoctor(doctor);
            JOptionPane.showMessageDialog(this, "Dokter berhasil diupdate!");
            clearFormDokter();
            loadDokter();
            refreshComboPasienDokter();
        } catch (RuntimeException e) {
            showError("Gagal update dokter", e);
        }
    }

    private void hapusDokter() {
        if (tblDokter.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Pilih dokter dulu!"); return;
        }
        if (JOptionPane.showConfirmDialog(this,
            "Hapus dokter '" + txtDokterNama.getText() + "'?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try {
            dao.deleteDoctor(txtDokterID.getText().trim());
            JOptionPane.showMessageDialog(this, "Dokter berhasil dihapus!");
            clearFormDokter();
            loadDokter();
            refreshComboPasienDokter();
        } catch (RuntimeException e) {
            showError("Gagal hapus dokter (mungkin ada appointment terkait)", e);
        }
    }

    // ================================================================
    // ======================== PANEL PERAWAT =========================
    // ================================================================
    private JPanel createPerawatPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnlForm = new JPanel(new BorderLayout());
        pnlForm.setBorder(BorderFactory.createTitledBorder("Data Perawat"));
        JPanel pnlInput = new JPanel(new GridBagLayout());

        txtPerawatID    = new JTextField(15);
        txtPerawatNama  = new JTextField(15);
        cmbPerawatGender = new JComboBox<>(new String[]{"L", "P"});
        txtPerawatTelp  = new JTextField(15);
        cmbPerawatShift = new JComboBox<>(new String[]{"Pagi", "Siang", "Malam"});
        txtPerawatWard  = new JTextField(15);

        addFormField(pnlInput, "ID Perawat:",  txtPerawatID,     0);
        addFormField(pnlInput, "Nama:",        txtPerawatNama,   1);
        addFormField(pnlInput, "Gender:",      cmbPerawatGender, 2);
        addFormField(pnlInput, "No. Telepon:", txtPerawatTelp,   3);
        addFormField(pnlInput, "Shift:",       cmbPerawatShift,  4);
        addFormField(pnlInput, "Ward:",        txtPerawatWard,   5);

        JPanel pnlBtn = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        btnPerawatTambah = createButton("Tambah", new Color(46, 139, 87));
        btnPerawatUpdate = createButton("Update",  new Color(30, 144, 255));
        btnPerawatHapus  = createButton("Hapus",   new Color(200, 30, 50));
        btnPerawatClear  = createButton("Clear",   null);
        pnlBtn.add(btnPerawatTambah); pnlBtn.add(btnPerawatUpdate);
        pnlBtn.add(btnPerawatHapus);  pnlBtn.add(btnPerawatClear);

        pnlForm.add(pnlInput, BorderLayout.CENTER);
        pnlForm.add(pnlBtn,   BorderLayout.SOUTH);
        panel.add(pnlForm, BorderLayout.NORTH);

        modelPerawat = new DefaultTableModel(
            new String[]{"ID", "Nama", "Gender", "Telepon", "Shift", "Ward"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblPerawat = createTable(modelPerawat);
        JScrollPane scroll = new JScrollPane(tblPerawat);
        scroll.setBorder(BorderFactory.createTitledBorder("Daftar Perawat"));
        panel.add(scroll, BorderLayout.CENTER);

        tblPerawat.getSelectionModel().addListSelectionListener(
            e -> { if (!e.getValueIsAdjusting()) fillFormPerawat(); });
        btnPerawatTambah.addActionListener(e -> tambahPerawat());
        btnPerawatUpdate.addActionListener(e -> updatePerawat());
        btnPerawatHapus .addActionListener(e -> hapusPerawat());
        btnPerawatClear .addActionListener(e -> clearFormPerawat());

        return panel;
    }

    private void loadPerawat() {
        modelPerawat.setRowCount(0);
        try {
            for (Nurse n : dao.getAllNurses()) {
                modelPerawat.addRow(new Object[]{
                    n.getID(), n.getName(), n.getGender(),
                    n.getPhoneNumber(), n.getShift(), n.getAssignedWard()
                });
            }
        } catch (RuntimeException e) {
            showError("Gagal load data perawat", e);
        }
    }

    private void fillFormPerawat() {
        int row = tblPerawat.getSelectedRow();
        if (row < 0) return;
        txtPerawatID.setText((String) modelPerawat.getValueAt(row, 0));
        txtPerawatID.setEditable(false);
        txtPerawatNama.setText((String) modelPerawat.getValueAt(row, 1));
        cmbPerawatGender.setSelectedItem(modelPerawat.getValueAt(row, 2));
        txtPerawatTelp.setText((String) modelPerawat.getValueAt(row, 3));
        cmbPerawatShift.setSelectedItem(modelPerawat.getValueAt(row, 4));
        txtPerawatWard.setText((String) modelPerawat.getValueAt(row, 5));
    }

    private void clearFormPerawat() {
        txtPerawatID.setText(""); txtPerawatID.setEditable(true);
        txtPerawatNama.setText(""); txtPerawatTelp.setText(""); txtPerawatWard.setText("");
        cmbPerawatGender.setSelectedIndex(0); cmbPerawatShift.setSelectedIndex(0);
        tblPerawat.clearSelection();
    }

    private void tambahPerawat() {
        String id = txtPerawatID.getText().trim();
        String nama = txtPerawatNama.getText().trim();
        if (id.isEmpty() || nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID dan Nama tidak boleh kosong!"); return;
        }
        Nurse nurse = new Nurse(
            id, nama,
            (String) cmbPerawatGender.getSelectedItem(),
            txtPerawatTelp.getText().trim(),
            (String) cmbPerawatShift.getSelectedItem(),
            txtPerawatWard.getText().trim()
        );
        try {
            dao.saveNurse(nurse);
            JOptionPane.showMessageDialog(this, "Perawat berhasil ditambahkan!");
            clearFormPerawat(); loadPerawat();
        } catch (RuntimeException e) {
            showError("Gagal tambah perawat", e);
        }
    }

    private void updatePerawat() {
        if (tblPerawat.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Pilih perawat dulu!"); return;
        }
        Nurse nurse = new Nurse(
            txtPerawatID.getText().trim(),
            txtPerawatNama.getText().trim(),
            (String) cmbPerawatGender.getSelectedItem(),
            txtPerawatTelp.getText().trim(),
            (String) cmbPerawatShift.getSelectedItem(),
            txtPerawatWard.getText().trim()
        );
        try {
            dao.updateNurse(nurse);
            JOptionPane.showMessageDialog(this, "Perawat berhasil diupdate!");
            clearFormPerawat(); loadPerawat();
        } catch (RuntimeException e) {
            showError("Gagal update perawat", e);
        }
    }

    private void hapusPerawat() {
        if (tblPerawat.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Pilih perawat dulu!"); return;
        }
        if (JOptionPane.showConfirmDialog(this,
            "Hapus perawat '" + txtPerawatNama.getText() + "'?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try {
            dao.deleteNurse(txtPerawatID.getText().trim());
            JOptionPane.showMessageDialog(this, "Perawat berhasil dihapus!");
            clearFormPerawat(); loadPerawat();
        } catch (RuntimeException e) {
            showError("Gagal hapus perawat", e);
        }
    }

    // ================================================================
    // ========================= PANEL PASIEN =========================
    // ================================================================
    private JPanel createPasienPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnlForm = new JPanel(new BorderLayout());
        pnlForm.setBorder(BorderFactory.createTitledBorder("Data Pasien"));
        JPanel pnlInput = new JPanel(new GridBagLayout());

        txtPasienID       = new JTextField(15);
        txtPasienNama     = new JTextField(15);
        cmbPasienGender   = new JComboBox<>(new String[]{"L", "P"});
        txtPasienTelp     = new JTextField(15);
        cmbPasienGolDarah = new JComboBox<>(new String[]{"A", "B", "AB", "O"});

        addFormField(pnlInput, "ID Pasien:",   txtPasienID,       0);
        addFormField(pnlInput, "Nama:",        txtPasienNama,     1);
        addFormField(pnlInput, "Gender:",      cmbPasienGender,   2);
        addFormField(pnlInput, "No. Telepon:", txtPasienTelp,     3);
        addFormField(pnlInput, "Gol. Darah:",  cmbPasienGolDarah, 4);

        JPanel pnlBtn = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        btnPasienTambah = createButton("Tambah", new Color(46, 139, 87));
        btnPasienUpdate = createButton("Update",  new Color(30, 144, 255));
        btnPasienHapus  = createButton("Hapus",   new Color(200, 30, 50));
        btnPasienClear  = createButton("Clear",   null);
        pnlBtn.add(btnPasienTambah); pnlBtn.add(btnPasienUpdate);
        pnlBtn.add(btnPasienHapus);  pnlBtn.add(btnPasienClear);

        pnlForm.add(pnlInput, BorderLayout.CENTER);
        pnlForm.add(pnlBtn,   BorderLayout.SOUTH);
        panel.add(pnlForm, BorderLayout.NORTH);

        modelPasien = new DefaultTableModel(
            new String[]{"ID", "Nama", "Gender", "Telepon", "Gol. Darah"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblPasien = createTable(modelPasien);
        JScrollPane scroll = new JScrollPane(tblPasien);
        scroll.setBorder(BorderFactory.createTitledBorder("Daftar Pasien"));
        panel.add(scroll, BorderLayout.CENTER);

        tblPasien.getSelectionModel().addListSelectionListener(
            e -> { if (!e.getValueIsAdjusting()) fillFormPasien(); });
        btnPasienTambah.addActionListener(e -> tambahPasien());
        btnPasienUpdate.addActionListener(e -> updatePasien());
        btnPasienHapus .addActionListener(e -> hapusPasien());
        btnPasienClear .addActionListener(e -> clearFormPasien());

        return panel;
    }

    private void loadPasien() {
        modelPasien.setRowCount(0);
        try {
            for (Patient p : dao.getAllPatients()) {
                modelPasien.addRow(new Object[]{
                    p.getID(), p.getName(), p.getGender(),
                    p.getPhoneNumber(), p.getBloodType()
                });
            }
        } catch (RuntimeException e) {
            showError("Gagal load data pasien", e);
        }
    }

    private void fillFormPasien() {
        int row = tblPasien.getSelectedRow();
        if (row < 0) return;
        txtPasienID.setText((String) modelPasien.getValueAt(row, 0));
        txtPasienID.setEditable(false);
        txtPasienNama.setText((String) modelPasien.getValueAt(row, 1));
        cmbPasienGender.setSelectedItem(modelPasien.getValueAt(row, 2));
        txtPasienTelp.setText((String) modelPasien.getValueAt(row, 3));
        cmbPasienGolDarah.setSelectedItem(modelPasien.getValueAt(row, 4));
    }

    private void clearFormPasien() {
        txtPasienID.setText(""); txtPasienID.setEditable(true);
        txtPasienNama.setText(""); txtPasienTelp.setText("");
        cmbPasienGender.setSelectedIndex(0); cmbPasienGolDarah.setSelectedIndex(0);
        tblPasien.clearSelection();
    }

    private void tambahPasien() {
        String id = txtPasienID.getText().trim();
        String nama = txtPasienNama.getText().trim();
        if (id.isEmpty() || nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID dan Nama tidak boleh kosong!"); return;
        }
        Patient patient = new Patient(
            id, nama,
            (String) cmbPasienGender.getSelectedItem(),
            txtPasienTelp.getText().trim(),
            (String) cmbPasienGolDarah.getSelectedItem()
        );
        try {
            dao.savePatient(patient);
            JOptionPane.showMessageDialog(this, "Pasien berhasil ditambahkan!");
            clearFormPasien(); loadPasien();
            refreshComboPasienDokter();
            refreshComboPasien(cmbBillPasien);
            refreshComboPasien(cmbMRPasien);
        } catch (RuntimeException e) {
            showError("Gagal tambah pasien", e);
        }
    }

    private void updatePasien() {
        if (tblPasien.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Pilih pasien dulu!"); return;
        }
        Patient patient = new Patient(
            txtPasienID.getText().trim(),
            txtPasienNama.getText().trim(),
            (String) cmbPasienGender.getSelectedItem(),
            txtPasienTelp.getText().trim(),
            (String) cmbPasienGolDarah.getSelectedItem()
        );
        try {
            dao.updatePatient(patient);
            JOptionPane.showMessageDialog(this, "Pasien berhasil diupdate!");
            clearFormPasien(); loadPasien();
            refreshComboPasienDokter();
            refreshComboPasien(cmbBillPasien);
            refreshComboPasien(cmbMRPasien);
        } catch (RuntimeException e) {
            showError("Gagal update pasien", e);
        }
    }

    private void hapusPasien() {
        if (tblPasien.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Pilih pasien dulu!"); return;
        }
        if (JOptionPane.showConfirmDialog(this,
            "Hapus pasien '" + txtPasienNama.getText() + "'?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try {
            dao.deletePatient(txtPasienID.getText().trim());
            JOptionPane.showMessageDialog(this, "Pasien berhasil dihapus!");
            clearFormPasien(); loadPasien();
            refreshComboPasienDokter();
            refreshComboPasien(cmbBillPasien);
            refreshComboPasien(cmbMRPasien);
        } catch (RuntimeException e) {
            showError("Gagal hapus pasien (mungkin ada data terkait)", e);
        }
    }

    // ================================================================
    // ======================== PANEL RUANGAN =========================
    // ================================================================
    private JPanel createRuanganPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnlForm = new JPanel(new BorderLayout());
        pnlForm.setBorder(BorderFactory.createTitledBorder("Data Ruangan"));
        JPanel pnlInput = new JPanel(new GridBagLayout());

        txtRuanganID        = new JTextField(15);
        cmbRuanganTipe      = new JComboBox<>(new String[]{"VIP", "Kelas 1", "Kelas 2", "ICU"});
        txtRuanganKapasitas = new JTextField(15);
        txtRuanganHarga     = new JTextField(15);

        addFormField(pnlInput, "ID Ruangan:",  txtRuanganID,        0);
        addFormField(pnlInput, "Tipe:",        cmbRuanganTipe,      1);
        addFormField(pnlInput, "Kapasitas:",   txtRuanganKapasitas, 2);
        addFormField(pnlInput, "Harga/Malam:", txtRuanganHarga,     3);

        JPanel pnlBtn = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        btnRuanganTambah = createButton("Tambah", new Color(46, 139, 87));
        btnRuanganUpdate = createButton("Update",  new Color(30, 144, 255));
        btnRuanganHapus  = createButton("Hapus",   new Color(200, 30, 50));
        btnRuanganClear  = createButton("Clear",   null);
        pnlBtn.add(btnRuanganTambah); pnlBtn.add(btnRuanganUpdate);
        pnlBtn.add(btnRuanganHapus);  pnlBtn.add(btnRuanganClear);

        pnlForm.add(pnlInput, BorderLayout.CENTER);
        pnlForm.add(pnlBtn,   BorderLayout.SOUTH);
        panel.add(pnlForm, BorderLayout.NORTH);

        modelRuangan = new DefaultTableModel(
            new String[]{"ID", "Tipe", "Kapasitas", "Harga/Malam", "Okupansi"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblRuangan = createTable(modelRuangan);
        JScrollPane scroll = new JScrollPane(tblRuangan);
        scroll.setBorder(BorderFactory.createTitledBorder("Daftar Ruangan"));
        panel.add(scroll, BorderLayout.CENTER);

        tblRuangan.getSelectionModel().addListSelectionListener(
            e -> { if (!e.getValueIsAdjusting()) fillFormRuangan(); });
        btnRuanganTambah.addActionListener(e -> tambahRuangan());
        btnRuanganUpdate.addActionListener(e -> updateRuangan());
        btnRuanganHapus .addActionListener(e -> hapusRuangan());
        btnRuanganClear .addActionListener(e -> clearFormRuangan());

        return panel;
    }

    private void loadRuangan() {
        modelRuangan.setRowCount(0);
        try {
            for (Room r : dao.getAllRooms()) {
                modelRuangan.addRow(new Object[]{
                    r.getRoomId(), r.getRoomType(), r.getCapacity(),
                    String.format("Rp %,.0f", r.getPricePerNight()),
                    r.getCurrentOccupancy()
                });
            }
        } catch (RuntimeException e) {
            showError("Gagal load data ruangan", e);
        }
    }

    private void fillFormRuangan() {
        int row = tblRuangan.getSelectedRow();
        if (row < 0) return;
        txtRuanganID.setText((String) modelRuangan.getValueAt(row, 0));
        txtRuanganID.setEditable(false);
        cmbRuanganTipe.setSelectedItem(modelRuangan.getValueAt(row, 1));
        txtRuanganKapasitas.setText(modelRuangan.getValueAt(row, 2).toString());
        txtRuanganHarga.setText(modelRuangan.getValueAt(row, 3)
            .toString().replace("Rp ", "").replace(",", ""));
    }

    private void clearFormRuangan() {
        txtRuanganID.setText(""); txtRuanganID.setEditable(true);
        txtRuanganKapasitas.setText(""); txtRuanganHarga.setText("");
        cmbRuanganTipe.setSelectedIndex(0); tblRuangan.clearSelection();
    }

    private void tambahRuangan() {
        String id = txtRuanganID.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Ruangan tidak boleh kosong!"); return;
        }
        try {
            int kap       = Integer.parseInt(txtRuanganKapasitas.getText().trim());
            double harga  = Double.parseDouble(txtRuanganHarga.getText().trim());
            Room room = new Room(id, (String) cmbRuanganTipe.getSelectedItem(), kap, harga);
            dao.saveRoom(room);
            JOptionPane.showMessageDialog(this, "Ruangan berhasil ditambahkan!");
            clearFormRuangan(); loadRuangan();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Kapasitas harus angka bulat, Harga harus angka!");
        } catch (RuntimeException e) {
            showError("Gagal tambah ruangan", e);
        }
    }

    private void updateRuangan() {
        if (tblRuangan.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Pilih ruangan dulu!"); return;
        }
        try {
            int kap      = Integer.parseInt(txtRuanganKapasitas.getText().trim());
            double harga = Double.parseDouble(txtRuanganHarga.getText().trim());
            Room room = new Room(
                txtRuanganID.getText().trim(),
                (String) cmbRuanganTipe.getSelectedItem(),
                kap, harga
            );
            dao.updateRoom(room);
            JOptionPane.showMessageDialog(this, "Ruangan berhasil diupdate!");
            clearFormRuangan(); loadRuangan();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Format angka tidak valid!");
        } catch (RuntimeException e) {
            showError("Gagal update ruangan", e);
        }
    }

    private void hapusRuangan() {
        if (tblRuangan.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Pilih ruangan dulu!"); return;
        }
        if (JOptionPane.showConfirmDialog(this,
            "Hapus ruangan '" + txtRuanganID.getText() + "'?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try {
            dao.deleteRoom(txtRuanganID.getText().trim());
            JOptionPane.showMessageDialog(this, "Ruangan berhasil dihapus!");
            clearFormRuangan(); loadRuangan();
        } catch (RuntimeException e) {
            showError("Gagal hapus ruangan", e);
        }
    }

    // ================================================================
    // ====================== PANEL APPOINTMENT =======================
    // ================================================================
    private JPanel createAppointmentPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnlForm = new JPanel(new BorderLayout());
        pnlForm.setBorder(BorderFactory.createTitledBorder("Data Appointment"));
        JPanel pnlInput = new JPanel(new GridBagLayout());

        txtAptID      = new JTextField(15);
        cmbAptPasien  = new JComboBox<>();
        cmbAptDokter  = new JComboBox<>();
        txtAptTanggal = new JTextField(15);
        txtAptTanggal.setToolTipText("Format: YYYY-MM-DD");
        txtAptJam     = new JTextField(15);
        txtAptJam.setToolTipText("Format: HH:MM");
        cmbAptStatus  = new JComboBox<>(new String[]{"Scheduled", "Selesai", "Dibatalkan"});

        addFormField(pnlInput, "Apt. ID:",              txtAptID,     0);
        addFormField(pnlInput, "Pasien:",               cmbAptPasien, 1);
        addFormField(pnlInput, "Dokter:",               cmbAptDokter, 2);
        addFormField(pnlInput, "Tanggal (YYYY-MM-DD):", txtAptTanggal,3);
        addFormField(pnlInput, "Jam (HH:MM):",          txtAptJam,    4);
        addFormField(pnlInput, "Status:",               cmbAptStatus, 5);

        JPanel pnlBtn = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        btnAptTambah = createButton("Tambah",        new Color(46, 139, 87));
        btnAptUpdate = createButton("Update Status", new Color(30, 144, 255));
        btnAptHapus  = createButton("Hapus",         new Color(200, 30, 50));
        btnAptClear  = createButton("Clear",         null);
        pnlBtn.add(btnAptTambah); pnlBtn.add(btnAptUpdate);
        pnlBtn.add(btnAptHapus);  pnlBtn.add(btnAptClear);

        pnlForm.add(pnlInput, BorderLayout.CENTER);
        pnlForm.add(pnlBtn,   BorderLayout.SOUTH);
        panel.add(pnlForm, BorderLayout.NORTH);

        modelAppointment = new DefaultTableModel(
            new String[]{"Apt. ID", "Pasien", "Dokter", "Tanggal", "Jam", "Status"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblAppointment = createTable(modelAppointment);
        JScrollPane scroll = new JScrollPane(tblAppointment);
        scroll.setBorder(BorderFactory.createTitledBorder("Daftar Appointment"));
        panel.add(scroll, BorderLayout.CENTER);

        tblAppointment.getSelectionModel().addListSelectionListener(
            e -> { if (!e.getValueIsAdjusting()) fillFormApt(); });
        btnAptTambah.addActionListener(e -> tambahApt());
        btnAptUpdate.addActionListener(e -> updateApt());
        btnAptHapus .addActionListener(e -> hapusApt());
        btnAptClear .addActionListener(e -> clearFormApt());

        return panel;
    }

    private void loadAppointment() {
        modelAppointment.setRowCount(0);
        try {
            for (String[] row : dao.getAllAppointments())
                modelAppointment.addRow(row);
        } catch (RuntimeException e) {
            showError("Gagal load data appointment", e);
        }
    }

    private void fillFormApt() {
        int row = tblAppointment.getSelectedRow();
        if (row < 0) return;
        txtAptID.setText((String) modelAppointment.getValueAt(row, 0));
        txtAptID.setEditable(false);
        txtAptTanggal.setText(modelAppointment.getValueAt(row, 3).toString());
        txtAptJam.setText((String) modelAppointment.getValueAt(row, 4));
        cmbAptStatus.setSelectedItem(modelAppointment.getValueAt(row, 5));
    }

    private void clearFormApt() {
        txtAptID.setText(""); txtAptID.setEditable(true);
        txtAptTanggal.setText(""); txtAptJam.setText("");
        cmbAptStatus.setSelectedIndex(0);
        tblAppointment.clearSelection();
        refreshComboPasienDokter();
    }

    /**
     * Appointment dibuat dengan membuat objek Doctor & Patient sementara (partial),
     * lalu membangun objek Appointment (Model), dan menyerahkannya ke DAO.
     * Ini memastikan logika bisnis (cek ketersediaan dokter) tetap ada di Model.
     */
    private void tambahApt() {
        if (txtAptID.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Apt. ID tidak boleh kosong!"); return;
        }
        if (cmbAptPasien.getItemCount() == 0 || cmbAptDokter.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "Tambah data Pasien dan Dokter dulu!"); return;
        }
        try {
            String patId = ((String) cmbAptPasien.getSelectedItem()).split(" - ")[0];
            String docId = ((String) cmbAptDokter.getSelectedItem()).split(" - ")[0];
            LocalDate date = LocalDate.parse(txtAptTanggal.getText().trim());

            // Buat objek Model minimal untuk membangun Appointment
            Patient patTemp = new Patient(patId, "tmp", "L", "", "A");
            Doctor  docTemp = new Doctor(docId, "tmp", "L", "", "", "");
            Appointment apt = new Appointment(
                txtAptID.getText().trim(), patTemp, docTemp,
                date, txtAptJam.getText().trim()
            );
            dao.saveAppointment(apt);
            JOptionPane.showMessageDialog(this, "Appointment berhasil dibuat!");
            clearFormApt(); loadAppointment();
        } catch (java.time.format.DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this,
                "Format tanggal salah!\nGunakan: YYYY-MM-DD (contoh: 2026-06-01)");
        } catch (Exception e) {
            showError("Gagal tambah appointment", new RuntimeException(e.getMessage()));
        }
    }

    private void updateApt() {
        if (tblAppointment.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Pilih appointment dulu!"); return;
        }
        try {
            dao.updateAppointmentStatus(
                txtAptID.getText().trim(),
                (String) cmbAptStatus.getSelectedItem()
            );
            JOptionPane.showMessageDialog(this, "Status appointment diupdate!");
            clearFormApt(); loadAppointment();
        } catch (RuntimeException e) {
            showError("Gagal update appointment", e);
        }
    }

    private void hapusApt() {
        if (tblAppointment.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Pilih appointment dulu!"); return;
        }
        if (JOptionPane.showConfirmDialog(this,
            "Hapus appointment '" + txtAptID.getText() + "'?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try {
            dao.deleteAppointment(txtAptID.getText().trim());
            JOptionPane.showMessageDialog(this, "Appointment berhasil dihapus!");
            clearFormApt(); loadAppointment();
        } catch (RuntimeException e) {
            showError("Gagal hapus appointment", e);
        }
    }

    // ================================================================
    // ========================= PANEL BILL ===========================
    // ================================================================
    private JPanel createBillPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(320);
        splitPane.setResizeWeight(0.45);

        // ===== Atas: Form buat bill + tabel bill =====
        JPanel pnlAtas = new JPanel(new BorderLayout(5, 5));

        JPanel pnlFormBill = new JPanel(new BorderLayout());
        pnlFormBill.setBorder(BorderFactory.createTitledBorder("Buat Bill Baru"));
        JPanel pnlInputBill = new JPanel(new GridBagLayout());

        txtBillID     = new JTextField(15);
        cmbBillPasien = new JComboBox<>();

        addFormField(pnlInputBill, "Bill ID:", txtBillID,     0);
        addFormField(pnlInputBill, "Pasien:",  cmbBillPasien, 1);

        JPanel pnlBtnBill = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        btnBillBuat  = createButton("Buat Bill",    new Color(46, 139, 87));
        btnBillBayar = createButton("Tandai LUNAS", new Color(200, 120, 0));
        btnBillClear = createButton("Clear",        null);
        btnBillBayar.setForeground(Color.WHITE);
        pnlBtnBill.add(btnBillBuat); pnlBtnBill.add(btnBillBayar); pnlBtnBill.add(btnBillClear);

        pnlFormBill.add(pnlInputBill, BorderLayout.CENTER);
        pnlFormBill.add(pnlBtnBill,   BorderLayout.SOUTH);

        modelBill = new DefaultTableModel(
            new String[]{"Bill ID", "Pasien", "Total (Rp)", "Status"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblBill = createTable(modelBill);
        JScrollPane scrollBill = new JScrollPane(tblBill);
        scrollBill.setBorder(BorderFactory.createTitledBorder("Daftar Bill"));

        pnlAtas.add(pnlFormBill, BorderLayout.NORTH);
        pnlAtas.add(scrollBill,  BorderLayout.CENTER);

        // ===== Bawah: Tambah item ke bill =====
        JPanel pnlBawah = new JPanel(new BorderLayout(5, 5));

        JPanel pnlFormItem = new JPanel(new BorderLayout());
        pnlFormItem.setBorder(BorderFactory.createTitledBorder(
            "Tambah Item (klik dulu bill di tabel atas)"));
        JPanel pnlInputItem = new JPanel(new GridBagLayout());

        txtItemDeskripsi = new JTextField(20);
        txtItemHarga     = new JTextField(10);
        txtItemQty       = new JTextField(5);
        txtItemQty.setText("1");

        addFormField(pnlInputItem, "Deskripsi:",         txtItemDeskripsi, 0);
        addFormField(pnlInputItem, "Harga Satuan (Rp):", txtItemHarga,     1);
        addFormField(pnlInputItem, "Qty:",               txtItemQty,       2);

        JPanel pnlBtnItem = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        btnItemTambah = createButton("Tambah Item", new Color(30, 144, 255));
        btnItemHapus  = createButton("Hapus Item",  new Color(200, 30, 50));
        pnlBtnItem.add(btnItemTambah); pnlBtnItem.add(btnItemHapus);

        pnlFormItem.add(pnlInputItem, BorderLayout.CENTER);
        pnlFormItem.add(pnlBtnItem,   BorderLayout.SOUTH);

        modelBillItem = new DefaultTableModel(
            new String[]{"ID", "Deskripsi", "Harga (Rp)"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblBillItem = createTable(modelBillItem);
        tblBillItem.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblBillItem.getColumnModel().getColumn(1).setPreferredWidth(400);
        tblBillItem.getColumnModel().getColumn(2).setPreferredWidth(120);
        JScrollPane scrollItem = new JScrollPane(tblBillItem);
        scrollItem.setBorder(BorderFactory.createTitledBorder("Item dalam Bill"));

        pnlBawah.add(pnlFormItem, BorderLayout.NORTH);
        pnlBawah.add(scrollItem,  BorderLayout.CENTER);

        splitPane.setTopComponent(pnlAtas);
        splitPane.setBottomComponent(pnlBawah);
        panel.add(splitPane, BorderLayout.CENTER);

        btnBillBuat .addActionListener(e -> buatBill());
        btnBillBayar.addActionListener(e -> bayarBill());
        btnBillClear.addActionListener(e -> clearFormBill());
        btnItemTambah.addActionListener(e -> tambahItemBill());
        btnItemHapus .addActionListener(e -> hapusItemBill());
        tblBill.getSelectionModel().addListSelectionListener(
            e -> { if (!e.getValueIsAdjusting()) loadItemBill(); });

        return panel;
    }

    private void loadBill() {
        modelBill.setRowCount(0);
        try {
            for (String[] row : dao.getAllBills())
                modelBill.addRow(row);
        } catch (RuntimeException e) {
            showError("Gagal load data bill", e);
        }
    }

    private void loadItemBill() {
        modelBillItem.setRowCount(0);
        int row = tblBill.getSelectedRow();
        if (row < 0) return;
        String billId = (String) modelBill.getValueAt(row, 0);
        txtBillID.setText(billId);
        try {
            for (String[] item : dao.getBillItems(billId))
                modelBillItem.addRow(item);
        } catch (RuntimeException e) {
            showError("Gagal load item bill", e);
        }
    }

    private void buatBill() {
        String id = txtBillID.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bill ID tidak boleh kosong!"); return;
        }
        if (cmbBillPasien.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "Tambah pasien dulu!"); return;
        }
        String patientId = ((String) cmbBillPasien.getSelectedItem()).split(" - ")[0];
        try {
            dao.createBill(id, patientId);
            JOptionPane.showMessageDialog(this, "Bill " + id + " berhasil dibuat!");
            txtBillID.setText(""); loadBill();
        } catch (RuntimeException e) {
            showError("Gagal buat bill", e);
        }
    }

    private void tambahItemBill() {
        int row = tblBill.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Klik dulu bill di tabel atas!"); return;
        }
        if (modelBill.getValueAt(row, 3).toString().equals("LUNAS")) {
            JOptionPane.showMessageDialog(this, "Bill sudah LUNAS, tidak bisa tambah item!"); return;
        }
        String deskripsi = txtItemDeskripsi.getText().trim();
        if (deskripsi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Deskripsi tidak boleh kosong!"); return;
        }
        try {
            double harga = Double.parseDouble(txtItemHarga.getText().trim());
            int qty      = Integer.parseInt(txtItemQty.getText().trim());
            if (harga < 0 || qty <= 0) throw new NumberFormatException();

            String billId = (String) modelBill.getValueAt(row, 0);
            String desc   = qty > 1 ? deskripsi + " (x" + qty + ")" : deskripsi;
            dao.addBillItem(billId, desc, harga * qty);

            txtItemDeskripsi.setText(""); txtItemHarga.setText(""); txtItemQty.setText("1");
            loadBill();
            // Pilih ulang baris bill yang sama
            for (int i = 0; i < modelBill.getRowCount(); i++) {
                if (modelBill.getValueAt(i, 0).equals(billId)) {
                    tblBill.setRowSelectionInterval(i, i); break;
                }
            }
            loadItemBill();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Input tidak valid!\n- Harga: angka positif\n- Qty: angka bulat > 0");
        } catch (RuntimeException e) {
            showError("Gagal tambah item", e);
        }
    }

    private void hapusItemBill() {
        int rowItem = tblBillItem.getSelectedRow();
        if (rowItem < 0) {
            JOptionPane.showMessageDialog(this, "Pilih item yang ingin dihapus!"); return;
        }
        int rowBill = tblBill.getSelectedRow();
        if (rowBill < 0) return;
        if (modelBill.getValueAt(rowBill, 3).toString().equals("LUNAS")) {
            JOptionPane.showMessageDialog(this, "Bill sudah LUNAS, tidak bisa hapus item!"); return;
        }
        if (JOptionPane.showConfirmDialog(this, "Hapus item ini?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;

        int    itemId = Integer.parseInt((String) modelBillItem.getValueAt(rowItem, 0));
        String billId = (String) modelBill.getValueAt(rowBill, 0);
        double cost   = Double.parseDouble(
            modelBillItem.getValueAt(rowItem, 2).toString()
                .replace("Rp ", "").replace(",", ""));
        try {
            dao.deleteBillItem(itemId, billId, cost);
            loadBill();
            for (int i = 0; i < modelBill.getRowCount(); i++) {
                if (modelBill.getValueAt(i, 0).equals(billId)) {
                    tblBill.setRowSelectionInterval(i, i); break;
                }
            }
            loadItemBill();
        } catch (RuntimeException e) {
            showError("Gagal hapus item", e);
        }
    }

    private void bayarBill() {
        int row = tblBill.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih bill dulu!"); return;
        }
        if (modelBill.getValueAt(row, 3).toString().equals("LUNAS")) {
            JOptionPane.showMessageDialog(this, "Bill ini sudah LUNAS!"); return;
        }
        if (modelBill.getValueAt(row, 2).toString().equals("Rp 0")) {
            JOptionPane.showMessageDialog(this, "Tambahkan item dulu sebelum bayar!"); return;
        }
        String billId = (String) modelBill.getValueAt(row, 0);
        String total  = (String) modelBill.getValueAt(row, 2);
        if (JOptionPane.showConfirmDialog(this,
            "Tandai bill " + billId + " sebagai LUNAS?\nTotal: " + total,
            "Konfirmasi Pembayaran", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try {
            dao.payBill(billId);
            JOptionPane.showMessageDialog(this, "Bill " + billId + " berhasil LUNAS!");
            loadBill();
        } catch (RuntimeException e) {
            showError("Gagal bayar bill", e);
        }
    }

    private void clearFormBill() {
        txtBillID.setText("");
        txtItemDeskripsi.setText(""); txtItemHarga.setText(""); txtItemQty.setText("1");
        tblBill.clearSelection(); modelBillItem.setRowCount(0);
        refreshComboPasien(cmbBillPasien);
    }

    // ================================================================
    // =================== PANEL MEDICAL RECORD =======================
    // ================================================================
    private JPanel createMedicalRecordPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(280);
        splitPane.setResizeWeight(0.4);

        // ===== Atas: Pilih pasien + tabel MR =====
        JPanel pnlAtas = new JPanel(new BorderLayout(5, 5));

        JPanel pnlFormMR = new JPanel(new BorderLayout());
        pnlFormMR.setBorder(BorderFactory.createTitledBorder("Pilih Pasien"));
        JPanel pnlInputMR = new JPanel(new GridBagLayout());

        cmbMRPasien = new JComboBox<>();
        addFormField(pnlInputMR, "Pasien:", cmbMRPasien, 0);

        JPanel pnlBtnMR = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        JButton btnMRBuat        = createButton("Buat / Lihat Record", new Color(30, 144, 255));
        JButton btnMRHapusRecord = createButton("Hapus Record",         new Color(200, 30, 50));
        pnlBtnMR.add(btnMRBuat); pnlBtnMR.add(btnMRHapusRecord);

        pnlFormMR.add(pnlInputMR, BorderLayout.CENTER);
        pnlFormMR.add(pnlBtnMR,   BorderLayout.SOUTH);

        modelMR = new DefaultTableModel(
            new String[]{"Record ID", "Patient ID", "Nama Pasien"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblMR = createTable(modelMR);
        JScrollPane scrollMR = new JScrollPane(tblMR);
        scrollMR.setBorder(BorderFactory.createTitledBorder("Daftar Medical Record"));

        pnlAtas.add(pnlFormMR, BorderLayout.NORTH);
        pnlAtas.add(scrollMR,  BorderLayout.CENTER);

        // ===== Bawah: Tambah catatan medis =====
        JPanel pnlBawah = new JPanel(new BorderLayout(5, 5));

        JPanel pnlFormEntry = new JPanel(new BorderLayout());
        pnlFormEntry.setBorder(BorderFactory.createTitledBorder(
            "Tambah Catatan (klik dulu record di tabel atas)"));
        JPanel pnlInputEntry = new JPanel(new GridBagLayout());

        txtMREntry = new JTextField(30);
        addFormField(pnlInputEntry, "Catatan Medis:", txtMREntry, 0);

        JPanel pnlBtnEntry = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 5));
        btnMRTambahEntry        = createButton("Tambah Catatan", new Color(46, 139, 87));
        JButton btnMRHapusEntry = createButton("Hapus Catatan",  new Color(200, 30, 50));
        btnMRClear              = createButton("Clear",          null);
        pnlBtnEntry.add(btnMRTambahEntry);
        pnlBtnEntry.add(btnMRHapusEntry);
        pnlBtnEntry.add(btnMRClear);

        pnlFormEntry.add(pnlInputEntry, BorderLayout.CENTER);
        pnlFormEntry.add(pnlBtnEntry,   BorderLayout.SOUTH);

        modelMREntry = new DefaultTableModel(
            new String[]{"ID", "Catatan Medis"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblMREntry = createTable(modelMREntry);
        tblMREntry.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblMREntry.getColumnModel().getColumn(1).setPreferredWidth(600);
        JScrollPane scrollEntry = new JScrollPane(tblMREntry);
        scrollEntry.setBorder(BorderFactory.createTitledBorder("Riwayat Catatan Medis"));

        pnlBawah.add(pnlFormEntry, BorderLayout.NORTH);
        pnlBawah.add(scrollEntry,  BorderLayout.CENTER);

        splitPane.setTopComponent(pnlAtas);
        splitPane.setBottomComponent(pnlBawah);
        panel.add(splitPane, BorderLayout.CENTER);

        btnMRBuat.addActionListener(e -> buatAtauLihatMR());
        btnMRHapusRecord.addActionListener(e -> hapusMR());
        btnMRTambahEntry.addActionListener(e -> tambahEntryMR());
        btnMRHapusEntry .addActionListener(e -> hapusEntryMR());
        btnMRClear.addActionListener(e -> {
            txtMREntry.setText("");
            tblMR.clearSelection();
            modelMREntry.setRowCount(0);
        });
        tblMR.getSelectionModel().addListSelectionListener(
            e -> { if (!e.getValueIsAdjusting()) loadEntryMR(); });

        return panel;
    }

    private void loadMR() {
        modelMR.setRowCount(0);
        try {
            for (String[] row : dao.getAllMedicalRecords())
                modelMR.addRow(row);
        } catch (RuntimeException e) {
            showError("Gagal load medical record", e);
        }
    }

    private void loadEntryMR() {
        modelMREntry.setRowCount(0);
        int row = tblMR.getSelectedRow();
        if (row < 0) return;
        String recordId = (String) modelMR.getValueAt(row, 0);
        try {
            for (String[] entry : dao.getMedicalEntries(recordId))
                modelMREntry.addRow(entry);
        } catch (RuntimeException e) {
            showError("Gagal load entries", e);
        }
    }

    private void buatAtauLihatMR() {
        if (cmbMRPasien.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "Tambah pasien dulu!"); return;
        }
        String patientId = ((String) cmbMRPasien.getSelectedItem()).split(" - ")[0];
        try {
            String recordId = dao.createMedicalRecord(patientId);
            if (recordId == null) {
                JOptionPane.showMessageDialog(this,
                    "Medical Record untuk pasien ini sudah ada.");
            } else {
                JOptionPane.showMessageDialog(this,
                    "Medical Record " + recordId + " berhasil dibuat!");
            }
            loadMR();
        } catch (RuntimeException e) {
            showError("Gagal buat medical record", e);
        }
    }

    private void tambahEntryMR() {
        int row = tblMR.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Klik dulu record di tabel atas!"); return;
        }
        String entry = txtMREntry.getText().trim();
        if (entry.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Catatan tidak boleh kosong!"); return;
        }
        String recordId = (String) modelMR.getValueAt(row, 0);
        try {
            dao.addMedicalEntry(recordId, entry);
            txtMREntry.setText("");
            loadEntryMR();
        } catch (RuntimeException e) {
            showError("Gagal tambah catatan", e);
        }
    }

    private void hapusEntryMR() {
        int row = tblMREntry.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih catatan yang ingin dihapus!"); return;
        }
        if (JOptionPane.showConfirmDialog(this, "Hapus catatan ini?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        int entryId = Integer.parseInt((String) modelMREntry.getValueAt(row, 0));
        try {
            dao.deleteMedicalEntry(entryId);
            loadEntryMR();
        } catch (RuntimeException e) {
            showError("Gagal hapus catatan", e);
        }
    }

    private void hapusMR() {
        int row = tblMR.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih medical record dulu!"); return;
        }
        String recordId = (String) modelMR.getValueAt(row, 0);
        if (JOptionPane.showConfirmDialog(this,
            "Hapus record " + recordId + " beserta semua catatannya?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try {
            dao.deleteMedicalRecord(recordId);
            JOptionPane.showMessageDialog(this, "Medical Record berhasil dihapus!");
            modelMREntry.setRowCount(0); loadMR();
        } catch (RuntimeException e) {
            showError("Gagal hapus medical record", e);
        }
    }

    // ================================================================
    // ============================= MAIN =============================
    // ================================================================
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) { /* fallback ke default */ }
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
