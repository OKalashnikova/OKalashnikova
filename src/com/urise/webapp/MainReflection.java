package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;

/**
 * Created by O&J on 31.07.2016.
 */
public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new uuid");
        // Na 13 minute H/W Вызвать метод toString() у резюме через отражение TODO: invoke r.toString via Reflection
        System.out.println(r);

    }
}
