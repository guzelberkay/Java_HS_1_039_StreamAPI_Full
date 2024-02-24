package com.berkay;

import java.util.Scanner;

public class HarfleriBirlestir {
    public static void main(String[] args) {
        /**
         * Kullanıcıdan 10 harf alacaksunuz ve aldığınız bu harflerin birleşimi sonuc olarak ekrana yazdıran kodu yazınız
         */
String x="";
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            System.out.print("Lutfen " + i + ". harfi giriniz : ");
           String y = new Scanner(System.in).nextLine();
           x +=y;

        }   System.out.print(x);

    }
}

