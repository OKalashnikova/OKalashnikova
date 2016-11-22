package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Created by OK on 20.11.2016.
 */
public abstract class AbstractStorage implements Storage{
    @Override
    public void clear() {

    }

    @Override
    public int getIndex(String uuid) {
        return 0;
    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int getSize() {
        return 0;
    }
}
