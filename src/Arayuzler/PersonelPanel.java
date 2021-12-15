//
// PersonelPanel.java
//
package Arayuzler;

import static Siniflar.Sabitler.FONK;

public class PersonelPanel extends javax.swing.JFrame {
  public PersonelPanel() {
    initComponents();
    setLocationRelativeTo(this);
    FONK.setIcon(this);
    btnCikis.requestFocus();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    btnUrunGidisi = new javax.swing.JButton();
    btnArama = new javax.swing.JButton();
    btnUrunGelisi = new javax.swing.JButton();
    btnCikis = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Depo Yönetim Sistemi");
    setResizable(false);

    jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Nb.Desktop.background"));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Personel Paneli");

    btnUrunGidisi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnUrunGidisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/urungidis.png"))); // NOI18N
    btnUrunGidisi.setText(" ÜRÜN GİDİŞ");
    btnUrunGidisi.setToolTipText("Depodan ürün çıkışı yapmak için tıklayın.");
    btnUrunGidisi.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUrunGidisiActionPerformed(evt);
      }
    });

    btnArama.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnArama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/arama.png"))); // NOI18N
    btnArama.setText("   ARAMA");
    btnArama.setToolTipText("Depoda arama yapmak için tıklayın.");
    btnArama.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAramaActionPerformed(evt);
      }
    });

    btnUrunGelisi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnUrunGelisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/urungelis.png"))); // NOI18N
    btnUrunGelisi.setText(" ÜRÜN GELİŞ");
    btnUrunGelisi.setToolTipText("Depoya ürün girişi yapmak için tıklayın.");
    btnUrunGelisi.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUrunGelisiActionPerformed(evt);
      }
    });

    btnCikis.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btnCikis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/cikis.png"))); // NOI18N
    btnCikis.setText("       ÇIKIŞ");
    btnCikis.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCikisActionPerformed(evt);
      }
    });

    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(btnArama, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnCikis, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnUrunGelisi, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUrunGidisi))))
          .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnUrunGelisi, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnArama, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnUrunGidisi, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(60, 60, 60)
        .addComponent(btnCikis, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(20, 20, 20))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btnUrunGidisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunGidisiActionPerformed
    new UrunGidisi().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnUrunGidisiActionPerformed

    private void btnAramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAramaActionPerformed
    new AramaPanel().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnAramaActionPerformed

    private void btnUrunGelisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunGelisiActionPerformed
    new UrunGelisi().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnUrunGelisiActionPerformed

    private void btnCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCikisActionPerformed
    System.exit(0);
    }//GEN-LAST:event_btnCikisActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnArama;
  private javax.swing.JButton btnCikis;
  private javax.swing.JButton btnUrunGelisi;
  private javax.swing.JButton btnUrunGidisi;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JSeparator jSeparator1;
  // End of variables declaration//GEN-END:variables
}
