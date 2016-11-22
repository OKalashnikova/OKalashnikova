package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OK on 20.11.2016.
 */
public class ListStorage extends AbstractStorage{

    private final static String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1);

    private final static String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2);

    private final static String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUID_3);

    private final static String UUID_4 = "uuid4";
    private static final Resume RESUME_4 = new Resume(UUID_4);

    public static void main(String[] args) {
        List listStorage = new ArrayList<>();
        listStorage.add(RESUME_1);
        listStorage.add(RESUME_2);
        listStorage.add(RESUME_3);
        listStorage.add(RESUME_4);

        System.out.println(listStorage.toString());

        listStorage.remove(RESUME_3);
        System.out.println(listStorage.toString());

        System.out.println(listStorage.indexOf(RESUME_4));
    }
}
