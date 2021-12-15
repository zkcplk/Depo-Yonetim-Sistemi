//
// DepodakiUrun.java
//
package Siniflar;

public class DepodakiUrun {
  private final int id;
  private final int urunId;
  private final int blokId;
  private final int rafId;
  private final int bolmeId;
  private final int koliId;

  public DepodakiUrun(int id, int urunId, int blokId, int rafId, int bolmeId, int koliId) {
    this.id = id;
    this.urunId = urunId;
    this.blokId = blokId;
    this.rafId = rafId;
    this.bolmeId = bolmeId;
    this.koliId = koliId;
  }

  public int getId() {
    return id;
  }

  public int getUrunId() {
    return urunId;
  }

  public int getBlokId() {
    return blokId;
  }

  public int getRafId() {
    return rafId;
  }

  public int getBolmeId() {
    return bolmeId;
  }

  public int getKoliId() {
    return koliId;
  }
}
