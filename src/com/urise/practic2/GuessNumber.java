package com.urise.practic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Created by O&J on 28.06.2016.
 */
public class GuessNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxNumb = 1001;
        int minNumb = 0;
        int attempCount = 0;


        for (; ; ) {
            int expectedNumb = minNumb + (maxNumb - minNumb) / 2; //предполагаем - какого числа больше или меньше загаданное
            System.out.println("Если Ваше число больше " + expectedNumb + " - нажмите 1, если меньше - нажмите 0. Если угадал - нажмите 2");
            String input = reader.readLine();

            if (input.length() < 0 || !isNumber(input)) {
                System.out.println("некорректный ввод!");
                continue;
            }

            int a = Integer.parseInt(input);


            if (a==0) {
                maxNumb = expectedNumb;
            }

            if (a == 1) {
                minNumb = expectedNumb;
            }

            if (a == 2) {
                System.out.println("Я угадал ваше число с " + attempCount + " попытки");
                break;
            }


            attempCount++;
        }


    }

    public static boolean isNumber(String testString) { //регулярное выражение, которое проверяет - то, что ввели в консоль - является числом или нет?
        return testString.matches("[\\w+]{1,4}");

    }
}