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

        String s = ARRAY_STORAGE.printAll();
        System.out.println(s);
        ARRAY_STORAGE.getAll();
        System.out.println("Size: " + ARRAY_STORAGE.size());
        ARRAY_STORAGE.delete(r1.uuid);
        String sDell = ARRAY_STORAGE.printAll();
        System.out.println(sDell);
        System.out.println("Size: " + ARRAY_STORAGE.size());
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
