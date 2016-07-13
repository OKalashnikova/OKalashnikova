package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by O&J on 20.06.2016.
 */
public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    public int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }


    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        if (isStorageFull())
            System.out.println("Storage overflow!");
        else if (getIndex(r.getUuid()) > -1)
            System.out.println("Resume " + r + " already exist!");
        else {
            int index = binaryInsert(r.getUuid());
            if (!Objects.equals(index, -1)) {
                System.arraycopy(storage, index, storage, index + 1, storage.length - index - 1);
                storage[index] = r;
                size++;
            } else
                System.out.println("this value \'" + r.getUuid() + "\' is not a number for id!");
        }
    }

    public int binaryInsert(String uuid) {
        if (!isPositiveInteger(uuid)) {
            return -1;
        }
        int insertKey = Integer.parseInt(uuid);
        if (size == 0)
            return 0;
        int lowerBound = 0;
        int upperBound = size - 1;
        int curIn;
        while (true) {
            curIn = (upperBound + lowerBound) / 2;
            if (Integer.parseInt(storage[curIn].getUuid()) < insertKey) {
                lowerBound = curIn + 1; // its in the upper
                if (lowerBound > upperBound)
                    return curIn + 1;
            } else {
                upperBound = curIn - 1; // its in the lower
                if (lowerBound > upperBound)
                    return curIn;
            }
        }
    }

    private boolean isPositiveInteger(String testString) {
        return testString.matches("[1-9][0-9]{0,4}");
    }


    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Summary with this uuid " + uuid + " doesn't exist");
        } else {
            System.arraycopy(storage, index + 1, storage, index, storage.length - index - 1);
            size--;
        }
    }


}


//    @Override
//protected void insertElement(Resume r, int index) {
//    http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
//    int insertIdx = -index - 1;
//    System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
//    storage[insertIdx] = r;
//}