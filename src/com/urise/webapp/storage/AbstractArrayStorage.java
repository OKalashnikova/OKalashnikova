package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;


/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    // @Override
    public int getSize() {
        return size;
    }

    public boolean isStorageFull() {
        if (size == STORAGE_LIMIT)
            return true;
        else
            return false;
    }




    //public abstract void delete(String uuid);

    @Override
    protected void doUpdate(Resume r, Object index) {
        storage[(Integer) index] = r;
    }

//    public void update(Resume r) {
//        int index = getIndex(r.getUuid());
//        if (index < 0) {
//            throw new NotExistStorageException(r.getUuid());
//        } else {
//            storage[index] = r;
//        }
//    }


    @Override
    protected void doSave(Resume r, Object index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r, (Integer) index);
            storage[size] = r;
            size++;
        }
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer)index >= 0;
    }

    //    public void save(Resume r) {
//        int index = getIndex(r.getUuid());
//        if (index >= 0) {
//            throw new ExistStorageException(r.getUuid());
//        } else if (size == STORAGE_LIMIT) {
//            throw new StorageException("Storage overflow", r.getUuid());
//        } else {
//            insertElement(r, index);
//            storage[size] = r;
//            size++;
//        }
//    }

    @Override
    public void doDelete(Object index) {
        fillDeletedElement((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    public abstract Integer getSearchKey(String uuid);

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }


}