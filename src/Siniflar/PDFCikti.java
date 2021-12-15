//
// PDFCikti.java
//
package Siniflar;

import static Siniflar.Sabitler.DESKTOP;
import static Siniflar.Sabitler.FONK;
import com.itextpdf.html2pdf.HtmlConverter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class PDFCikti {
  public static void pdfYap(String html, String dosyaAd, long unixTime) throws FileNotFoundException {
    FileOutputStream fileOutputStream
            = new FileOutputStream(DESKTOP + "/" + dosyaAd + " "
                    + FONK.unixToTarih(unixTime, "dd-MM-yyyy HH_mm_ss")
                    + ".pdf");

    HtmlConverter.convertToPdf(html, fileOutputStream);
  }

  public static String bufferBaslat(long unixTime, String baslik) {
    return "<!doctype html><html lang=\"tr\">"
            + "<head><meta charset=\"utf-8\">"
            + "<title>" + baslik + "</title>"
            + "<style>div{font-family:Arial,Helvetica,sans-serif;display:block;margin:0 auto}.table td{padding:5px;vertical-align:middle}.table-bordered td{border:1px solid #dee2e6}.bg{background-color:#fafaff}.saga{text-align:right}.ortala{text-align:center}h2{font-size:16px}#koliler td,#urunler td{text-align:center}</style>"
            + "</head><body>"
            + "<div style=\"margin-top:50px;max-width:1120px;margin:0 auto\">"
            + "<div><h1 class=\"ortala\"><strong>" + baslik + "</strong></h1>"
            + "<h2 class=\"ortala\">" + FONK.unixToTarih(unixTime, "dd.MM.yyyy HH:mm") + "</h2>"
            + "</div>";
  }

  public static String bufferUreticiEkle(String firma, String adres, String telefon) {
    return "<div><table class=\"table table-bordered\" style=\"width:550px; margin:auto\">"
            + "<tr><td class=\"bg saga\"><b>Üretici Firma: </b></td><td>&nbsp; " + firma + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Üretici Adres: </b></td>"
            + "<td>&nbsp; " + adres + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Üretici Telefon: </b></td><td>&nbsp; " + telefon + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Depo Personeli: </b></td><td>&nbsp; " + Sabitler.PERSONELAD + "</td></tr>"
            + "</table></div>";
  }

  public static String bufferMagazaEkle(String firma, String adres, String telefon) {
    return "<div><table class=\"table table-bordered\" style=\"width:550px; margin:auto\">"
            + "<tr><td class=\"bg saga\"><b>Mağaza: </b></td><td>&nbsp; " + firma + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Mağaza Adres: </b></td>"
            + "<td>&nbsp; " + adres + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Mağaza Telefon: </b></td><td>&nbsp; " + telefon + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Depo Personeli: </b></td><td>&nbsp; " + Sabitler.PERSONELAD + "</td></tr>"
            + "</table></div>";
  }

  public static String bufferUrunlerILK(String baslik) {
    return "<div>&nbsp;</div><div><table id=\"urunler\" class=\"table table-bordered\" style=\"width:300px; margin:auto\">"
            + "<tr><td colspan=\"2\" class=\"bg ortala\"><b>" + baslik + "</b></td></tr>"
            + "<tr><td class=\"bg\"><b>Ürün</b></td><td class=\"bg\"><b>Adet (Koli)</b></td></tr>";
  }

  public static String bufferUrunler(String urun, int adet) {
    return "<tr><td>" + urun + "</td><td>" + adet + "</td></tr>";
  }

  public static String bufferUrunlerSON(int toplam) {
    return "<tr><td class=\"bg\"><b>Toplam Koli Sayısı</b></td><td class=\"bg\"><b>" + toplam + "</b></td></tr></table></div>";
  }

  public static String bufferKolilerILK(String baslik) {
    return "<div>&nbsp;</div><div>"
            + "<table id=\"koliler\" class=\"table table-bordered\" style=\"width:500px; margin:auto\">"
            + "<tr><td colspan=\"5\" class=\"bg ortala\"><b>" + baslik + "</b></td></tr>"
            + "<tr><td class=\"bg\"><b>Ürün</b></td><td class=\"bg\"><b>Blok No</b></td>"
            + "<td class=\"bg\"><b>Raf No</b></td><td class=\"bg\"><b>Bölme No</b></td>"
            + "<td class=\"bg\"><b>Koli No</b></td>"
            + "</tr>";
  }

  public static String bufferKoliler(String urun, int blok, int raf, int bolme, int koli) {
    return "<tr style=\"font-size:10pt\">"
            + "<td>" + urun + "</td>"
            + "<td>" + blok + "</td>"
            + "<td>" + raf + "</td>"
            + "<td>" + bolme + "</td>"
            + "<td>" + koli + "</td>"
            + "</tr>";
  }

  public static String bufferKolilerSON() {
    return "</table></div>";
  }

  public static String bufferBitir() {
    return "</div></body></html>";
  }

  public static String urunSayimPDF(Object[][] tablo,
          long unixTime,
          String urunCesidi,
          String toplamKoli,
          String bosYer,
          String dolulukOrani) {

    String urunSayim = bufferBaslat(unixTime, "ÜRÜN SAYIM SONUCU");

    urunSayim += "<div><table class=\"table table-bordered\" style=\"width:350px; margin:auto\">"
            + "<tr><td class=\"bg saga\"><b>Toplam Ürün Çeşidi: </b></td><td>&nbsp; " + urunCesidi + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Toplam Koli Sayısı: </b></td><td>&nbsp; " + toplamKoli + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Toplam Boş Yer: </b></td><td>&nbsp; " + bosYer + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Depo Doluluk Oranı: </b></td><td>&nbsp; " + dolulukOrani + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>İşlemi Yapan: </b></td><td>&nbsp; " + Sabitler.PERSONELAD + "</td></tr>"
            + "</table></div>";

    urunSayim += "<div>&nbsp;</div><div><table id=\"urunler\" class=\"table table-bordered\" style=\"width:300px; margin:auto\">"
            + "<tr><td colspan=\"3\" class=\"bg ortala\"><b>Depo Ürün Listesi</b></td></tr>"
            + "<tr><td class=\"bg\"><b>Ürün</b></td><td class=\"bg\"><b>Koli</b></td><td class=\"bg\"><b>Adet</b></td></tr>";

    for (Object[] obj : tablo) {
      urunSayim += "<tr style=\"font-size:10pt\">"
              + "<td>" + obj[0] + "</td>"
              + "<td>" + obj[1] + "</td>"
              + "<td>" + obj[2] + "</td>"
              + "</tr>";
    }

    urunSayim += "</table></div>";
    return urunSayim;
  }

  public static String araUrunPDF(ArrayList<Object[]> araUrunListesi, long unixTime, String urun) {
    String urunArama = bufferBaslat(unixTime, "ÜRÜN ARAMA SONUCU");

    urunArama += "<div><table class=\"table table-bordered\" style=\"width:400px; margin:auto\">"
            + "<tr><td class=\"bg saga\"><b>Aranan Ürün: </b></td><td>&nbsp; " + urun + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Toplam Koli Sayısı: </b></td><td>&nbsp; " + araUrunListesi.size() + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>İşlemi Yapan: </b></td><td>&nbsp; " + Sabitler.PERSONELAD + "</td></tr>"
            + "</table></div>";

    urunArama += "<div>&nbsp;</div><div><table id=\"urunler\" class=\"table table-bordered\" style=\"width:300px; margin:auto\">"
            + "<tr><td colspan=\"4\" class=\"bg ortala\"><b>Ürünün bulunduğu yerler</b></td></tr>"
            + "<tr><td class=\"bg\"><b>Ürün</b></td><td class=\"bg\"><b>Raf</b></td>"
            + "<td class=\"bg\"><b>Bölme</b></td><td class=\"bg\"><b>Koli</b></td></tr>";

    for (Object[] obj : araUrunListesi) {
      urunArama += "<tr style=\"font-size:10pt\">"
              + "<td>" + obj[0] + "</td>"
              + "<td>" + obj[1] + "</td>"
              + "<td>" + obj[2] + "</td>"
              + "<td>" + obj[3] + "</td>"
              + "</tr>";
    }

    urunArama += "</table></div>";
    return urunArama;
  }

  public static String araUreticiPDF(ArrayList<Object[]> araUreticiListesi, long unixTime, String uretici, String toplamKoli) {
    String ureticiArama = bufferBaslat(unixTime, "ÜRETİCİ ARAMA SONUCU");

    ureticiArama += "<div><table class=\"table table-bordered\" style=\"width:500px; margin:auto\">"
            + "<tr><td class=\"bg saga\"><b>Aranan Üretici: </b></td><td>&nbsp; " + uretici + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Toplam Koli Sayısı: </b></td><td>&nbsp; " + toplamKoli + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>İşlemi Yapan: </b></td><td>&nbsp; " + Sabitler.PERSONELAD + "</td></tr>"
            + "</table></div>";

    ureticiArama += "<div>&nbsp;</div><div><table id=\"urunler\" class=\"table table-bordered\" style=\"width:500px; margin:auto\">"
            + "<tr><td colspan=\"4\" class=\"bg ortala\"><b>Üreticinin depodaki ürünleri</b></td></tr>"
            + "<tr><td class=\"bg\"><b>Ürün</b></td><td class=\"bg\"><b>Koli</b></td>"
            + "<td class=\"bg\"><b>Personel</b></td><td class=\"bg\"><b>Geliş Tarihi</b></td></tr>";

    for (Object[] obj : araUreticiListesi) {
      ureticiArama += "<tr style=\"font-size:10pt\">"
              + "<td>" + obj[0] + "</td>"
              + "<td>" + obj[1] + "</td>"
              + "<td>" + obj[2] + "</td>"
              + "<td>" + obj[3] + "</td>"
              + "</tr>";
    }

    ureticiArama += "</table></div>";
    return ureticiArama;
  }

  public static String araMagazaPDF(ArrayList<Object[]> araMagazaListesi, long unixTime, String magaza, String toplamKoli) {
    String magazaArama = bufferBaslat(unixTime, "MAĞAZA ARAMA SONUCU");

    magazaArama += "<div><table class=\"table table-bordered\" style=\"width:500px; margin:auto\">"
            + "<tr><td class=\"bg saga\"><b>Aranan Mağaza: </b></td><td>&nbsp; " + magaza + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Toplam Koli Sayısı: </b></td><td>&nbsp; " + toplamKoli + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>İşlemi Yapan: </b></td><td>&nbsp; " + Sabitler.PERSONELAD + "</td></tr>"
            + "</table></div>";

    magazaArama += "<div>&nbsp;</div><div><table id=\"urunler\" class=\"table table-bordered\" style=\"width:500px; margin:auto\">"
            + "<tr><td colspan=\"4\" class=\"bg ortala\"><b>Mağazaya gönderilen ürünler</b></td></tr>"
            + "<tr><td class=\"bg\"><b>Ürün</b></td><td class=\"bg\"><b>Koli</b></td>"
            + "<td class=\"bg\"><b>Personel</b></td><td class=\"bg\"><b>Gidiş Tarihi</b></td></tr>";

    for (Object[] obj : araMagazaListesi) {
      magazaArama += "<tr style=\"font-size:10pt\">"
              + "<td>" + obj[0] + "</td>"
              + "<td>" + obj[1] + "</td>"
              + "<td>" + obj[2] + "</td>"
              + "<td>" + obj[3] + "</td>"
              + "</tr>";
    }

    magazaArama += "</table></div>";
    return magazaArama;
  }

  public static String araPersonelPDF(ArrayList<Object[]> araPersonelListesi, long unixTime, String personel, String toplamKoli) {
    String personelArama = bufferBaslat(unixTime, "PERSONEL ARAMA SONUCU");

    personelArama += "<div><table class=\"table table-bordered\" style=\"width:600px; margin:auto\">"
            + "<tr><td class=\"bg saga\"><b>Aranan Personel: </b></td><td>&nbsp; " + personel + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Toplam Koli Sayısı: </b></td><td>&nbsp; " + toplamKoli + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>İşlemi Yapan: </b></td><td>&nbsp; " + Sabitler.PERSONELAD + "</td></tr>"
            + "</table></div>";

    personelArama += "<div>&nbsp;</div><div><table id=\"urunler\" class=\"table table-bordered\" style=\"width:600px; margin:auto\">"
            + "<tr><td colspan=\"4\" class=\"bg ortala\"><b>Personelin ilgilendiği faaliyetler</b></td></tr>"
            + "<tr><td class=\"bg\"><b>Ürün</b></td><td class=\"bg\"><b>Gelen/Giden</b></td>"
            + "<td class=\"bg\"><b>Koli</b></td><td class=\"bg\"><b>Tarih</b></td></tr>";

    for (Object[] obj : araPersonelListesi) {
      personelArama += "<tr style=\"font-size:10pt\">"
              + "<td>" + obj[0] + "</td>"
              + "<td>" + obj[1] + "</td>"
              + "<td>" + obj[2] + "</td>"
              + "<td>" + obj[3] + "</td>"
              + "</tr>";
    }

    personelArama += "</table></div>";
    return personelArama;
  }

  public static String araTarihPDF(ArrayList<Object[]> araTarihListesi, long unixTime, long min, long max) {
    String tarihArama = bufferBaslat(unixTime, "TARİHSEL ARAMA SONUCU");

    tarihArama += "<div><table class=\"table table-bordered\" style=\"width:600px; margin:auto\">"
            + "<tr><td class=\"bg saga\"><b>Tarih 1: </b></td><td>&nbsp; " + FONK.unixToTarih(min, "dd/MM/yyyy") + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>Tarih 2: </b></td><td>&nbsp; " + FONK.unixToTarih(max, "dd/MM/yyyy") + "</td></tr>"
            + "<tr><td class=\"bg saga\"><b>İşlemi Yapan: </b></td><td>&nbsp; " + Sabitler.PERSONELAD + "</td></tr>"
            + "</table></div>";

    tarihArama += "<div>&nbsp;</div><div><table id=\"urunler\" class=\"table table-bordered\" style=\"width:600px; margin:auto\">"
            + "<tr><td colspan=\"6\" class=\"bg ortala\"><b>Belirtilen tarih aralığındaki faaliyetler</b></td></tr>"
            + "<tr style=\"font-size:10pt\">"
            + "<td class=\"bg\"><b>Ürün</b></td>"
            + "<td class=\"bg\"><b>Gelen/Giden</b></td>"
            + "<td class=\"bg\"><b>Üretici/Mağaza</b></td>"
            + "<td class=\"bg\"><b>Koli</b></td>"
            + "<td class=\"bg\"><b>Personel</b></td>"
            + "<td class=\"bg\"><b>Tarih</b></td>"
            + "</tr>";

    for (Object[] obj : araTarihListesi) {
      tarihArama += "<tr style=\"font-size:10pt\">"
              + "<td>" + obj[0] + "</td>"
              + "<td>" + obj[1] + "</td>"
              + "<td>" + obj[2] + "</td>"
              + "<td>" + obj[3] + "</td>"
              + "<td>" + obj[4] + "</td>"
              + "<td>" + obj[5] + "</td>"
              + "</tr>";
    }

    tarihArama += "</table></div>";
    return tarihArama;
  }

  public static String istatistiklerPDF(long unixTime, Object[][] istatistikler) {
    String istatistik = bufferBaslat(unixTime, "İSTATİSTİKLER TABLOSU");
    istatistik += "<div><table class=\"table table-bordered\" style=\"width:600px; margin:auto\">";

    int size = istatistikler.length;
    for (Object[] obj : istatistikler) {
      istatistik += "<tr>"
              + "<td class=\"bg saga\" style=\"width:55%;\">" + obj[0] + "</b></td>"
              + "<td>&nbsp; " + obj[1] + "</td>"
              + "</tr>";
    }

    istatistik += "</table></div>";
    return istatistik;
  }
}
