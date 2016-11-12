package com.urise.webapp;


/**
 * Created by OK on 10.11.2016.
 */
public class MainString {
    public static void main(String[] args) {
        String[] strArray = new String[]{"1", "2", "3", "4", "5"};
//        String result = "";
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str).append(", ");
        }
        System.out.println(sb.toString());
        // StringBuffer - не создает новый объект, а обновляет существующий

        // String internal pull - Позволяет сравнивать два одинаковых объекта, при помощи того, что
        // присваивает им ссылку на один и тот же объект. Действие происходит не в рантайме, поэтому
        // компилятор ищет в памяти существующий такой объект

        String str1 = "abc";
        String str3 = "c";
        String str2 = ("ab" + str3).intern();
        System.out.println(str1 == str2);

    }
}
