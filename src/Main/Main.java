// ------------------------
//   DEPO YÖNETİM SİSTEMİ
//
//   Zeki ÇIPLAK
//   github.com/zkcplk
// ------------------------
package Main;

import Arayuzler.Login;
import Siniflar.DepodakiUrun;
import static Siniflar.Sabitler.DB;
import static Siniflar.Sabitler.TUMYERLER;
import java.util.ArrayList;

public class Main {
  public static void main(String args[]) {
    // Veritabanı bağlantı kontrolü.
    if (DB.baglan()) {
      DB.kapat();

      // Tablolarda eksiklik varsa, default ayarlar yüklenir.
      if (!DB.tabloKontrol()) {
        System.out.println("HATA : Bazı tablolar eksik! "
                + "Sistem, default verilerle yeniden oluşturuldu!");

        DB.tabloOlustur();
        DB.tabloYukle();
      }
    } else {
      System.out.println("HATA : Veritabanına bağlanılamadı!");
      return;
    }

    // Depoda bulunan kolilerin yerleri, dört boyutlu diziye yüklenir.
    ArrayList<DepodakiUrun> tabDepodakiler = DB.okuDepodakiler();
    int x, y, z, t;
    for (DepodakiUrun depodaki : tabDepodakiler) {
      x = depodaki.getBlokId();
      y = depodaki.getRafId();
      z = depodaki.getBolmeId();
      t = depodaki.getKoliId();
      TUMYERLER[x][y][z][t] = depodaki.getUrunId();
    }

    // Login paneli çağırılır.
    new Login().setVisible(true);
  }
}
