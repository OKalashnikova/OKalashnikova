package com.urise.practic3;

import java.util.Scanner;

/**
 * Created by O&J on 12.07.2016.
 */
public class Trenning {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = in.nextLine();
        System.out.println("How old are you?");
        int age = in.nextInt();

        System.out.printf("Hello, %s. This year, you'll be %d.\n", name, age+1);

        String message = String.format("Hello, %s. This year, you'll be %d.\n", name, age+1);
    }
}
