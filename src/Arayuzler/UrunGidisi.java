//
// UrunGidisi.java
//
package Arayuzler;

import Siniflar.DepodakiUrun;
import Siniflar.GidenUrun;
import Siniflar.Magaza;
import Siniflar.PDFCikti;
import Siniflar.Sabitler;
import static Siniflar.Sabitler.DB;
import static Siniflar.Sabitler.FONK;
import Siniflar.Urun;
import Siniflar.UrunGidis;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UrunGidisi extends javax.swing.JFrame {
  private long unixTime;
  private String pdf;
  private final ArrayList<Urun> tabUrunler;
  private final ArrayList<Magaza> tabMagazalar;
  private ArrayList<DepodakiUrun> tabDepodakiler;
  private HashMap<Integer, String> urunMap;
  private HashMap<Integer, Magaza> magazaMap;
  private final DefaultTableModel tabModel;

  public UrunGidisi() {
    initComponents();
    setLocationRelativeTo(this);
    FONK.setIcon(this);
    btnKaydet.requestFocus();

    jProgressBar1.setVisible(false);

    tabUrunler = DB.okuUrunler();
    tabMagazalar = DB.okuMagazalar();

    // ürün id ve magazaId'nin bilindiği yerlerde,
    // ürün adı ve mağazaya ait diğer bilgileri elde edebilmek için.
    urunMap = new HashMap<>();
    magazaMap = new HashMap<>();

    // ürünlerin comboBox'a yükleme işlemi
    tabUrunler.forEach(urun -> {
      cmbUrunler.addItem(urun.getUrunAdi());
      urunMap.put(urun.getId(), urun.getUrunAdi());
    });

    // üreticilerin comboBox'a yükleme işlemi
    tabMagazalar.forEach(magaza -> {
      cmbMagazalar.addItem(magaza.getAd());
      magazaMap.put(magaza.getId(), magaza);
    });

    tabModel = (DefaultTableModel) tablo.getModel();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btnSil = new javax.swing.JButton();
    btnKaydet = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();
    cmbKoli = new javax.swing.JComboBox<>();
    jSeparator2 = new javax.swing.JSeparator();
    jProgressBar1 = new javax.swing.JProgressBar();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    cmbMagazalar = new javax.swing.JComboBox<>();
    jLabel3 = new javax.swing.JLabel();
    cmbUrunler = new javax.swing.JComboBox<>();
    jLabel4 = new javax.swing.JLabel();
    btnEkleGuncelle = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablo = new javax.swing.JTable();

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

    btnKaydet.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnKaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/kaydet.png"))); // NOI18N
    btnKaydet.setText(" Kaydet ve Çıktı Al");
    btnKaydet.setToolTipText("Listeyi kaydetmek ve PDF çıktısı almak için tıklayın.");
    btnKaydet.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnKaydetActionPerformed(evt);
      }
    });

    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    cmbKoli.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    cmbKoli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15", "20", "25", "30", "35", "40", "45", "50", "60", "70", "80", "90", "100" }));
    cmbKoli.setToolTipText("İlgili üründen kaç koli gönderileceğini buradan seçebilirsiniz.");

    jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
    jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

    jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Depodan Ürün Çıkışı");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
    jLabel2.setText("Mağaza Adı:");

    cmbMagazalar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    cmbMagazalar.setToolTipText("Ürünlerin gönderileceği mağazayı buradan seçebilirsiniz.");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
    jLabel3.setText("Ürün:");

    cmbUrunler.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    cmbUrunler.setToolTipText("Ürün seçmek için tıklayın.");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
    jLabel4.setText("Koli:");

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

    tablo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tablo.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Mağaza ID", "MAĞAZA", "Ürün ID", "ÜRÜN", "KOLİ ADEDİ", "TOPLAM ADET"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tablo.setAlignmentX(1.0F);
    tablo.setAlignmentY(1.0F);
    tablo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tablo.getTableHeader().setReorderingAllowed(false);
    jScrollPane1.setViewportView(tablo);
    if (tablo.getColumnModel().getColumnCount() > 0) {
      tablo.getColumnModel().getColumn(0).setMinWidth(0);
      tablo.getColumnModel().getColumn(0).setPreferredWidth(0);
      tablo.getColumnModel().getColumn(0).setMaxWidth(0);
      tablo.getColumnModel().getColumn(2).setMinWidth(0);
      tablo.getColumnModel().getColumn(2).setPreferredWidth(0);
      tablo.getColumnModel().getColumn(2).setMaxWidth(0);
    }

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
              .addComponent(jLabel2)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(cmbUrunler, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jLabel4)
                  .addComponent(cmbKoli, 0, 89, Short.MAX_VALUE)))
              .addComponent(cmbMagazalar, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEkleGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cmbMagazalar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(jLabel4))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(cmbUrunler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cmbKoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGap(55, 55, 55)
            .addComponent(btnEkleGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    new PersonelPanel().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

  private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
    if (tabModel.getRowCount() < 1) {
      JOptionPane.showMessageDialog(this, "Silinecek herhangi bir ürün yok!",
              "HATA : Ürün bilgisi eksik!", 2);
    } else if (tablo.getSelectedRowCount() < 1) {
      JOptionPane.showMessageDialog(this, "Silinecek herhangi bir ürün seçmediniz!",
              "HATA : Ürün bilgisi eksik!", 2);
    } else {
      tabModel.removeRow(tablo.getSelectedRow());
    }
  }//GEN-LAST:event_btnSilActionPerformed

  private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
    if (tabModel.getRowCount() < 1) {
      JOptionPane.showMessageDialog(this, "Herhangi bir ürün eklemediniz!",
              "HATA : Ürün bilgisi eksik!", 2);
    } else {
      unixTime = System.currentTimeMillis() / 1000L;

      // PDF çıktısı hazırlanmaya başlıyor...
      pdf = PDFCikti.bufferBaslat(unixTime, "DEPODAN ÜRÜN ÇIKIŞI");
      pdf += PDFCikti.bufferMagazaEkle(
              magazaMap.get(Integer.valueOf(tabModel.getValueAt(0, 0).toString())).getAd(),
              magazaMap.get(Integer.valueOf(tabModel.getValueAt(0, 0).toString())).getAdres(),
              magazaMap.get(Integer.valueOf(tabModel.getValueAt(0, 0).toString())).getTelefon()
      );
      pdf += PDFCikti.bufferUrunlerILK("Depodan çıkan ürünler");

      // Depodan giden ürünlerin listesi
      ArrayList<GidenUrun> gidenUrunler = new ArrayList<>();

      int koliToplam = 0;
      for (int i = 0; i < tabModel.getRowCount(); i++) {
        int urunId = Integer.valueOf(tabModel.getValueAt(i, 2).toString());
        int magazaId = Integer.valueOf(tabModel.getValueAt(i, 0).toString());
        int koli = Integer.valueOf(tabModel.getValueAt(i, 4).toString());

        GidenUrun gidenUrun = new GidenUrun(0, urunId, koli, unixTime, Sabitler.PERSONELID, magazaId);
        pdf += PDFCikti.bufferUrunler(tabModel.getValueAt(i, 3).toString(), koli);

        gidenUrunler.add(gidenUrun);
        koliToplam += koli;
      }

      pdf += PDFCikti.bufferUrunlerSON(koliToplam);

      UrunGidis gideni = new UrunGidis();
      tabDepodakiler = DB.okuDepodakiler();

      if (gideni.kabul(gidenUrunler, tabDepodakiler)) {
        btnKaydet.setEnabled(false);
        btnEkleGuncelle.setEnabled(false);
        btnSil.setEnabled(false);
        tablo.setEnabled(false);
        cmbUrunler.setEnabled(false);
        cmbKoli.setEnabled(false);

        jProgressBar1.setVisible(true);
        jProgressBar1.setIndeterminate(true);
        jProgressBar1.setSize(590, 20);
        jProgressBar1.setAlignmentX(10);
        jProgressBar1.setAlignmentY(210);

        new Thread(new Runnable() {
          @Override
          public void run() {
            ArrayList<DepodakiUrun> gitmisUrunler = gideni.yolla(gidenUrunler);
            pdf += PDFCikti.bufferKolilerILK("Depoda bulunan kolilerin yerleri");

            gitmisUrunler.forEach((depodakiUrun) -> {
              pdf += PDFCikti.bufferKoliler(
                      urunMap.get(depodakiUrun.getUrunId()),
                      depodakiUrun.getBlokId() + 1,
                      depodakiUrun.getRafId() + 1,
                      depodakiUrun.getBolmeId() + 1,
                      depodakiUrun.getKoliId() + 1
              );
            });

            pdf += PDFCikti.bufferKolilerSON();
            pdf += PDFCikti.bufferBitir();

            try {
              PDFCikti.pdfYap(pdf, "GidenUrunler", unixTime);
            } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(UrunGidisi.this, "PDF çıktısı oluşturulamadı!", "PDF Hatası!", 0);
              UrunGidisi.this.dispose();
            }

            JOptionPane.showMessageDialog(UrunGidisi.this, "Ürünler depodan başarıyla çıkarıldı!\n"
                    + "PDF çıktısını masaüstünüzde bulabilirsiniz.", "Ürün Çıkartma Başarılı ✓", 1);

            UrunGidisi.this.dispose();
          }
        }).start();

      } else {
        JOptionPane.showMessageDialog(this,
                "Depoda belirttiğiniz koli sayısında ürün yok!\nÜrün kolilerini azaltarak yeniden deneyebilirsiniz.",
                "Ürünler depoda bulunamadı!", 0);
      }
    }
  }//GEN-LAST:event_btnKaydetActionPerformed

  private void btnEkleGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleGuncelleActionPerformed
    String urunAdi = cmbUrunler.getSelectedItem().toString().trim();
    int urunId = tabUrunler.get(cmbUrunler.getSelectedIndex()).getId();

    String magazaAdi = cmbMagazalar.getSelectedItem().toString().trim();
    int magazaId = tabMagazalar.get(cmbMagazalar.getSelectedIndex()).getId();

    int koli = Integer.valueOf(cmbKoli.getSelectedItem().toString());
    int toplamAdet = koli * tabUrunler.get(cmbUrunler.getSelectedIndex()).getKoliAdedi();

    cmbMagazalar.setEnabled(false);

    // eklenmek istenen daha önce eklenmişse,
    // farklı olan değerleri güncellenir, aksi halde hiçbir şey yapılmaz!
    for (int i = 0; i < tabModel.getRowCount(); i++) {
      if (urunAdi.equals(tabModel.getValueAt(i, 3).toString())) {
        tabModel.removeRow(i);
      }
    }

    // Tabloya ürün ekleme işlemi
    // Bazı değerler tabloda gizli haldedir, gösterilmez. (magazaId ve urunId gibi)
    tabModel.addRow(new Object[]{magazaId, magazaAdi, urunId, urunAdi, koli, toplamAdet});
  }//GEN-LAST:event_btnEkleGuncelleActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnEkleGuncelle;
  private javax.swing.JButton btnKaydet;
  private javax.swing.JButton btnSil;
  private javax.swing.JComboBox<String> cmbKoli;
  private javax.swing.JComboBox<String> cmbMagazalar;
  private javax.swing.JComboBox<String> cmbUrunler;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JProgressBar jProgressBar1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JTable tablo;
  // End of variables declaration//GEN-END:variables
}
