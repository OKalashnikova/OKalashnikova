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

    int insertedIndex() {
        int index = 0;
        if (size == 0) {
            storage[index].getUuid();
        }
        return index;
    }


    public int foundIdx(String uuid) {
        int foundIndex = Integer.parseInt(uuid);
        int min = 0;
        int max = size;
        int index = 0;


        for (; ; ) {
            int expectIndex = min + (max - min) / 2;
            String foundMinUuid = storage[expectIndex].getUuid();
            String foundMaxUuid = storage[expectIndex + 1].getUuid();
            int minUuid = Integer.parseInt(foundMinUuid);
            int maxUuid = Integer.parseInt(foundMaxUuid);

            if (size == 0) {
                index = 0;
            } else if (foundIndex > minUuid && foundIndex < maxUuid) {
                cycle(""+minUuid, ""+maxUuid, ""+foundIndex);
                break;
            } else if (foundIndex < minUuid) {
                max = minUuid;
            } else if (foundIndex > maxUuid) {
                min = maxUuid;
            }
        }
        return index;
    }

    public void cycle(String minUuid, String maxUuid, String foundIndex){
        int j=getIndex(maxUuid);
        for(int i=getIndex(minUuid); i<getIndex(maxUuid); i++){
            if(storage[i]<foundIndex && storage[i+1]>foundIndex){
                int backindex=i+1;
                break;
            }
        }return;

    }

    @Override
    public void save(Resume r) {
        int size = getSize();
        String uuid = r.getUuid();
        int indexForSave = foundIdx(uuid);
        System.arraycopy(storage, indexForSave, storage, indexForSave + 1, size - indexForSave);
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


//package storage;
//
//        import model.Resume;
//
//        import java.util.Arrays;
//
//public class SortedArrayStorage extends AbstractArrayStorage {
//
//    public void save(Resume r) {
//        storage[size] = r;
//        size++;
//        Arrays.sort(storage, 0, size);
//    }
//
//    public void delete(String uuid) {
//        int index = getIndex(uuid);
//        if (index == -1) {
//            System.out.println("Resume " + uuid + " not exist");
//        } else {
//            System.arraycopy(storage, index + 1, storage, index, size);
//            size--;
//        }
//    }
//
//
//    @Override
//    protected int getIndex(String uuid) {
//        Resume searchKey = new Resume();
//        searchKey.setUuid(uuid);
//        return Arrays.binarySearch(storage, 0, size, searchKey);
//    }
//}

//    @Override
//    public void save(Resume r) {
//        int min = 0;
//        int max = size + 1;
//        String fId = r.getUuid();
//        int foundIndex = Integer.parseInt(fId);
//        for (; ; ) {
//            int expectIndex = min + (max - min) / 2;
//            String foundMinUuid = storage[expectIndex].getUuid();
//            String foundMaxUuid = storage[expectIndex + 1].getUuid();
//            int minUuid = Integer.parseInt(foundMinUuid);
//            int maxUuid = Integer.parseInt(foundMaxUuid);
//            if (foundIndex > minUuid && foundIndex < maxUuid) {
//                foundIndex = maxUuid;
//                System.arraycopy(storage, foundIndex, storage, foundIndex + 1, size - foundIndex);
//                storage[foundIndex] = r;
//                break;
//            }
//            if (foundIndex < minUuid) {
//                max = minUuid;
//            }
//            if (foundIndex > maxUuid) {
//                min = maxUuid;
//            }
//
//        }
//    }