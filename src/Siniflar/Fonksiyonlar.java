//
//  Fonksiyonlar.java
//
package Siniflar;

import static Siniflar.Sabitler.APPICON;
import static Siniflar.Sabitler.DB;
import static Siniflar.Sabitler.PERSONELAD;
import static Siniflar.Sabitler.PERSONELID;
import static Siniflar.Sabitler.PERSONELUSER;
import static Siniflar.Sabitler.TEMA;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

public class Fonksiyonlar {
  public Personel kontrolUserPass(String user, String pass) {
    ArrayList<Personel> tabPersoneller = DB.okuPersoneller();

    for (Personel personel : tabPersoneller) {
      if (user.equals(personel.getKullaniciAdi()) && pass.equals(personel.getSifre())) {
        PERSONELID = personel.getId();
        PERSONELAD = personel.getAdSoyad();
        PERSONELUSER = personel.getKullaniciAdi();

        return personel;
      }
    }

    return null;
  }

  public void startWindowsTheme() {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info
              : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if (TEMA.equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | IllegalAccessException
            | InstantiationException | UnsupportedLookAndFeelException ex) {
      System.out.println("startWindowsTheme() hatası: " + ex);
    }
  }

  public void setIcon(JFrame frame) {
    java.net.URL url = ClassLoader.getSystemResource(APPICON);
    Toolkit kit = Toolkit.getDefaultToolkit();
    Image img = kit.createImage(url);
    frame.setIconImage(img);
  }

  //  unixToTarih(1588453200, "dd-MM-yyyy");
  public String unixToTarih(long unixTime, String format) {
    Date date = new java.util.Date(unixTime * 1000L);
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(date);
  }

  //  tarihToUnix("04-05-2020","dd-MM-yyyy");
  public long tarihToUnix(String tarih, String format) {
    Date date = new java.util.Date();
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    try {
      date = sdf.parse(tarih);
    } catch (ParseException hata) {
      System.out.println("tarihToUnix() hatası: " + hata.getMessage());
    }
    return date.getTime() / 1000L;
  }

  public String[] minMaxGunAySene(String format) {
    long[] tarihler = new long[4];
    tarihler[0] = DB.maxTarihGelenler();
    tarihler[1] = DB.maxTarihGidenler();
    tarihler[2] = DB.minTarihGelenler();
    tarihler[3] = DB.minTarihGidenler();

    long minTarih = Integer.MAX_VALUE, maxTarih = 0;
    for (int i = 0; i < 4; i++) {
      if (tarihler[i] < minTarih) {
        minTarih = tarihler[i];
      }

      if (tarihler[i] > maxTarih) {
        maxTarih = tarihler[i];
      }
    }

    maxTarih += 86400;

    String[] cmbTarihler = new String[6];

    String maxGunAySene = unixToTarih(maxTarih, format);
    String minGunAySene = unixToTarih(minTarih, format);

    cmbTarihler[0] = minGunAySene.split("-")[0];
    cmbTarihler[1] = minGunAySene.split("-")[1];
    cmbTarihler[2] = minGunAySene.split("-")[2];

    cmbTarihler[3] = maxGunAySene.split("-")[0];
    cmbTarihler[4] = maxGunAySene.split("-")[1];
    cmbTarihler[5] = maxGunAySene.split("-")[2];

    return cmbTarihler;
  }

  // kontrolTarih("20190228");
  public boolean kontrolTarih(String tarih) {
    DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
    try {
      LocalDate.parse(tarih, dateFormatter);
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
