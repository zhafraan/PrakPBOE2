package jdbc.program;

import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import jdbc.model.Mahasiswa;
import jdbc.service.MysqlMahasiswaService;

public class JFrameUtama extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFrameUtama.class.getName());
    MysqlMahasiswaService service;
    DefaultListModel<String> dlmID;
    DefaultListModel<String> dlmNama;

    public JFrameUtama() {
        initComponents();
        
        dlmID = new DefaultListModel<>();
        dlmNama = new DefaultListModel<>();
        
        jListID.setModel(dlmID);
        jListNama.setModel(dlmNama);
        try {
            service = new MysqlMahasiswaService();
        } 
        catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
    }
        private void tampilData() {
        dlmID.clear();
        dlmNama.clear();
        try {
            List<Mahasiswa> list =
            service.getAll();

            for(Mahasiswa mhs : list) {
                dlmID.addElement(String.valueOf(mhs.getId()));
                dlmNama.addElement(mhs.getNama());
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
    private void resetForm() {
        InputNama.setText("");

        jTextFieldEditID.setText("");
        jTextFieldEditNama.setText("");

        jTextFieldHapusID.setText("");
        jTextFieldHapusNama.setText("");
    }
    private void resetIndex() {
    try {
        List<Mahasiswa> list =
        service.getAll();
        int indexBaru = 1;

        for(Mahasiswa mhs : list) {
            mhs.setId(indexBaru);
            service.update(mhs);
            indexBaru++;
        }
        jLabelIndexReset.setText(
            "Index di reset ke = 1"
        );
        tampilData();
    } catch(Exception e) {
        System.out.println(e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListID = new javax.swing.JList<>();
        jLabelID = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListNama = new javax.swing.JList<>();
        jLabelNama = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonAmbilDataAll = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        InputNama = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jTextFieldEditID = new javax.swing.JTextField();
        jTextFieldEditNama = new javax.swing.JTextField();
        jTextFieldHapusID = new javax.swing.JTextField();
        jTextFieldHapusNama = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabelIndexReset = new javax.swing.JLabel();

        label1.setText("label1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jListID.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListID);

        jLabelID.setText("ID");

        jListNama.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListNama);

        jLabelNama.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Kelola Data Mahasiswa");

        jButtonAmbilDataAll.setText("Ambil Semua data");
        jButtonAmbilDataAll.addActionListener(this::jButtonAmbilDataAllActionPerformed);

        jLabel4.setText("Nama :");

        InputNama.addActionListener(this::InputNamaActionPerformed);

        jButtonAdd.setText("Tambah");
        jButtonAdd.addActionListener(this::jButtonAddActionPerformed);

        jTextFieldEditID.addActionListener(this::jTextFieldEditIDActionPerformed);

        jTextFieldHapusID.addActionListener(this::jTextFieldHapusIDActionPerformed);

        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(this::jButtonEditActionPerformed);

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(this::jButtonHapusActionPerformed);

        jButtonReset.setText("Reset Index");
        jButtonReset.addActionListener(this::jButtonResetActionPerformed);

        jLabelIndexReset.setText("Index di reset ke =");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAmbilDataAll)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputNama, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldHapusID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jTextFieldEditID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldEditNama)
                            .addComponent(jTextFieldHapusNama, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEdit)
                            .addComponent(jButtonHapus)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelIndexReset, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelID)
                    .addComponent(jLabelNama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAmbilDataAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEditID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEditNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEdit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldHapusID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHapusNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonHapus))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonReset)
                            .addComponent(jLabelIndexReset)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAmbilDataAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAmbilDataAllActionPerformed
         tampilData();
    }//GEN-LAST:event_jButtonAmbilDataAllActionPerformed

    private void InputNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputNamaActionPerformed
        
    }//GEN-LAST:event_InputNamaActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try {
        Mahasiswa mhs = new Mahasiswa();
        int idBaru = service.getAll().size() + 1;

        mhs.setId(idBaru);
        mhs.setNama(InputNama.getText());
        service.add(mhs);
        tampilData();
        InputNama.setText("");

        } catch(Exception e) {
            System.out.println(e.getMessage());
    }

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTextFieldEditIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEditIDActionPerformed
        
    }//GEN-LAST:event_jTextFieldEditIDActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        try {
        Mahasiswa mhs = new Mahasiswa();
       
        mhs.setId(Integer.parseInt(jTextFieldEditID.getText()));
        mhs.setNama(jTextFieldEditNama.getText());
            
        service.update(mhs);
        tampilData();
        resetForm();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        try {
            int id = Integer.parseInt(jTextFieldHapusID.getText());
            service.delete(id);
            tampilData();
            resetForm();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButtonHapusActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
         resetIndex();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jTextFieldHapusIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHapusIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHapusIDActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JFrameUtama().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InputNama;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAmbilDataAll;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelIndexReset;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JList<String> jListID;
    private javax.swing.JList<String> jListNama;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldEditID;
    private javax.swing.JTextField jTextFieldEditNama;
    private javax.swing.JTextField jTextFieldHapusID;
    private javax.swing.JTextField jTextFieldHapusNama;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
