package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage{
    private static final int STORAGE_LIMIT = 100000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;


    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }


//    public boolean uuidExist(String uuid) {
//        boolean uuidExist = false;
//        for (int i = 0; i < size; i++) {
//            if (uuid.equals(storage[i].getUuid())) {
//                uuidExist = true;
//                break;
//            }
//        }
//        return uuidExist;
//    }



    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Sorry, ID " + r + " doesn't exist");
        } else {
            storage[index] = r;
            return;
        }

    }


    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size == storage.length) {
            System.out.println("Sorry, server is full");
        } else if (index == -1) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Element with this uuid " + r.getUuid()+ " exist");
        }
    }


    public Resume get(String uuid) {
        int index = getIndex(uuid);
        Objects.requireNonNull(uuid, "uuis must not be null");

        if (index == -1) {
            System.out.println("Element with this uuid doesn't exist");
            return null;
        } else {
            return storage[index];
        }
    }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Summary with this uuid " + uuid + " doesn't exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            return;

        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }


}