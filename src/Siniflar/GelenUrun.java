//
// GelenUrun.java
//
package Siniflar;

public class GelenUrun {
  private final int id;
  private final int urunId;
  private final int koliToplam;
  private final long gelisTarih;
  private final int personelId;
  private final int ureticiId;

  public GelenUrun(int id, int urunId, int koliToplam, long gelisTarih, int personelId, int ureticiId) {
    this.id = id;
    this.urunId = urunId;
    this.koliToplam = koliToplam;
    this.gelisTarih = gelisTarih;
    this.personelId = personelId;
    this.ureticiId = ureticiId;
  }

  public int getId() {
    return id;
  }

  public int getUrunId() {
    return urunId;
  }

  public int getKoliToplam() {
    return koliToplam;
  }

  public long getGelisTarih() {
    return gelisTarih;
  }

  public int getPersonelId() {
    return personelId;
  }

  public int getUreticiId() {
    return ureticiId;
  }

}
