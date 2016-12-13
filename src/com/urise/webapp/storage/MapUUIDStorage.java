package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by OK on 10.12.2016.
 */
public class MapUUIDStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    public String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {

    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {

    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }
}
