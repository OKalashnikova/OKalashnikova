package com.urise.practic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class GetNumber {

    private static int a;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxNumb = 1000;
        int minNumb = 1;
        int attempCount = 0;
        int expectedNuumb = (int) (1000 * Math.random());

        for (; ; ){
            System.out.println("Введите число: ");
            String input = reader.readLine();
            if(input.length() < 1 || !isNumber(input)) {
                System.out.println("некорректный ввод!");
                continue;
            }
            int a = Integer.parseInt(input);
            if(Objects.equals(a,expectedNuumb)) {
                System.out.println("Угадали! с попытки № " + attempCount);
                break;
            }
            else if(a > maxNumb)
                System.out.println("Вы ввелии число большее максимума");
            else if(a < minNumb)
                System.out.println("Вы ввелии число меньшее минимума");
            else if (a > expectedNuumb){
                System.out.println("Вы ввелии число большее загаданого");
                maxNumb = a;
            }
            else if (a < expectedNuumb) {
                System.out.println("Вы ввелии число меньшее загаданого");
                minNumb = a;
            }
            attempCount++;
        }


    }




    public static boolean isNumber(String testString) {
        return testString.matches("[\\w+]{1,4}");

    }

}