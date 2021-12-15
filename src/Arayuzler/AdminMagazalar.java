//
// AdminMagazalar.java
//
package Arayuzler;

import Siniflar.Magaza;
import static Siniflar.Sabitler.DB;
import static Siniflar.Sabitler.FONK;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminMagazalar extends javax.swing.JFrame {
  private final ArrayList<Magaza> tabMagazalar;
  private final DefaultTableModel tabModel;
  private final ArrayList<String> silinecekler;

  public AdminMagazalar() {
    initComponents();
    setLocationRelativeTo(this);
    FONK.setIcon(this);
    btnKaydet.requestFocus();

    tabMagazalar = DB.okuMagazalar();
    tabModel = (DefaultTableModel) tablo.getModel();
    silinecekler = new ArrayList<>();

    tabMagazalar.forEach((magaza) -> {
      tabModel.addRow(new Object[]{magaza.getId(), magaza.getAd(),
        magaza.getAdres(), magaza.getTelefon()});
    });
  }

  private void temizle() {
    txtMagazaAd.setText("");
    txtMagazaAdres.setText("");
    txtMagazaTel.setText("");
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jSeparator2 = new javax.swing.JSeparator();
    btnEkleGuncelle = new javax.swing.JButton();
    btnSil = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    txtMagazaAd = new javax.swing.JTextField();
    txtMagazaAdres = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    btnKaydet = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablo = new javax.swing.JTable();
    jLabel3 = new javax.swing.JLabel();
    txtMagazaTel = new javax.swing.JFormattedTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Depo Yönetim Sistemi");
    setResizable(false);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosed(java.awt.event.WindowEvent evt) {
        formWindowClosed(evt);
      }
    });

    jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
    jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

    btnEkleGuncelle.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnEkleGuncelle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/ekle.png"))); // NOI18N
    btnEkleGuncelle.setText("  Ekle | Güncelle");
    btnEkleGuncelle.setToolTipText("Listeye eklemek veya eklenmiş olan maddeyi değiştirmek için tıklayın.");
    btnEkleGuncelle.setPreferredSize(new java.awt.Dimension(150, 30));
    btnEkleGuncelle.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEkleGuncelleActionPerformed(evt);
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

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel5.setText("Adres:");

    txtMagazaAd.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    txtMagazaAd.setToolTipText("Mağaza Adı");

    txtMagazaAdres.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    txtMagazaAdres.setToolTipText("Mağazanın açık adresi");

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Mağaza Listesi Düzenleme Paneli");

    btnKaydet.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnKaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/kaydet.png"))); // NOI18N
    btnKaydet.setText(" Kaydet");
    btnKaydet.setToolTipText("Listeyi kaydetmek için tıklayın.");
    btnKaydet.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnKaydetActionPerformed(evt);
      }
    });

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel4.setText("Telefon:");

    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    tablo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tablo.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Mağaza ID", "MAĞAZA AD", "MAĞAZA ADRES", "MAĞAZA TELEFON"
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

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel3.setText("Mağaza Adı:");

    try {
      txtMagazaTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-##-##")));
    } catch (java.text.ParseException ex) {
      ex.printStackTrace();
    }
    txtMagazaTel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jScrollPane1)
          .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(392, 392, 392))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                      .addComponent(txtMagazaAd))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(txtMagazaTel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                  .addComponent(txtMagazaAdres))
                .addGap(18, 18, 18)))
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnEkleGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(jLabel4))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(txtMagazaAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(txtMagazaTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtMagazaAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGap(49, 49, 49)
            .addComponent(btnEkleGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    new AdminPanel().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

  private void btnEkleGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleGuncelleActionPerformed
    boolean yeni = true;

    // Mağaza Adı, Adres veya Telefon bilgisi boş olamaz.
    String magazaAd = txtMagazaAd.getText().trim();
    String magazaAdres = txtMagazaAdres.getText().trim();
    String magazaTel = txtMagazaTel.getText().trim();

    if (magazaAd.equals("") || magazaAdres.equals("") || magazaTel.equals("")) {
      JOptionPane.showMessageDialog(this, "Lütfen Mağaza Adı, "
              + "Magaza Adresi veya Telefon bilgilerini boş bırakmayınız!",
              "HATA : Eksik bilgi!", 0);
      return;
    }

    // Eklenmek istenen "Mağaza Adı" daha önce eklenmişse,
    // ilgili mağazanın farklı olan diğer değerleri güncellenir,
    // aksi halde hiçbir şey yapılmaz.
    for (int i = 0; i < tabModel.getRowCount(); i++) {
      if (magazaAd.equals(tabModel.getValueAt(i, 1).toString())) {
        tabModel.setValueAt(tabModel.getValueAt(i, 0).toString(), i, 0);
        tabModel.setValueAt(magazaAdres, i, 2);
        tabModel.setValueAt(magazaTel, i, 3);
        temizle();
        return;
      }
    }

    // Listeden yanlışlıkla silinip, aynı adla eklenen mağazalar için kullanılır.
    for (Magaza magaza : tabMagazalar) {
      if (magaza.getAd().equals(magazaAd)) {
        tabModel.addRow(new Object[]{magaza.getId(), magazaAd, magazaAdres, magazaTel});
        silinecekler.remove("" + magaza.getId());
        temizle();
        return;
      }
    }

    if (yeni) {
      tabModel.addRow(new Object[]{0, magazaAd, magazaAdres, magazaTel});
      temizle();
    }
  }//GEN-LAST:event_btnEkleGuncelleActionPerformed

  private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
    if (tabModel.getRowCount() < 1) {
      JOptionPane.showMessageDialog(this, "Silinecek herhangi bir mağaza yok!",
              "HATA : Mağaza bilgisi eksik!", 2);
    } else if (tablo.getSelectedRowCount() < 1) {
      JOptionPane.showMessageDialog(this, "Silinecek herhangi bir mağaza seçmediniz!",
              "HATA : Mağaza bilgisi eksik!", 2);
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
    txtMagazaAd.setEnabled(false);
    txtMagazaAdres.setEnabled(false);
    txtMagazaTel.setEnabled(false);

    for (int i = 0; i < tabModel.getRowCount(); i++) {
      int magazaId = Integer.valueOf(tabModel.getValueAt(i, 0).toString());
      String magazaAd = tabModel.getValueAt(i, 1).toString();
      String magazaAdres = tabModel.getValueAt(i, 2).toString();
      String magazaTel = tabModel.getValueAt(i, 3).toString();

      if (magazaId == 0) {
        DB.ekle(new Magaza(magazaId, magazaAd, magazaAdres, magazaTel));
      } else {
        DB.degistir(new Magaza(magazaId, magazaAd, magazaAdres, magazaTel));
      }
    }

    silinecekler.forEach((silinecek) -> {
      System.out.println(silinecek);
      DB.sil(Integer.valueOf(silinecek), "tabMagazalar");
    });

    JOptionPane.showMessageDialog(this,
            "Mağaza Listesi başarılı bir şekilde güncellendi.\n"
            + "Silinen mağazaların depodaki diğer kayıtları da silindi!",
            "Mağaza Listesi Düzenlendi ✓", 1);

    this.dispose();
  }//GEN-LAST:event_btnKaydetActionPerformed

  private void tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabloMouseClicked
    if (tablo.getSelectedRow() != -1) {
      txtMagazaAd.setText(tablo.getValueAt(tablo.getSelectedRow(), 1).toString());
      txtMagazaAdres.setText(tablo.getValueAt(tablo.getSelectedRow(), 2).toString());
      txtMagazaTel.setText(tablo.getValueAt(tablo.getSelectedRow(), 3).toString());
    } else {
      JOptionPane.showMessageDialog(this, "Silinecek herhangi bir mağaza seçmediniz!",
              "HATA : Mağaza bilgisi eksik!", 2);
    }
  }//GEN-LAST:event_tabloMouseClicked

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
  private javax.swing.JTextField txtMagazaAd;
  private javax.swing.JTextField txtMagazaAdres;
  private javax.swing.JFormattedTextField txtMagazaTel;
  // End of variables declaration//GEN-END:variables
}
