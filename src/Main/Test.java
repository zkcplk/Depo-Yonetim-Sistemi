//
//  Test.java
//
package Main;

import Siniflar.Hesap;
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

public class Test {
  static String root = "root";
  static String rootPass = "101";
  static String user = "zeki";
  static String userPass = "111";
  static int sleep = 3000;

  public static void main(String[] args) throws InterruptedException {
    System.out.println("TEST -> YÖNETİCİ LOGIN/PERSONEL LOGIN/GEÇERSİZ LOGIN");
    login(root, rootPass);
    login(user, userPass);
    login("test", "test");
    Thread.sleep(sleep);

    System.out.println("TEST -> ÜRÜN -> EKLE/GÜNCELLE/SİL");
    urun();
    Thread.sleep(sleep);

    System.out.println("TEST -> PERSONEL -> EKLE/GÜNCELLE/SİL");
    personel();
    Thread.sleep(sleep);

    System.out.println("TEST -> ÜRETİCİ -> EKLE/GÜNCELLE/SİL");
    uretici();
    Thread.sleep(sleep);

    System.out.println("TEST -> MAĞAZA -> EKLE/GÜNCELLE/SİL");
    magaza();
    Thread.sleep(sleep);

    System.out.println("TEST -> ARAMA -> ÜRÜN SAY/PDF OLUŞTUR");
    urunSayim();
    Thread.sleep(sleep);

    System.out.println("TEST -> ARAMA -> ÜRÜN ARA/PDF OLUŞTUR");
    araUrun();
    Thread.sleep(sleep);

    System.out.println("TEST -> ARAMA -> ÜRETİCİYE GÖRE ARA/PDF OLUŞTUR");
    araUretici();
    Thread.sleep(sleep);

    System.out.println("TEST -> ARAMA -> MAĞAZAYA GÖRE ARA/PDF OLUŞTUR");
    araMagaza();
    Thread.sleep(sleep);

    System.out.println("TEST -> ARAMA -> PERSONELE GÖRE ARA/PDF OLUŞTUR");
    araPersonel();
    Thread.sleep(sleep);

    System.out.println("TEST -> ARAMA -> TARİHE GÖRE ARA/PDF OLUŞTUR");
    araTarih();
    Thread.sleep(sleep);

    System.out.println("TEST -> İSTATİSTİK -> GÖSTER/PDF OLUŞTUR");
    istatistik();
  }

  public static void login(String user, String pass) {
    Personel personel = FONK.kontrolUserPass(user, pass);

    if (personel != null) {
      if (PERSONELUSER.equals("root")) {
        System.out.println("Yönetici LOGIN: " + PERSONELUSER + " " + pass);
      } else {
        System.out.println("Personel LOGIN: " + PERSONELUSER + " " + pass);
      }
    } else {
      System.out.println("Geçersiz LOGIN!\n\n");
    }
  }

  public static void urun() {
    String urunAdi = "Yeni Ürün";
    int koliAdedi = 10;

    // Ürün ekleme
    int dId = DB.ekle(new Urun(0, urunAdi, koliAdedi));
    System.out.println("ÜRÜN EKLE >> id: " + dId + ", ürün adı: " + urunAdi + " koli adedi: " + koliAdedi);

    // Ürün güncelleme
    urunAdi = "Yeni Deterjan";
    dId = DB.degistir(new Urun(dId, urunAdi, koliAdedi + 10));
    System.out.println("ÜRÜN GÜNCELLE >> id: " + dId + ", ürün adı: " + urunAdi);

    // Ürün silme
    dId = DB.sil(dId, "tabUrunler");
    System.out.println("ÜRÜN SİL >> id: " + dId + "\n\n");
  }

  public static void personel() {
    String personelAdi = "Yeni Personel";
    String personelUser = "yenip";
    String personelPass = "2222";

    // Personel ekleme
    int dId = DB.ekle(new Personel(0, personelAdi, personelUser, personelPass));
    System.out.println("PERSONEL EKLE >> kullanıcı adı: " + personelUser + ", şifre: " + personelPass);

    // Personel güncelleme
    personelAdi = "Aslan Personel";
    dId = DB.degistir(new Personel(dId, personelAdi, personelUser, personelPass));
    System.out.println("PERSONEL GÜNCELLE >> id: " + dId + ", ad-soyad: " + personelAdi);

    // Personel silme
    dId = DB.sil(dId, "tabPersoneller");
    System.out.println("PERSONEL SİL >> id: " + dId + "\n\n");
  }

  public static void uretici() {
    String ureticiAdi = "Java Kimya Limited Şirketi";
    String ureticiAdres = "Java Mah. Java Sok. No:77 Tuzla / İSTANBUL";
    String ureticiTel = "(216) 777-77-77";

    // Üretici ekleme
    int dId = DB.ekle(new Uretici(0, ureticiAdi, ureticiAdres, ureticiTel));
    System.out.println("ÜRETİCİ EKLE >> üretici adı: " + ureticiAdi + ", tel: " + ureticiTel);

    // Üretici güncelleme
    ureticiAdi = "Java Kimya Anonim Şirketi";
    dId = DB.degistir(new Uretici(dId, ureticiAdi, ureticiAdres, ureticiTel));
    System.out.println("ÜRETİCİ GÜNCELLE >> id: " + dId + ", üretici adı: " + ureticiAdi);

    // Üretici silme
    dId = DB.sil(dId, "tabUreticiler");
    System.out.println("ÜRETİCİ SİL >> id: " + dId + "\n\n");
  }

  public static void magaza() {
    String magazaAdi = "Java Kimya Ürünleri Mağazası";
    String magazaAdres = "Java Cd. Kimya Sk. No:22 Kartal / İSTANBUL";
    String magazaTel = "(216) 777-55-55";

    // Mağaza ekleme
    int dId = DB.ekle(new Magaza(0, magazaAdi, magazaAdres, magazaTel));
    System.out.println("MAĞAZA EKLE >> üretici adı: " + magazaAdi + ", tel: " + magazaTel);

    // Mağaza güncelleme
    magazaAdi = "Java Kimya Market";
    dId = DB.degistir(new Magaza(dId, magazaAdi, magazaAdres, magazaTel));
    System.out.println("MAĞAZA GÜNCELLE >> id: " + dId + ", mağaza adı: " + magazaAdi);

    // Mağaza silme
    dId = DB.sil(dId, "tabMagazalar");
    System.out.println("MAĞAZA SİL >> id: " + dId + "\n\n");
  }

  public static void urunSayim() {
    // Depoda bulunan ürünlerin sayımı
    int[][] urunListesi = DB.sayUrunler();
    ArrayList<Urun> tabUrunler = DB.okuUrunler();
    HashMap<Integer, Urun> urunMap = new HashMap<>();
    Object[][] sayimListesi = new Object[urunListesi.length][];

    tabUrunler.forEach(urun -> {
      urunMap.put(urun.getId(), new Urun(urun.getId(), urun.getUrunAdi(), urun.getKoliAdedi()));
    });

    int toplamKoli = 0;
    System.out.println("------------------------------------");
    System.out.println("Ürün Adı\tKoli\tÜrün Adedi");
    System.out.println("------------------------------------");
    for (int i = 0; i < urunListesi.length; i++) {
      String urunAdi = urunMap.get(urunListesi[i][0]).getUrunAdi();
      int urunKoli = urunListesi[i][1];
      int urunAdet = urunKoli * urunMap.get(urunListesi[i][0]).getKoliAdedi();

      sayimListesi[i] = new Object[]{urunAdi, urunKoli, urunAdet};

      System.out.println(urunAdi + "\t" + urunKoli + "\t" + urunAdet);
      toplamKoli += urunKoli;
    }

    System.out.println("------------------------------------");
    System.out.println("Toplam koli: " + toplamKoli);
    System.out.println("Ürün Çeşidi: " + urunListesi.length);

    double dolulukOrani = ((int) (((toplamKoli * 100.0 / KAPASITE)) * 100) / 100.0);
    System.out.println("Doluluk Oranı: % " + dolulukOrani);
    System.out.println("Boş yer sayısı: " + (KAPASITE - toplamKoli));
    System.out.println("------------------------------------");

    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.urunSayimPDF(sayimListesi,
            unixTime,
            String.valueOf(urunListesi.length),
            String.valueOf(toplamKoli),
            String.valueOf((KAPASITE - toplamKoli)),
            String.valueOf(dolulukOrani)
    );

    try {
      PDFCikti.pdfYap(pdf, "UrunSayim", unixTime);
      System.out.println("PDF OLUŞTURULDU: urunSayim()");
      System.out.println("------------------------------------\n\n");
    } catch (FileNotFoundException ex) {
      System.out.println("urunSayim() PDF Hatası: PDF çıktısı oluşturulamadı!\n");
    }
  }

  public static void araUrun() {
    String urunAdi = "Deterjan";
    System.out.println("------------------------------------");
    System.out.println("Aranan Ürün: " + urunAdi);
    ArrayList<Object[]> araUrunListesi = DB.araUrun(urunAdi);

    if (araUrunListesi.size() < 1) {
      System.out.println(urunAdi + " ile ilgili hiçbir sonuç bulunamadı!");
    } else {
      System.out.println("------------------------------------");
      System.out.println("Aranan ürünün depodaki yerleri");
      System.out.println("------------------------------------");
      System.out.println("Blok\tRaf\tBölme\tKoli No");
      System.out.println("------------------------------------");
      for (Object[] obj : araUrunListesi) {
        System.out.println(obj[0] + "\t" + obj[1] + "\t" + obj[2] + "\t" + obj[3]);
      }
      System.out.println("------------------------------------");
    }

    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.araUrunPDF(araUrunListesi, unixTime, urunAdi);

    try {
      PDFCikti.pdfYap(pdf, "UrunArama", unixTime);
      System.out.println("PDF OLUŞTURULDU: araUrun()");
      System.out.println("------------------------------------\n\n");
    } catch (FileNotFoundException ex) {
      System.out.println("araUrun() PDF Hatası: PDF çıktısı oluşturulamadı!\n");
    }
  }

  public static void araUretici() {
    String ureticiAdi = "A Kimya Ltd.";
    System.out.println("------------------------------------");
    System.out.println("Aranan Üretici: " + ureticiAdi);
    ArrayList<Object[]> araUreticiListesi = DB.araUretici(ureticiAdi);

    int toplamKoli = 0;
    if (araUreticiListesi.size() < 1) {
      System.out.println(ureticiAdi + " ile ilgili hiçbir sonuç bulunamadı!");
    } else {
      System.out.println("------------------------------------");
      System.out.println("Üreticinin getirdiği ürünler");
      System.out.println("------------------------------------");
      System.out.println("Ürün\tKoli\tPersonel\tTarih");
      System.out.println("------------------------------------");
      for (Object[] obj : araUreticiListesi) {
        System.out.println(obj[0] + "\t" + obj[1] + "\t" + obj[2] + "\t" + obj[3]);
        toplamKoli += Integer.valueOf("" + obj[1]);
      }
      System.out.println("------------------------------------");
    }

    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.araUreticiPDF(araUreticiListesi, unixTime, ureticiAdi, String.valueOf(toplamKoli));

    try {
      PDFCikti.pdfYap(pdf, "UreticiArama", unixTime);
      System.out.println("PDF OLUŞTURULDU: araUretici()");
      System.out.println("------------------------------------\n\n");
    } catch (FileNotFoundException ex) {
      System.out.println("araUretici() PDF Hatası: PDF çıktısı oluşturulamadı!\n");
    }
  }

  public static void araMagaza() {
    String magazaAdi = "X Kimyasal Ürünler";
    System.out.println("------------------------------------");
    System.out.println("Aranan Mağaza: " + magazaAdi);
    ArrayList<Object[]> araMagazaListesi = DB.araMagaza(magazaAdi);

    int toplamKoli = 0;
    if (araMagazaListesi.size() < 1) {
      System.out.println(magazaAdi + " ile ilgili hiçbir sonuç bulunamadı!");
    } else {
      System.out.println("------------------------------------");
      System.out.println("Mağazaya gönderilen ürünler");
      System.out.println("------------------------------------");
      System.out.println("Ürün\tKoli\tPersonel\tTarih");
      System.out.println("------------------------------------");
      for (Object[] obj : araMagazaListesi) {
        System.out.println(obj[0] + "\t" + obj[1] + "\t" + obj[2] + "\t" + obj[3]);
        toplamKoli += Integer.valueOf("" + obj[1]);
      }
      System.out.println("------------------------------------");
    }

    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.araMagazaPDF(araMagazaListesi, unixTime, magazaAdi, String.valueOf(toplamKoli));

    try {
      PDFCikti.pdfYap(pdf, "MagazaArama", unixTime);
      System.out.println("PDF OLUŞTURULDU: araMagaza()");
      System.out.println("------------------------------------\n\n");
    } catch (FileNotFoundException ex) {
      System.out.println("araMagaza() PDF Hatası: PDF çıktısı oluşturulamadı!\n");
    }
  }

  public static void araPersonel() {
    String person = "Zeki ÇIPLAK (zeki)";
    String personelAdSoyad = person.split("\\(")[0].trim();
    String personelKullaniciAdi = person.split("\\(")[1].split("\\)")[0].trim();
    System.out.println("------------------------------------");
    System.out.println("Aranan Personel: " + person);
    ArrayList<Object[]> araPersonelListesi = DB.araPersonel(personelKullaniciAdi);

    int toplamKoli = 0;
    if (araPersonelListesi.size() < 1) {
      System.out.println(person + " ile ilgili hiçbir sonuç bulunamadı!");
    } else {
      System.out.println("------------------------------------");
      System.out.println("Personelin taşıdığı ürünler");
      System.out.println("------------------------------------");
      System.out.println("Ürün\tGelen/Giden\tKoli\tTarih");
      System.out.println("------------------------------------");

      for (Object[] obj : araPersonelListesi) {
        System.out.println(obj[0] + "\t" + obj[1] + "\t" + obj[2] + "\t" + obj[3]);
        toplamKoli += Integer.valueOf("" + obj[2]);
      }
      System.out.println("------------------------------------");
    }

    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.araPersonelPDF(araPersonelListesi, unixTime, person, String.valueOf(toplamKoli));

    try {
      PDFCikti.pdfYap(pdf, "PersonelArama", unixTime);
      System.out.println("PDF OLUŞTURULDU: araPersonel()");
      System.out.println("------------------------------------\n\n");
    } catch (FileNotFoundException ex) {
      System.out.println("araPersonel() PDF Hatası: PDF çıktısı oluşturulamadı!\n");
    }
  }

  public static void araTarih() {
    String tarihMin = "30-10-2021";
    String tarihMax = "31-12-2021";

    long unixMinTarih = FONK.tarihToUnix(tarihMin, "dd-MM-yyyy");
    long unixMaxTarih = FONK.tarihToUnix(tarihMax, "dd-MM-yyyy");

    ArrayList<Object[]> araTarihListesi = DB.araTarih(unixMinTarih, unixMaxTarih);

    if (araTarihListesi.size() < 1) {
      System.out.println("İlgili tarih aralığında ile ilgili hiçbir sonuç bulunamadı!");
    } else {
      System.out.println("------------------------------------");
      System.out.println("Tarih Aralığı: " + tarihMin + " ile " + tarihMax);
      System.out.println("------------------------------------");
      System.out.println("Ürün\tGelen/Giden\tÜretici/Mağaza\tKoli\tPersonel\tTarih");
      System.out.println("------------------------------------");

      for (Object[] obj : araTarihListesi) {
        System.out.println(obj[0] + "\t" + obj[1] + "\t" + obj[2] + "\t" + obj[3] + "\t" + obj[4] + "\t" + obj[5]);
      }
      System.out.println("------------------------------------");
    }

    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.araTarihPDF(araTarihListesi, unixTime, unixMinTarih, unixMaxTarih);

    try {
      PDFCikti.pdfYap(pdf, "TarihselArama", unixTime);
      System.out.println("PDF OLUŞTURULDU: araTarih()");
      System.out.println("------------------------------------\n\n");
    } catch (FileNotFoundException ex) {
      System.out.println("araTarih() PDF Hatası: PDF çıktısı oluşturulamadı!\n");
    }
  }

  public static void istatistik() {
    Object[][] istatistikler = new Hesap().istatistikHesapla();

    System.out.println("------------------------------------");
    for (int i = 0; i < 14; i++) {
      System.out.println(istatistikler[i][0] + ": " + istatistikler[i][1]);
    }

    long unixTime = System.currentTimeMillis() / 1000L;
    String pdf = PDFCikti.istatistiklerPDF(unixTime, istatistikler);

    try {
      PDFCikti.pdfYap(pdf, "Istatistikler", unixTime);
      System.out.println("------------------------------------");
      System.out.println("PDF OLUŞTURULDU: istatistik()");
      System.out.println("------------------------------------");
    } catch (FileNotFoundException ex) {
      System.out.println("istatistik() PDF Hatası: PDF çıktısı oluşturulamadı!\n");
    }
  }
}
