package com.urise.practic3.Less5;

/**
 * Created by O&J on 17.07.2016.
 */
public class Lesson5 {

        public static void main(String[] args) {
            String palindrome = "Dot saw I was Tod";
            int len = palindrome.length();
            char[] tempCharArray = new char[len];
            char[] charArray = new char[len];

            // создадим из строки
            // массив символов
            for (int i = 0; i < len; i++) {
                tempCharArray[i] =
                        palindrome.charAt(i);
            }
            //Мы будем использовать метод charAt(i), который возвращает i-й символ строки, начиная с 0
            // Класс String содержит метод getChars(), который возвращает массив символов, поэтому первый цикл можно заменить строкой:
            //palindrome.getChars(0, len, tempCharArray, 0);

            // перевернем массив символов
            for (int j = 0; j < len; j++) {
                charArray[j] =
                        tempCharArray[len - 1 - j];
            }

            String reversePalindrome =
                    new String(charArray);
            System.out.println(reversePalindrome);
        }
    }

//Следующий код вернет подстроку строки, начиная с 11 символа, но не включая 15, получится слово «roar»
//        String anotherPalindrome = "Niagara. O roar again!";
//       String roar = anotherPalindrome.substring(11, 15);

//http://easy-code.ru/lesson/manipulating-characters-string-java
//StringBuilder:
//http://easy-code.ru/lesson/manipulating-characters-string-java-part2

// String pool
// http://tlazarenko.blogspot.com/2013/10/string-java.html