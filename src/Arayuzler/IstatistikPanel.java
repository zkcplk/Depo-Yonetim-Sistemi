//
// IstatistikPanel.java
//
package Arayuzler;

import Siniflar.Hesap;
import Siniflar.PDFCikti;
import static Siniflar.Sabitler.*;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IstatistikPanel extends javax.swing.JFrame {
  private Object[][] istatistikler;
  private final DefaultTableModel tabModelIstatistik;

  public IstatistikPanel() {
    initComponents();
    setLocationRelativeTo(null);
    FONK.setIcon(this);

    btnPDFIstatistikler.setEnabled(false);
    tabModelIstatistik = (DefaultTableModel) tabloIstatistik.getModel();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tabloIstatistik = new javax.swing.JTable();
    jSeparator1 = new javax.swing.JSeparator();
    btnPDFIstatistikler = new javax.swing.JButton();
    btnIstatistikler = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Depo Yönetim Sistemi");
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("İstatistikler Paneli");

    tabloIstatistik.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
    tabloIstatistik.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "DURUM", "SONUÇ"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tabloIstatistik.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tabloIstatistik.getTableHeader().setReorderingAllowed(false);
    jScrollPane1.setViewportView(tabloIstatistik);
    if (tabloIstatistik.getColumnModel().getColumnCount() > 0) {
      tabloIstatistik.getColumnModel().getColumn(0).setPreferredWidth(280);
    }

    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    btnPDFIstatistikler.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnPDFIstatistikler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/pdf.png"))); // NOI18N
    btnPDFIstatistikler.setText("   PDF olarak kaydet");
    btnPDFIstatistikler.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnPDFIstatistiklerActionPerformed(evt);
      }
    });

    btnIstatistikler.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnIstatistikler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/arama.png"))); // NOI18N
    btnIstatistikler.setText(" İstatistikleri Getir");
    btnIstatistikler.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnIstatistiklerActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jSeparator1)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(btnPDFIstatistikler)
                .addGap(29, 29, 29)
                .addComponent(btnIstatistikler, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(btnPDFIstatistikler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btnIstatistikler, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnPDFIstatistiklerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFIstatistiklerActionPerformed

    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.istatistiklerPDF(unixTime, istatistikler);

    try {
      PDFCikti.pdfYap(pdf, "Istatistikler", unixTime);
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(this, "PDF çıktısı oluşturulamadı!", "PDF Hatası!", 0);
      this.dispose();
    }

    JOptionPane.showMessageDialog(this, "İstatistikler için PDF çıktısı başarıyla oluşturuldu!\n"
            + "PDF çıktısını masaüstünüzde bulabilirsiniz.", "PDF İşlemi Başarılı ✓", 1);

    btnPDFIstatistikler.setEnabled(false);
  }//GEN-LAST:event_btnPDFIstatistiklerActionPerformed

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    if (PERSONELUSER.equals("root")) {
      new AdminPanel().setVisible(true);
    } else {
      new PersonelPanel().setVisible(true);
    }

    this.dispose();
  }//GEN-LAST:event_formWindowClosing

  private void btnIstatistiklerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIstatistiklerActionPerformed
    Hesap hesap = new Hesap();
    tabModelIstatistik.setRowCount(0);
    istatistikler = hesap.istatistikHesapla();

    for (int i = 0; i < 14; i++) {
      tabModelIstatistik.addRow(istatistikler[i]);
    }

    btnPDFIstatistikler.setEnabled(true);
    btnIstatistikler.setEnabled(false);
  }//GEN-LAST:event_btnIstatistiklerActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnIstatistikler;
  private javax.swing.JButton btnPDFIstatistikler;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JTable tabloIstatistik;
  // End of variables declaration//GEN-END:variables
}
