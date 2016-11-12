package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by OK on 12.11.2016.
 */
public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Class<? extends Resume> resumeClass = r.getClass();
        Field field = resumeClass.getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        // Na 13 minute H/W Вызвать метод toString() у резюме через отражение TODO: invoke r.toString via Reflection

        Method method = resumeClass.getMethod("toString");
        method.invoke(r);
        Object result = method.invoke(r);
        System.out.println(result);
    }
}