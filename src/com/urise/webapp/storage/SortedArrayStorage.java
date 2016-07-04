package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by O&J on 20.06.2016.
 */
public class SortedArrayStorage extends AbstractArrayStorage {
    protected int size = 0;


    @Override
    public int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    public void clear() {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        int min = 0;
        int max = size + 1;
        String fId = r.getUuid();
        int foundIndex = Integer.parseInt(fId);
        for (; ; ) {
            int expectIndex = min + (max - min) / 2;
            String foundMinUuid = storage[expectIndex].getUuid();
            String foundMaxUuid = storage[expectIndex + 1].getUuid();
            int minUuid = Integer.parseInt(foundMinUuid);
            int maxUuid = Integer.parseInt(foundMaxUuid);
            if (foundIndex > minUuid && foundIndex < maxUuid) {
                foundIndex = maxUuid;
                System.arraycopy(storage, foundIndex, storage, foundIndex + 1, size - foundIndex);
                storage[foundIndex] = r;
                break;
            }
            if (foundIndex < minUuid) {
                max = minUuid;
            }
            if (foundIndex > maxUuid) {
                min = maxUuid;
            }

        }
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
        return size;
    }
}


//    @Override
//protected void insertElement(Resume r, int index) {
//    http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
//    int insertIdx = -index - 1;
//    System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
//    storage[insertIdx] = r;
//}