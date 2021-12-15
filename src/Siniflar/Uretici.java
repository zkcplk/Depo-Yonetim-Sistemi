//
// Uretici.java
//
package Siniflar;

public class Uretici {
  private final int id;
  private final String ad;
  private final String adres;
  private final String telefon;

  public Uretici(int id, String ad, String adres, String telefon) {
    this.id = id;
    this.ad = ad;
    this.adres = adres;
    this.telefon = telefon;
  }

  public int getId() {
    return id;
  }

  public String getAd() {
    return ad;
  }

  public String getAdres() {
    return adres;
  }

  public String getTelefon() {
    return telefon;
  }
}
