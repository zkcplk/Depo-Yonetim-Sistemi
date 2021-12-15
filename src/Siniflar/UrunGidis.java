//
// UrunGidis.java
//
package Siniflar;

import static Siniflar.Sabitler.BLOKRAF;
import static Siniflar.Sabitler.BOLMEKOLI;
import static Siniflar.Sabitler.DB;
import static Siniflar.Sabitler.DEPOBLOK;
import static Siniflar.Sabitler.RAFBOLME;
import static Siniflar.Sabitler.TUMYERLER;
import java.util.ArrayList;

public class UrunGidis {
  // Depodan istenen ürün miktarı depoda yoksa,
  // istenen ürünlerin hiçbiri depodan çıkış yapamaz,
  // işlem iptal edilir.
  public boolean kabul(ArrayList<GidenUrun> gidenUrunler, ArrayList<DepodakiUrun> depodakiUrunler) {
    int id1, koli1;
    for (GidenUrun giden : gidenUrunler) {
      id1 = giden.getUrunId();
      koli1 = giden.getKoliToplam();

      int id2, koli2 = 0;
      for (DepodakiUrun depodaki : depodakiUrunler) {
        id2 = depodaki.getUrunId();
        if (id1 == id2) {
          koli2++;
        }
      }

      if (koli2 < koli1) {
        return false;
      }
    }

    return true;
  }

  // Depodan çıkışı kabul edilen ürünlerin kolilerini,
  // tabDepodakiler tablosundan çıkarıp, tabGidenler tablosuna ekleyen metod
  public ArrayList<DepodakiUrun> yolla(ArrayList<GidenUrun> gidenUrunler) {
    ArrayList<DepodakiUrun> gidenlerinYerleri = new ArrayList<>();

    int id, koli;
    for (GidenUrun giden : gidenUrunler) {
      id = giden.getUrunId();
      koli = giden.getKoliToplam();

      DB.ekle(giden);
      for (int i = 0; i < DEPOBLOK; i++) {
        for (int j = 0; j < BLOKRAF; j++) {
          for (int k = 0; k < RAFBOLME; k++) {
            for (int l = 0; l < BOLMEKOLI; l++) {
              if (TUMYERLER[i][j][k][l] == id && koli > 0) {
                koli--;
                TUMYERLER[i][j][k][l] = 0;

                // tabDepodakiler tablosundan silme işlemi
                DepodakiUrun depodaki = new DepodakiUrun(0, id, i, j, k, l);
                DB.sil(depodaki);

                // PDF çıktısında depodaki nesnesine ihtiyacımız olacak
                gidenlerinYerleri.add(depodaki);
              }
            }
          }
        }
      }
    }

    return gidenlerinYerleri;
  }
}
