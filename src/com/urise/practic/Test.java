package com.urise.practic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by O&J on 27.06.2016.
 */
public class Test {
    public static final AirAmbar AIR_AMBAR = new AirAmbar();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Введите одну из команд: (save | free | last | exit):");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 2) {
                System.out.println("Bad command");
                continue;
            }
            if (params.length == 2) {
                params[1] = params[1].intern();
            }
            switch (params[0]) {
                case "save":
                    Airplaine a = new Airplaine();
                    a.setBortNumber(params[1]);
                    AIR_AMBAR.save(a);
                    printAll();
                    break;
                case "last":
                    AIR_AMBAR.exitLast();
                    printAll();
                    break;
                case "free":
                    AIR_AMBAR.exitAll();
                    printAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Bad command");
                    break;
            }
        }}

    static void printAll() {
        Airplaine[] all = AIR_AMBAR.getAll();
        System.out.println("----------------------------");
        if (all.length == 0) {
            System.out.println("Empty");
        } else {
            for (Airplaine a : all) {
                System.out.println(a);
            }
        }
        System.out.println("----------------------------");
    }
}


