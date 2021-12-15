//
// AdminUrunler.java
//
package Arayuzler;

import static Siniflar.Sabitler.DB;
import static Siniflar.Sabitler.FONK;
import Siniflar.Urun;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminUrunler extends javax.swing.JFrame {
  private final ArrayList<Urun> tabUrunler;
  private final DefaultTableModel tabModel;
  private final ArrayList<String> silinecekler;

  public AdminUrunler() {
    initComponents();
    setLocationRelativeTo(this);
    FONK.setIcon(this);
    btnKaydet.requestFocus();
    jProgressBar1.setVisible(false);

    tabUrunler = DB.okuUrunler();
    tabModel = (DefaultTableModel) tablo.getModel();
    silinecekler = new ArrayList<>();

    tabUrunler.forEach((urun) -> {
      tabModel.addRow(new Object[]{urun.getId(), urun.getUrunAdi(), urun.getKoliAdedi()});
    });
  }

  private void temizle() {
    txtUrunAdi.setText("");
    txtKoli.setText("");
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    tablo = new javax.swing.JTable();
    btnSil = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    btnKaydet = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    txtKoli = new javax.swing.JTextField();
    btnEkleGuncelle = new javax.swing.JButton();
    txtUrunAdi = new javax.swing.JTextField();
    jProgressBar1 = new javax.swing.JProgressBar();
    jSeparator2 = new javax.swing.JSeparator();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Depo Yönetim Sistemi");
    setResizable(false);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosed(java.awt.event.WindowEvent evt) {
        formWindowClosed(evt);
      }
    });

    tablo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tablo.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Ürün ID", "ÜRÜN ADI", "BİR KOLİDEKİ ÜRÜN MİKTARI"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false
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

    btnSil.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/sil.png"))); // NOI18N
    btnSil.setText(" Sil");
    btnSil.setToolTipText("Listeden bir maddeyi silmek için tıklayın.");
    btnSil.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSilActionPerformed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Ürün Listesi Düzenleme Paneli");

    btnKaydet.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnKaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/kaydet.png"))); // NOI18N
    btnKaydet.setText(" Kaydet");
    btnKaydet.setToolTipText("Listeyi kaydetmek için tıklayın.");
    btnKaydet.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnKaydetActionPerformed(evt);
      }
    });

    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel3.setText("Ürün Adı:");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel4.setText("Koli Adedi:");

    txtKoli.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    txtKoli.setToolTipText("Bu üründen bir kolide kaç adet var?");

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

    txtUrunAdi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    txtUrunAdi.setToolTipText("Ürünün adı");

    jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
    jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

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
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel3)
              .addComponent(txtUrunAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(txtKoli, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnEkleGuncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(btnEkleGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUrunAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addGroup(layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        .addGap(18, 18, 18)
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

    // Ürün Adı kısmı boş olamaz.
    String urunAdi = txtUrunAdi.getText().trim();
    if (urunAdi.equals("")) {
      JOptionPane.showMessageDialog(this, "Lütfen geçerli bir Ürün Adı giriniz!",
              "HATA : Ürün Adı bilgisi geçersiz!", 0);
      return;
    }

    // Koli Adedi kısmı sayısal bir değer olmalıdır.
    int koliAdedi = 0;
    try {
      koliAdedi = Integer.valueOf(txtKoli.getText().trim());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Lütfen geçerli bir sayı değeri giriniz!",
              "HATA : Koli Adedi bilgisi geçersiz!", 0);
      return;
    }

    // Eklenmek istenen Ürün Adı daha önce eklenmişse,
    // farklı olan diğer değerleri güncellenir, aksi halde hiçbir şey yapılmaz.
    for (int i = 0; i < tabModel.getRowCount(); i++) {
      if (urunAdi.equals(tabModel.getValueAt(i, 1).toString())) {
        tabModel.setValueAt(tabModel.getValueAt(i, 0).toString(), i, 0);
        tabModel.setValueAt(txtKoli.getText().trim(), i, 2);
        temizle();
        return;
      }
    }

    // Listeden yanlışlıkla silinip, aynı adla eklenen ürünler için kullanılır.
    for (Urun urun : tabUrunler) {
      if (urun.getUrunAdi().equals(urunAdi)) {
        tabModel.addRow(new Object[]{urun.getId(), urun.getUrunAdi(), koliAdedi});
        silinecekler.remove("" + urun.getId());
        temizle();
        return;
      }
    }

    if (yeni) {
      tabModel.addRow(new Object[]{0, urunAdi, koliAdedi});
      temizle();
    }
  }//GEN-LAST:event_btnEkleGuncelleActionPerformed

  private void tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabloMouseClicked
    if (tablo.getSelectedRow() != -1) {
      txtUrunAdi.setText(tablo.getValueAt(tablo.getSelectedRow(), 1).toString());
      txtKoli.setText(tablo.getValueAt(tablo.getSelectedRow(), 2).toString());
    } else {
      JOptionPane.showMessageDialog(this, "Silinecek herhangi bir ürün seçmediniz!",
              "HATA : Ürün bilgisi eksik!", 2);
    }
  }//GEN-LAST:event_tabloMouseClicked

  private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
    btnKaydet.setEnabled(false);
    btnEkleGuncelle.setEnabled(false);
    btnSil.setEnabled(false);
    tablo.setEnabled(false);
    txtKoli.setEnabled(false);
    txtUrunAdi.setEnabled(false);
    jProgressBar1.setVisible(true);
    jProgressBar1.setIndeterminate(true);

    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < tabModel.getRowCount(); i++) {
          int urunId = Integer.valueOf(tabModel.getValueAt(i, 0).toString());
          int koliAdedi = Integer.valueOf(tabModel.getValueAt(i, 2).toString());
          String urunAdi = tabModel.getValueAt(i, 1).toString();

          if (urunId == 0) {
            DB.ekle(new Urun(urunId, urunAdi, koliAdedi));
          } else {
            DB.degistir(new Urun(urunId, urunAdi, koliAdedi));
          }
        }

        silinecekler.forEach((silinecek) -> {
          DB.sil(Integer.valueOf(silinecek), "tabUrunler");
        });

        JOptionPane.showMessageDialog(AdminUrunler.this,
                "Ürün Listesi başarılı bir şekilde güncellendi.\n"
                + "Silinen ürünlerin depodaki kayıtları da silindi!",
                "Ürün Listesi Düzenlendi ✓", 1);

        AdminUrunler.this.dispose();
      }
    }).start();
  }//GEN-LAST:event_btnKaydetActionPerformed

  private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
    if (tabModel.getRowCount() < 1) {
      JOptionPane.showMessageDialog(this, "Silinecek herhangi bir ürün yok!",
              "HATA : Ürün bilgisi eksik!", 2);
    } else if (tablo.getSelectedRowCount() < 1) {
      JOptionPane.showMessageDialog(this, "Silinecek herhangi bir ürün seçmediniz!",
              "HATA : Ürün bilgisi eksik!", 2);
    } else {
      if (Integer.valueOf(tabModel.getValueAt(tablo.getSelectedRow(), 0).toString()) != 0) {
        // bu ürün hem tabUrunler'den silinecek
        // hem de tabGelenler ve tabGidenler'de bu ürünle ilgili tüm satırlar silinecek.
        silinecekler.add(tabModel.getValueAt(tablo.getSelectedRow(), 0).toString());
      }

      tabModel.removeRow(tablo.getSelectedRow());
    }
  }//GEN-LAST:event_btnSilActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnEkleGuncelle;
  private javax.swing.JButton btnKaydet;
  private javax.swing.JButton btnSil;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JProgressBar jProgressBar1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JTable tablo;
  private javax.swing.JTextField txtKoli;
  private javax.swing.JTextField txtUrunAdi;
  // End of variables declaration//GEN-END:variables
}
