package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;


/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public int getSize() {
        return size;
    }

    public boolean isStorageFull() {
        if (size == STORAGE_LIMIT)
            return true;
        else
            return false;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Element with this uuid" + uuid + " doesn't exist");
            return null;
        } else {
            return storage[index];
        }
    }

    public abstract int getIndex(String uuid);

    public abstract void delete(String uuid);

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Sorry, ID " + r + " doesn't exist");
        } else {
            storage[index] = r;
            return;
        }

    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }


}