//
// Urun.java
//
package Siniflar;

public class Urun {
  private final int id;
  private final String urunAdi;
  private final int koliAdedi;

  public Urun(int id, String urunAdi, int koliAdedi) {
    this.id = id;
    this.urunAdi = urunAdi;
    this.koliAdedi = koliAdedi;
  }

  public int getId() {
    return id;
  }

  public String getUrunAdi() {
    return urunAdi;
  }

  public int getKoliAdedi() {
    return koliAdedi;
  }
}
