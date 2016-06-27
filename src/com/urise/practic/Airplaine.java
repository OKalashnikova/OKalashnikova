package com.urise.practic;

/**
 * Created by O&J on 27.06.2016.
 */
public class Airplaine {
    String bortNumber;


    public String getBortNumber() {
        return bortNumber;
    }

    public void setBortNumber(String bortNumber) {
        this.bortNumber = bortNumber;
    }

    @Override
    public String toString() {
        return bortNumber;
    }
}
