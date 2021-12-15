//
// AdminPersoneller.java
//
package Arayuzler;

import Siniflar.Personel;
import static Siniflar.Sabitler.DB;
import static Siniflar.Sabitler.FONK;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminPersoneller extends javax.swing.JFrame {
  private final ArrayList<Personel> tabPersoneller;
  private final DefaultTableModel tabModel;
  private final ArrayList<String> silinecekler;

  public AdminPersoneller() {
    initComponents();
    setLocationRelativeTo(this);
    FONK.setIcon(this);
    btnKaydet.requestFocus();

    tabPersoneller = DB.okuPersoneller();
    tabModel = (DefaultTableModel) tablo.getModel();
    silinecekler = new ArrayList<>();

    tabPersoneller.forEach((personel) -> {
      tabModel.addRow(new Object[]{personel.getId(), personel.getAdSoyad(),
        personel.getKullaniciAdi(), personel.getSifre()});
    });
  }

  private void temizle() {
    txtPersonel.setText("");
    txtUser.setText("");
    txtPass.setText("");
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btnSil = new javax.swing.JButton();
    txtPersonel = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    btnKaydet = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablo = new javax.swing.JTable();
    txtUser = new javax.swing.JTextField();
    btnEkleGuncelle = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    txtPass = new javax.swing.JTextField();
    jSeparator2 = new javax.swing.JSeparator();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Depo Yönetim Sistemi");
    setResizable(false);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosed(java.awt.event.WindowEvent evt) {
        formWindowClosed(evt);
      }
    });

    btnSil.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/sil.png"))); // NOI18N
    btnSil.setText(" Sil");
    btnSil.setToolTipText("Listeden bir maddeyi silmek için tıklayın.");
    btnSil.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSilActionPerformed(evt);
      }
    });

    txtPersonel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    txtPersonel.setToolTipText("Personelin Adı ve Soyadı");

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Personel Listesi Düzenleme Paneli");

    btnKaydet.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnKaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/kaydet.png"))); // NOI18N
    btnKaydet.setText("Kaydet");
    btnKaydet.setToolTipText("Listeyi kaydetmek için tıklayın.");
    btnKaydet.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnKaydetActionPerformed(evt);
      }
    });

    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel3.setText("Personelin Adı ve Soyadı:");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel4.setText("Kullanıcı Adı:");

    tablo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tablo.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "PERSONEL ID", "AD SOYAD", "KULLANICI ADI", "ŞİFRE"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tablo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tablo.getTableHeader().setReorderingAllowed(false);
    tablo.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tabloMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(tablo);
    if (tablo.getColumnModel().getColumnCount() > 0) {
      tablo.getColumnModel().getColumn(0).setMinWidth(0);
      tablo.getColumnModel().getColumn(0).setPreferredWidth(0);
      tablo.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    txtUser.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    txtUser.setToolTipText("Personele ait kullanıcı adı");

    btnEkleGuncelle.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnEkleGuncelle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/ekle.png"))); // NOI18N
    btnEkleGuncelle.setText("   Ekle | Güncelle");
    btnEkleGuncelle.setToolTipText("Listeye eklemek veya eklenmiş olan maddeyi değiştirmek için tıklayın.");
    btnEkleGuncelle.setPreferredSize(new java.awt.Dimension(150, 30));
    btnEkleGuncelle.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEkleGuncelleActionPerformed(evt);
      }
    });

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel5.setText("Şifre:");

    txtPass.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    txtPass.setToolTipText("Personelin Şifresi");

    jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
    jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jSeparator1)
              .addGroup(layout.createSequentialGroup()
                .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jLabel4)
                      .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(txtPass)))
                  .addComponent(jLabel3)
                  .addComponent(txtPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEkleGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel4)
              .addComponent(jLabel5))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addGap(43, 43, 43)
            .addComponent(btnEkleGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(13, 13, 13)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    new AdminPanel().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

  private void btnEkleGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleGuncelleActionPerformed
    boolean yeni = true;

    // Personel Ad-Soyad, Kullanıcı Adı veya Şifre kısmı boş olamaz.
    String personelAd = txtPersonel.getText().trim();
    String personelUser = txtUser.getText().trim();
    String personelPass = txtPass.getText().trim();

    if (personelAd.equals("") || personelUser.equals("") || personelPass.equals("")) {
      JOptionPane.showMessageDialog(this, "Lütfen Personel Ad-Soyad, "
              + "Kullanıcı Adı veya Şifre kısımlarını boş bırakmayınız!",
              "HATA : Eksik bilgi!", 0);
      return;
    }

    // Eklenmek istenen "Kullanıcı Adı" daha önce eklenmişse,
    // farklı olan diğer değerleri güncellenir, aksi halde hiçbir şey yapılmaz.
    for (int i = 0; i < tabModel.getRowCount(); i++) {
      if (personelUser.equals(tabModel.getValueAt(i, 2).toString())) {
        tabModel.setValueAt(tabModel.getValueAt(i, 0).toString(), i, 0);
        tabModel.setValueAt(personelAd, i, 1);
        tabModel.setValueAt(personelPass, i, 3);
        temizle();
        return;
      }
    }

    // Listeden yanlışlıkla silinip, aynı adla eklenen personeller için kullanılır.
    for (Personel personel : tabPersoneller) {
      if (personel.getKullaniciAdi().equals(personelUser)) {
        tabModel.addRow(new Object[]{personel.getId(), personelAd, personelUser, personelPass});
        silinecekler.remove("" + personel.getId());
        temizle();
        return;
      }
    }

    if (yeni) {
      tabModel.addRow(new Object[]{0, personelAd, personelUser, personelPass});
      temizle();
    }
  }//GEN-LAST:event_btnEkleGuncelleActionPerformed

  private void tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabloMouseClicked
    if (tablo.getSelectedRow() != -1) {
      txtPersonel.setText(tablo.getValueAt(tablo.getSelectedRow(), 1).toString());
      txtUser.setText(tablo.getValueAt(tablo.getSelectedRow(), 2).toString());
      txtPass.setText(tablo.getValueAt(tablo.getSelectedRow(), 3).toString());
    } else {
      JOptionPane.showMessageDialog(this, "Silinecek herhangi bir personel seçmediniz!",
              "HATA : Personel bilgisi eksik!", 2);
    }
  }//GEN-LAST:event_tabloMouseClicked

  private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
    if (tabModel.getRowCount() < 1) {
      JOptionPane.showMessageDialog(this, "Silinecek herhangi bir personel yok!",
              "HATA : Personel bilgisi eksik!", 2);
    } else if (tablo.getSelectedRowCount() < 1) {
      JOptionPane.showMessageDialog(this, "Silinecek herhangi bir personel seçmediniz!",
              "HATA : Personel bilgisi eksik!", 2);
    } else if (tabModel.getValueAt(tablo.getSelectedRow(), 2).toString().equals("root")) {
      JOptionPane.showMessageDialog(this, "Yönetici (root) kullanıcısı silinemez!",
              "HATA : Yasak İşlem!", 0);
    } else {
      if (Integer.valueOf(tabModel.getValueAt(tablo.getSelectedRow(), 0).toString()) != 0) {
        silinecekler.add(tabModel.getValueAt(tablo.getSelectedRow(), 0).toString());
      }

      tabModel.removeRow(tablo.getSelectedRow());
    }
  }//GEN-LAST:event_btnSilActionPerformed

  private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
    btnKaydet.setEnabled(false);
    btnEkleGuncelle.setEnabled(false);
    btnSil.setEnabled(false);
    tablo.setEnabled(false);
    txtPersonel.setEnabled(false);
    txtUser.setEnabled(false);
    txtPass.setEnabled(false);

    for (int i = 0; i < tabModel.getRowCount(); i++) {
      int personelId = Integer.valueOf(tabModel.getValueAt(i, 0).toString());
      String adSoyad = tabModel.getValueAt(i, 1).toString();
      String kullaniciAdi = tabModel.getValueAt(i, 2).toString();
      String sifre = tabModel.getValueAt(i, 3).toString();

      if (personelId == 0) {
        DB.ekle(new Personel(personelId, adSoyad, kullaniciAdi, sifre));
      } else {
        DB.degistir(new Personel(personelId, adSoyad, kullaniciAdi, sifre));
      }
    }

    silinecekler.forEach((silinecek) -> {
      DB.sil(Integer.valueOf(silinecek), "tabPersoneller");
    });

    JOptionPane.showMessageDialog(AdminPersoneller.this,
            "Personel Listesi başarılı bir şekilde güncellendi.\n"
            + "Silinen personellerin depodaki diğer kayıtları da silindi!",
            "Personel Listesi Düzenlendi ✓", 1);

    AdminPersoneller.this.dispose();
  }//GEN-LAST:event_btnKaydetActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnEkleGuncelle;
  private javax.swing.JButton btnKaydet;
  private javax.swing.JButton btnSil;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JTable tablo;
  private javax.swing.JTextField txtPass;
  private javax.swing.JTextField txtPersonel;
  private javax.swing.JTextField txtUser;
  // End of variables declaration//GEN-END:variables
}
