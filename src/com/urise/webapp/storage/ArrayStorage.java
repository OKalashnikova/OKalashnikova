package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage{

//   private int size = 0;
//    public int getSize() {
//        return size;
//    }


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



//    public void update(Resume r) {
//        int index = getIndex(r.getUuid());
//        if (index == -1) {
//            System.out.println("Sorry, ID " + r + " doesn't exist");
//        } else {
//            storage[index] = r;
//            return;
//        }
//
//    }

//    public Resume get(String uuid) {
//        int index = getIndex(uuid);
//        Objects.requireNonNull(uuid, "uuis must not be null");
//
//        if (index == -1) {
//            System.out.println("Element with this uuid doesn't exist");
//            return null;
//        } else {
//            return storage[index];
//        }
//    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void insertElement(Resume r, int index) {
        storage[size] = r;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */



}