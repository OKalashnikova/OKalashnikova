package com.urise.practic2;

import java.util.Arrays;

/**
 * Created by O&J on 01.07.2016.
 */
public class Draft {
    public static void main(String[] args) {
        String name1="Ole";
        String name2="Adele";

//        int n1=Integer.parseInt(name1, 10);
//        int n2=Integer.parseInt(name2, 10);

        char[] n1 = name1.toCharArray();
        char[] n2 = name2.toCharArray();

        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
        System.out.println(name1.charAt(0));

    }
}

//http://prologistic.com.ua/kak-preobrazovat-stroku-string-v-simvol-char-na-java.html

//public class Main {
//
//    public static void main(String[] args) {
//        // write your code here
//        char a = 'a';
//        System.out.println((int)a);
//    }
//}