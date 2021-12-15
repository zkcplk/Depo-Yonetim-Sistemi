//
// AdminPanel.java
//
package Arayuzler;

import static Siniflar.Sabitler.FONK;

public class AdminPanel extends javax.swing.JFrame {
  public AdminPanel() {
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
    btnCalisanlar = new javax.swing.JButton();
    btnArama = new javax.swing.JButton();
    btnUrunler = new javax.swing.JButton();
    btnMagazalar = new javax.swing.JButton();
    btnIstatistik = new javax.swing.JButton();
    btnUreticiler = new javax.swing.JButton();
    btnCikis = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Depo Yönetim Sistemi");
    setResizable(false);

    jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Nb.Desktop.background"));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Yönetici Paneli");

    btnCalisanlar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnCalisanlar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/personel.png"))); // NOI18N
    btnCalisanlar.setText("PERSONEL");
    btnCalisanlar.setToolTipText("Personel listesini düzenlemek için tıklayın.");
    btnCalisanlar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCalisanlarActionPerformed(evt);
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

    btnUrunler.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnUrunler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/urunler.png"))); // NOI18N
    btnUrunler.setText("   ÜRÜN");
    btnUrunler.setToolTipText("Ürün listesini düzenlemek için tıklayın.");
    btnUrunler.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUrunlerActionPerformed(evt);
      }
    });

    btnMagazalar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnMagazalar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/magaza.png"))); // NOI18N
    btnMagazalar.setText("  MAĞAZA");
    btnMagazalar.setToolTipText("Mağaza listesini düzenlemek için tıklayın.");
    btnMagazalar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnMagazalarActionPerformed(evt);
      }
    });

    btnIstatistik.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnIstatistik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/istatistik.png"))); // NOI18N
    btnIstatistik.setText("  İSTATİSTİK");
    btnIstatistik.setToolTipText("İstatistik bilgilerini edinmek için tıklayın.");
    btnIstatistik.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnIstatistikActionPerformed(evt);
      }
    });

    btnUreticiler.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnUreticiler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/uretici.png"))); // NOI18N
    btnUreticiler.setText(" ÜRETİCİ");
    btnUreticiler.setToolTipText("Üretici listesini düzenlemek için tıklayın.");
    btnUreticiler.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUreticilerActionPerformed(evt);
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
          .addComponent(jSeparator1)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnUrunler, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCalisanlar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnArama, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnUreticiler, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(btnCikis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(btnMagazalar, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnIstatistik, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnCalisanlar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnUrunler, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnArama, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnMagazalar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnIstatistik, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnUreticiler, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(70, 70, 70)
        .addComponent(btnCikis, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
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

    private void btnCalisanlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalisanlarActionPerformed
    new AdminPersoneller().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnCalisanlarActionPerformed

    private void btnAramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAramaActionPerformed
    new AramaPanel().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnAramaActionPerformed

    private void btnUrunlerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunlerActionPerformed
    new AdminUrunler().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnUrunlerActionPerformed

    private void btnMagazalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMagazalarActionPerformed
    new AdminMagazalar().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnMagazalarActionPerformed

    private void btnIstatistikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIstatistikActionPerformed
    new IstatistikPanel().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnIstatistikActionPerformed

    private void btnUreticilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUreticilerActionPerformed
    new AdminUreticiler().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnUreticilerActionPerformed

    private void btnCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCikisActionPerformed
    System.exit(0);
    }//GEN-LAST:event_btnCikisActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnArama;
  private javax.swing.JButton btnCalisanlar;
  private javax.swing.JButton btnCikis;
  private javax.swing.JButton btnIstatistik;
  private javax.swing.JButton btnMagazalar;
  private javax.swing.JButton btnUreticiler;
  private javax.swing.JButton btnUrunler;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JSeparator jSeparator1;
  // End of variables declaration//GEN-END:variables
}
