package com.urise.practic3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * - Написать программу, которая будет выдавать имя владельца автомобиля по его номеру.
 * Программа должна быть умной: если у неё в памяти номера нет, она должна попросить ввести его имя и запомнить.
 */
public class List {

    private static final int LIMIT = 10;
    Card[] cardList = new Card[LIMIT];
    private int size = 0;

    public void save(String number) throws IOException {
        BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<size+1; i++){
            if(cardList[i]==null){
//                cardList[i].equals(number);
                System.out.println("Введите имя владельца машины");
                String name = n.readLine();
                cardList[i].equals(new Card(name, number));
            }
        }
    }

//    public void search (String number){
//        for (int i =0; i< size+1; i++){
//            if (cardList[i].equals(number)){
//                System.out.println("Запрашиваемые данные: " + Card(getName, ));
//            }
//        }
//
//    }


    public static boolean isCarNumber(String testString) {
        return testString.matches("[АВЕКМНОРСТУХD][\\w+]{3}[АВЕКМНОРСТУХD]{2}");
    }

}


//MAP
//    public static boolean isCarNumber(String testString) {
//        return testString.matches("[АВЕКМНОРСТУХD][\\w+]{3}[АВЕКМНОРСТУХD]{2}");
//    }
//[A-z]
//        [A-Я][a-я]{2,20}

