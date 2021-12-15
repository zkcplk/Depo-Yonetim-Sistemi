//
// Personel.java
//
package Siniflar;

public class Personel {
  private final int id;
  private final String adSoyad;
  private final String kullaniciAdi;
  private final String sifre;

  public Personel(int id, String adSoyad, String kullaniciAdi, String sifre) {
    this.id = id;
    this.adSoyad = adSoyad;
    this.kullaniciAdi = kullaniciAdi;
    this.sifre = sifre;
  }

  public int getId() {
    return id;
  }

  public String getAdSoyad() {
    return adSoyad;
  }

  public String getKullaniciAdi() {
    return kullaniciAdi;
  }

  public String getSifre() {
    return sifre;
  }
}
