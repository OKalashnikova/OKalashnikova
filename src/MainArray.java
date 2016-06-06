//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//
///**
// * Test for ArrayStorage
// */
//public class MainArray {
//    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        while (true) {
//            System.out.print("Введите одну из команд - (list | save uuid | delete uuid | get uuid | clear | exit): ");
//            String[] params = reader.readLine().trim().toLowerCase().split(" ");
//            if (params.length < 1 || params.length > 2) {
//                System.out.println("Неверная команда.");
//                continue;
//            }
//            if (params.length == 2) {
//                params[1] = params[1].intern();
//            }
//            switch (params[0]) {
//                case "list":
//                    printAll();
//                    break;
//                case "size":
//                    System.out.println(ARRAY_STORAGE.size());
//                    break;
//                case "save":
//                    Resume r = new Resume();
//                    r.uuid = params[1];
//                    ARRAY_STORAGE.save(r);
//                    printAll();
//                    break;
//                case "delete":
//                    ARRAY_STORAGE.delete(params[1]);
//                    printAll();
//                    break;
//                case "get":
//                    System.out.println(ARRAY_STORAGE.get(params[1]));
//                    break;
//                case "clear":
//                    ARRAY_STORAGE.clear();
//                    printAll();
//                    break;
//                case "exit":
//                    return;
//                default:
//                    System.out.println("Неверная команда.");
//                    break;
//            }
//        }
//    }
//
//    static void printAll() {
//        Resume[] all = ARRAY_STORAGE.getAll();
//        System.out.println("----------------------------");
//        if (all.length == 0) {
//            System.out.println("Empty");
//        } else {
//            for (Resume r : all) {
//                System.out.println(r);
//            }
//        }
//        System.out.println("----------------------------");
//    }
//}

import java.lang.reflect.Array;
import java.util.Arrays;

import static com.sun.deploy.config.JREInfo.getAll;

/**
 * Test for com.urise.webapp.storage.ArrayStorage
 */
public class MainArray {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.uuid = "uuid1";
        Resume r2 = new Resume();
        r2.uuid = "uuid2";
        Resume r3 = new Resume();
        r3.uuid = "uuid3";
        Resume r4 = new Resume();
        r4.uuid = "uuid4";
        Resume r5 = new Resume();
        r5.uuid = "uuid5";

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r5);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.uuid));
        System.out.println("Get r2: " + ARRAY_STORAGE.get(r2.uuid));
        System.out.println("Get r3: " + ARRAY_STORAGE.get(r3.uuid));
        System.out.println("Get r4: " + ARRAY_STORAGE.get(r4.uuid));
        System.out.println("Get r5: " + ARRAY_STORAGE.get(r5.uuid));
        System.out.println("Size: " + ARRAY_STORAGE.size());
//        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));


        ARRAY_STORAGE.delete("uuid2");
        System.out.println("Size: " + ARRAY_STORAGE.size());
        printAll();
        ARRAY_STORAGE.clear();
        System.out.println("Size: " + ARRAY_STORAGE.size());


    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}