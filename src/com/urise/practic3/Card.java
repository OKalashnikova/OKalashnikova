package com.urise.practic3;

/**
 * Created by O&J on 30.06.2016.
 */
public class Card {
    String name;
    String number;

    public Card(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
