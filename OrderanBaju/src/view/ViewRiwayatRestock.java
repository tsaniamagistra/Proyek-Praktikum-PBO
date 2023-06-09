/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JDateChooser;
import controller.ControllerRestock;
import controller.CustomException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import koneksi.connector;

/**
 *
 * @author HP
 */
public class ViewRiwayatRestock extends javax.swing.JFrame {

    /**
     * Creates new form ViewRiwayatRestock
     */
    ControllerRestock dr;
    Connection connection;
    Statement stmt;
    ResultSet rs;
    
    public ViewRiwayatRestock() {
        try {
            initComponents();
            
            dr = new ControllerRestock(this);
            dr.isitabel();
            
            connection = connector.connection();
            
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT nama from item");
            while(rs.next()){
                String nama = rs.getString("nama");
                jComboBoxItem.addItem(nama);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewOrderan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxItem = new javax.swing.JComboBox<>();
        pilihTanggal = new com.toedter.calendar.JDateChooser();
        hapusBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        resetBtn = new javax.swing.JButton();
        jumlahTf = new javax.swing.JTextField();
        idRiwayat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        simpanBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelRiwayat = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tutupBtn = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Data Orderan");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(124, 172, 193));

        jPanel1.setBackground(new java.awt.Color(124, 172, 193));

        hapusBtn.setBackground(new java.awt.Color(99, 135, 150));
        hapusBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hapusBtn.setForeground(new java.awt.Color(255, 255, 255));
        hapusBtn.setText("Hapus");
        hapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Riwayat");

        resetBtn.setBackground(new java.awt.Color(99, 135, 150));
        resetBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        idRiwayat.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tanggal Masuk");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah");

        simpanBtn.setBackground(new java.awt.Color(99, 135, 150));
        simpanBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        simpanBtn.setForeground(new java.awt.Color(255, 255, 255));
        simpanBtn.setText("Simpan");
        simpanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBtnActionPerformed(evt);
            }
        });

        tabelRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelRiwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelRiwayatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelRiwayat);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Data Riwayat Restock");

        tutupBtn.setBackground(new java.awt.Color(99, 135, 150));
        tutupBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tutupBtn.setForeground(new java.awt.Color(255, 255, 255));
        tutupBtn.setText("Tutup");
        tutupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutupBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(simpanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pilihTanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idRiwayat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jumlahTf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxItem, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tutupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(249, 249, 249))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tutupBtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(pilihTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jumlahTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpanBtn)
                            .addComponent(hapusBtn)
                            .addComponent(resetBtn))
                        .addGap(72, 72, 72))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tutupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutupBtnActionPerformed
        // TODO add your handling code here:
        ViewMenu menu = new ViewMenu();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_tutupBtnActionPerformed

    private void hapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBtnActionPerformed
        try {
            // TODO add your handling code here:
            dr.delete();
        } catch (CustomException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        finally {
            dr.isitabel();
            pilihTanggal.setCalendar(null);
            idRiwayat.setText(" ");
            jComboBoxItem.setSelectedIndex(0);
            jumlahTf.setText("");
            simpanBtn.setEnabled(true);
            pilihTanggal.setEnabled(true);
            jComboBoxItem.setEnabled(true);
            jumlahTf.setEditable(true);
        }
    }//GEN-LAST:event_hapusBtnActionPerformed

    private void simpanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBtnActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            dr.insert();
        }
        catch (SQLException ex) {
            Logger.getLogger(ViewOrderan.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex) {
            if(ex instanceof NullPointerException){
                JOptionPane.showMessageDialog(this, "Pilih Tanggal Masuk!");
            }
            else if(ex instanceof CustomException){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            else if(ex instanceof NumberFormatException){
                JOptionPane.showMessageDialog(this, "Input Jumlah harus berupa angka!");
            }
            else{
                JOptionPane.showMessageDialog(this, ex);
            }
        }
        finally {
            dr.isitabel();
        }
    }//GEN-LAST:event_simpanBtnActionPerformed

    private void tabelRiwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelRiwayatMouseClicked
        // TODO add your handling code here:
        int baris = tabelRiwayat.getSelectedRow();
        idRiwayat.setText(tabelRiwayat.getValueAt(baris , 0).toString());
        pilihTanggal.setDate((java.util.Date) tabelRiwayat.getValueAt(baris , 1));
        jComboBoxItem.setSelectedItem(tabelRiwayat.getValueAt(baris, 2).toString());
        jumlahTf.setText(tabelRiwayat.getValueAt(baris , 3).toString());
        simpanBtn.setEnabled(false);
        pilihTanggal.setEnabled(false);
        jComboBoxItem.setEnabled(false);
        jumlahTf.setEditable(false);
    }//GEN-LAST:event_tabelRiwayatMouseClicked

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
        pilihTanggal.setCalendar(null);
        idRiwayat.setText(" ");
        jComboBoxItem.setSelectedIndex(0);
        jumlahTf.setText("");
        simpanBtn.setEnabled(true);
        pilihTanggal.setEnabled(true);
        jComboBoxItem.setEnabled(true);
        jumlahTf.setEditable(true);
    }//GEN-LAST:event_resetBtnActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewRiwayatRestock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRiwayatRestock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRiwayatRestock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRiwayatRestock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRiwayatRestock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapusBtn;
    private javax.swing.JTextField idRiwayat;
    private javax.swing.JComboBox<String> jComboBoxItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahTf;
    private com.toedter.calendar.JDateChooser pilihTanggal;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton simpanBtn;
    private javax.swing.JTable tabelRiwayat;
    private javax.swing.JButton tutupBtn;
    // End of variables declaration//GEN-END:variables

    public JTextField getIdRiwayat() {
        return idRiwayat;
    }

    public void setIdRiwayat(JTextField idRiwayat) {
        this.idRiwayat = idRiwayat;
    }

    public JComboBox<String> getjComboBoxItem() {
        return jComboBoxItem;
    }

    public void setjComboBoxItem(JComboBox<String> jComboBoxItem) {
        this.jComboBoxItem = jComboBoxItem;
    }

    public JTextField getJumlahTf() {
        return jumlahTf;
    }

    public void setJumlahTf(JTextField jumlahTf) {
        this.jumlahTf = jumlahTf;
    }

    public JDateChooser getPilihTanggal() {
        return pilihTanggal;
    }

    public void setPilihTanggal(JDateChooser pilihTanggal) {
        this.pilihTanggal = pilihTanggal;
    }

    public JTable getTabelRiwayat() {
        return tabelRiwayat;
    }

    public void setTabelRiwayat(JTable tabelRiwayat) {
        this.tabelRiwayat = tabelRiwayat;
    }
    
    
}
