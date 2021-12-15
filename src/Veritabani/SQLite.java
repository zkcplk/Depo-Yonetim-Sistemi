//
// SQLite.java
//
package Veritabani;

import Siniflar.DepodakiUrun;
import Siniflar.GelenUrun;
import Siniflar.GidenUrun;
import Siniflar.Magaza;
import Siniflar.Personel;
import static Siniflar.Sabitler.FONK;
import Siniflar.Uretici;
import Siniflar.Urun;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.sqlite.mc.SQLiteMCSqlCipherConfig;

public class SQLite extends SoyutDB {
  private final String dbUrl;
  private Connection baglanti = null;

  public SQLite(String dbName) {
    super(dbName);
    this.dbUrl = "jdbc:sqlite:file:" + dbName + "";
  }

  @Override // veritabanı bağlantısı kurma işlemi
  public boolean baglan() {
    try {
      // Burada withKey(...) içerisine yazılan ifade şifreleme şifresidir.
      // Bu şifre programcı tarafından programın sahibine (Admin) verilir.
      // İlgili database dosyası "DB Browser (SQLCipher)" programıyla açıldığında,
      // ekrandaki panelde "Şifreleme Ayarları" kısmında "SQLCipher 3" seçilir ve şifre girilerek veriler görüntülenebilir.
      // Aksi durumda veriler, ancak programın içerisinden erişilebilir olur.
      baglanti = SQLiteMCSqlCipherConfig.getV3Defaults().withKey("zeki").createConnection(dbUrl);
      return true;
    } catch (SQLException hata) {
      System.out.println(hata.getMessage());
      return false;
    }
  }

  @Override // veritabanı bağlantısını kapatma işlemi
  public void kapat() {
    try {
      baglanti.close();
    } catch (SQLException hata) {
      System.out.println("kapat() hatası: " + hata.getMessage());
    }
  }

  @Override
  public boolean tabloKontrol() {
    try {
      baglan();
      DatabaseMetaData databaseMetaData = baglanti.getMetaData();
      ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});

      int all = 0;
      while (resultSet.next()) {
        all++;
      }

      return all > 6;
    } catch (SQLException hata) {
      System.out.println("tabloKontrol() hatası: " + hata.getMessage());
    }
    return false;
  }

  @Override // ilk çalıştırılma için default tabloların oluşturulması işlemi
  public void tabloOlustur() {
    String sqlUrunler
            = "CREATE TABLE IF NOT EXISTS tabUrunler (\n"
            + "	id integer PRIMARY KEY,\n"
            + "	urunAdi text NOT NULL UNIQUE,\n"
            + "	koliAdedi integer,\n"
            + " UNIQUE(urunAdi)\n"
            + ");";
    String sqlDepodakiler
            = "CREATE TABLE IF NOT EXISTS tabDepodakiler (\n"
            + "	id integer PRIMARY KEY,\n"
            + "	urunId integer,\n"
            + "	blokId integer,\n"
            + "	rafId integer,\n"
            + "	bolmeId integer,\n"
            + "	koliId integer,\n"
            + " UNIQUE(blokId, rafId, bolmeId, koliId),\n"
            + " FOREIGN KEY (urunId) REFERENCES tabUrunler(id) ON DELETE CASCADE "
            + ");";
    String sqlGelenler
            = "CREATE TABLE IF NOT EXISTS tabGelenler (\n"
            + "	id integer PRIMARY KEY,\n"
            + "	urunId integer,\n"
            + "	koliToplam integer,\n"
            + "	gelisTarih integer,\n"
            + "	personelId integer,\n"
            + "	ureticiId integer,\n"
            + " UNIQUE(urunId, gelisTarih),\n"
            + " FOREIGN KEY (urunId) REFERENCES tabUrunler(id) ON DELETE CASCADE, "
            + " FOREIGN KEY (personelId) REFERENCES tabPersoneller(id) ON DELETE CASCADE, "
            + " FOREIGN KEY (ureticiId) REFERENCES tabUreticiler(id) ON DELETE CASCADE "
            + ");";
    String sqlGidenler
            = "CREATE TABLE IF NOT EXISTS tabGidenler (\n"
            + "	id integer PRIMARY KEY,\n"
            + "	urunId integer,\n"
            + "	koliToplam integer,\n"
            + "	gidisTarih integer,\n"
            + "	personelId integer,\n"
            + "	magazaId integer,\n"
            + " UNIQUE(urunId, gidisTarih),\n"
            + " FOREIGN KEY (urunId) REFERENCES tabUrunler(id) ON DELETE CASCADE, "
            + " FOREIGN KEY (personelId) REFERENCES tabPersoneller(id) ON DELETE CASCADE, "
            + " FOREIGN KEY (magazaId) REFERENCES tabMagazalar(id) ON DELETE CASCADE "
            + ");";
    String sqlMagazalar
            = "CREATE TABLE IF NOT EXISTS tabMagazalar (\n"
            + "	id integer PRIMARY KEY,\n"
            + "	ad text NOT NULL UNIQUE,\n"
            + "	adres text NOT NULL,\n"
            + "	telefon text NOT NULL,\n"
            + " UNIQUE(ad)\n"
            + ");";
    String sqlUreticiler
            = "CREATE TABLE IF NOT EXISTS tabUreticiler (\n"
            + "	id integer PRIMARY KEY,\n"
            + "	ad text NOT NULL UNIQUE,\n"
            + "	adres text NOT NULL,\n"
            + "	telefon text NOT NULL,\n"
            + " UNIQUE(ad)\n"
            + ");";
    String sqlPersoneller
            = "CREATE TABLE IF NOT EXISTS tabPersoneller (\n"
            + "	id integer PRIMARY KEY,\n"
            + "	adSoyad text NOT NULL,\n"
            + "	kullaniciAdi text NOT NULL,\n"
            + "	sifre text NOT NULL,\n"
            + " UNIQUE(kullaniciAdi)\n"
            + ");";
    try {
      baglan();
      Statement st = baglanti.createStatement();

      st.addBatch(sqlUrunler);
      st.addBatch(sqlDepodakiler);
      st.addBatch(sqlGelenler);
      st.addBatch(sqlGidenler);
      st.addBatch(sqlMagazalar);
      st.addBatch(sqlUreticiler);
      st.addBatch(sqlPersoneller);
      st.executeBatch();
    } catch (SQLException hata) {
      System.out.println(hata.getMessage());
    } finally {
      kapat();
    }
  }

  @Override // ilk çalıştırılma için default tablolara default değerlerin eklenmesi işlemi
  public void tabloYukle() {
    // tabUrunler tablosunun default verileri
    ekle(new Urun(0, "Deterjan", 20));
    ekle(new Urun(0, "Dezenfektan", 120));
    ekle(new Urun(0, "Kolonya", 40));
    ekle(new Urun(0, "Sabun", 100));
    ekle(new Urun(0, "Şampuan", 70));
    ekle(new Urun(0, "Çamaşır Suyu", 50));
    ekle(new Urun(0, "Tiner", 30));

    // tabPersoneller tablosunun default verileri
    ekle(new Personel(0, "Yönetici", "root", "101"));
    ekle(new Personel(0, "Zeki ÇIPLAK", "zeki", "111"));
    ekle(new Personel(0, "Ali ÖZTÜRK", "ali", "112"));
    ekle(new Personel(0, "Mehmet AYDIN", "mhmt", "113"));
    ekle(new Personel(0, "Hasan DEMİR", "hsn", "114"));

    // tabMagazalar tablosunun default verileri
    ekle(new Magaza(0, "X Kimyasal Ürünler", "X sok. No:1 Tuzla/İSTANBUL", "(216) 588-12-13"));
    ekle(new Magaza(0, "Y Kimyasal Ürünler", "Y sok. No:2 Gebze/KOCAELİ", "(262) 614-54-54"));
    ekle(new Magaza(0, "Z Kimyasal Ürünler", "Z sok. No:3 Kadıköy/İSTANBUL", "(216) 678-78-89"));

    // tabUreticiler tablosunun default verileri
    ekle(new Uretici(0, "A Kimya Ltd.", "A cad. A sok. No:10 Gebze/İSTANBUL", "(262) 256-25-21"));
    ekle(new Uretici(0, "B Kimya Ltd.", "B cad. B sok. No:20 Tuzla/İSTANBUL", "(216) 572-12-15"));
    ekle(new Uretici(0, "C Kimya Ltd.", "C cad. C sok. No:30 Tuzla/İSTANBUL", "(216) 678-56-34"));

    // tabGelenler tablosunun default verileri
    ekle(new GelenUrun(0, 1, 20, 1635000000, 2, 1));
    ekle(new GelenUrun(0, 2, 30, 1635000000, 2, 1));
    ekle(new GelenUrun(0, 3, 20, 1635000000, 2, 1));

    // tabDepodakiler tablosunun default verileri
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 10; j++) {
        ekle(new DepodakiUrun(0, 1, 0, 0, i, j));
      }
    }

    for (int i = 2; i < 5; i++) {
      for (int j = 0; j < 10; j++) {
        ekle(new DepodakiUrun(0, 2, 0, 0, i, j));
      }
    }

    for (int i = 5; i < 7; i++) {
      for (int j = 0; j < 10; j++) {
        ekle(new DepodakiUrun(0, 3, 0, 0, i, j));
      }
    }

    // tabGidenler tablosunun default verileri
    ekle(new GidenUrun(0, 1, 5, 1635627198, 2, 1));
    ekle(new GidenUrun(0, 2, 5, 1635627198, 2, 2));

    // tabDepodakiler tablosundan silme işlemi
    sil(1, "tabDepodakiler");
    sil(2, "tabDepodakiler");
    sil(3, "tabDepodakiler");
    sil(4, "tabDepodakiler");
    sil(5, "tabDepodakiler");
    sil(21, "tabDepodakiler");
    sil(22, "tabDepodakiler");
    sil(23, "tabDepodakiler");
    sil(24, "tabDepodakiler");
    sil(25, "tabDepodakiler");
  }

  @Override // tabUrunler tablosuna ekleme işlemi
  public int ekle(Urun urun) {
    int dId = 0;
    String sql = "INSERT INTO tabUrunler(urunAdi, koliAdedi) VALUES(?, ?)";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      pst.setString(1, urun.getUrunAdi());
      pst.setInt(2, urun.getKoliAdedi());
      pst.executeUpdate();

      ResultSet rs = pst.getGeneratedKeys();
      dId = rs.getInt(1);
    } catch (SQLException hata) {
      System.out.println("ekle(tabUrunler) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return dId;
  }

  @Override // tabGelenler tablosuna ekleme işlemi
  public int ekle(GelenUrun gelenUrun) {
    int dId = 0;
    String sql
            = "INSERT INTO tabGelenler(urunId, koliToplam, gelisTarih, personelId, ureticiId) "
            + "VALUES(?, ?, ?, ?, ?)";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      pst.setInt(1, gelenUrun.getUrunId());
      pst.setInt(2, gelenUrun.getKoliToplam());
      pst.setLong(3, gelenUrun.getGelisTarih());
      pst.setInt(4, gelenUrun.getPersonelId());
      pst.setInt(5, gelenUrun.getUreticiId());
      pst.executeUpdate();

      ResultSet rs = pst.getGeneratedKeys();
      dId = rs.getInt(1);
    } catch (SQLException hata) {
      System.out.println("ekle(tabGelenler) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return dId;
  }

  @Override // tabGidenler tablosuna ekleme işlemi
  public int ekle(GidenUrun gidenUrun) {
    int dId = 0;
    String sql
            = "INSERT INTO tabGidenler(urunId, koliToplam, gidisTarih, personelId, magazaId) "
            + "VALUES(?, ?, ?, ?, ?)";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      pst.setInt(1, gidenUrun.getUrunId());
      pst.setInt(2, gidenUrun.getKoliToplam());
      pst.setLong(3, gidenUrun.getGidisTarih());
      pst.setInt(4, gidenUrun.getPersonelId());
      pst.setInt(5, gidenUrun.getMagazaId());
      pst.executeUpdate();

      ResultSet rs = pst.getGeneratedKeys();
      dId = rs.getInt(1);
    } catch (SQLException hata) {
      System.out.println("ekle(tabGidenler) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return dId;
  }

  @Override // tabDepodakiler tablosuna ekleme işlemi
  public int ekle(DepodakiUrun depodakiUrun) {
    int dId = 0;
    String sql
            = "INSERT INTO tabDepodakiler(urunId, blokId, rafId, bolmeId, koliId) "
            + "VALUES(?, ?, ?, ?, ?)";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      pst.setInt(1, depodakiUrun.getUrunId());
      pst.setInt(2, depodakiUrun.getBlokId());
      pst.setInt(3, depodakiUrun.getRafId());
      pst.setInt(4, depodakiUrun.getBolmeId());
      pst.setInt(5, depodakiUrun.getKoliId());
      pst.executeUpdate();

      ResultSet rs = pst.getGeneratedKeys();
      dId = rs.getInt(1);
    } catch (SQLException hata) {
      System.out.println("ekle(tabDepodakiler) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }
    return dId;

  }

  @Override // tabMagazalar tablosuna ekleme işlemi
  public int ekle(Magaza magaza) {
    int dId = 0;
    String sql = "INSERT INTO  tabMagazalar(ad, adres, telefon) VALUES(?, ?, ?)";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      pst.setString(1, magaza.getAd());
      pst.setString(2, magaza.getAdres());
      pst.setString(3, magaza.getTelefon());
      pst.executeUpdate();

      ResultSet rs = pst.getGeneratedKeys();
      dId = rs.getInt(1);
    } catch (SQLException hata) {
      System.out.println("ekle(tabMagazalar) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return dId;
  }

  @Override // tabUreticiler tablosuna ekleme işlemi
  public int ekle(Uretici uretici) {
    int dId = 0;
    String sql = "INSERT INTO  tabUreticiler(ad, adres, telefon) VALUES(?, ?, ?)";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      pst.setString(1, uretici.getAd());
      pst.setString(2, uretici.getAdres());
      pst.setString(3, uretici.getTelefon());
      pst.executeUpdate();

      ResultSet rs = pst.getGeneratedKeys();
      dId = rs.getInt(1);
    } catch (SQLException hata) {
      System.out.println("ekle(tabUreticiler) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return dId;
  }

  @Override // tabPersoneller tablosuna ekleme işlemi
  public int ekle(Personel personel) {
    int dId = 0;
    String sql = "INSERT INTO tabPersoneller(adSoyad, kullaniciAdi, sifre) VALUES(?, ?, ?)";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      pst.setString(1, personel.getAdSoyad());
      pst.setString(2, personel.getKullaniciAdi());
      pst.setString(3, personel.getSifre());
      pst.executeUpdate();

      ResultSet rs = pst.getGeneratedKeys();
      dId = rs.getInt(1);
    } catch (SQLException hata) {
      System.out.println("ekle(tabPersoneller) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return dId;
  }

  @Override // tabUrunler tablosunda değiştirme işlemi
  public int degistir(Urun urun) {
    String sql = "UPDATE tabUrunler SET urunAdi = ?, koliAdedi = ? WHERE id = ?";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql);
      pst.setString(1, urun.getUrunAdi());
      pst.setInt(2, urun.getKoliAdedi());
      pst.setInt(3, urun.getId());
      pst.executeUpdate();
    } catch (SQLException hata) {
      System.out.println("degistir(tabUrunler) hatası: " + hata.getMessage());
      return 0;
    } finally {
      kapat();
    }

    return urun.getId();
  }

  @Override // tabMagazalar tablosunda değiştirme işlemi
  public int degistir(Magaza magaza) {
    String sql = "UPDATE tabMagazalar SET ad = ?, adres = ?, telefon = ? WHERE id = ?";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql);
      pst.setString(1, magaza.getAd());
      pst.setString(2, magaza.getAdres());
      pst.setString(3, magaza.getTelefon());
      pst.setInt(4, magaza.getId());
      pst.executeUpdate();
    } catch (SQLException hata) {
      System.out.println("degistir(tabMagazalar) hatası: " + hata.getMessage());
      return 0;
    } finally {
      kapat();
    }

    return magaza.getId();
  }

  @Override // tabUreticiler tablosunda değiştirme işlemi
  public int degistir(Uretici uretici) {
    String sql = "UPDATE tabUreticiler SET ad = ?, adres = ?, telefon = ? WHERE id = ?";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql);
      pst.setString(1, uretici.getAd());
      pst.setString(2, uretici.getAdres());
      pst.setString(3, uretici.getTelefon());
      pst.setInt(4, uretici.getId());
      pst.executeUpdate();
    } catch (SQLException hata) {
      System.out.println("degistir(tabUreticiler) hatası: " + hata.getMessage());
      return 0;
    } finally {
      kapat();
    }

    return uretici.getId();
  }

  @Override // tabPersoneller tablosunda değiştirme işlemi
  public int degistir(Personel personel) {
    String sql = "UPDATE tabPersoneller SET adSoyad = ?, kullaniciAdi = ?, sifre = ? WHERE id = ?";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql);
      pst.setString(1, personel.getAdSoyad());
      pst.setString(2, personel.getKullaniciAdi());
      pst.setString(3, personel.getSifre());
      pst.setInt(4, personel.getId());
      pst.executeUpdate();
    } catch (SQLException hata) {
      System.out.println("degistir(tabPersoneller) hatası: " + hata.getMessage());
      return 0;
    } finally {
      kapat();
    }

    return personel.getId();
  }

  @Override // herhangi bir tablodan temel id'ye göre silme işlemi
  public int sil(int id, String tablo) {
    String sql = "DELETE FROM " + tablo + " WHERE id = ?";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      st.executeUpdate("PRAGMA foreign_keys = ON;");

      PreparedStatement pst = baglanti.prepareStatement(sql);
      pst.setInt(1, id);
      pst.executeUpdate();
    } catch (SQLException hata) {
      System.out.println("sil() hatası: " + hata.getMessage());
      return 0;
    } finally {
      kapat();
    }

    return id;
  }

  @Override // tabDepodakiler tablosundan silme işlemi
  public void sil(DepodakiUrun depodakiUrun) {
    String sql
            = "DELETE FROM tabDepodakiler WHERE blokId = ? AND "
            + "rafId = ? AND "
            + "bolmeId = ? AND "
            + "koliId = ?";
    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql);
      pst.setInt(1, depodakiUrun.getBlokId());
      pst.setInt(2, depodakiUrun.getRafId());
      pst.setInt(3, depodakiUrun.getBolmeId());
      pst.setInt(4, depodakiUrun.getKoliId());
      pst.executeUpdate();
    } catch (SQLException hata) {
      System.out.println("sil(tabDepodakiler) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }
  }

  @Override // tabUrunler tablosundan okuma işlemi
  public ArrayList<Urun> okuUrunler() {
    ArrayList<Urun> urunler = new ArrayList<>();
    String sql = "SELECT id, urunAdi, koliAdedi FROM tabUrunler ORDER BY id";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        urunler.add(new Urun(rs.getInt("id"), rs.getString("urunAdi"),
                rs.getInt("koliAdedi")));
      }
    } catch (SQLException hata) {
      System.out.println("okuUrunler() hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return urunler;
  }

  @Override // tabGelenler tablosundan okuma işlemi
  public ArrayList<GelenUrun> okuGelenler() {
    ArrayList<GelenUrun> gelenler = new ArrayList<>();
    String sql = "SELECT id, urunId, koliToplam, gelisTarih, personelId, "
            + "ureticiId FROM tabGelenler";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        gelenler.add(
                new GelenUrun(
                        rs.getInt("id"),
                        rs.getInt("urunId"),
                        rs.getInt("koliToplam"),
                        rs.getLong("gelisTarih"),
                        rs.getInt("personelId"),
                        rs.getInt("ureticiId")));
      }
    } catch (SQLException hata) {
      System.out.println("okuGelenler() hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return gelenler;
  }

  @Override // tabGidenler tablosundan okuma işlemi
  public ArrayList<GidenUrun> okuGidenler() {
    ArrayList<GidenUrun> gidenler = new ArrayList<>();
    String sql = "SELECT id, urunId, koliToplam, gidisTarih, personelId, "
            + "magazaId FROM tabGidenler";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        gidenler.add(
                new GidenUrun(
                        rs.getInt("id"),
                        rs.getInt("urunId"),
                        rs.getInt("koliToplam"),
                        rs.getInt("gidisTarih"),
                        rs.getInt("personelId"),
                        rs.getInt("magazaId")));
      }
    } catch (SQLException hata) {
      System.out.println("okuGidenler() hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return gidenler;
  }

  @Override // tabDepodakiler tablosundan okuma işlemi
  public ArrayList<DepodakiUrun> okuDepodakiler() {
    ArrayList<DepodakiUrun> depodakiler = new ArrayList<>();
    String sql
            = "SELECT id, urunId, blokId, rafId, bolmeId, koliId FROM tabDepodakiler";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        depodakiler.add(
                new DepodakiUrun(
                        rs.getInt("id"),
                        rs.getInt("urunId"),
                        rs.getInt("blokId"),
                        rs.getInt("rafId"),
                        rs.getInt("bolmeId"),
                        rs.getInt("koliId")));
      }
    } catch (SQLException hata) {
      System.out.println("okuDepodakiler() hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return depodakiler;
  }

  @Override // tabMagazalar tablosundan okuma işlemi
  public ArrayList<Magaza> okuMagazalar() {
    ArrayList<Magaza> magazalar = new ArrayList<>();
    String sql = "SELECT id, ad, adres, telefon FROM tabMagazalar";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        magazalar.add(
                new Magaza(
                        rs.getInt("id"),
                        rs.getString("ad"),
                        rs.getString("adres"),
                        rs.getString("telefon")));
      }
    } catch (SQLException hata) {
      System.out.println("okuMagazalar() hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return magazalar;
  }

  @Override // tabUreticiler tablosundan okuma işlemi
  public ArrayList<Uretici> okuUreticiler() {
    ArrayList<Uretici> ureticiler = new ArrayList<>();
    String sql = "SELECT id, ad, adres, telefon FROM tabUreticiler";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        ureticiler.add(
                new Uretici(
                        rs.getInt("id"),
                        rs.getString("ad"),
                        rs.getString("adres"),
                        rs.getString("telefon")));
      }
    } catch (SQLException hata) {
      System.out.println("okuUreticiler() hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return ureticiler;
  }

  @Override // tabPersoneller tablosunun okuma işlemi
  public ArrayList<Personel> okuPersoneller() {
    ArrayList<Personel> personeller = new ArrayList<>();
    String sql = "SELECT id, adSoyad, kullaniciAdi, sifre FROM tabPersoneller";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        personeller.add(
                new Personel(
                        rs.getInt("id"),
                        rs.getString("adSoyad"),
                        rs.getString("kullaniciAdi"),
                        rs.getString("sifre")));
      }
    } catch (SQLException hata) {
      System.out.println("okuPersoneller() hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return personeller;
  }

  @Override // ürün sayımı
  public int[][] sayUrunler() {
    int farkliUrunler = 0;

    // Depoda (çeşit olarak) kaç farklı ürün var?
    String sql1 = "SELECT count(DISTINCT urunId) as farkliUrunler FROM tabDepodakiler";

    // Depoda hangi çeşit üründen kaç koli var?
    String sql2 = "SELECT urunId, count(*) AS toplam FROM tabDepodakiler GROUP BY urunId";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql1);

      while (rs.next()) {
        farkliUrunler = rs.getInt("farkliUrunler");
      }
    } catch (SQLException hata) {
      System.out.println("sayUrunler(1) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    int[][] sonuc = new int[farkliUrunler][2];

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql2);

      int i = 0;
      while (rs.next()) {
        sonuc[i][0] = rs.getInt("urunId");
        sonuc[i][1] = rs.getInt("toplam");
        i++;
      }
    } catch (SQLException hata) {
      System.out.println("sayUrunler(2) hatası: " + hata.getMessage());
    }

    return sonuc;
  }

  @Override // tabDepodakiler tablosunda urunAdi'na göre arama işlemi
  public ArrayList<Object[]> araUrun(String urunAdi) {
    int urunId = 0;
    ArrayList<Object[]> koliler = new ArrayList<>();

    String sql1 = "SELECT id FROM tabUrunler WHERE urunAdi = ? ";
    String sql2 = "SELECT blokId, rafId, bolmeId, koliId FROM tabDepodakiler "
            + "WHERE urunId = ? ORDER BY id";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql1);
      pst.setString(1, urunAdi);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        urunId = rs.getInt("id");
      }
    } catch (SQLException hata) {
      System.out.println("araUrun(1) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql2);
      pst.setInt(1, urunId);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        koliler.add(new Object[]{
          rs.getInt("blokId") + 1,
          rs.getInt("rafId") + 1,
          rs.getInt("bolmeId") + 1,
          rs.getInt("koliId") + 1
        });
      }
    } catch (SQLException hata) {
      System.out.println("araUrun(2) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return koliler;
  }

  @Override // tabGidenler tablosunda magazaAdi'na göre arama işlemi
  public ArrayList<Object[]> araMagaza(String magazaAdi) {
    int magazaId = 0;
    ArrayList<Object[]> urunler = new ArrayList<>();

    // Ürün mapleme
    HashMap<Integer, String> urunMap = new HashMap<>();
    ArrayList<Urun> tabUrunler = okuUrunler();
    tabUrunler.forEach(urun -> {
      urunMap.put(urun.getId(), urun.getUrunAdi());
    });

    // Personel mapleme
    HashMap<Integer, String> personelMap = new HashMap<>();
    ArrayList<Personel> tabPersoneller = okuPersoneller();
    tabPersoneller.forEach(personel -> {
      personelMap.put(personel.getId(), personel.getAdSoyad() + " (" + personel.getKullaniciAdi() + ")");
    });

    String sql1 = "SELECT id FROM tabMagazalar WHERE ad = ? ";
    String sql2 = "SELECT urunId, koliToplam, gidisTarih, personelId "
            + "FROM tabGidenler WHERE magazaId = ?";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql1);
      pst.setString(1, magazaAdi);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        magazaId = rs.getInt("id");
      }
    } catch (SQLException hata) {
      System.out.println("araMagaza(1) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql2);
      pst.setInt(1, magazaId);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        urunler.add(new Object[]{
          urunMap.get(rs.getInt("urunId")),
          rs.getInt("koliToplam"),
          personelMap.get(rs.getInt("personelId")),
          FONK.unixToTarih(rs.getLong("gidisTarih"), "dd-MM-yyyy HH:mm")
        });
      }
    } catch (SQLException hata) {
      System.out.println("araMagaza(2) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return urunler;
  }

  @Override // tabGelenler tablosunda ureticiAdi'na göre arama işlemi
  public ArrayList<Object[]> araUretici(String ureticiAdi) {
    int ureticiId = 0;
    ArrayList<Object[]> urunler = new ArrayList<>();

    // Ürün mapleme
    HashMap<Integer, String> urunMap = new HashMap<>();
    ArrayList<Urun> tabUrunler = okuUrunler();
    tabUrunler.forEach(urun -> {
      urunMap.put(urun.getId(), urun.getUrunAdi());
    });

    // Personel mapleme
    HashMap<Integer, String> personelMap = new HashMap<>();
    ArrayList<Personel> tabPersoneller = okuPersoneller();
    tabPersoneller.forEach(personel -> {
      personelMap.put(personel.getId(), personel.getAdSoyad() + " (" + personel.getKullaniciAdi() + ")");
    });

    String sql1 = "SELECT id FROM tabUreticiler WHERE ad = ? ";
    String sql2 = "SELECT urunId, koliToplam, gelisTarih, personelId "
            + "FROM tabGelenler WHERE ureticiId = ? ";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql1);
      pst.setString(1, ureticiAdi);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        ureticiId = rs.getInt("id");
      }
    } catch (SQLException hata) {
      System.out.println("araUretici(1) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql2);
      pst.setInt(1, ureticiId);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        urunler.add(new Object[]{
          urunMap.get(rs.getInt("urunId")),
          rs.getInt("koliToplam"),
          personelMap.get(rs.getInt("personelId")),
          FONK.unixToTarih(rs.getLong("gelisTarih"), "dd-MM-yyyy HH:mm")
        });
      }
    } catch (SQLException hata) {
      System.out.println("araUretici(2) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return urunler;
  }

  @Override // tabGelenler ve tabGidenler tablolarında personelId'ye göre arama işlemi
  public ArrayList<Object[]> araPersonel(String personelKullaniciAdi) {
    int personelId = 0;

    ArrayList<Object[]> urunler = new ArrayList<>();
    HashMap<Integer, String> urunMap = new HashMap<>();

    ArrayList<Urun> tabUrunler = okuUrunler();
    tabUrunler.forEach(urun -> {
      urunMap.put(urun.getId(), urun.getUrunAdi());
    });

    String sql1 = "SELECT id FROM tabPersoneller WHERE kullaniciAdi = ? ";
    String sql2 = "SELECT urunId, koliToplam, gelisTarih FROM tabGelenler WHERE personelId = ?";
    String sql3 = "SELECT urunId, koliToplam, gidisTarih FROM tabGidenler WHERE personelId = ? ";

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql1);
      pst.setString(1, personelKullaniciAdi);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        personelId = rs.getInt("id");
      }
    } catch (SQLException hata) {
      System.out.println("araPersonel(1) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql2);
      pst.setInt(1, personelId);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        urunler.add(new Object[]{
          urunMap.get(rs.getInt("urunId")),
          "Gelen",
          rs.getInt("koliToplam"),
          FONK.unixToTarih(rs.getLong("gelisTarih"), "dd-MM-yyyy HH:mm")
        });
      }
    } catch (SQLException hata) {
      System.out.println("araPersonel(2) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql3);
      pst.setInt(1, personelId);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        urunler.add(new Object[]{
          urunMap.get(rs.getInt("urunId")),
          "Giden",
          rs.getInt("koliToplam"),
          FONK.unixToTarih(rs.getLong("gidisTarih"), "dd-MM-yyyy HH:mm")
        });
      }
    } catch (SQLException hata) {
      System.out.println("araPersonel(3) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return urunler;
  }

  @Override // tabGelenler ve tabGidenler tablolarında, gelisTarih ve gidisTarih'e göre arama işlemi
  public ArrayList<Object[]> araTarih(long min, long max) {
    String sql1 = "SELECT urunId, ureticiId, koliToplam, personelId, gelisTarih "
            + "FROM tabGelenler WHERE gelisTarih BETWEEN ? AND ? "
            + "GROUP BY urunId, gelisTarih ORDER BY gelisTarih";

    String sql2 = "SELECT urunId, magazaId, koliToplam, personelId, gidisTarih "
            + "FROM tabGidenler WHERE gidisTarih BETWEEN ? AND ? "
            + "GROUP BY urunId, gidisTarih ORDER BY gidisTarih";

    HashMap<Integer, String> urunMap = new HashMap<>();
    HashMap<Integer, String> ureticiMap = new HashMap<>();
    HashMap<Integer, String> magazaMap = new HashMap<>();
    HashMap<Integer, String> personelMap = new HashMap<>();

    ArrayList<Urun> tabUrunler = okuUrunler();
    tabUrunler.forEach(urun -> {
      urunMap.put(urun.getId(), urun.getUrunAdi());
    });

    ArrayList<Uretici> tabUreticiler = okuUreticiler();
    tabUreticiler.forEach(uretici -> {
      ureticiMap.put(uretici.getId(), uretici.getAd());
    });

    ArrayList<Magaza> tabMagazalar = okuMagazalar();
    tabMagazalar.forEach(magaza -> {
      magazaMap.put(magaza.getId(), magaza.getAd());
    });

    ArrayList<Personel> tabPersoneller = okuPersoneller();
    tabPersoneller.forEach(personel -> {
      personelMap.put(personel.getId(),
              personel.getAdSoyad() + " (" + personel.getKullaniciAdi() + ")");
    });

    ArrayList<Object[]> urunler = new ArrayList<>();

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql1);
      pst.setLong(1, min);
      pst.setLong(2, max);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        urunler.add(new Object[]{
          urunMap.get(rs.getInt("urunId")),
          "Gelen",
          ureticiMap.get(rs.getInt("ureticiId")),
          rs.getInt("koliToplam"),
          personelMap.get(rs.getInt("personelId")),
          FONK.unixToTarih(rs.getLong("gelisTarih"), "dd-MM-yyyy HH:mm")
        });
      }
    } catch (SQLException hata) {
      System.out.println("araTarih(1) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    try {
      baglan();
      PreparedStatement pst = baglanti.prepareStatement(sql2);
      pst.setLong(1, min);
      pst.setLong(2, max);
      ResultSet rs = pst.executeQuery();
      while (rs.next()) {
        urunler.add(new Object[]{
          urunMap.get(rs.getInt("urunId")),
          "Giden",
          magazaMap.get(rs.getInt("magazaId")),
          rs.getInt("koliToplam"),
          personelMap.get(rs.getInt("personelId")),
          FONK.unixToTarih(rs.getLong("gidisTarih"), "dd-MM-yyyy HH:mm")
        });
      }
    } catch (SQLException hata) {
      System.out.println("araTarih(2) hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return urunler;
  }

  @Override // tabGelenler tablosunda gelisTarih değeri maksimum olan tarihi döndürme işlemi
  public long maxTarihGelenler() {
    long maksimum = 0;
    String sql = "SELECT MAX(gelisTarih) as maksimum FROM tabGelenler";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        maksimum = rs.getInt("maksimum");
      }
    } catch (SQLException hata) {
      System.out.println("maxTarihGelenler() hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return maksimum;
  }

  @Override // tabGelenler tablosunda gelisTarih değeri minimum olan tarihi döndürme işlemi
  public long minTarihGelenler() {
    long minimum = 0;
    String sql = "SELECT MIN(gelisTarih) as minimum FROM tabGelenler";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        minimum = rs.getInt("minimum");
      }
    } catch (SQLException hata) {
      System.out.println("minTarihGelenler() hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return minimum;
  }

  @Override // tabGidenler tablosunda gidisTarih değeri maksimum olan tarihi döndürme işlemi
  public long maxTarihGidenler() {
    long maksimum = 0;
    String sql = "SELECT MAX(gidisTarih) as maksimum FROM tabGidenler";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        maksimum = rs.getInt("maksimum");
      }
    } catch (SQLException hata) {
      System.out.println("maxTarihGidenler() hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return maksimum;
  }

  @Override // tabGidenler tablosunda gidisTarih değeri minimum olan tarihi döndürme işlemi
  public long minTarihGidenler() {
    long minimum = 0;
    String sql = "SELECT MIN(gidisTarih) as minimum FROM tabGidenler";

    try {
      baglan();
      Statement st = baglanti.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        minimum = rs.getInt("minimum");
      }
    } catch (SQLException hata) {
      System.out.println("minTarihGidenler() hatası: " + hata.getMessage());
    } finally {
      kapat();
    }

    return minimum;
  }

}
