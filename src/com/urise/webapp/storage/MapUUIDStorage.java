package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
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
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int getSize() {
      return map.size();
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        if (map.containsKey(searchKey)) {
            map.put((String) searchKey, r);
        }else{throw new NotExistStorageException((String)searchKey);}
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
    if (map.containsKey(searchKey)){
        throw new ExistStorageException((String)searchKey);}
   else
    {map.put((String)searchKey, r);
    }
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove(searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return  map.get(searchKey);
    }
}
