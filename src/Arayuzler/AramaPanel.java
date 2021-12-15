//
// AdminPanel.java
//
package Arayuzler;

import Siniflar.Magaza;
import Siniflar.PDFCikti;
import Siniflar.Personel;
import static Siniflar.Sabitler.DB;
import static Siniflar.Sabitler.FONK;
import static Siniflar.Sabitler.KAPASITE;
import static Siniflar.Sabitler.PERSONELUSER;
import Siniflar.Uretici;
import Siniflar.Urun;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class AramaPanel extends javax.swing.JFrame {
  private final ArrayList<Urun> tabUrunler;
  private final ArrayList<Uretici> tabUreticiler;
  private final ArrayList<Magaza> tabMagazalar;
  private final ArrayList<Personel> tabPersoneller;
  private HashMap<Integer, Urun> urunMap;
  private final DefaultTableModel tabModelSayim;
  private final DefaultTableModel tabModelUrun;
  private final DefaultTableModel tabModelUretici;
  private final DefaultTableModel tabModelMagaza;
  private final DefaultTableModel tabModelPersonel;
  private final DefaultTableModel tabModelTarih;
  private long unixMinTarih;
  private long unixMaxTarih;
  Object[][] sayimListesi;
  ArrayList<Object[]> araUrunListesi;
  ArrayList<Object[]> araUreticiListesi;
  ArrayList<Object[]> araMagazaListesi;
  ArrayList<Object[]> araPersonelListesi;
  ArrayList<Object[]> araTarihListesi;

  public AramaPanel() {
    initComponents();
    setLocationRelativeTo(null);
    FONK.setIcon(this);

    btnPDFUrun.setEnabled(false);
    btnPDFUretici.setEnabled(false);
    btnPDFMagaza.setEnabled(false);
    btnPDFPersonel.setEnabled(false);

    // Tab değişimini izliyoruz...
    tabs.addChangeListener((ChangeEvent e) -> {
      if (tabs.getSelectedIndex() == 5) {
        // minimum ve maksimum tarih tespiti
        String[] cmb = FONK.minMaxGunAySene("dd-MM-yyyy");

        cmbMinGun.setSelectedItem(cmb[0]);
        cmbMinAy.setSelectedItem(cmb[1]);
        cmbMinSene.setSelectedItem(cmb[2]);

        cmbMaxGun.setSelectedItem(cmb[3]);
        cmbMaxAy.setSelectedItem(cmb[4]);
        cmbMaxSene.setSelectedItem(cmb[5]);
      }
    });

    // En tepedeki tab aktif olsun.
    tabs.setSelectedIndex(0);

    // Ürünler Tablosu
    tabUrunler = DB.okuUrunler();
    urunMap = new HashMap<>();

    tabUrunler.forEach(urun -> {
      cmbUrun.addItem(urun.getUrunAdi());
      // Veritabanından id'ye göre gelen ürünleri,
      // ürün adına göre mapleme işlemi.
      urunMap.put(urun.getId(), new Urun(urun.getId(), urun.getUrunAdi(), urun.getKoliAdedi()));
    });

    // Üreticiler Tablosu
    tabUreticiler = DB.okuUreticiler();
    tabUreticiler.forEach((uretici) -> {
      cmbUretici.addItem(uretici.getAd());
    });

    // Mağazalar Tablosu
    tabMagazalar = DB.okuMagazalar();
    tabMagazalar.forEach((magaza) -> {
      cmbMagaza.addItem(magaza.getAd());
    });

    // Personeller Tablosu
    tabPersoneller = DB.okuPersoneller();
    tabPersoneller.forEach((personel) -> {
      if (!personel.getKullaniciAdi().equals("root")) {
        cmbPersonel.addItem(personel.getAdSoyad() + " (" + personel.getKullaniciAdi() + ")");
      }
    });

    tabModelSayim = (DefaultTableModel) tabloSayim.getModel();
    tabModelUrun = (DefaultTableModel) tabloUrun.getModel();
    tabModelUretici = (DefaultTableModel) tabloUretici.getModel();
    tabModelMagaza = (DefaultTableModel) tabloMagaza.getModel();
    tabModelPersonel = (DefaultTableModel) tabloPersonel.getModel();
    tabModelTarih = (DefaultTableModel) tabloTarih.getModel();

    // Farklı ürünlerin depodaki ayrı ayrı toplamlarını döndüren liste.
    int[][] urunListesi = DB.sayUrunler();
    sayimListesi = new Object[urunListesi.length][];

    int toplamKoli = 0;
    for (int i = 0; i < urunListesi.length; i++) {
      String urunAdi = urunMap.get(urunListesi[i][0]).getUrunAdi();
      int urunKoli = urunListesi[i][1];
      int urunAdet = urunKoli * urunMap.get(urunListesi[i][0]).getKoliAdedi();

      sayimListesi[i] = new Object[]{urunAdi, urunKoli, urunAdet};
      tabModelSayim.addRow(sayimListesi[i]);

      toplamKoli += urunKoli;
    }

    lblKoli.setText("" + toplamKoli);
    lblBosYer.setText("" + (KAPASITE - toplamKoli));
    lblUrunCesidi.setText(String.valueOf(urunListesi.length));

    double dolulukOrani = ((int) (((toplamKoli * 100.0 / KAPASITE)) * 100) / 100.0);
    lblDolulukOrani.setText("% " + dolulukOrani);

    lblUreticiToplamKoli.setText("...");
    lblMagazaToplamKoli.setText("...");
    lblPersonelToplamKoli.setText("...");
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    tabs = new javax.swing.JTabbedPane();
    jPanel3 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tabloSayim = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    lblUrunCesidi = new javax.swing.JLabel();
    lblKoli = new javax.swing.JLabel();
    lblBosYer = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    lblDolulukOrani = new javax.swing.JLabel();
    btnPDFSayim = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jPanel13 = new javax.swing.JPanel();
    cmbUrun = new javax.swing.JComboBox<>();
    btnAraUrun = new javax.swing.JButton();
    jLabel11 = new javax.swing.JLabel();
    jScrollPane7 = new javax.swing.JScrollPane();
    tabloUrun = new javax.swing.JTable();
    btnPDFUrun = new javax.swing.JButton();
    jPanel6 = new javax.swing.JPanel();
    jPanel15 = new javax.swing.JPanel();
    cmbUretici = new javax.swing.JComboBox<>();
    btnAraUretici = new javax.swing.JButton();
    jLabel15 = new javax.swing.JLabel();
    jScrollPane9 = new javax.swing.JScrollPane();
    tabloUretici = new javax.swing.JTable();
    btnPDFUretici = new javax.swing.JButton();
    jPanel19 = new javax.swing.JPanel();
    jLabel14 = new javax.swing.JLabel();
    lblUreticiToplamKoli = new javax.swing.JLabel();
    jPanel7 = new javax.swing.JPanel();
    jPanel16 = new javax.swing.JPanel();
    cmbMagaza = new javax.swing.JComboBox<>();
    btnAraMagaza = new javax.swing.JButton();
    jLabel16 = new javax.swing.JLabel();
    jScrollPane10 = new javax.swing.JScrollPane();
    tabloMagaza = new javax.swing.JTable();
    btnPDFMagaza = new javax.swing.JButton();
    jPanel30 = new javax.swing.JPanel();
    jLabel32 = new javax.swing.JLabel();
    lblMagazaToplamKoli = new javax.swing.JLabel();
    jPanel8 = new javax.swing.JPanel();
    jPanel17 = new javax.swing.JPanel();
    cmbPersonel = new javax.swing.JComboBox<>();
    btnAraPersonel = new javax.swing.JButton();
    jLabel17 = new javax.swing.JLabel();
    jScrollPane11 = new javax.swing.JScrollPane();
    tabloPersonel = new javax.swing.JTable();
    btnPDFPersonel = new javax.swing.JButton();
    jPanel31 = new javax.swing.JPanel();
    jLabel33 = new javax.swing.JLabel();
    lblPersonelToplamKoli = new javax.swing.JLabel();
    jPanel5 = new javax.swing.JPanel();
    jPanel18 = new javax.swing.JPanel();
    btnAraTarih = new javax.swing.JButton();
    cmbMinGun = new javax.swing.JComboBox<>();
    cmbMinAy = new javax.swing.JComboBox<>();
    cmbMinSene = new javax.swing.JComboBox<>();
    cmbMaxGun = new javax.swing.JComboBox<>();
    cmbMaxAy = new javax.swing.JComboBox<>();
    cmbMaxSene = new javax.swing.JComboBox<>();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jScrollPane12 = new javax.swing.JScrollPane();
    tabloTarih = new javax.swing.JTable();
    btnPDFTarih = new javax.swing.JButton();
    jLabel7 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Depo Yönetim Sistemi");
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    tabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);
    tabs.setToolTipText("");
    tabs.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

    tabloSayim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabloSayim.setForeground(new java.awt.Color(0, 0, 153));
    tabloSayim.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ÜRÜN", "KOLİ", "ADET"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tabloSayim.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tabloSayim.getTableHeader().setReorderingAllowed(false);
    jScrollPane1.setViewportView(tabloSayim);
    if (tabloSayim.getColumnModel().getColumnCount() > 0) {
      tabloSayim.getColumnModel().getColumn(0).setPreferredWidth(200);
    }

    jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel8.setText("Toplam Ürün Çeşidi : ");
    jLabel8.setToolTipText("Depoda kaç farklı ürün var?");

    jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel10.setText("Toplam Koli Sayısı :");
    jLabel10.setToolTipText("Depodaki tüm kolilerin toplamı");

    jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel12.setText("Toplam Boş Yer :");
    jLabel12.setToolTipText("Depoya getirilebilecek yeni koli sayısı");

    lblUrunCesidi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblUrunCesidi.setText("5");

    lblKoli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblKoli.setText("1248");

    lblBosYer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblBosYer.setText("4752");

    jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel9.setText("Depo Doluluk Oranı :");
    jLabel9.setToolTipText("Deponun yüzde kaçı dolu?");

    lblDolulukOrani.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblDolulukOrani.setText("% 32.4");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel8)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(jLabel10)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lblKoli)
          .addComponent(lblUrunCesidi))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lblBosYer)
          .addComponent(lblDolulukOrani))
        .addGap(27, 27, 27))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel9)
            .addComponent(lblDolulukOrani))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel8)
              .addComponent(lblUrunCesidi))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel12)
                .addComponent(lblBosYer))
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblKoli)))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    btnPDFSayim.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnPDFSayim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/pdf.png"))); // NOI18N
    btnPDFSayim.setText("   PDF olarak kaydet");
    btnPDFSayim.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnPDFSayimActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
          .addComponent(btnPDFSayim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addComponent(btnPDFSayim, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    tabs.addTab(" Ürün Sayım", new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/sayim.png")), jPanel3); // NOI18N

    jPanel2.setAlignmentX(1.0F);
    jPanel2.setAlignmentY(1.0F);

    jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    cmbUrun.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

    btnAraUrun.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnAraUrun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/arama.png"))); // NOI18N
    btnAraUrun.setText("   ARA");
    btnAraUrun.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAraUrunActionPerformed(evt);
      }
    });

    jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel11.setText("Ürün Adı:");

    javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
    jPanel13.setLayout(jPanel13Layout);
    jPanel13Layout.setHorizontalGroup(
      jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel13Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel11)
          .addComponent(cmbUrun, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(btnAraUrun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel13Layout.setVerticalGroup(
      jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel13Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(btnAraUrun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel13Layout.createSequentialGroup()
            .addComponent(jLabel11)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cmbUrun, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(22, Short.MAX_VALUE))
    );

    tabloUrun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabloUrun.setForeground(new java.awt.Color(0, 0, 153));
    tabloUrun.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "BLOK NO", "RAF NO", "BÖLME NO", "KOLİ NO"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tabloUrun.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tabloUrun.getTableHeader().setReorderingAllowed(false);
    jScrollPane7.setViewportView(tabloUrun);

    btnPDFUrun.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnPDFUrun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/pdf.png"))); // NOI18N
    btnPDFUrun.setText("   PDF olarak kaydet");
    btnPDFUrun.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnPDFUrunActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
          .addComponent(btnPDFUrun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addComponent(btnPDFUrun, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    tabs.addTab(" Ürüne göre ara", new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/arama.png")), jPanel2); // NOI18N

    jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    cmbUretici.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

    btnAraUretici.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnAraUretici.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/arama.png"))); // NOI18N
    btnAraUretici.setText("   ARA");
    btnAraUretici.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAraUreticiActionPerformed(evt);
      }
    });

    jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel15.setText("Üretici Firma:");

    javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
    jPanel15.setLayout(jPanel15Layout);
    jPanel15Layout.setHorizontalGroup(
      jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel15Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(cmbUretici, 0, 280, Short.MAX_VALUE)
          .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(18, 18, 18)
        .addComponent(btnAraUretici, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel15Layout.setVerticalGroup(
      jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel15Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(btnAraUretici, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel15Layout.createSequentialGroup()
            .addComponent(jLabel15)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cmbUretici, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(22, Short.MAX_VALUE))
    );

    tabloUretici.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabloUretici.setForeground(new java.awt.Color(0, 0, 153));
    tabloUretici.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ÜRÜN", "KOLİ", "PERSONEL", "TARİH"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tabloUretici.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tabloUretici.getTableHeader().setReorderingAllowed(false);
    jScrollPane9.setViewportView(tabloUretici);
    if (tabloUretici.getColumnModel().getColumnCount() > 0) {
      tabloUretici.getColumnModel().getColumn(0).setPreferredWidth(120);
      tabloUretici.getColumnModel().getColumn(1).setPreferredWidth(30);
    }

    btnPDFUretici.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnPDFUretici.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/pdf.png"))); // NOI18N
    btnPDFUretici.setText("   PDF olarak kaydet");
    btnPDFUretici.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnPDFUreticiActionPerformed(evt);
      }
    });

    jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    jPanel19.setToolTipText("Üreticinin getirdiği ve depoda bulunan koliler");

    jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel14.setText("Toplam Koli Sayısı :");
    jLabel14.setToolTipText("");

    lblUreticiToplamKoli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblUreticiToplamKoli.setText("1248");

    javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
    jPanel19.setLayout(jPanel19Layout);
    jPanel19Layout.setHorizontalGroup(
      jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel19Layout.createSequentialGroup()
        .addGap(171, 171, 171)
        .addComponent(jLabel14)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(lblUreticiToplamKoli)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel19Layout.setVerticalGroup(
      jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel19Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblUreticiToplamKoli))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
          .addComponent(btnPDFUretici, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel6Layout.setVerticalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addComponent(btnPDFUretici, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    tabs.addTab(" Üreticiye göre ara", new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/uretici.png")), jPanel6); // NOI18N

    jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    cmbMagaza.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

    btnAraMagaza.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnAraMagaza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/arama.png"))); // NOI18N
    btnAraMagaza.setText("   ARA");
    btnAraMagaza.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAraMagazaActionPerformed(evt);
      }
    });

    jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel16.setText("Mağaza Adı:");

    javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
    jPanel16.setLayout(jPanel16Layout);
    jPanel16Layout.setHorizontalGroup(
      jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel16Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(cmbMagaza, 0, 280, Short.MAX_VALUE)
          .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(18, 18, 18)
        .addComponent(btnAraMagaza, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel16Layout.setVerticalGroup(
      jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel16Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(btnAraMagaza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel16Layout.createSequentialGroup()
            .addComponent(jLabel16)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cmbMagaza, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(22, Short.MAX_VALUE))
    );

    tabloMagaza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabloMagaza.setForeground(new java.awt.Color(0, 0, 153));
    tabloMagaza.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ÜRÜN", "KOLİ", "PERSONEL", "TARİH"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tabloMagaza.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tabloMagaza.getTableHeader().setReorderingAllowed(false);
    jScrollPane10.setViewportView(tabloMagaza);
    if (tabloMagaza.getColumnModel().getColumnCount() > 0) {
      tabloMagaza.getColumnModel().getColumn(0).setPreferredWidth(120);
      tabloMagaza.getColumnModel().getColumn(1).setPreferredWidth(30);
    }

    btnPDFMagaza.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnPDFMagaza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/pdf.png"))); // NOI18N
    btnPDFMagaza.setText("   PDF olarak kaydet");
    btnPDFMagaza.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnPDFMagazaActionPerformed(evt);
      }
    });

    jPanel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    jPanel30.setToolTipText("Mağazaya gönderilen koliler");

    jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel32.setText("Toplam Koli Sayısı :");
    jLabel32.setToolTipText("");

    lblMagazaToplamKoli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblMagazaToplamKoli.setText("1248");

    javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
    jPanel30.setLayout(jPanel30Layout);
    jPanel30Layout.setHorizontalGroup(
      jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel30Layout.createSequentialGroup()
        .addGap(171, 171, 171)
        .addComponent(jLabel32)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(lblMagazaToplamKoli)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel30Layout.setVerticalGroup(
      jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel30Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblMagazaToplamKoli))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel7Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
          .addComponent(btnPDFMagaza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel7Layout.setVerticalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel7Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addComponent(btnPDFMagaza, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    tabs.addTab(" Mağazaya göre ara ", new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/magaza.png")), jPanel7); // NOI18N

    jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    cmbPersonel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

    btnAraPersonel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnAraPersonel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/arama.png"))); // NOI18N
    btnAraPersonel.setText("   ARA");
    btnAraPersonel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAraPersonelActionPerformed(evt);
      }
    });

    jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    jLabel17.setText("Personel Adı:");

    javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
    jPanel17.setLayout(jPanel17Layout);
    jPanel17Layout.setHorizontalGroup(
      jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel17Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(cmbPersonel, 0, 280, Short.MAX_VALUE)
          .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(18, 18, 18)
        .addComponent(btnAraPersonel, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel17Layout.setVerticalGroup(
      jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel17Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(btnAraPersonel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel17Layout.createSequentialGroup()
            .addComponent(jLabel17)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cmbPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(22, Short.MAX_VALUE))
    );

    tabloPersonel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabloPersonel.setForeground(new java.awt.Color(0, 0, 153));
    tabloPersonel.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ÜRÜN", "GELEN/GİDEN", "KOLİ", "TARİH"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tabloPersonel.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tabloPersonel.getTableHeader().setReorderingAllowed(false);
    jScrollPane11.setViewportView(tabloPersonel);
    if (tabloPersonel.getColumnModel().getColumnCount() > 0) {
      tabloPersonel.getColumnModel().getColumn(0).setPreferredWidth(60);
      tabloPersonel.getColumnModel().getColumn(1).setPreferredWidth(20);
      tabloPersonel.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    btnPDFPersonel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnPDFPersonel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/pdf.png"))); // NOI18N
    btnPDFPersonel.setText("   PDF olarak kaydet");
    btnPDFPersonel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnPDFPersonelActionPerformed(evt);
      }
    });

    jPanel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    jPanel31.setToolTipText("Gelen ve Giden dahil, personelin ilgilendiği tüm koli sayısı");

    jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel33.setText("Toplam Koli Sayısı :");
    jLabel33.setToolTipText("");

    lblPersonelToplamKoli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblPersonelToplamKoli.setText("1248");

    javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
    jPanel31.setLayout(jPanel31Layout);
    jPanel31Layout.setHorizontalGroup(
      jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel31Layout.createSequentialGroup()
        .addGap(171, 171, 171)
        .addComponent(jLabel33)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(lblPersonelToplamKoli)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel31Layout.setVerticalGroup(
      jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel31Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblPersonelToplamKoli))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel8Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
          .addComponent(btnPDFPersonel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel8Layout.setVerticalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel8Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addComponent(btnPDFPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    tabs.addTab(" Personele göre ara", new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/personel.png")), jPanel8); // NOI18N

    jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    btnAraTarih.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnAraTarih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/arama.png"))); // NOI18N
    btnAraTarih.setText("   ARA");
    btnAraTarih.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAraTarihActionPerformed(evt);
      }
    });

    cmbMinGun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    cmbMinGun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

    cmbMinAy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    cmbMinAy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

    cmbMinSene.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    cmbMinSene.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033" }));

    cmbMaxGun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    cmbMaxGun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

    cmbMaxAy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    cmbMaxAy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

    cmbMaxSene.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    cmbMaxSene.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033" }));

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel5.setText("ile");

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel6.setText("arasında");

    javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
    jPanel18.setLayout(jPanel18Layout);
    jPanel18Layout.setHorizontalGroup(
      jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel18Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel18Layout.createSequentialGroup()
            .addComponent(cmbMinGun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(cmbMinAy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(cmbMinSene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel5))
          .addGroup(jPanel18Layout.createSequentialGroup()
            .addComponent(cmbMaxGun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(cmbMaxAy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(cmbMaxSene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel6)))
        .addGap(17, 17, 17)
        .addComponent(btnAraTarih, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel18Layout.setVerticalGroup(
      jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel18Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel18Layout.createSequentialGroup()
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(cmbMinGun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cmbMinAy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cmbMinSene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel5))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(cmbMaxGun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cmbMaxAy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cmbMaxSene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel6)))
          .addComponent(btnAraTarih, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(22, Short.MAX_VALUE))
    );

    tabloTarih.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    tabloTarih.setForeground(new java.awt.Color(0, 0, 153));
    tabloTarih.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ÜRÜN", "GELEN/GİDEN", "ÜRETİCİ/MAĞAZA", "KOLİ", "PERSONEL", "TARİH"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tabloTarih.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tabloTarih.getTableHeader().setReorderingAllowed(false);
    jScrollPane12.setViewportView(tabloTarih);
    if (tabloTarih.getColumnModel().getColumnCount() > 0) {
      tabloTarih.getColumnModel().getColumn(0).setPreferredWidth(60);
      tabloTarih.getColumnModel().getColumn(1).setPreferredWidth(30);
      tabloTarih.getColumnModel().getColumn(2).setPreferredWidth(50);
      tabloTarih.getColumnModel().getColumn(3).setPreferredWidth(20);
      tabloTarih.getColumnModel().getColumn(4).setPreferredWidth(40);
      tabloTarih.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    btnPDFTarih.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnPDFTarih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/pdf.png"))); // NOI18N
    btnPDFTarih.setText("   PDF olarak kaydet");
    btnPDFTarih.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnPDFTarihActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(btnPDFTarih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(btnPDFTarih, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    tabs.addTab(" Tarihe göre ara", new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/zaman.png")), jPanel5); // NOI18N

    jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel7.setText("Arama | Listeleme Paneli");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(tabs, javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    tabs.getAccessibleContext().setAccessibleName("Ürün Sayım");

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnPDFSayimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFSayimActionPerformed
    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.urunSayimPDF(sayimListesi, unixTime, lblUrunCesidi.getText(),
            lblKoli.getText(), lblBosYer.getText(), lblDolulukOrani.getText());

    try {
      PDFCikti.pdfYap(pdf, "UrunSayim", unixTime);
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(this, "PDF çıktısı oluşturulamadı!", "PDF Hatası!", 0);
      this.dispose();
    }

    JOptionPane.showMessageDialog(this, "Ürün Sayım PDF çıktısı başarıyla oluşturuldu!\n"
            + "PDF çıktısını masaüstünüzde bulabilirsiniz.", "PDF İşlemi Başarılı ✓", 1);

    btnPDFSayim.setEnabled(false);
  }//GEN-LAST:event_btnPDFSayimActionPerformed

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    if (PERSONELUSER.equals("root")) {
      new AdminPanel().setVisible(true);
    } else {
      new PersonelPanel().setVisible(true);
    }

    this.dispose();
  }//GEN-LAST:event_formWindowClosing

  private void btnPDFUrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFUrunActionPerformed
    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.araUrunPDF(araUrunListesi, unixTime, cmbUrun.getSelectedItem().toString());

    try {
      PDFCikti.pdfYap(pdf, "UrunArama", unixTime);
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(this, "PDF çıktısı oluşturulamadı!", "PDF Hatası!", 0);
      this.dispose();
    }

    JOptionPane.showMessageDialog(this, "Ürün Arama PDF çıktısı başarıyla oluşturuldu!\n"
            + "PDF çıktısını masaüstünüzde bulabilirsiniz.", "PDF İşlemi Başarılı ✓", 1);

    btnPDFUrun.setEnabled(false);
  }//GEN-LAST:event_btnPDFUrunActionPerformed

  private void btnPDFUreticiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFUreticiActionPerformed
    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.araUreticiPDF(araUreticiListesi, unixTime,
            cmbUretici.getSelectedItem().toString(), lblUreticiToplamKoli.getText());

    try {
      PDFCikti.pdfYap(pdf, "UreticiArama", unixTime);
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(this, "PDF çıktısı oluşturulamadı!", "PDF Hatası!", 0);
      this.dispose();
    }

    JOptionPane.showMessageDialog(this, "Üretici Arama PDF çıktısı başarıyla oluşturuldu!\n"
            + "PDF çıktısını masaüstünüzde bulabilirsiniz.", "PDF İşlemi Başarılı ✓", 1);

    btnPDFUretici.setEnabled(false);
  }//GEN-LAST:event_btnPDFUreticiActionPerformed

  private void btnPDFMagazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFMagazaActionPerformed
    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.araMagazaPDF(araMagazaListesi, unixTime,
            cmbMagaza.getSelectedItem().toString(), lblMagazaToplamKoli.getText());

    try {
      PDFCikti.pdfYap(pdf, "MagazaArama", unixTime);
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(this, "PDF çıktısı oluşturulamadı!", "PDF Hatası!", 0);
      this.dispose();
    }

    JOptionPane.showMessageDialog(this, "Mağaza Arama PDF çıktısı başarıyla oluşturuldu!\n"
            + "PDF çıktısını masaüstünüzde bulabilirsiniz.", "PDF İşlemi Başarılı ✓", 1);

    btnPDFMagaza.setEnabled(false);
  }//GEN-LAST:event_btnPDFMagazaActionPerformed

  private void btnPDFPersonelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFPersonelActionPerformed
    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.araPersonelPDF(araPersonelListesi, unixTime,
            cmbPersonel.getSelectedItem().toString(), lblPersonelToplamKoli.getText());

    try {
      PDFCikti.pdfYap(pdf, "PersonelArama", unixTime);
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(this, "PDF çıktısı oluşturulamadı!", "PDF Hatası!", 0);
      this.dispose();
    }

    JOptionPane.showMessageDialog(this, "Personel Arama PDF çıktısı başarıyla oluşturuldu!\n"
            + "PDF çıktısını masaüstünüzde bulabilirsiniz.", "PDF İşlemi Başarılı ✓", 1);

    btnPDFPersonel.setEnabled(false);
  }//GEN-LAST:event_btnPDFPersonelActionPerformed

  private void btnAraUrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraUrunActionPerformed
    tabModelUrun.setRowCount(0);

    String urunAdi = cmbUrun.getSelectedItem().toString();
    araUrunListesi = DB.araUrun(urunAdi);

    if (araUrunListesi.size() < 1) {
      btnPDFUrun.setEnabled(false);
      JOptionPane.showMessageDialog(this,
              urunAdi + " ile ilgili hiçbir sonuç bulunamadı!", "Veri yok!", 2);
    } else {
      btnPDFUrun.setEnabled(true);
      araUrunListesi.forEach((urun) -> {
        tabModelUrun.addRow(urun);
      });
    }
  }//GEN-LAST:event_btnAraUrunActionPerformed

  private void btnAraUreticiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraUreticiActionPerformed
    tabModelUretici.setRowCount(0);

    String ureticiAdi = cmbUretici.getSelectedItem().toString();
    araUreticiListesi = DB.araUretici(ureticiAdi);

    if (araUreticiListesi.size() < 1) {
      btnPDFUretici.setEnabled(false);
      lblUreticiToplamKoli.setText("" + 0);

      JOptionPane.showMessageDialog(this,
              ureticiAdi + " firması ile ilgili hiçbir sonuç bulunamadı!", "Veri yok!", 2);
    } else {
      btnPDFUretici.setEnabled(true);

      int toplamKoli = 0;
      for (Object[] i : araUreticiListesi) {
        tabModelUretici.addRow(i);
        toplamKoli += Integer.valueOf("" + i[1]);
      }

      lblUreticiToplamKoli.setText("" + toplamKoli);
    }
  }//GEN-LAST:event_btnAraUreticiActionPerformed

  private void btnAraMagazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraMagazaActionPerformed
    tabModelMagaza.setRowCount(0);

    String magazaAdi = cmbMagaza.getSelectedItem().toString();
    araMagazaListesi = DB.araMagaza(magazaAdi);

    if (araMagazaListesi.size() < 1) {
      btnPDFMagaza.setEnabled(false);
      lblMagazaToplamKoli.setText("" + 0);

      JOptionPane.showMessageDialog(this,
              magazaAdi + " mağazası ile ilgili hiçbir sonuç bulunamadı!", "Veri yok!", 2);
    } else {
      btnPDFMagaza.setEnabled(true);

      int toplamKoli = 0;
      for (Object[] i : araMagazaListesi) {
        tabModelMagaza.addRow(i);
        toplamKoli += Integer.valueOf("" + i[1]);
      }

      lblMagazaToplamKoli.setText("" + toplamKoli);
    }
  }//GEN-LAST:event_btnAraMagazaActionPerformed

  private void btnAraPersonelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraPersonelActionPerformed
    tabModelPersonel.setRowCount(0);

    String personelAdSoyad = cmbPersonel.getSelectedItem().toString()
            .split("\\(")[0]
            .trim();
    String personelKullaniciAdi = cmbPersonel.getSelectedItem().toString()
            .split("\\(")[1]
            .split("\\)")[0]
            .trim();

    araPersonelListesi = DB.araPersonel(personelKullaniciAdi);

    if (araPersonelListesi.size() < 1) {
      btnPDFPersonel.setEnabled(false);
      lblPersonelToplamKoli.setText("" + 0);

      JOptionPane.showMessageDialog(this,
              personelAdSoyad + " personeli ile ilgili hiçbir sonuç bulunamadı!",
              "Veri yok!", 2);
    } else {
      btnPDFPersonel.setEnabled(true);

      int toplamKoli = 0;
      for (Object[] i : araPersonelListesi) {
        tabModelPersonel.addRow(i);
        toplamKoli += Integer.valueOf("" + i[2]);
      }

      lblPersonelToplamKoli.setText("" + toplamKoli);
    }
  }//GEN-LAST:event_btnAraPersonelActionPerformed

  private void btnPDFTarihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFTarihActionPerformed
    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.araTarihPDF(araTarihListesi, unixTime, unixMinTarih, unixMaxTarih);

    try {
      PDFCikti.pdfYap(pdf, "TarihselArama", unixTime);
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(this, "PDF çıktısı oluşturulamadı!", "PDF Hatası!", 0);
      this.dispose();
    }

    JOptionPane.showMessageDialog(this, "Tarihsel Arama PDF çıktısı başarıyla oluşturuldu!\n"
            + "PDF çıktısını masaüstünüzde bulabilirsiniz.", "PDF İşlemi Başarılı ✓", 1);

    btnPDFTarih.setEnabled(false);
  }//GEN-LAST:event_btnPDFTarihActionPerformed

  private void btnAraTarihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraTarihActionPerformed
    tabModelTarih.setRowCount(0);

    String tarihMin = cmbMinSene.getSelectedItem().toString()
            + cmbMinAy.getSelectedItem().toString()
            + cmbMinGun.getSelectedItem().toString();
    String tarihMax = cmbMaxSene.getSelectedItem().toString()
            + cmbMaxAy.getSelectedItem().toString()
            + cmbMaxGun.getSelectedItem().toString();

    unixMaxTarih = FONK.tarihToUnix(tarihMax, "yyyyMMdd");
    unixMinTarih = FONK.tarihToUnix(tarihMin, "yyyyMMdd");

    if (FONK.kontrolTarih(tarihMin)
            && FONK.kontrolTarih(tarihMax)
            && unixMaxTarih >= unixMinTarih) {

      araTarihListesi = DB.araTarih(unixMinTarih, unixMaxTarih);

      if (araTarihListesi.size() < 1) {
        btnPDFTarih.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Hiçbir sonuç bulunamadı!", "Veri yok!", 2);
      } else {
        btnPDFTarih.setEnabled(true);

        araTarihListesi.forEach((i) -> {
          tabModelTarih.addRow(i);
        });
      }
    } else {
      JOptionPane.showMessageDialog(this,
              " Seçilen tarih aralıklarında hata var!\nLütfen değiştirip yeniden deneyiniz...",
              "HATA : Seçilen tarihler yanlış!", 0);
    }
  }//GEN-LAST:event_btnAraTarihActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAraMagaza;
  private javax.swing.JButton btnAraPersonel;
  private javax.swing.JButton btnAraTarih;
  private javax.swing.JButton btnAraUretici;
  private javax.swing.JButton btnAraUrun;
  private javax.swing.JButton btnPDFMagaza;
  private javax.swing.JButton btnPDFPersonel;
  private javax.swing.JButton btnPDFSayim;
  private javax.swing.JButton btnPDFTarih;
  private javax.swing.JButton btnPDFUretici;
  private javax.swing.JButton btnPDFUrun;
  private javax.swing.JComboBox<String> cmbMagaza;
  private javax.swing.JComboBox<String> cmbMaxAy;
  private javax.swing.JComboBox<String> cmbMaxGun;
  private javax.swing.JComboBox<String> cmbMaxSene;
  private javax.swing.JComboBox<String> cmbMinAy;
  private javax.swing.JComboBox<String> cmbMinGun;
  private javax.swing.JComboBox<String> cmbMinSene;
  private javax.swing.JComboBox<String> cmbPersonel;
  private javax.swing.JComboBox<String> cmbUretici;
  private javax.swing.JComboBox<String> cmbUrun;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel32;
  private javax.swing.JLabel jLabel33;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel13;
  private javax.swing.JPanel jPanel15;
  private javax.swing.JPanel jPanel16;
  private javax.swing.JPanel jPanel17;
  private javax.swing.JPanel jPanel18;
  private javax.swing.JPanel jPanel19;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel30;
  private javax.swing.JPanel jPanel31;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPanel jPanel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane10;
  private javax.swing.JScrollPane jScrollPane11;
  private javax.swing.JScrollPane jScrollPane12;
  private javax.swing.JScrollPane jScrollPane7;
  private javax.swing.JScrollPane jScrollPane9;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JLabel lblBosYer;
  private javax.swing.JLabel lblDolulukOrani;
  private javax.swing.JLabel lblKoli;
  private javax.swing.JLabel lblMagazaToplamKoli;
  private javax.swing.JLabel lblPersonelToplamKoli;
  private javax.swing.JLabel lblUreticiToplamKoli;
  private javax.swing.JLabel lblUrunCesidi;
  private javax.swing.JTable tabloMagaza;
  private javax.swing.JTable tabloPersonel;
  private javax.swing.JTable tabloSayim;
  private javax.swing.JTable tabloTarih;
  private javax.swing.JTable tabloUretici;
  private javax.swing.JTable tabloUrun;
  private javax.swing.JTabbedPane tabs;
  // End of variables declaration//GEN-END:variables
}
