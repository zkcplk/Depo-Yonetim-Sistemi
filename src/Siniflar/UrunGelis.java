//
// UrunGelis.java
//
package Siniflar;

import static Siniflar.Sabitler.BLOKRAF;
import static Siniflar.Sabitler.BOLMEKOLI;
import static Siniflar.Sabitler.DB;
import static Siniflar.Sabitler.DEPOBLOK;
import static Siniflar.Sabitler.RAFBOLME;
import static Siniflar.Sabitler.TUMYERLER;
import java.util.ArrayList;

public class UrunGelis {

  // Depoda koli yerleştirilebilecek boş yerleri sayan metod
  public int bosYer() {
    int bos = 0;
    for (int i = 0; i < DEPOBLOK; i++) {
      for (int j = 0; j < BLOKRAF; j++) {
        for (int k = 0; k < RAFBOLME; k++) {
          for (int l = 0; l < BOLMEKOLI; l++) {
            if (TUMYERLER[i][j][k][l] == 0) {
              bos++;
            }
          }
        }
      }
    }
    return bos;
  }

  // Depoda yeni gelecek ürünlere yetecek yer yoksa,
  // ürünler depoya giriş yapamaz, işlem iptal edilir.
  public boolean kabul(ArrayList<GelenUrun> gelenUrunler) {
    boolean urunKabul = false;
    if (bosYer() >= gelenUrunler.size()) {
      urunKabul = true;
    }
    return urunKabul;
  }

  // Depoya girişi kabul edilen ürünlerin kolilerini,
  // depodaki boş yerlere yerleştiren ve veritabanına kaydeden metod
  public ArrayList<DepodakiUrun> yerlestir(ArrayList<GelenUrun> gelenUrunler) {
    ArrayList<DepodakiUrun> gelenlerinYerleri = new ArrayList<>();

    int id, koli;
    for (GelenUrun gelen : gelenUrunler) {
      id = gelen.getUrunId();
      koli = gelen.getKoliToplam();

      // tabGelenler tablosuna ekleme işlemi
      DB.ekle(gelen);
      for (int i = 0; i < DEPOBLOK; i++) {
        for (int j = 0; j < BLOKRAF; j++) {
          for (int k = 0; k < RAFBOLME; k++) {
            for (int l = 0; l < BOLMEKOLI; l++) {
              if (TUMYERLER[i][j][k][l] == 0 && koli > 0) {
                koli--;
                TUMYERLER[i][j][k][l] = id;

                // tabDepodakiler tablosuna ekleme işlemi
                DepodakiUrun depodaki = new DepodakiUrun(0, id, i, j, k, l);
                DB.ekle(depodaki);

                // PDF çıktısında "depodaki" nesnesine ihtiyacımız olacak
                gelenlerinYerleri.add(depodaki);
              }
            }
          }
        }
      }
    }

    return gelenlerinYerleri;
  }
}
