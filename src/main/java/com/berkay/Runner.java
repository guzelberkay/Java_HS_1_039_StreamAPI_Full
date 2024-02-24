package com.berkay;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        /**
         * *****   Java Stream API   *****
         * ---------
         * Stream nedir? (AKIS)
         * Bir youtube videosu çektiğinizi ve yüklediğinizi var sayalım
         * ve video boyutu 300mb olsun.
         * 11 Senaryo -> önce video kullanıcının bilgisayarına indirilir, sonra kullanıcı videoyu
         * kesintisiz bir şekilde izlemeye başlar.
         * Sorunlar;
         * - çok uzun zaman alabilir.
         * - fazla boyutlu bir video indirmek istediğimiz için kotanız dolabilir.
         * - bir videoyu sadece göz gezdirmek için bile açsan beklemek zorundasın.
         * - sunucu tarafından fazlaca yük oluşur.
         *
         * 2. Senaryo -> video olabildiğince küçük parçalara bölünür ve her bir parça ayrı
         * ayrı indirilir, bu indirme islemi kullanıcı bir sonraki parçayı izlemek istediğinde
         * ya da ona akış olarak yaklaştığında indirilir.
         * **** Stream ****
         */

        Stream<String> bosStream = Stream.empty(); // Boş bir stream oluşturduk yani count ->0
        System.out.println("bosStream = " + bosStream.count());
        // System.out.println("bosStream = " + bosStream.count());  //Hata -> stream has already been operated upon or closed

        Stream<String> tekKayit = Stream.of("Berkay"); // count -> 1
        System.out.println("tekKayit = " + tekKayit.count());

        Stream<String> cokluStream = Stream.of("Berkay", "Muhammet", "Yusuf"); // count -> 3
        System.out.println("cokluSTream = " + cokluStream.count());
/**
 * Stream API ,
 * kendi başına fonksiyonel programlamayı içerisinde barındıran bir yapıdır.
 * Genel olarak tüm uygulamalarda data saklamak için Collections kullanırız, ancak bu dataları
 * işlemek için  Stream kullanmamız gerekmektedir.
 * ------------
 * Peki Collections lar stream a nasıl dönüşür?
 *
 */
        List<String> haftaninGunleri = List.of("Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma", "Cumartesi", "Pazar");
        Stream<String> streamHaftaninGunleri = haftaninGunleri.stream();
        /**
         * yukarıda yaptığımız işlem = elimizde var olan bir listemiz var bunu stream a çevirdik.
         */
        streamHaftaninGunleri.filter(gun -> gun.contains("i")).forEach(System.out::println);
        // streamHaftaninGunleri.filter(gun -> gun.contains("e")).forEach(System.out::println);
/**
 * Çok mantıksız, çünkü sadece bir kere kullanabileceğim bir yapıyı ne yapayım.
 */

        haftaninGunleri.stream().filter(gun -> gun.contains("i")).forEach(System.out::println);
        haftaninGunleri.stream().filter(gun -> gun.contains("s")).forEach(System.out::println);
        haftaninGunleri.stream().filter(gun -> gun.contains("C")).forEach(System.out::println);
        haftaninGunleri.stream().filter(gun -> gun.contains("s")).forEach(System.out::println);

        /**
         ********** STREAM FONKSİYONLARI **********
         * 1- Sonsuz Streamlar
         */
        Stream<Double> sonsuzSayiDizisi = Stream.generate(Math::random); //0-1 arasında rasgele sayı üretir.
        /**
         * Yukarıdaki Stream ın bize maliyet suan 0. Ancak kullanmaya başladıkça biz bırakana kadar
         * maliyeti artacaktır.
         */
//        sonsuzSayiDizisi.forEach(sayi -> {
//            System.out.println("sayi = " + sayi);
//            try {
//                Thread.sleep(1_000L);
//
//            } catch (Exception exception) {
//
//            }
//        });

        Stream<Integer> sayilar = Stream.iterate(1000, s -> s + 1);

        Stream<Integer> sonsuzSonlusayilar = Stream.iterate(400_000, s -> s < 402_000, s -> s + 150);
//        sonsuzSonlusayilar.forEach(sayi -> {
//            System.out.println("sayi = " + sayi);
//            try {
//                Thread.sleep(1_000L);
//
//            } catch (Exception exception) {
//
//            }
//        });
        /**
         *  ** reeduce **
         *
         */
        String[] adiniz = new String[]{"B", "E", "R", "K", "A", "Y"};
        StringBuilder isminiz = new StringBuilder();
        for (String ad : adiniz)
            isminiz.append(ad);

        Stream<String> streamAdiniz = Stream.of("B", "E", "R", "K", "A", "Y");
        String ifade = streamAdiniz.reduce("", (x, y) -> x + y);
        System.out.println("ifade : " + ifade);

        Stream<Integer> ogrenciNotlari = Stream.of(56, 87, 34, 98, 32, 50); //Boost Ogrenci Notları
        Integer toplam = ogrenciNotlari.reduce(0, (x, y) -> x + y);
        System.out.println("ortalama....: " + (toplam / 6));

        ogrenciNotlari = Stream.of(56, 87, null, 98, 32, 50);
        /**
         * if(true) bunu yap
         * else başka birşey yap
         * (KURAL)? bunu yap: başka birşey yap
         */
        toplam = ogrenciNotlari.reduce(0, (x, y) -> y != null ? x + y : x);

//        toplam = ogrenciNotlari.reduce(0, (x, y) -> {
//            if (y != null)
//                x + y;
//            else x;
//        });
        System.out.println("ortalama....: " + (toplam / 6));

        /**
         *
         * min, max, avg, count, sum ...
         * optional data type
         */
        Stream<String> isimListesi = Stream.of("Ahmet","Deniz","Muhammet","Derya","Ayse," +
                "Ali","Ecrin","Lutfu","Duran","Ay","Turunc");
        // Adının uzunluğu en küçük olan kişinin adını yazdıran kodu yazdırınız.
        String enKisaIsim = isimListesi
                .min((mevcutIsim, sonrakiIsim) -> mevcutIsim.length()-sonrakiIsim.length())
                .orElse("");
        System.out.println(enKisaIsim);

//        Stream<Integer> satisTutari = Stream.of(12_000,4_500,null,321_000,56_000);
//        int enBuyukSatis = satisTutari.max((x,y) -> x.compareTo(y)).orElse(-1);
//        System.out.println("En Buyuk Satis : "+enBuyukSatis);
//        Stream<Satis> satisListesi = Stream.of(
//                new Satis("Seker",1_258)
//        );

    }// main sonu


}
