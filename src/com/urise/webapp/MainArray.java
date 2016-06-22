package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Test for com.urise.webapp.storage.ArrayStorage
 */
public class MainArray {
   // static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
    private final static Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Введите одну из команд - (list | save uuid | delete uuid | get uuid | clear | update uuid | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 2) {
                System.out.println("Неверная команда.");
                continue;
            }
            if (params.length == 2) {
                params[1] = params[1].intern();
            }
            switch (params[0]) {
                case "list":
                    printAll();
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE.getSize());
                    break;
                case "save":
                    Resume r = new Resume();
                    r.setUuid(params[1]);
                    ARRAY_STORAGE.save(r);
                    printAll();
                    break;
                case "delete":
                    ARRAY_STORAGE.delete(params[1]);
                    printAll();
                    break;
                case "get":
                    System.out.println(ARRAY_STORAGE.get(params[1]));
                    break;
                case "clear":
                    ARRAY_STORAGE.clear();
                    printAll();
                    break;
                case "update":
                    r = new Resume();
                    r.setUuid(params[1]);
                    ARRAY_STORAGE.update(r);
                    printAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }

    static void printAll() {
        Resume[] all = ARRAY_STORAGE.getAll();
        System.out.println("----------------------------");
        if (all.length == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}

//import java.lang.reflect.Array;
//import java.util.Arrays;
//
//import static com.sun.deploy.config.JREInfo.getAll;

/**
 * Test for com.urise.webapp.storage.com.urise.webapp.storage.ArrayStorage
 */
//public class com.urise.webapp.MainArray {
//     private final static com.urise.webapp.storage.ArrayStorage ARRAY_STORAGE = new com.urise.webapp.storage.ArrayStorage();
//
//    public static void main(String[] args) {
//       final com.urise.webapp.model.Resume r1 = new com.urise.webapp.model.Resume();
//        r1.uuid = "uuid1";
//       final com.urise.webapp.model.Resume r2 = new com.urise.webapp.model.Resume();
//        r2.uuid = "uuid2";
//       final com.urise.webapp.model.Resume r3 = new com.urise.webapp.model.Resume();
//        r3.uuid = "uuid3";
//       final com.urise.webapp.model.Resume r4 = new com.urise.webapp.model.Resume();
//        r4.uuid = "uuid4";
//       final com.urise.webapp.model.Resume r5 = new com.urise.webapp.model.Resume();
//        r5.uuid = "uuid5";
//
//        ARRAY_STORAGE.save(r1);
//        ARRAY_STORAGE.save(r2);
//        ARRAY_STORAGE.save(r3);
//        ARRAY_STORAGE.save(r4);
//        ARRAY_STORAGE.save(r5);
//
//        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.uuid));
//        System.out.println("Get r2: " + ARRAY_STORAGE.get(r2.uuid));
//        System.out.println("Get r3: " + ARRAY_STORAGE.get(r3.uuid));
//        System.out.println("Get r4: " + ARRAY_STORAGE.get(r4.uuid));
//        System.out.println("Get r5: " + ARRAY_STORAGE.get(r5.uuid));
//        System.out.println("Size: " + ARRAY_STORAGE.size);
////        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
//
//
//        ARRAY_STORAGE.delete("uuid2");
//        System.out.println("Size: " + ARRAY_STORAGE.size);
//        printAll();
//        ARRAY_STORAGE.clear();
//        System.out.println("Size: " + ARRAY_STORAGE.size);
//
//
//
//    }
//
//    static void printAll() {
//        System.out.println("\nGet All");
//        for (com.urise.webapp.model.Resume r : ARRAY_STORAGE.getAll()) {
//            System.out.println(r);
//        }
//    }
//}