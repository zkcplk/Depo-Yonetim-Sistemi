//
// Hesap.java
//
package Siniflar;

import static Siniflar.Sabitler.DB;
import static Siniflar.Sabitler.KAPASITE;
import java.util.ArrayList;
import java.util.HashMap;

public class Hesap {
  private final ArrayList<Urun> tabUrunler;
  private final ArrayList<Uretici> tabUreticiler;
  private final ArrayList<Magaza> tabMagazalar;
  private final ArrayList<GelenUrun> tabGelenler;
  private final ArrayList<GidenUrun> tabGidenler;
  private final ArrayList<DepodakiUrun> tabDepodakiler;
  private final ArrayList<Personel> tabPersoneller;

  public Hesap() {
    tabUrunler = DB.okuUrunler();
    tabGelenler = DB.okuGelenler();
    tabGidenler = DB.okuGidenler();
    tabDepodakiler = DB.okuDepodakiler();
    tabUreticiler = DB.okuUreticiler();
    tabMagazalar = DB.okuMagazalar();
    tabPersoneller = DB.okuPersoneller();
  }

  public String[] enCokEnAzBulunanUrunler() {
    HashMap<Integer, Integer> urunler = new HashMap<>();

    for (int i = 0; i < tabDepodakiler.size(); i++) {
      int urunId = tabDepodakiler.get(i).getUrunId();
      urunler.put(urunId, urunler.containsKey(urunId) ? urunler.get(urunId) + 1 : 1);
    }

    int max = 0;
    int min = KAPASITE;
    Urun minUrun = null;
    Urun maxUrun = null;
    for (Urun urun : tabUrunler) {
      int urunId = urun.getId();

      if (urunler.containsKey(urunId) ? urunler.get(urunId) > max : false) {
        max = urunler.get(urun.getId());
        maxUrun = urun;
      }

      if (urunler.containsKey(urunId) ? urunler.get(urunId) < min : false) {
        min = urunler.get(urun.getId());
        minUrun = urun;
      }
    }

    return new String[]{minUrun.getUrunAdi(), maxUrun.getUrunAdi()};
  }

  public String[] enCokEnAzUrunuOlanUreticiler() {
    HashMap<Integer, Integer> ureticiler = new HashMap<>();

    for (int i = 0; i < tabGelenler.size(); i++) {
      int ureticiId = tabGelenler.get(i).getUreticiId();
      int koliToplam = tabGelenler.get(i).getKoliToplam();
      ureticiler.put(ureticiId, ureticiler.containsKey(ureticiId) ? ureticiler.get(ureticiId) + koliToplam : koliToplam);
    }

    int max = 0;
    int min = KAPASITE;
    Uretici minUretici = null;
    Uretici maxUretici = null;
    for (Uretici uretici : tabUreticiler) {
      int ureticiId = uretici.getId();

      if (ureticiler.containsKey(ureticiId) ? ureticiler.get(ureticiId) > max : false) {
        max = ureticiler.get(uretici.getId());
        maxUretici = uretici;
      }

      if (ureticiler.containsKey(ureticiId) ? ureticiler.get(ureticiId) < min : false) {
        min = ureticiler.get(uretici.getId());
        minUretici = uretici;
      }
    }

    return new String[]{minUretici.getAd(), maxUretici.getAd()};
  }

  public String[] enCokEnAzUrunGonderilenMagazalar() {
    HashMap<Integer, Integer> magazalar = new HashMap<>();

    for (int i = 0; i < tabGidenler.size(); i++) {
      int magazaId = tabGidenler.get(i).getMagazaId();
      int koliToplam = tabGidenler.get(i).getKoliToplam();
      magazalar.put(magazaId, magazalar.containsKey(magazaId) ? magazalar.get(magazaId) + koliToplam : koliToplam);
    }

    int max = 0;
    int min = 9999999;
    Magaza minMagaza = null;
    Magaza maxMagaza = null;
    for (Magaza magaza : tabMagazalar) {
      int magazaId = magaza.getId();

      if (magazalar.containsKey(magazaId) ? magazalar.get(magazaId) > max : false) {
        max = magazalar.get(magaza.getId());
        maxMagaza = magaza;
      }

      if (magazalar.containsKey(magazaId) ? magazalar.get(magazaId) < min : false) {
        min = magazalar.get(magaza.getId());
        minMagaza = magaza;
      }
    }

    return new String[]{minMagaza.getAd(), maxMagaza.getAd()};
  }

  public String[] enCokEnAzCalisanPersoneller() {
    HashMap<Integer, Integer> personeller = new HashMap<>();

    for (int i = 0; i < tabGelenler.size(); i++) {
      int personelId = tabGelenler.get(i).getPersonelId();
      int koliToplam = tabGelenler.get(i).getKoliToplam();
      personeller.put(personelId, personeller.containsKey(personelId) ? personeller.get(personelId) + koliToplam : koliToplam);
    }

    for (int i = 0; i < tabGidenler.size(); i++) {
      int personelId = tabGidenler.get(i).getPersonelId();
      int koliToplam = tabGidenler.get(i).getKoliToplam();
      personeller.put(personelId, personeller.containsKey(personelId) ? personeller.get(personelId) + koliToplam : koliToplam);
    }

    int max = 0;
    int min = Integer.MAX_VALUE;
    Personel minPersonel = null;
    Personel maxPersonel = null;
    for (Personel personel : tabPersoneller) {
      int personelId = personel.getId();

      if (personeller.containsKey(personelId) ? personeller.get(personelId) > max : false) {
        max = personeller.get(personel.getId());
        maxPersonel = personel;
      }

      if (personeller.containsKey(personelId) ? personeller.get(personelId) < min : false) {
        min = personeller.get(personel.getId());
        minPersonel = personel;
      }
    }

    return new String[]{
      minPersonel.getAdSoyad() + " (" + minPersonel.getKullaniciAdi() + ")",
      maxPersonel.getAdSoyad() + " (" + maxPersonel.getKullaniciAdi() + ")"
    };
  }

  public double[] toplamKoliDolulukOrani() {
    // Farkl?? ??r??nlerin depodaki ayr?? ayr?? toplamlar??n?? d??nd??ren liste.
    int[][] liste = DB.sayUrunler();

    int toplamKoli = 0;
    int size = liste.length;
    for (int i = 0; i < size; i++) {
      int urunKoli = liste[i][1];
      toplamKoli += urunKoli;
    }

    double dolulukOrani = ((int) (((toplamKoli * 100.0 / KAPASITE)) * 100) / 100.0);

    return new double[]{toplamKoli, dolulukOrani};
  }

  public double ortalamaUrunBasinaKoli() {
    int urunSayisi = DB.sayUrunler().length;
    double toplamKoli = toplamKoliDolulukOrani()[0];

    return ((int) (toplamKoli * 100 / urunSayisi)) / 100.0;
  }

  public double ortalamaPersonelBasinaKoli() {
    HashMap<Integer, Integer> personeller = new HashMap<>();
    int toplamKoli = 0;

    int size1 = tabGelenler.size();
    for (int i = 0; i < size1; i++) {
      int personelId = tabGelenler.get(i).getPersonelId();
      toplamKoli += tabGelenler.get(i).getKoliToplam();
      personeller.put(personelId, personeller.containsKey(personelId) ? personeller.get(personelId) + 1 : 1);
    }

    int size2 = tabGidenler.size();
    for (int i = 0; i < size2; i++) {
      int personelId = tabGidenler.get(i).getPersonelId();
      toplamKoli += tabGidenler.get(i).getKoliToplam();
      personeller.put(personelId, personeller.containsKey(personelId) ? personeller.get(personelId) + 1 : 1);
    }

    // Burada tabPersoneller listesindeki her personel yok!
    // Sadece i?? yapm???? olanlar hesaplamaya dahil ediliyor.
    int personelSayisi = personeller.size();

    return (int) (toplamKoli * 100 / personelSayisi) / 100.0;
  }

  public double ortalamaUreticiBasinaKoli() {
    HashMap<Integer, Integer> ureticiler = new HashMap<>();
    int toplamKoli = 0;

    for (int i = 0; i < tabGelenler.size(); i++) {
      int ureticiId = tabGelenler.get(i).getUreticiId();
      toplamKoli += tabGelenler.get(i).getKoliToplam();
      ureticiler.put(ureticiId, ureticiler.containsKey(ureticiId) ? ureticiler.get(ureticiId) + 1 : 1);
    }

    // Burada tabUreticiler listesindeki her ??retici yok!
    // Sadece ??r??n getirmi?? olanlar hesaplamaya dahil ediliyor.
    int ureticiSayisi = ureticiler.size();

    return (int) (toplamKoli * 100 / ureticiSayisi) / 100.0;
  }

  public double ortalamaMagazaBasinaKoli() {
    HashMap<Integer, Integer> magazalar = new HashMap<>();
    int toplamKoli = 0;

    for (int i = 0; i < tabGidenler.size(); i++) {
      int magazaId = tabGidenler.get(i).getMagazaId();
      toplamKoli += tabGidenler.get(i).getKoliToplam();
      magazalar.put(magazaId, magazalar.containsKey(magazaId) ? magazalar.get(magazaId) + 1 : 1);
    }

    // Burada tabMagazalar listesindeki her magaza yok!
    // Sadece ??r??n g??nderilmi?? olanlar hesaplamaya dahil ediliyor.
    int magazaSayisi = magazalar.size();

    return (int) (toplamKoli * 100 / magazaSayisi) / 100.0;
  }

  public Object[][] istatistikHesapla() {
    Object[][] istatistikler = new Object[14][];

    istatistikler[0] = new Object[]{"Deponun Doluluk Oran??", "% " + toplamKoliDolulukOrani()[1]};
    istatistikler[1] = new Object[]{"Depoda bulunan toplam koli say??s??", "" + (int) toplamKoliDolulukOrani()[0]};
    istatistikler[2] = new Object[]{"Depoda bulunan her bir ??e??it ??r??n??n ortalama koli say??s??", "" + ortalamaUrunBasinaKoli()};
    istatistikler[3] = new Object[]{"Her bir ??reticinin depoya getirdi??i ortalama koli say??s??", "" + ortalamaUreticiBasinaKoli()};
    istatistikler[4] = new Object[]{"Her bir ma??azaya g??nderilen ortalama koli say??s??", "" + ortalamaMagazaBasinaKoli()};
    istatistikler[5] = new Object[]{"Her bir personelin ta????d?????? ortalama koli say??s??", "" + ortalamaPersonelBasinaKoli()};
    istatistikler[6] = new Object[]{"Depoda en az bulunan ??r??n", enCokEnAzBulunanUrunler()[0]};
    istatistikler[7] = new Object[]{"Depoda en ??ok bulunan ??r??n", enCokEnAzBulunanUrunler()[1]};
    istatistikler[8] = new Object[]{"Depoya en az ??r??n getirmi?? olan ??retici", enCokEnAzUrunuOlanUreticiler()[0]};
    istatistikler[9] = new Object[]{"Depoya en ??ok ??r??n getirmi?? olan ??retici", enCokEnAzUrunuOlanUreticiler()[1]};
    istatistikler[10] = new Object[]{"En az ??r??n g??nderilmi?? olan ma??aza", enCokEnAzUrunGonderilenMagazalar()[0]};
    istatistikler[11] = new Object[]{"En ??ok ??r??n g??nderilmi?? olan ma??aza", enCokEnAzUrunGonderilenMagazalar()[1]};
    istatistikler[12] = new Object[]{"Depoda en az ??al????an personel", enCokEnAzCalisanPersoneller()[0]};
    istatistikler[13] = new Object[]{"Depoda en ??ok ??al????an personel", enCokEnAzCalisanPersoneller()[1]};

    return istatistikler;
  }
}
