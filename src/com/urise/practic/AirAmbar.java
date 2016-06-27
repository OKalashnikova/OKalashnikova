package com.urise.practic;

import java.util.Arrays;

/**
 - Реализовать эмулятор стоянки самолётов-стэк.
 Размер стоянки ­ 5- мест.
 Работать должно быть следующим образом:
 вводим в консоль бортовые номера самолётов, и программа их запоминает (“ставит” их на стоянку).
 При вводе команды “exitAll” программа должна распечатать номера самолётов в порядке покидания стоянки
 (и удалить их все из памяти).
 При вводе “exitLast” ­ должна распечатать и удалить из памяти только тот самолёт, который сейчас выезжает.
 Если стоянка заполнена полностью, следующему самолёту должно быть отказано во въезде.
 */
public class AirAmbar {
    int limitPlace=5;
    Airplaine[] station = new Airplaine[limitPlace];
    int size = 0;

    public void save(Airplaine bortNumber){
        for(int i=0; i<limitPlace; i++){
            if(station[i]==null){
                station[i]=bortNumber;
                size++;
                break;
            }
        }
        if(size == limitPlace){
        System.out.println("The station is full!");}
    }

    public void exitAll() {
        for (int i = size-1; i >= 0; i--) {
            Airplaine num = station[i];
            System.out.println("The Airplane number is " + num);
            station[i] = null;
        }
        size = 0;
    }

    public void exitLast(){
        Airplaine num = station[size-1];
        System.out.println("The Airplane number is " + num);
        station[limitPlace-1]=null;
        size--;
    }

    public Airplaine[] getAll(){
        return Arrays.copyOfRange(station, 0, size);

       }
    }






