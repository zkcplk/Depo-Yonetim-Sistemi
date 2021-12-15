//
// GidenUrun.java
//
package Siniflar;

public class GidenUrun {
  private final int id;
  private final int urunId;
  private final int koliToplam;
  private final long gidisTarih;
  private final int personelId;
  private final int magazaId;

  public GidenUrun(int id, int urunId, int koliToplam, long gidisTarih, int personelId, int magazaId) {
    this.id = id;
    this.urunId = urunId;
    this.koliToplam = koliToplam;
    this.gidisTarih = gidisTarih;
    this.personelId = personelId;
    this.magazaId = magazaId;
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

  public long getGidisTarih() {
    return gidisTarih;
  }

  public int getPersonelId() {
    return personelId;
  }

  public int getMagazaId() {
    return magazaId;
  }

}
