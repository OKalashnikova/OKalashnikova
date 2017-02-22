package com.urise.webapp.util;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by OK on 21.02.2017.
 */
public class DateUtil {
    public static LocalDate of(int year, Month month){
        return LocalDate.of(year, month, 1);
    }
}
