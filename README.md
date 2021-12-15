# Depo Yönetim Sistemi
Depo Yönetim Sistemi (Warehouse Management System)

Bu proje, kimyasal ürün satan bir firmanın belli başlı ürünlerini barındırdığı bir depoda kullanılacak olan yazılımdır. Yazılım, Java programlama diliyle oluşturulmuştur. Depo’da blok denilen katlı ve uzun raf sistemleri ve her rafta, çeşitli ürünleri barındıran standart kolilerin yer aldığı raf bölmeleri bulunmaktadır. Depo kendi içinde kompozit bir yapıya sahiptir. 

Depo, tüm blokları; bloklar, rafları; raflar, bölmeleri; bölmeler, kolileri ve koliler de ürünleri kapsamaktadır. Depo’nun kuşbakışı ve temsili bir görünümü aşağıdaki resimde gösterilmiştir.

![Depo Planı](https://github.com/zkcplk/Depo-Yonetim-Sistemi/blob/main/images/DepoTemsiliResim.png)

Depo 6 adet bloktan oluşmaktadır. Her blok, 5 raftan ve her raf 20 bölmeden oluşmaktadır. Her bir bölmeye 10 adet eşit büyüklükte standart koli yerleştirilebilmektedir. Deponun toplam koli kapasitesi, 6 x 5 x 20 x 10 = 6000 kolidir.

Depoya üretici firmalardan sürekli olarak ürünler gelmekte ve ilgili ürünler depodan, ilgili mağazalara gönderilmek üzere yola çıkarılmaktadır. Program, bu giriş/çıkış hareketlerini depoda çalışan personeller eliyle gerçekleştirmektedir. 

# Login
Programı kullananlara ilk görünecek arayüzdür. Kullanıcı adı ve şifre olmadan sisteme girmek mümkün değildir. Kullanıcı adı ve şifre bilgileri girilerek, “Giriş Yap” butonuna basılır. Varsayılan yönetici kullanıcı adı **root** ve şifresi **101**'dir.

![Login paneli](https://github.com/zkcplk/Depo-Yonetim-Sistemi/blob/main/images/Login.png)

İki tip kullanıcı bulunur. Bunlar Root (Yönetici) ve Personel kullanıcılarıdır. Sisteme giriş yapıldıktan sonra, giriş yapanın türüne göre farklı arayüzler gösterilir.

# Admin Paneli
![Admin (Yönetici) Paneli](https://github.com/zkcplk/Depo-Yonetim-Sistemi/blob/main/images/AdminPanel.png)

# Personel Paneli
![Personel Paneli](https://github.com/zkcplk/Depo-Yonetim-Sistemi/blob/main/images/PersonelPanel.png)

# Arama Paneli
Tüm kullanıcıların ortak olarak erişim sağlayabildiği arayüzlerden biri de Arama Paneli'dir. Kullanıcılar çeşitli kriterlere göre arama yapabilir. Toplam 6 adet sekme
bulunur. Her bir sekmede ayrı bir işlem gerçekleştirilir ve tüm işlemler için PDF çıktısı alınabilir.

![Arama Paneli - Ürün Sayım Sekmesi](https://github.com/zkcplk/Depo-Yonetim-Sistemi/blob/main/images/AramaPanelUrunSayim.png)

# Depoya Ürün Giriş Paneli
![Arama Paneli - Ürün Sayım Sekmesi](https://github.com/zkcplk/Depo-Yonetim-Sistemi/blob/main/images/UrunGelisi.png)

# Depodan Ürün Çıkış Paneli
![Arama Paneli - Ürün Sayım Sekmesi](https://github.com/zkcplk/Depo-Yonetim-Sistemi/blob/main/images/UrunGidisi.png)

Daha fazla ayrıntı için [analiz](https://github.com/zkcplk/Depo-Yonetim-Sistemi/blob/main/analiz.pdf) dosyasını inceleyebilirsiniz.

