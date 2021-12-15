//
// Sabitler.java
//
package Siniflar;

import Veritabani.SQLite;
import Veritabani.SoyutDB;
import javax.swing.filechooser.FileSystemView;

public class Sabitler {
  // Veritabanı yolu
  public static final String DBPATH = "test.db";

  // Depodaki blok sayısı
  public static final int DEPOBLOK = 6;

  // Bir bloktaki raf sayısı
  public static final int BLOKRAF = 5;

  // Bir raftaki bölme sayısı
  public static final int RAFBOLME = 20;

  // Bir bölmedeki maksimum koli sayısı
  public static final int BOLMEKOLI = 10;

  // Programı anlık olarak çalıştıran personelin id'si
  public static int PERSONELID;

  // Programı anlık olarak çalıştıran personelin adı ve soyadı
  public static String PERSONELAD;

  // Programı anlık olarak çalıştıran personelin kullanıcı adı
  public static String PERSONELUSER;

  // Programın temel icon dosyası
  public static final String APPICON = "Arayuzler/images/depo.png";

  // Programın kullandığı tema // Nimbus, Windows Classic vs. de olabilir.
  public static final String TEMA = "Windows";

  // Deponun alabileceği maksimum koli sayısı
  public static final int KAPASITE = DEPOBLOK * BLOKRAF * RAFBOLME * BOLMEKOLI;

  // Depodaki kolilerin blok, raf, bölme ve koli numaralarını tutan 4 boyutlu dizi
  public static int[][][][] TUMYERLER = new int[DEPOBLOK][BLOKRAF][RAFBOLME][BOLMEKOLI];

  // Veritabanı bağlantısının kurulması
  public static SoyutDB DB = new SQLite(DBPATH);

  // Çok kullanılan fonksiyonlar için nesne oluşturulması
  public static Fonksiyonlar FONK = new Fonksiyonlar();

  // Bilgisayarın masaüstü adresi
  public static final String DESKTOP = FileSystemView.getFileSystemView().getHomeDirectory().toString();
}
