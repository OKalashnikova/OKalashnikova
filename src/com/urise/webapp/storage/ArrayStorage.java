package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Objects;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[5];
    public int size = 0;


    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }


    public boolean uuidExist(String uuid) {
        boolean uuidExist = false;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                uuidExist = true;
                break;
            }
        }
        return uuidExist;
    }


    public void update(Resume r) {
        for (int i = 0; i < size; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                storage[i] = r;
                return;
            }
        }
        System.out.println("Резюме с таким id " + r + " не существует");
    }



    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("К сожалению, место на сервере для хранения резюме закончилось");
        } else if (uuidExist(r.getUuid())) {
            System.out.println("Sorry, резюме с таким id уже существует");
        } else {
            storage[size] = r;
            size++;
        }
    }


    public Resume get(String uuid) {
        int index = getIndex(uuid);
        Objects.requireNonNull(uuid, "uuis must not be null");

        if (index == -1) {
            System.out.println("К сожалению, резюме такого нет");
        } else {
            return storage[index];
        }
        return null;
    }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Резюме с таким id " + uuid + " не существует");
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
        Resume[] result = new Resume[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (storage[i] != null) {
                result[j] = storage[i];
                j++;
            }
        }
        return result;
    }

//    int size() {
//        int size = 0;
//        for (int i = 0; i < storage.length; i++) {
//            if (storage[i] != null) {
//                size++;
//            }
//        }
//        return size;
//    }

}