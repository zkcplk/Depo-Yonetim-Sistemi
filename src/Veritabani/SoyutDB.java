//
// SoyutDB.java
//
package Veritabani;

import Siniflar.DepodakiUrun;
import Siniflar.GelenUrun;
import Siniflar.GidenUrun;
import Siniflar.Magaza;
import Siniflar.Personel;
import Siniflar.Uretici;
import Siniflar.Urun;
import java.util.ArrayList;

public abstract class SoyutDB {
  private final String dbName;

  public SoyutDB(String dbName) {
    this.dbName = dbName;
  }

  public String getDbName() {
    return dbName;
  }

  // db bağlantı metodları
  public abstract boolean baglan();

  public abstract void kapat();

  // ilk kurulumlar için metodlar
  public abstract boolean tabloKontrol();

  public abstract void tabloOlustur();

  public abstract void tabloYukle();

  // ekleme metodları (overload metodlar)
  public abstract int ekle(Urun urun);

  public abstract int ekle(GelenUrun gelenUrun);

  public abstract int ekle(GidenUrun gidenUrun);

  public abstract int ekle(DepodakiUrun depodakiUrun);

  public abstract int ekle(Magaza magaza);

  public abstract int ekle(Uretici uretici);

  public abstract int ekle(Personel personel);

  // güncelleme metodları (overload metodlar)
  public abstract int degistir(Urun urun);

  public abstract int degistir(Magaza magaza);

  public abstract int degistir(Uretici uretici);

  public abstract int degistir(Personel personel);

  // silme metodları
  public abstract int sil(int id, String tablo);

  public abstract void sil(DepodakiUrun depodakiUrun);

  // okuma metodları
  public abstract ArrayList<Urun> okuUrunler();

  public abstract ArrayList<GelenUrun> okuGelenler();

  public abstract ArrayList<GidenUrun> okuGidenler();

  public abstract ArrayList<DepodakiUrun> okuDepodakiler();

  public abstract ArrayList<Magaza> okuMagazalar();

  public abstract ArrayList<Uretici> okuUreticiler();

  public abstract ArrayList<Personel> okuPersoneller();

  // sayım
  public abstract int[][] sayUrunler();

  // arama metodları
  public abstract ArrayList<Object[]> araUrun(String urunAdi);

  public abstract ArrayList<Object[]> araMagaza(String magazaAdi);

  public abstract ArrayList<Object[]> araUretici(String ureticiAdi);

  public abstract ArrayList<Object[]> araPersonel(String personelKullaniciAdi);

  public abstract ArrayList<Object[]> araTarih(long min, long max);

  // maksimum - minimum tarih
  public abstract long maxTarihGelenler();

  public abstract long minTarihGelenler();

  public abstract long maxTarihGidenler();

  public abstract long minTarihGidenler();
}
